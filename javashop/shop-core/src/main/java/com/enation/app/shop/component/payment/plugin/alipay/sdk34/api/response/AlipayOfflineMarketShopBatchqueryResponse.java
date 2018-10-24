package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.offline.market.shop.batchquery response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-14 11:53:10
 */
public class AlipayOfflineMarketShopBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3698978551353529256L;

	/** 
	 * 当前页码
	 */
	@ApiField("current_pageno")
	private String currentPageno;

	/** 
	 * 门店列表ID，逗号分隔
	 */
	@ApiListField("shop_ids")
	@ApiField("string")
	private List<String> shopIds;

	/** 
	 * 总页码数目
	 */
	@ApiField("total_pageno")
	private String totalPageno;

	public void setCurrentPageno(String currentPageno) {
		this.currentPageno = currentPageno;
	}
	public String getCurrentPageno( ) {
		return this.currentPageno;
	}

	public void setShopIds(List<String> shopIds) {
		this.shopIds = shopIds;
	}
	public List<String> getShopIds( ) {
		return this.shopIds;
	}

	public void setTotalPageno(String totalPageno) {
		this.totalPageno = totalPageno;
	}
	public String getTotalPageno( ) {
		return this.totalPageno;
	}

}
