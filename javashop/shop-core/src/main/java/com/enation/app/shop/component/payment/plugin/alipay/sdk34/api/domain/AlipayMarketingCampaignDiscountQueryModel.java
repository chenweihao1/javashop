package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 优惠活动查看
 *
 * @author auto create
 * @since 1.0, 2017-03-03 16:47:49
 */
public class AlipayMarketingCampaignDiscountQueryModel extends AlipayObject {

	private static final long serialVersionUID = 2568369181474968742L;

	/**
	 * 活动id
	 */
	@ApiField("camp_id")
	private String campId;

	public String getCampId() {
		return this.campId;
	}
	public void setCampId(String campId) {
		this.campId = campId;
	}

}
