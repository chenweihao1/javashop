package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 指定优惠金额
 *
 * @author auto create
 * @since 1.0, 2017-03-03 16:47:49
 */
public class ReduceToAmtDstCampPrizeModel extends AlipayObject {

	private static final long serialVersionUID = 3337959268473611691L;

	/**
	 * 优惠后价格
	 */
	@ApiField("reduct_to_amt")
	private String reductToAmt;

	public String getReductToAmt() {
		return this.reductToAmt;
	}
	public void setReductToAmt(String reductToAmt) {
		this.reductToAmt = reductToAmt;
	}

}
