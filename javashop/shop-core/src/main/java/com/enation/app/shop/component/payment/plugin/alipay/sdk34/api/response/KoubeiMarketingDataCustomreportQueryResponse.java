package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.ReportDataItem;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: koubei.marketing.data.customreport.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-13 15:42:37
 */
public class KoubeiMarketingDataCustomreportQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6444284716339945727L;

	/** 
	 * 数据量
	 */
	@ApiField("count")
	private String count;

	/** 
	 * 满足自定义报表规则的报表数据
	 */
	@ApiListField("report_data")
	@ApiField("report_data_item")
	private List<ReportDataItem> reportData;

	public void setCount(String count) {
		this.count = count;
	}
	public String getCount( ) {
		return this.count;
	}

	public void setReportData(List<ReportDataItem> reportData) {
		this.reportData = reportData;
	}
	public List<ReportDataItem> getReportData( ) {
		return this.reportData;
	}

}
