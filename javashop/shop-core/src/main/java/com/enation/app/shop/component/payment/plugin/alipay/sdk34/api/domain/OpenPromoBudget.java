package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 开放活动－预算
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:38
 */
public class OpenPromoBudget extends AlipayObject {

	private static final long serialVersionUID = 2529287514874467196L;

	/**
	 * 预算数量，支持1～999999999之间。默认为999999999
	 */
	@ApiField("budget_total")
	private String budgetTotal;

	/**
	 * 预算类型，现在支持CAMP_BUDGET_AMOUNT：表示数量预算
	 */
	@ApiField("budget_type")
	private String budgetType;

	public String getBudgetTotal() {
		return this.budgetTotal;
	}
	public void setBudgetTotal(String budgetTotal) {
		this.budgetTotal = budgetTotal;
	}

	public String getBudgetType() {
		return this.budgetType;
	}
	public void setBudgetType(String budgetType) {
		this.budgetType = budgetType;
	}

}
