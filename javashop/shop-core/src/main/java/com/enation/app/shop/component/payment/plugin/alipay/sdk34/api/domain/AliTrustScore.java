package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 芝麻分
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:39
 */
public class AliTrustScore extends AlipayObject {

	private static final long serialVersionUID = 5241823369864969893L;

	/**
	 * 芝麻分
	 */
	@ApiField("score")
	private Long score;

	public Long getScore() {
		return this.score;
	}
	public void setScore(Long score) {
		this.score = score;
	}

}
