package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.beacon.device.add response.
 * 
 * @author auto create
 * @since 1.0, 2017-02-28 11:14:28
 */
public class AlipayMobileBeaconDeviceAddResponse extends AlipayResponse {

	private static final long serialVersionUID = 4257346828722571119L;

	/** 
	 * 请求操作成功与否，200为成功
	 */
	@ApiField("code")
	private String code;

	/** 
	 * 请求的处理结果
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
