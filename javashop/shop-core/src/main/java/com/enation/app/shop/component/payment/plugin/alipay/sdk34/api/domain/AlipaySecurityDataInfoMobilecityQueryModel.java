package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 手机号归属信息查询
 *
 * @author auto create
 * @since 1.0, 2017-01-03 17:38:43
 */
public class AlipaySecurityDataInfoMobilecityQueryModel extends AlipayObject {

	private static final long serialVersionUID = 8566759665633927248L;

	/**
	 * 电话号码
	 */
	@ApiField("phone")
	private String phone;

	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
