package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.pass.tpl.content.update response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-01 15:29:44
 */
public class AlipayPassTplContentUpdateResponse extends AlipayResponse {

	private static final long serialVersionUID = 3693382547493139729L;

	/** 
	 * 业务错误码
	 */
	@ApiField("error_code")
	private String errorCode;

	/** 
	 * 业务结果数据：包含serialNumber, pass_Id和操作类型
	 */
	@ApiField("result")
	private String result;

	/** 
	 * 操作是否成功标识：T标识成功；F标识失败
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
