package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.campaign.discount.budget.append response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-08 12:53:50
 */
public class AlipayMarketingCampaignDiscountBudgetAppendResponse extends AlipayResponse {

	private static final long serialVersionUID = 4411688523157482193L;

	/** 
	 * 预算ID
	 */
	@ApiField("budget_id")
	private String budgetId;

	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}
	public String getBudgetId( ) {
		return this.budgetId;
	}

}
