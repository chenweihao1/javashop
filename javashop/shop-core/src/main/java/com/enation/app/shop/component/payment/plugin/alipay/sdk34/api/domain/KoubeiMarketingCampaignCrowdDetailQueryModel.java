package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 口碑商户人群组详情查询接口
 *
 * @author auto create
 * @since 1.0, 2016-08-29 14:52:14
 */
public class KoubeiMarketingCampaignCrowdDetailQueryModel extends AlipayObject {

	private static final long serialVersionUID = 8642828869487593225L;

	/**
	 * 人群组ID，人群组创建成功时返回的ID
	 */
	@ApiField("crowd_group_id")
	private String crowdGroupId;

	public String getCrowdGroupId() {
		return this.crowdGroupId;
	}
	public void setCrowdGroupId(String crowdGroupId) {
		this.crowdGroupId = crowdGroupId;
	}

}
