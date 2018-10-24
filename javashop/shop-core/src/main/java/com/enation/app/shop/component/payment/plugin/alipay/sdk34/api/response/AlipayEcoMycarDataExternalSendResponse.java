package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.mycar.data.external.send response.
 * 
 * @author auto create
 * @since 1.0, 2016-05-12 10:25:11
 */
public class AlipayEcoMycarDataExternalSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 3665965755399823122L;

	/** 
	 * 20
	 */
	@ApiField("external_system_name")
	private String externalSystemName;

	/** 
	 * outter_response
	 */
	@ApiField("process_result")
	private String processResult;

	public void setExternalSystemName(String externalSystemName) {
		this.externalSystemName = externalSystemName;
	}
	public String getExternalSystemName( ) {
		return this.externalSystemName;
	}

	public void setProcessResult(String processResult) {
		this.processResult = processResult;
	}
	public String getProcessResult( ) {
		return this.processResult;
	}

}
