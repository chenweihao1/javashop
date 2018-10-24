package com.enation.app.shop.component.payment.plugin.alipay.direct;

import java.util.HashMap;
import java.util.Map;

import com.enation.app.shop.core.order.model.Refund;
import com.enation.app.shop.core.order.model.RefundBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayClient;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.DefaultAlipayClient;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.request.AlipayTradeRefundRequest;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response.AlipayTradeRefundResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.config.AlipayConfig;
import com.enation.framework.cache.ICache;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

@Service
public class AlipayRefundExcutor extends AlipayPluginConfig{

	@Autowired
	private ICache cache;
	
	/**
	 * 退款
	 * @param bill
	 * @return
	 */
	public boolean refundPay(RefundBill bill) {
		try {
			super.setConfig();
			
			//获得初始化的AlipayClient
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			
			//设置请求参数
			AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
			
			//商户订单号，商户网站订单系统中唯一订单号
			String out_trade_no = bill.getTrade_sn();
			//需要退款的金额，该金额不能大于订单金额，必填
			Double refund_amount = bill.getRefund_price();
			//退款的原因说明
			String refund_reason = "正常退款";
			//标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
			String out_request_no = "HZ"+bill.getRefund_sn();
			
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("trade_no", out_trade_no);
			sParaTemp.put("refund_amount", refund_amount+"");
			sParaTemp.put("refund_reason", refund_reason);
			sParaTemp.put("out_request_no", out_request_no);
			
			ObjectMapper json = new ObjectMapper();
			
		    alipayRequest.setBizContent(json.writeValueAsString(sParaTemp));//填充业务参数
		    AlipayTradeRefundResponse response = alipayClient.execute(alipayRequest);
		    if(response.isSuccess()){
		    	System.out.println("调用成功");
		    	return true;
		    } else {
		    	System.out.println("调用失败");
		    	cache.put(this.getRefundErrorMessageCode(),response.getCode()+":"+response.getSubMsg() );
		    	return false;
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 查询退款
	 * @param refund
	 */
	public Refund queryRefundStatus(Refund refund) {
		try {
			super.setConfig();
			
			//获得初始化的AlipayClient
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			
			//设置请求参数
			AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();
			
			//商户订单号，商户网站订单系统中唯一订单号
			String out_trade_no = refund.getSn();
			//请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填
			String out_request_no = "HZ" + refund.getSn();
			
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("out_trade_no", out_trade_no);
			sParaTemp.put("out_request_no", out_request_no);
			
			ObjectMapper json = new ObjectMapper();
			alipayRequest.setBizContent(json.writeValueAsString(sParaTemp));
		
			AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(alipayRequest);
			
			if(response.isSuccess()){
				System.out.println(response.getBody());
				JSONObject jsonObj = JSONObject.fromObject(response.getBody());
				JSONObject res = (JSONObject) jsonObj.get("alipay_trade_fastpay_refund_query_response");
				if(res.get("out_trade_no")!=null){
					refund.setStatus(1);
				}else{
					refund.setStatus(1);
				}
		    } 
			
	    } catch (Exception e) {
			e.printStackTrace();
		}
		
		return refund;
	}

}
