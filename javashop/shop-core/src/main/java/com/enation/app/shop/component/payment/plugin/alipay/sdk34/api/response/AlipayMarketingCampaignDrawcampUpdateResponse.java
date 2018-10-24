package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.campaign.drawcamp.update response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-23 14:22:20
 */
public class AlipayMarketingCampaignDrawcampUpdateResponse extends AlipayResponse {

	private static final long serialVersionUID = 5813438178754947157L;

	/** 
	 * 操作结果状态，true表示修改成功立即生效，false表示修改失败
	 */
	@ApiField("camp_result")
	private Boolean campResult;

	public void setCampResult(Boolean campResult) {
		this.campResult = campResult;
	}
	public Boolean getCampResult( ) {
		return this.campResult;
	}

}
