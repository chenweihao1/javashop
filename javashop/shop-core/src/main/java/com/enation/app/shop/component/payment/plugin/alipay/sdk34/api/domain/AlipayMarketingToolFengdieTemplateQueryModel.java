package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 查询当前用户可用的模板列表
 *
 * @author auto create
 * @since 1.0, 2017-03-20 10:29:23
 */
public class AlipayMarketingToolFengdieTemplateQueryModel extends AlipayObject {

	private static final long serialVersionUID = 6757225255142596276L;

	/**
	 * 当前页数，默认为1
	 */
	@ApiField("page_number")
	private Long pageNumber;

	/**
	 * 每页记录数，不能超过50，默认为10
	 */
	@ApiField("page_size")
	private Long pageSize;

	public Long getPageNumber() {
		return this.pageNumber;
	}
	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Long getPageSize() {
		return this.pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

}
