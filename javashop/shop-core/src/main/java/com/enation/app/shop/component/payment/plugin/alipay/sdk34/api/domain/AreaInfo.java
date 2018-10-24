package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 省份城市地区
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:41
 */
public class AreaInfo extends AlipayObject {

	private static final long serialVersionUID = 7863761287481218781L;

	/**
	 * 城市
	 */
	@ApiField("city")
	private String city;

	/**
	 * 省份
	 */
	@ApiField("province")
	private String province;

	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return this.province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

}
