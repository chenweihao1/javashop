package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.mycar.dataservice.violationinfo.share response.
 * 
 * @author auto create
 * @since 1.0, 2016-05-12 09:57:29
 */
public class AlipayEcoMycarDataserviceViolationinfoShareResponse extends AlipayResponse {

	private static final long serialVersionUID = 4226254848292131838L;

	/** 
	 * 车架号
	 */
	@ApiField("body_num")
	private String bodyNum;

	/** 
	 * 发动机号
	 */
	@ApiField("engine_num")
	private String engineNum;

	/** 
	 * 车辆id
	 */
	@ApiField("vehicle_id")
	private String vehicleId;

	/** 
	 * 车牌
	 */
	@ApiField("vi_number")
	private String viNumber;

	public void setBodyNum(String bodyNum) {
		this.bodyNum = bodyNum;
	}
	public String getBodyNum( ) {
		return this.bodyNum;
	}

	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}
	public String getEngineNum( ) {
		return this.engineNum;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleId( ) {
		return this.vehicleId;
	}

	public void setViNumber(String viNumber) {
		this.viNumber = viNumber;
	}
	public String getViNumber( ) {
		return this.viNumber;
	}

}
