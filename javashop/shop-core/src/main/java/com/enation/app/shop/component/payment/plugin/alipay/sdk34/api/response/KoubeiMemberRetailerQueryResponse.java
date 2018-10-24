package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.Retailer;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: koubei.member.retailer.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-06 10:47:45
 */
public class KoubeiMemberRetailerQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5811476512496528676L;

	/** 
	 * 零售商信息列表
	 */
	@ApiListField("retailer_list")
	@ApiField("retailer")
	private List<Retailer> retailerList;

	public void setRetailerList(List<Retailer> retailerList) {
		this.retailerList = retailerList;
	}
	public List<Retailer> getRetailerList( ) {
		return this.retailerList;
	}

}
