package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.transfer.thirdparty.bill.create response.
 * 
 * @author auto create
 * @since 1.0, 2014-06-25 17:00:56
 */
public class AlipayTransferThirdpartyBillCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 6176792824841921412L;

	/** 
	 * 支付宝转账交易号
	 */
	@ApiField("order_id")
	private String orderId;

	/** 
	 * 交易类型，固定为transfer
	 */
	@ApiField("order_type")
	private String orderType;

	/** 
	 * 外部应用创建的交易ID
	 */
	@ApiField("payment_id")
	private String paymentId;

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderId( ) {
		return this.orderId;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderType( ) {
		return this.orderType;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentId( ) {
		return this.paymentId;
	}

}
