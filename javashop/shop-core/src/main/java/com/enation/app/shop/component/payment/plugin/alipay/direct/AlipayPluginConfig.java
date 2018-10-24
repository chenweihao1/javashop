package com.enation.app.shop.component.payment.plugin.alipay.direct;

import java.util.Map;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.config.AlipayConfig;
import com.enation.app.shop.core.payment.service.AbstractPaymentPlugin;


public class AlipayPluginConfig extends AbstractPaymentPlugin{

	@Override
	public String getPluginId() {
		
		return "alipayDirectPlugin";
	}

	/**
	 * 设置参数
	 */
	public void setConfig() {
		Map<String, String> config = this.getConfig();
//		AlipayConfig.gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
		AlipayConfig.app_id = config.get("app_id");
		AlipayConfig.merchant_private_key = config.get("merchant_private_key");
		AlipayConfig.alipay_public_key = config.get("alipay_public_key");
	}
	
}
