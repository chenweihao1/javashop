package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 查询某个ISV下的指定app_auth_token的授权信息：授权者、授权接口列表、状态、过期时间等
 *
 * @author auto create
 * @since 1.0, 2016-07-18 13:35:47
 */
public class AlipayOpenAuthTokenAppQueryModel extends AlipayObject {

	private static final long serialVersionUID = 3422676798797248676L;

	/**
	 * 应用授权令牌
	 */
	@ApiField("app_auth_token")
	private String appAuthToken;

	public String getAppAuthToken() {
		return this.appAuthToken;
	}
	public void setAppAuthToken(String appAuthToken) {
		this.appAuthToken = appAuthToken;
	}

}
