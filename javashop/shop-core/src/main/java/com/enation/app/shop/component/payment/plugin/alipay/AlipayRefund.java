package com.enation.app.shop.component.payment.plugin.alipay;

import java.util.HashMap;
import java.util.Map;

import com.enation.app.shop.core.order.model.RefundBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayClient;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.DefaultAlipayClient;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.request.AlipayTradeRefundRequest;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response.AlipayTradeRefundResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.config.AlipayConfig34;
import com.enation.framework.database.IDaoSupport;
import com.enation.framework.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
 * 
 * (支付宝统一退款方法) 
 * @author zjp
 * @version  v6.3
 * @since v6.3
 * 2017年6月28日 下午2:43:29
 */
@Component
public class AlipayRefund  {
	
	@Autowired
	IDaoSupport daoSupport;
	
	/**
	 * 支付宝退款方法实现，原路退回
	 * @param refundBill
	 * @return
	 */
	public String onRefund(RefundBill refundBill) {
		////////////////////////////////////请求参数//////////////////////////////////////
		Map<String, String> config = this.getConfig();
		this.setConfig(config);
		
		try {
		
			//获得初始化的AlipayClient
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig34.gatewayUrl, AlipayConfig34.app_id, AlipayConfig34.merchant_private_key, "json", AlipayConfig34.charset, AlipayConfig34.alipay_public_key, AlipayConfig34.sign_type);
			
			//设置请求参数
			AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
			
			//商户订单号，商户网站订单系统中唯一订单号 
			String out_trade_no = refundBill.getTrade_sn();
			//需要退款的金额，该金额不能大于订单金额，必填
			Double refund_amount = refundBill.getTrade_price();
			//退款的原因说明
			String refund_reason = "正常退款";
			//标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
			String out_request_no = "HZ"+refundBill.getRefund_sn();
			
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("out_trade_no", "150181666574");//TODO
			sParaTemp.put("refund_amount", "0.01");//TODO
			sParaTemp.put("refund_reason", refund_reason);
			sParaTemp.put("out_request_no", out_request_no);
			
			ObjectMapper json = new ObjectMapper();
			
		    
			alipayRequest.setBizContent(json.writeValueAsString(sParaTemp));
			//填充业务参数
		    AlipayTradeRefundResponse response = alipayClient.execute(alipayRequest);
		    if(response.isSuccess()){
		    	System.out.println("调用成功");
		    	return "SUCCESS";
		    } else {
		    	System.out.println("调用失败");
		    	return "fail";
		    }
		}catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
	}
	
	/**
	 * 设置支付宝的参数
	 */
	private void setConfig(Map<String,String> config){
		AlipayConfig34.app_id = config.get("app_id");
		AlipayConfig34.merchant_private_key = config.get("merchant_private_key");
		AlipayConfig34.alipay_public_key = config.get("alipay_public_key");
	}

	protected Map<String,String> getConfig(){
		//获取当前支付插件的id
		String paymentMethodId = "alipayDirectPlugin";//TODO 
		String config  = daoSupport.queryForString("select config from es_payment_method where plugin_id=?", paymentMethodId);
		if(StringUtil.isEmpty(config)){
			return new HashMap<String,String>();
		}
		Gson gson = new Gson();
		Map<String,String> configMap = gson.fromJson(config,   new TypeToken<Map<String, String>>() {  
                }.getType());
	
		return configMap;
	}
}
