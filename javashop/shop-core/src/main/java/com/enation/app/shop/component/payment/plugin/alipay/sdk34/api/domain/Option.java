package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 展示文本和对应取值的映射关系
 *
 * @author auto create
 * @since 1.0, 2017-06-14 11:09:05
 */
public class Option extends AlipayObject {

	private static final long serialVersionUID = 4334289463547827834L;

	/**
	 * 文本，通常用于理解对应的取值
	 */
	@ApiField("text")
	private String text;

	/**
	 * 取值，通常使用简单的数字或字符串
	 */
	@ApiField("value")
	private String value;

	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
