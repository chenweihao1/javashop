package com.enation.app.shop.core.payment.model.vo;

import java.io.Serializable;


/**
 * 订单支付回调参数功能
 * @author fk
 * @version 1.0
 * @since pangu1.0
 * 2017年7月17日14:53:47
 */
public class OrderPayReturnParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4051740176234491980L;
	
	private String pay_key;
	private Double payprice;//支付金额
	private int payment_method_id;//支付方式method
	private String payment_plugin_id;//支付方式bean
	private String payment_method_name;//支付方式
	private String pay_order_no;//支付插件返回的流水号
	private String trade;
	
	

	public String getPay_key() {
		return pay_key;
	}
	public void setPay_key(String pay_key) {
		this.pay_key = pay_key;
	}
	public String getPay_order_no() {
		return pay_order_no;
	}
	public void setPay_order_no(String pay_order_no) {
		this.pay_order_no = pay_order_no;
	}
	public Double getPayprice() {
		return payprice;
	}
	public void setPayprice(Double payprice) {
		this.payprice = payprice;
	}
	
	public int getPayment_method_id() {
		return payment_method_id;
	}
	public void setPayment_method_id(int payment_method_id) {
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
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	
}
