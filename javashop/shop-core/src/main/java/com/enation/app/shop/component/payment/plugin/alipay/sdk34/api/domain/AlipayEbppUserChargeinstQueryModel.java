package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 查询用户常缴机构与城市接口
 *
 * @author auto create
 * @since 1.0, 2017-05-22 17:13:48
 */
public class AlipayEbppUserChargeinstQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4358923753167628233L;

	/**
	 * 用户ID
	 */
	@ApiField("user_id")
	private String userId;

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
