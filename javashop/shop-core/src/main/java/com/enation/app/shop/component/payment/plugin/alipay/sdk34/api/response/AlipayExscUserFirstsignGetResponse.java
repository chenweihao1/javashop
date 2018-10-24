package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.exsc.user.firstsign.get response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-29 17:13:27
 */
public class AlipayExscUserFirstsignGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 1234871237881299417L;

	/** 
	 * 返回结果的业务类型。首次快捷绑卡业务类型 （first_sign）
	 */
	@ApiField("biz_type")
	private String bizType;

	/** 
	 * 业务处理结果
 true 无绑卡记录，本次是首次绑卡
 false 曾经绑过快捷卡，本次不是首次绑卡
	 */
	@ApiField("success")
	private Boolean success;

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getBizType( ) {
		return this.bizType;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Boolean getSuccess( ) {
		return this.success;
	}

}
