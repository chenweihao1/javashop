package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ins.scene.application.issue.confirm response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-18 11:34:53
 */
public class AlipayInsSceneApplicationIssueConfirmResponse extends AlipayResponse {

	private static final long serialVersionUID = 1432384794533312438L;

	/** 
	 * 投保订单号
	 */
	@ApiField("application_no")
	private String applicationNo;

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	public String getApplicationNo( ) {
		return this.applicationNo;
	}

}
