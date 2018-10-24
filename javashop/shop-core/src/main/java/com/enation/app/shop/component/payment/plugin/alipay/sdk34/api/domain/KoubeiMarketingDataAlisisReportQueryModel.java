package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 报表详情查询接口
 *
 * @author auto create
 * @since 1.0, 2017-03-24 16:17:12
 */
public class KoubeiMarketingDataAlisisReportQueryModel extends AlipayObject {

	private static final long serialVersionUID = 5146231238944596781L;

	/**
	 * 报表唯一标识
	 */
	@ApiField("report_uk")
	private String reportUk;

	public String getReportUk() {
		return this.reportUk;
	}
	public void setReportUk(String reportUk) {
		this.reportUk = reportUk;
	}

}
