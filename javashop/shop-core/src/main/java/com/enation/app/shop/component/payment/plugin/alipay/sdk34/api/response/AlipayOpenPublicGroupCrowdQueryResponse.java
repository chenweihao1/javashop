package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.group.crowd.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-06-14 11:01:58
 */
public class AlipayOpenPublicGroupCrowdQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7415216196362643135L;

	/** 
	 * 分组圈出的人群数量
	 */
	@ApiField("count")
	private String count;

	public void setCount(String count) {
		this.count = count;
	}
	public String getCount( ) {
		return this.count;
	}

}
