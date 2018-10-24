package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 停车卡生成二维码
 *
 * @author auto create
 * @since 1.0, 2016-10-26 18:05:18
 */
public class AlipayEcoMycarParkingCardbarcodeCreateModel extends AlipayObject {

	private static final long serialVersionUID = 7229528714362112924L;

	/**
	 * 设备商订单id
	 */
	@ApiField("equipment_id")
	private String equipmentId;

	/**
	 * 支付宝交易流水号订单
	 */
	@ApiField("parking_id")
	private String parkingId;

	public String getEquipmentId() {
		return this.equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getParkingId() {
		return this.parkingId;
	}
	public void setParkingId(String parkingId) {
		this.parkingId = parkingId;
	}

}
