package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.AlipayUserDetail;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.user.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-29 19:51:20
 */
public class AlipayUserGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 8283674818129544313L;

	/** 
	 * 支付宝用户信息
	 */
	@ApiField("alipay_user_detail")
	private AlipayUserDetail alipayUserDetail;

	public void setAlipayUserDetail(AlipayUserDetail alipayUserDetail) {
		this.alipayUserDetail = alipayUserDetail;
	}
	public AlipayUserDetail getAlipayUserDetail( ) {
		return this.alipayUserDetail;
	}

}
