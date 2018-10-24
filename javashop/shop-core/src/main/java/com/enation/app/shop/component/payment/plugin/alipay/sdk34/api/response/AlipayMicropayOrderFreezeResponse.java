package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.MicroPayOrderDetail;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.micropay.order.freeze response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-06 17:49:00
 */
public class AlipayMicropayOrderFreezeResponse extends AlipayResponse {

	private static final long serialVersionUID = 1151955813445317964L;

	/** 
	 * 冻结订单详情
	 */
	@ApiField("micro_pay_order_detail")
	private MicroPayOrderDetail microPayOrderDetail;

	public void setMicroPayOrderDetail(MicroPayOrderDetail microPayOrderDetail) {
		this.microPayOrderDetail = microPayOrderDetail;
	}
	public MicroPayOrderDetail getMicroPayOrderDetail( ) {
		return this.microPayOrderDetail;
	}

}
