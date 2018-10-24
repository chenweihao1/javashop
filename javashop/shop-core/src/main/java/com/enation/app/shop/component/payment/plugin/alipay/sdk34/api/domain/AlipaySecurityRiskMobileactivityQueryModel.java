package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 客户风险评级客户绑定手机活跃度服务
 *
 * @author auto create
 * @since 1.0, 2016-06-15 13:55:46
 */
public class AlipaySecurityRiskMobileactivityQueryModel extends AlipayObject {

	private static final long serialVersionUID = 8727714397681597667L;

	/**
	 * 账户绑定手机号
	 */
	@ApiField("mobile")
	private String mobile;

	/**
	 * 场景名称
	 */
	@ApiField("scene_id")
	private String sceneId;

	/**
	 * 支付宝userId
	 */
	@ApiField("user_id")
	private String userId;

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSceneId() {
		return this.sceneId;
	}
	public void setSceneId(String sceneId) {
		this.sceneId = sceneId;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
