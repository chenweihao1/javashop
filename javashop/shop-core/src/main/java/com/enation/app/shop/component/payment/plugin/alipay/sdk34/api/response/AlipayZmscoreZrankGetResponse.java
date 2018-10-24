package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.AlipayZmScoreZrankResult;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.zmscore.zrank.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-02 14:27:12
 */
public class AlipayZmscoreZrankGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 6662369132787933254L;

	/** 
	 * 芝麻分分段
	 */
	@ApiField("zm_score_zrank")
	private AlipayZmScoreZrankResult zmScoreZrank;

	public void setZmScoreZrank(AlipayZmScoreZrankResult zmScoreZrank) {
		this.zmScoreZrank = zmScoreZrank;
	}
	public AlipayZmScoreZrankResult getZmScoreZrank( ) {
		return this.zmScoreZrank;
	}

}
