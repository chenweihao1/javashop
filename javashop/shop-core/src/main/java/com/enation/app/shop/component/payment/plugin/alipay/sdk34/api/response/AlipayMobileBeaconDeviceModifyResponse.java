package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.beacon.device.modify response.
 * 
 * @author auto create
 * @since 1.0, 2017-02-28 11:15:27
 */
public class AlipayMobileBeaconDeviceModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 5523568717326552282L;

	/** 
	 * 返回的操作码
	 */
	@ApiField("code")
	private String code;

	/** 
	 * 操作结果说明
	 */
	@ApiField("msg")
	private String msg;

	public void setCode(String code) {
		this.code = code;
	}
	public String getCode( ) {
		return this.code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg( ) {
		return this.msg;
	}

}
