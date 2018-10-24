package com.enation.app.shop.core.payment.model.vo;

import java.io.Serializable;


/**
 * 支付结果包括订单
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年8月31日 下午2:23:19
 */
public class PaymentOrderResult implements Serializable{

	private static final long serialVersionUID = 8152920682508525903L;

	private Integer result;
	
	//private OrderDetail orderDetail;
	
	//private TradePo tradePo;
	
	private String  error;
	
	private String type;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

//	public OrderDetail getOrderDetail() {
//		return orderDetail;
//	}
//
//	public void setOrderDetail(OrderDetail orderDetail) {
//		this.orderDetail = orderDetail;
//	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public TradePo getTradePo() {
//		return tradePo;
//	}
//
//	public void setTradePo(TradePo tradePo) {
//		this.tradePo = tradePo;
//	}
	
	
}
