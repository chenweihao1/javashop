package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 保险营销权益基础信息
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:38
 */
public class InsMktCouponBaseDTO extends AlipayObject {

	private static final long serialVersionUID = 2831229672221443851L;

	/**
	 * 权益Id
	 */
	@ApiField("coupon_id")
	private String couponId;

	/**
	 * 权益类型
	 */
	@ApiField("coupon_type")
	private String couponType;

	/**
	 * 权益值
	 */
	@ApiField("coupon_value")
	private String couponValue;

	public String getCouponId() {
		return this.couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCouponType() {
		return this.couponType;
	}
	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCouponValue() {
		return this.couponValue;
	}
	public void setCouponValue(String couponValue) {
		this.couponValue = couponValue;
	}

}
