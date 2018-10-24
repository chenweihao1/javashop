package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.member.brandowner.name.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-06 10:48:20
 */
public class KoubeiMemberBrandownerNameQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3645466149317214898L;

	/** 
	 * 品牌商名称
	 */
	@ApiField("name")
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	public String getName( ) {
		return this.name;
	}

}
