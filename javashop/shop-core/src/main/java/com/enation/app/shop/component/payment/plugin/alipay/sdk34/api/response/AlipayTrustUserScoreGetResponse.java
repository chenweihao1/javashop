package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.AliTrustScore;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.trust.user.score.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-01-04 10:16:11
 */
public class AlipayTrustUserScoreGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 2789134738854291199L;

	/** 
	 * 芝麻信用通过模型计算出的该用户的芝麻信用评分
	 */
	@ApiField("ali_trust_score")
	private AliTrustScore aliTrustScore;

	public void setAliTrustScore(AliTrustScore aliTrustScore) {
		this.aliTrustScore = aliTrustScore;
	}
	public AliTrustScore getAliTrustScore( ) {
		return this.aliTrustScore;
	}

}
