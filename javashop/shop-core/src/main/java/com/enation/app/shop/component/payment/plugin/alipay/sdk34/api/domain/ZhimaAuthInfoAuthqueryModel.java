package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 查询是否授权的接口
 *
 * @author auto create
 * @since 1.0, 2016-09-21 19:49:58
 */
public class ZhimaAuthInfoAuthqueryModel extends AlipayObject {

	private static final long serialVersionUID = 5416969632331155112L;

	/**
	 * json格式的内容,包含userId,userId为支付宝用户id,用户授权后商户可以拿到这个支付宝userId
	 */
	@ApiField("identity_param")
	private String identityParam;

	public String getIdentityParam() {
		return this.identityParam;
	}
	public void setIdentityParam(String identityParam) {
		this.identityParam = identityParam;
	}

}
