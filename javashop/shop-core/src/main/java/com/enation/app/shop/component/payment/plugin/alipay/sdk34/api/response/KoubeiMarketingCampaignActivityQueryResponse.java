package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.CampDetail;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.campaign.activity.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-20 16:40:53
 */
public class KoubeiMarketingCampaignActivityQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7566194259844658977L;

	/** 
	 * 活动详情
	 */
	@ApiField("camp_detail")
	private CampDetail campDetail;

	public void setCampDetail(CampDetail campDetail) {
		this.campDetail = campDetail;
	}
	public CampDetail getCampDetail( ) {
		return this.campDetail;
	}

}
