package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.cdp.advertise.create response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-01 15:29:02
 */
public class AlipayMarketingCdpAdvertiseCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 3649342977751819978L;

	/** 
	 * 创建广告唯一标识
	 */
	@ApiField("ad_id")
	private String adId;

	public void setAdId(String adId) {
		this.adId = adId;
	}
	public String getAdId( ) {
		return this.adId;
	}

}
