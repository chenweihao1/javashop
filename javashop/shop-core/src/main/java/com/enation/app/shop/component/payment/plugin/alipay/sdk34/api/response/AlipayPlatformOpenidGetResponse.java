package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.platform.openid.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-06 17:38:21
 */
public class AlipayPlatformOpenidGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 7312994137595139196L;

	/** 
	 * 结果码
	 */
	@ApiField("code")
	private String code;

	/** 
	 * id字典，key为userId和老的openId，value为新的openId
	 */
	@ApiField("dict")
	private String dict;

	/** 
	 * 结果描述
	 */
	@ApiField("msg")
	private String msg;

	public void setCode(String code) {
		this.code = code;
	}
	public String getCode( ) {
		return this.code;
	}

	public void setDict(String dict) {
		this.dict = dict;
	}
	public String getDict( ) {
		return this.dict;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg( ) {
		return this.msg;
	}

}
