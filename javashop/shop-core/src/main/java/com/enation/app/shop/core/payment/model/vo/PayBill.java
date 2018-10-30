package com.enation.app.shop.core.payment.model.vo;


import com.enation.app.shop.core.order.model.OrderType;
import com.enation.app.shop.core.payment.model.enums.ClientType;

import java.io.Serializable;

/**
 * 要支付的订单
 * @author kingapex
 * @version 1.0
 * @since pangu1.0
 * 2017年4月3日下午11:31:10
 */
public class PayBill implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -8927776219119098139L;


//	public PaymentBill(){super();}
//
//	public PaymentBill(String sn){ super();this.order_sn = sn;}

	/**
	 * 订单id
	 */
	private Integer order_id;

	/**
	 * 订单编号
	 */
	private String order_sn;

	/**
	 * 要支付的金额
	 */
	private Double order_price;

	/**
	 * 此订单的会员id
	 */
	private Integer member_id;

	/**
	 * 会员用户名
	 */
	private String member_name;

	/**
	 * 支付方式id
	 */
	private Integer payment_method_id;

	/**
	 * 支付插件id
	 */
	private String payment_plugin_id;

	/**
	 * 支付名称
	 */
	private String payment_method_name;

	/**
	 * normal:正常的网页跳转
	 * qr:二维码扫描
	 */
	private String pay_mode;

	/**
	 * 交易类型
	 */
	private OrderType orderType;

	/**
	 * 支付类型
	 */
	private ClientType clientType;


	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrder_sn() {
		return order_sn;
	}

	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public Double getOrder_price() {
		return order_price;
	}

	public void setOrder_price(Double order_price) {
		this.order_price = order_price;
	}

	public Integer getPayment_method_id() {
		return payment_method_id;
	}

	public void setPayment_method_id(Integer payment_method_id) {
		this.payment_method_id = payment_method_id;
	}

	public String getPayment_plugin_id() {
		return payment_plugin_id;
	}

	public void setPayment_plugin_id(String payment_plugin_id) {
		this.payment_plugin_id = payment_plugin_id;
	}

	public String getPayment_method_name() {
		return payment_method_name;
	}

	public void setPayment_method_name(String payment_method_name) {
		this.payment_method_name = payment_method_name;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public String getPay_mode() {
		return pay_mode;
	}

	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}


}
