package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 物料二维码
 *
 * @author auto create
 * @since 1.0, 2016-10-26 18:05:18
 */
public class AlipayEcoMycarParkingLotbarcodeCreateModel extends AlipayObject {

	private static final long serialVersionUID = 4858871687748996162L;

	/**
	 * 停车场编号
	 */
	@ApiField("parking_id")
	private String parkingId;

	public String getParkingId() {
		return this.parkingId;
	}
	public void setParkingId(String parkingId) {
		this.parkingId = parkingId;
	}

}
