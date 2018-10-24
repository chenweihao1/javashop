package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.card.consume.sync response.
 * 
 * @author auto create
 * @since 1.0, 2016-10-18 15:46:55
 */
public class AlipayMarketingCardConsumeSyncResponse extends AlipayResponse {

	private static final long serialVersionUID = 1255827882324721378L;

	/** 
	 * 外部卡号
	 */
	@ApiField("external_card_no")
	private String externalCardNo;

	public void setExternalCardNo(String externalCardNo) {
		this.externalCardNo = externalCardNo;
	}
	public String getExternalCardNo( ) {
		return this.externalCardNo;
	}

}
