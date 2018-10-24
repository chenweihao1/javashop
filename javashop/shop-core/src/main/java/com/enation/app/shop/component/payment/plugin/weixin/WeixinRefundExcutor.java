package com.enation.app.shop.component.payment.plugin.weixin;

import java.util.Map;
import java.util.TreeMap;

import com.enation.app.shop.core.order.model.Refund;
import com.enation.app.shop.core.order.model.RefundBill;
import com.enation.framework.cache.ICache;
import com.enation.framework.util.StringUtil;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeixinRefundExcutor extends WeixinPuginConfig{

	@Autowired
	private ICache cache;
	
	public boolean returnPay(RefundBill bill) {
		Map<String, String> cfgparams = this.getConfig();
		if (cfgparams == null) {
			throw new RuntimeException("请设置微信支付商户参数!");
		}
		String mchid = cfgparams.get("mchid");// cfgparams.get("mchid");
		String appid = cfgparams.get("appid");// cfgparams.get("appid");
		String key = cfgparams.get("key"); // cfgparams.get("key");
		String p12_path = cfgparams.get("p12_path"); // cfgparams.get("key");
		String original_sn = bill.getTrade_sn();
		
		Map params = new TreeMap();
		params.put("appid", appid);
		params.put("mch_id", mchid);
		params.put("nonce_str", StringUtil.getRandStr(10));
		params.put("transaction_id", original_sn);
		params.put("refund_fee", toFen(bill.getRefund_price()));
		params.put("total_fee", toFen(bill.getTrade_price()));//交易金额
		params.put("out_refund_no", bill.getRefund_sn());
		String sign = WeixinUtil.createSign(params, key);
		params.put("sign", sign);
		
		try {
			String xml = WeixinUtil.mapToXml(params);
			System.out.println(xml);
			Document resultDoc = WeixinUtil.verifyCertPost("https://api.mch.weixin.qq.com/secapi/pay/refund", xml,mchid,p12_path);

			System.out.println("-----------return xml ------------");
			System.out.println(WeixinUtil.doc2String(resultDoc));
			Element rootEl = resultDoc.getRootElement();

			// 返回结果
			String return_code = rootEl.element("return_code").getText(); // 返回码
			if ("SUCCESS".equals(return_code)) {
				return true;
			} else {
				this.cache.put(this.getRefundErrorMessageCode(), return_code);
				return false;
			}
			
		} catch (Exception e) {
			this.logger.error("微信退款失败", e);
			this.cache.put(this.getRefundErrorMessageCode(), "异常");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 查询退款状态
	 * @param refund
	 * @return
	 */
	public Refund queryRefundStatus(Refund refund) {
		Map<String, String> cfgparams = this.getConfig();
		if (cfgparams == null) {
			throw new RuntimeException("请设置微信支付商户参数!");
		}
		String mchid = cfgparams.get("mchid");// cfgparams.get("mchid");
		String appid = cfgparams.get("appid");// cfgparams.get("appid");
		String key = cfgparams.get("key"); // cfgparams.get("key");
		
		Map params = new TreeMap();
		params.put("appid", appid);
		params.put("mch_id", mchid);
		params.put("nonce_str", StringUtil.getRandStr(10));
		/** 商户系统内部订单号 */
		params.put("out_refund_no",refund.getSn());
		/** 签名	 */
		String sign = WeixinUtil.createSign(params, key);
		params.put("sign", sign);
		try {
			String xml = WeixinUtil.mapToXml(params);
			Document resultDoc = WeixinUtil.post("https://api.mch.weixin.qq.com/pay/refundquery", xml);
			/** 调试时可打开此处注释，以观察微信返回的数据 **/
			// this.logger.debug("-----------return xml ------------");
			// this.logger.debug( WeixinUtil.doc2String(resultDoc) );
			Element rootEl = resultDoc.getRootElement();
			System.out.println(WeixinUtil.xmlToMap(resultDoc));
			/** 返回码 */
			String return_code = rootEl.element("return_code").getText(); // 返回码
			if ("SUCCESS".equals(return_code)) {
				/** 实际退款状态 */
				String status = rootEl.element("refund_status_0").getText(); // 返回码
//				退款状态： SUCCESS—退款成功  REFUNDCLOSE—退款关闭。  PROCESSING—退款处理中 
//				CHANGE—退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。$n为下标，从0开始编号。
				if("SUCCESS".equals(status)){
					refund.setStatus(1);//完成
				}else if("PROCESSING".equals(status)){
					refund.setStatus(1);//退款中
				}else {
					refund.setStatus(0);//退款失败
				}
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return refund;
	}

	

}
