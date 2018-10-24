package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.public.template.message.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-14 20:27:44
 */
public class AlipayMobilePublicTemplateMessageQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2653238326545936459L;

	/** 
	 * 结果值
	 */
	@ApiField("result")
	private String result;

	public void setResult(String result) {
		this.result = result;
	}
	public String getResult( ) {
		return this.result;
	}

}
