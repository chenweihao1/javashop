package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 申请流水撤销
 *
 * @author auto create
 * @since 1.0, 2017-02-07 16:46:35
 */
public class AlipayOfflineMarketShopApplyorderCancelModel extends AlipayObject {

	private static final long serialVersionUID = 8618896177775599667L;

	/**
	 * 撤销申请流水的原因
	 */
	@ApiField("memo")
	private String memo;

	/**
	 * 操作人ID，开店请求时候的操作人ID
	 */
	@ApiField("op_id")
	private String opId;

	/**
	 * 要撤销的订单ID，当店铺创建、修改接口迁移至2.0时，同步返回的apply_id可以用作此接口的入参。
	 */
	@ApiField("order_id")
	private String orderId;

	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOpId() {
		return this.opId;
	}
	public void setOpId(String opId) {
		this.opId = opId;
	}

	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
