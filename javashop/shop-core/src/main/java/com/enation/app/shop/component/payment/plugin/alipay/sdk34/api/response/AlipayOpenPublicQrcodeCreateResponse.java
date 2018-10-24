package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.qrcode.create response.
 * 
 * @author auto create
 * @since 1.0, 2016-12-08 11:59:38
 */
public class AlipayOpenPublicQrcodeCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 5277473628541411116L;

	/** 
	 * 二维码图片地址，可跳转到实际图片
	 */
	@ApiField("code_img")
	private String codeImg;

	/** 
	 * 二维码有效时间，单位（秒）。永久码暂时忽略该信息
	 */
	@ApiField("expire_second")
	private String expireSecond;

	public void setCodeImg(String codeImg) {
		this.codeImg = codeImg;
	}
	public String getCodeImg( ) {
		return this.codeImg;
	}

	public void setExpireSecond(String expireSecond) {
		this.expireSecond = expireSecond;
	}
	public String getExpireSecond( ) {
		return this.expireSecond;
	}

}
