package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.AliTrustRiskIdentify;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.trust.user.riskidentify.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-01-04 10:16:04
 */
public class AlipayTrustUserRiskidentifyGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 2696549622549663913L;

	/** 
	 * 行业关注名单识别结果
	 */
	@ApiField("ali_trust_risk_identify")
	private AliTrustRiskIdentify aliTrustRiskIdentify;

	public void setAliTrustRiskIdentify(AliTrustRiskIdentify aliTrustRiskIdentify) {
		this.aliTrustRiskIdentify = aliTrustRiskIdentify;
	}
	public AliTrustRiskIdentify getAliTrustRiskIdentify( ) {
		return this.aliTrustRiskIdentify;
	}

}
