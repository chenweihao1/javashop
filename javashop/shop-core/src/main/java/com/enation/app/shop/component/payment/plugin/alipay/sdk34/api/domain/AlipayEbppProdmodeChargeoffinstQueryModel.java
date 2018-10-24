package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 查询销账机构列表
 *
 * @author auto create
 * @since 1.0, 2016-12-22 21:53:37
 */
public class AlipayEbppProdmodeChargeoffinstQueryModel extends AlipayObject {

	private static final long serialVersionUID = 1545984784168915138L;

	/**
	 * 业务类型
	 */
	@ApiField("biz_type")
	private String bizType;

	public String getBizType() {
		return this.bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

}
