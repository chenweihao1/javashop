package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ISV获取违章车辆信息
 *
 * @author auto create
 * @since 1.0, 2016-10-26 18:05:19
 */
public class AlipayEcoMycarDataserviceViolationinfoShareModel extends AlipayObject {

	private static final long serialVersionUID = 5289551822759316959L;

	/**
	 * 支付宝app_id
	 */
	@ApiField("app_id")
	private String appId;

	/**
	 * 车辆id
	 */
	@ApiField("vehicle_id")
	private String vehicleId;

	public String getAppId() {
		return this.appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getVehicleId() {
		return this.vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

}
