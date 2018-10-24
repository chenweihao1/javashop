package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 圈人标签查询
 *
 * @author auto create
 * @since 1.0, 2016-12-19 15:27:21
 */
public class AlipayMarketingCampaignRuleTagQueryModel extends AlipayObject {

	private static final long serialVersionUID = 8879771562454489325L;

	/**
	 * 签约商户下属机构唯一编号
	 */
	@ApiField("mpid")
	private String mpid;

	public String getMpid() {
		return this.mpid;
	}
	public void setMpid(String mpid) {
		this.mpid = mpid;
	}

}
