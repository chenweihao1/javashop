package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.shortlink.create response.
 * 
 * @author auto create
 * @since 1.0, 2016-12-08 12:00:56
 */
public class AlipayOpenPublicShortlinkCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 5719826115325556359L;

	/** 
	 * 生成的带参推广短链接
	 */
	@ApiField("shortlink")
	private String shortlink;

	public void setShortlink(String shortlink) {
		this.shortlink = shortlink;
	}
	public String getShortlink( ) {
		return this.shortlink;
	}

}
