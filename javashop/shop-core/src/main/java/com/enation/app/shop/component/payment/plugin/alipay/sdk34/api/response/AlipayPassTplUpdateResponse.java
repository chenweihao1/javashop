package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.pass.tpl.update response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-01 15:35:58
 */
public class AlipayPassTplUpdateResponse extends AlipayResponse {

	private static final long serialVersionUID = 3186796574765653598L;

	/** 
	 * 业务错误码
	 */
	@ApiField("error_code")
	private String errorCode;

	/** 
	 * 业务结果信息：包含模版id、动态参数集合和操作类型
	 */
	@ApiField("result")
	private String result;

	/** 
	 * 操作成功与否标识：T标识成功，F标识失败
	 */
	@ApiField("success")
	private String success;

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorCode( ) {
		return this.errorCode;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public String getResult( ) {
		return this.result;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
	public String getSuccess( ) {
		return this.success;
	}

}
