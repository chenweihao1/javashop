package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 报表列表查询接口
 *
 * @author auto create
 * @since 1.0, 2016-10-28 10:26:26
 */
public class KoubeiMarketingDataAlisisReportBatchqueryModel extends AlipayObject {

	private static final long serialVersionUID = 4387733971222996729L;

	/**
	 * 当前页码
	 */
	@ApiField("page")
	private String page;

	/**
	 * 每页最大条数，最大为30
	 */
	@ApiField("size")
	private String size;

	public String getPage() {
		return this.page;
	}
	public void setPage(String page) {
		this.page = page;
	}

	public String getSize() {
		return this.size;
	}
	public void setSize(String size) {
		this.size = size;
	}

}
