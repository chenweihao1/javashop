package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 奖品剩余数量查询
 *
 * @author auto create
 * @since 1.0, 2017-03-23 14:22:01
 */
public class AlipayMarketingCampaignPrizeAmountQueryModel extends AlipayObject {

	private static final long serialVersionUID = 7313197363814449484L;

	/**
	 * 活动id
	 */
	@ApiField("camp_id")
	private String campId;

	/**
	 * 奖品id
	 */
	@ApiField("prize_id")
	private String prizeId;

	public String getCampId() {
		return this.campId;
	}
	public void setCampId(String campId) {
		this.campId = campId;
	}

	public String getPrizeId() {
		return this.prizeId;
	}
	public void setPrizeId(String prizeId) {
		this.prizeId = prizeId;
	}

}
