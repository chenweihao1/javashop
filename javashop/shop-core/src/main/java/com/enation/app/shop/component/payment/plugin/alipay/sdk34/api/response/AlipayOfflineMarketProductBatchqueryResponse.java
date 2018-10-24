package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.offline.market.product.batchquery response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-14 11:43:44
 */
public class AlipayOfflineMarketProductBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 8152591148131247724L;

	/** 
	 * 当前页码
	 */
	@ApiField("current_pageno")
	private Long currentPageno;

	/** 
	 * 商品列表ID，逗号分隔
	 */
	@ApiListField("item_ids")
	@ApiField("string")
	private List<String> itemIds;

	/** 
	 * 总页码数
	 */
	@ApiField("total_pageno")
	private Long totalPageno;

	public void setCurrentPageno(Long currentPageno) {
		this.currentPageno = currentPageno;
	}
	public Long getCurrentPageno( ) {
		return this.currentPageno;
	}

	public void setItemIds(List<String> itemIds) {
		this.itemIds = itemIds;
	}
	public List<String> getItemIds( ) {
		return this.itemIds;
	}

	public void setTotalPageno(Long totalPageno) {
		this.totalPageno = totalPageno;
	}
	public Long getTotalPageno( ) {
		return this.totalPageno;
	}

}
