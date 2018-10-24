package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 文本消息内容
 *
 * @author auto create
 * @since 1.0, 2016-12-02 15:56:25
 */
public class Text extends AlipayObject {

	private static final long serialVersionUID = 1722856787996731267L;

	/**
	 * 你好!
	 */
	@ApiField("content")
	private String content;

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
