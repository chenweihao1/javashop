package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 余额宝负债端预测数据
 *
 * @author auto create
 * @since 1.0, 2016-10-15 18:47:07
 */
public class AlipayDataDataserviceYuebaolqdDetailQueryModel extends AlipayObject {

	private static final long serialVersionUID = 1262867437463956224L;

	/**
	 * 服务入参，格式为yyyymmdd
	 */
	@ApiField("report_date")
	private String reportDate;

	public String getReportDate() {
		return this.reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

}
