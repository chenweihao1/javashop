package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 集点查询
 *
 * @author auto create
 * @since 1.0, 2016-10-09 11:45:18
 */
public class KoubeiMarketingToolPointsQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4183247598233223211L;

	/**
	 * 活动积分帐户
	 */
	@ApiField("activity_account")
	private String activityAccount;

	/**
	 * 用户ID
	 */
	@ApiField("user_id")
	private String userId;

	public String getActivityAccount() {
		return this.activityAccount;
	}
	public void setActivityAccount(String activityAccount) {
		this.activityAccount = activityAccount;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
