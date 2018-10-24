package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.trust.user.report.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-03-04 11:36:24
 */
public class AlipayTrustUserReportGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 7175455882828753865L;

	/** 
	 * 报告内容，格式详见示例代码
	 */
	@ApiField("report")
	private String report;

	public void setReport(String report) {
		this.report = report;
	}
	public String getReport( ) {
		return this.report;
	}

}
