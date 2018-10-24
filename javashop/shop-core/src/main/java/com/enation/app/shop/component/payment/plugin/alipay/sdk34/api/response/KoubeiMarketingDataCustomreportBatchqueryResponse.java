package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.CustomReportCondition;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: koubei.marketing.data.customreport.batchquery response.
 * 
 * @author auto create
 * @since 1.0, 2016-11-17 11:57:57
 */
public class KoubeiMarketingDataCustomreportBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4853987342265717463L;

	/** 
	 * 分页输出自定义开放数据规则列表
	 */
	@ApiListField("report_condition_list")
	@ApiField("custom_report_condition")
	private List<CustomReportCondition> reportConditionList;

	public void setReportConditionList(List<CustomReportCondition> reportConditionList) {
		this.reportConditionList = reportConditionList;
	}
	public List<CustomReportCondition> getReportConditionList( ) {
		return this.reportConditionList;
	}

}
