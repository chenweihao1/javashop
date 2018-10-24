package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 基于设备和城市查询当前支持的功能
 *
 * @author auto create
 * @since 1.0, 2016-10-26 18:05:20
 */
public class AlipayCommerceCityfacilitatorFunctionQueryModel extends AlipayObject {

	private static final long serialVersionUID = 3168945189236526542L;

	/**
	 * 城市国家标准编码
	 */
	@ApiField("city_code")
	private String cityCode;

	/**
	 * 终端设备编码，android可直接获取设备的devicecode值
	 */
	@ApiField("device_code")
	private String deviceCode;

	public String getCityCode() {
		return this.cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDeviceCode() {
		return this.deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

}
