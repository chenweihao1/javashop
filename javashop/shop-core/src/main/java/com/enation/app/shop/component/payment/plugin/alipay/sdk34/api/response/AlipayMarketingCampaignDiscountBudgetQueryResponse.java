package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.campaign.discount.budget.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-08 12:53:45
 */
public class AlipayMarketingCampaignDiscountBudgetQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6453467137555521582L;

	/** 
	 * 预算ID
	 */
	@ApiField("budget_id")
	private String budgetId;

	/** 
	 * 预算总金额，单位：元
	 */
	@ApiField("total_amount")
	private String totalAmount;

	/** 
	 * 已使用金额
	 */
	@ApiField("used_amount")
	private String usedAmount;

	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}
	public String getBudgetId( ) {
		return this.budgetId;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getTotalAmount( ) {
		return this.totalAmount;
	}

	public void setUsedAmount(String usedAmount) {
		this.usedAmount = usedAmount;
	}
	public String getUsedAmount( ) {
		return this.usedAmount;
	}

}
