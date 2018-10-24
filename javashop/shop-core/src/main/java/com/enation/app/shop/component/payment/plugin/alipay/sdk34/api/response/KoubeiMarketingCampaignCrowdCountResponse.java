package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.campaign.crowd.count response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-07 17:14:41
 */
public class KoubeiMarketingCampaignCrowdCountResponse extends AlipayResponse {

	private static final long serialVersionUID = 1672384455113373336L;

	/** 
	 * 各个细分维度的值，label为标签code，value为该标签各个标签值对应的统计信息，本示例表示pam_gender这个标签的男有100人，女有1000人满足入参指定的圈人条件
	 */
	@ApiField("dimension_values")
	private String dimensionValues;

	/** 
	 * 人群组的汇总统计值total是人数，sum是交易金额
	 */
	@ApiField("summary_values")
	private String summaryValues;

	public void setDimensionValues(String dimensionValues) {
		this.dimensionValues = dimensionValues;
	}
	public String getDimensionValues( ) {
		return this.dimensionValues;
	}

	public void setSummaryValues(String summaryValues) {
		this.summaryValues = summaryValues;
	}
	public String getSummaryValues( ) {
		return this.summaryValues;
	}

}
