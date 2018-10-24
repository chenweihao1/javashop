package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 零售商信息
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:42
 */
public class Retailer extends AlipayObject {

	private static final long serialVersionUID = 2826275226999451973L;

	/**
	 * 零售商名称
	 */
	@ApiField("name")
	private String name;

	/**
	 * 零售商pid
	 */
	@ApiField("partner_id")
	private String partnerId;

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPartnerId() {
		return this.partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

}
