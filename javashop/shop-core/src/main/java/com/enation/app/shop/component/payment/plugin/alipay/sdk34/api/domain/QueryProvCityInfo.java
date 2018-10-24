package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 省市下拉列表数据对象模型
 *
 * @author auto create
 * @since 1.0, 2016-12-21 11:02:47
 */
public class QueryProvCityInfo extends AlipayObject {

	private static final long serialVersionUID = 8888287339692897793L;

	/**
	 * 省市编号
	 */
	@ApiField("adcode")
	private String adcode;

	/**
	 * 城市名称
	 */
	@ApiField("name")
	private String name;

	public String getAdcode() {
		return this.adcode;
	}
	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
