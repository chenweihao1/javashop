package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.RecruitShopInfo;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: koubei.marketing.campaign.recruit.shop.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-12-19 14:48:59
 */
public class KoubeiMarketingCampaignRecruitShopQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3557175755436819333L;

	/** 
	 * 招商活动id
	 */
	@ApiField("plan_id")
	private String planId;

	/** 
	 * 总量
	 */
	@ApiField("shop_count")
	private String shopCount;

	/** 
	 * 招商门店确认详情
	 */
	@ApiListField("shop_info")
	@ApiField("recruit_shop_info")
	private List<RecruitShopInfo> shopInfo;

	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanId( ) {
		return this.planId;
	}

	public void setShopCount(String shopCount) {
		this.shopCount = shopCount;
	}
	public String getShopCount( ) {
		return this.shopCount;
	}

	public void setShopInfo(List<RecruitShopInfo> shopInfo) {
		this.shopInfo = shopInfo;
	}
	public List<RecruitShopInfo> getShopInfo( ) {
		return this.shopInfo;
	}

}
