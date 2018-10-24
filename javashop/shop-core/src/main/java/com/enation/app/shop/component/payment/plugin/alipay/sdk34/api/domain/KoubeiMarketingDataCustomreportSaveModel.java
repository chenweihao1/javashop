package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 自定义数据报表创建及更新接口
 *
 * @author auto create
 * @since 1.0, 2017-03-10 17:56:42
 */
public class KoubeiMarketingDataCustomreportSaveModel extends AlipayObject {

	private static final long serialVersionUID = 7196252271813612761L;

	/**
	 * 自定义报表规则条件信息
	 */
	@ApiField("report_condition_info")
	private CustomReportCondition reportConditionInfo;

	public CustomReportCondition getReportConditionInfo() {
		return this.reportConditionInfo;
	}
	public void setReportConditionInfo(CustomReportCondition reportConditionInfo) {
		this.reportConditionInfo = reportConditionInfo;
	}

}
