package com.enation.app.shop.component.payment.plugin.weixin.executor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enation.app.shop.component.payment.plugin.weixin.WeixinPuginConfig;
import com.enation.app.shop.component.payment.plugin.weixin.WeixinUtil;
import com.enation.app.shop.core.order.model.PaymentResult;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.framework.cache.ICache;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import com.enation.framework.util.CurrencyUtil;
import com.enation.framework.util.StringUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeixinPaymentExecutor extends WeixinPuginConfig {

	@Autowired
	private ICache cache;
	
	/**
	 * 支付
	 * @param bill
	 * @return
	 */
	public String onPay(PayBill bill) {
		
		
		Map<String, String> cfgparams = this.getConfig();
		if (cfgparams == null) {
			throw new RuntimeException("请设置微信支付商户参数!");
		}
		String mchid = cfgparams.get("mchid");// cfgparams.get("mchid");
		String appid = cfgparams.get("appid");// cfgparams.get("appid");
		String key = cfgparams.get("key"); // cfgparams.get("key");

		String original_sn = bill.getOrder_sn();
		String body = "网店订单[" + original_sn + "]";

		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		Map<String,String> params = new TreeMap();
		params.put("appid", appid);
		params.put("mch_id", mchid);
		params.put("nonce_str", StringUtil.getRandStr(10));
		params.put("body", body);
		params.put("out_trade_no", original_sn);

		// 应付转为分
		Double money = bill.getOrder_price();
		params.put("total_fee", toFen(money));
		params.put("spbill_create_ip", "127.0.0.1");
		params.put("notify_url",this.getCallBackUrl(bill.getOrderType()));
		params.put("trade_type", "NATIVE");
		String sign = WeixinUtil.createSign(params, key);
		params.put("sign", sign);
		String code_url = "";
		String tradeType = bill.getOrderType().name();

		try {
			String xml = WeixinUtil.mapToXml(params);
			Document resultDoc = WeixinUtil.post("https://api.mch.weixin.qq.com/pay/unifiedorder", xml);
			/** 调试时可打开此处注释，以观察微信返回的数据 **/
			if (logger.isDebugEnabled()) {
				this.logger.debug("-----------return xml ------------");
				this.logger.debug(WeixinUtil.doc2String(resultDoc));
			}

			Element rootEl = resultDoc.getRootElement();

			// 返回结果
			String result_code = rootEl.element("result_code").getText();
			if ("SUCCESS".equals(result_code)) {
				code_url = rootEl.element("code_url").getText(); // 返回码
				String qr = code_url.replaceAll(QR_URL_PREFIX, "");
				return "<script> location.href='/order-pay/weixin/qrpage/"+tradeType+"/"+ original_sn + "/" + qr + ".do';</script>";
			} else {
				return "二维码生成错误";
			}
		} catch (Exception e) {
			this.logger.error("微信生成支付二维码错误", e);
			return "二维码生成错误";
		}

	}
	
	/**
	 * 异步回调
	 * @param ordertype
	 * @return
	 */
	public String onCallback(String ordertype) {
		Map<String, String> cfgparams = this.getConfig();
		if (cfgparams == null) {
			throw new RuntimeException("请设置微信支付商户参数!");
		}
		String key = cfgparams.get("key");

		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		Map map = new HashMap();

		try {
			SAXReader saxReadr = new SAXReader();
			Document document = saxReadr.read(request.getInputStream());

			/** 调试时可以打开下面注释 ，以观察通知的xml内容 **/
			if (logger.isDebugEnabled()) {
				String docstr = WeixinUtil.doc2String(document);
				this.logger.debug("--------post xml-------");
				this.logger.debug(docstr);
				this.logger.debug("--------end-------");
			}

			Map<String, String> params = WeixinUtil.xmlToMap(document);

			String return_code = params.get("return_code");
			String result_code = params.get("result_code");
			if ("SUCCESS".equals(return_code) && "SUCCESS".equals(result_code)) {

				String sign = WeixinUtil.createSign(params, key);
				if (sign.equals(params.get("sign"))) {

					// 本商城交易号
					String out_trade_no = params.get("out_trade_no");

					// 微信支付订单号
					String transaction_id = params.get("transaction_id");

					// 支付金额
					String total_fee = params.get("total_fee");
					double payprice = StringUtil.toDouble(total_fee, 0d);
					// 传回来的是分，转为元
					payprice = CurrencyUtil.mul(payprice, 0.01);

					// openid
					String openid = params.get("openid");

					PaymentResult paymentResult = new PaymentResult();
					paymentResult.setOrdersn(out_trade_no);
					paymentResult.setPay_order_no(transaction_id);
					//paymentResult.setPay_account(openid);
					paymentResult.setOrderType(ordertype);
					paymentResult.setPay_price(payprice);

					this.paySuccess(paymentResult);

					map.put("return_code", "SUCCESS");
					// 标记为成功
					cache.put(CACHE_KEY_PREFIX + out_trade_no, "ok", 60);
					if (logger.isDebugEnabled()) {
						this.logger.debug("签名校验成功");
					}
				} else {
					if (logger.isDebugEnabled()) {
						this.logger.debug("-----------签名校验失败---------");
						this.logger.debug("weixin sign:" + params.get("sign"));
						this.logger.debug("my sign:" + sign);
					}
					map.put("return_code", "FAIL");
					map.put("return_msg", "签名失败");
				}
			} else {
				map.put("return_code", "FAIL");
				this.logger.debug("微信通知的结果为失败");
			}

		} catch (IOException e) {
			map.put("return_code", "FAIL");
			map.put("return_msg", "");
			e.printStackTrace();
		} catch (DocumentException e) {
			map.put("return_code", "FAIL");
			map.put("return_msg", "");
			e.printStackTrace();
		} catch (Exception e){
            map.put("return_code", "FAIL");
            map.put("return_msg", "");
		    e.printStackTrace();
        }
		HttpServletResponse response = ThreadContextHolder.getHttpResponse();
		response.setHeader("Content-Type", "text/xml");
		try {
			return WeixinUtil.mapToXml(map);
		} catch (Exception e) {
			e.printStackTrace();
			return "出现错误";
		}

	}

}
