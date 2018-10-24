package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 图片信息
 *
 * @author auto create
 * @since 1.0, 2017-06-14 11:02:07
 */
public class Image extends AlipayObject {

	private static final long serialVersionUID = 7427277888797433679L;

	/**
	 * 图片url
	 */
	@ApiField("url")
	private String url;

	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
