package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 标准的兑换交易受理接口
 *
 * @author auto create
 * @since 1.0, 2016-05-13 15:15:53
 */
public class AlipayAccountExrateAdviceAcceptModel extends AlipayObject {

	private static final long serialVersionUID = 3132913716898931831L;

	/**
	 * 交易请求对象内容
	 */
	@ApiField("advice")
	private AdviceVO advice;

	public AdviceVO getAdvice() {
		return this.advice;
	}
	public void setAdvice(AdviceVO advice) {
		this.advice = advice;
	}

}
