package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.mycar.parking.lotbarcode.create response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-14 15:08:52
 */
public class AlipayEcoMycarParkingLotbarcodeCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 3849938829158695576L;

	/** 
	 * 返回二维码链接地址
	 */
	@ApiField("qrcode_url")
	private String qrcodeUrl;

	/** 
	 * 返回状态：1为成功，0为失败
	 */
	@ApiField("status")
	private String status;

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}
	public String getQrcodeUrl( ) {
		return this.qrcodeUrl;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus( ) {
		return this.status;
	}

}
