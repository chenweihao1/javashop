package com.enation.app.shop.core.order.model;

import java.io.Serializable;

/**
 * 要退款的订单
 * @author fk
 * @version 1.0
 * @since pangu1.0
 * 2017年7月19日14:27:37
 */
public class RefundBill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6902367702212390171L;

	private String refund_sn;//退款编号
	
	private String trade_sn;//交易编号
	
	private Double refund_price;//退款金额
	
	private Double trade_price;//交易金额
	
	private String trasaction_id;//付款后返回的id码
	
	public String getRefund_sn() {
		return refund_sn;
	}

	public void setRefund_sn(String refund_sn) {
		this.refund_sn = refund_sn;
	}

	public String getTrade_sn() {
		return trade_sn;
	}

	public void setTrade_sn(String trade_sn) {
		this.trade_sn = trade_sn;
	}

	public Double getRefund_price() {
		return refund_price;
	}

	public void setRefund_price(Double refund_price) {
		this.refund_price = refund_price;
	}

	public Double getTrade_price() {
		return trade_price;
	}

	public void setTrade_price(Double trade_price) {
		this.trade_price = trade_price;
	}

	public String getTrasaction_id() {
		return trasaction_id;
	}

	public void setTrasaction_id(String trasaction_id) {
		this.trasaction_id = trasaction_id;
	}

}
