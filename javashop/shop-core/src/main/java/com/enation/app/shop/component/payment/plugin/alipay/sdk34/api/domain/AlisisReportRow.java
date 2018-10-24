package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * 报表行对象
 *
 * @author auto create
 * @since 1.0, 2016-10-28 10:26:15
 */
public class AlisisReportRow extends AlipayObject {

	private static final long serialVersionUID = 1565177871463427383L;

	/**
	 * 报表行信息，每个对象是一列的数据
	 */
	@ApiListField("row_data")
	@ApiField("alisis_report_column")
	private List<AlisisReportColumn> rowData;

	public List<AlisisReportColumn> getRowData() {
		return this.rowData;
	}
	public void setRowData(List<AlisisReportColumn> rowData) {
		this.rowData = rowData;
	}

}
