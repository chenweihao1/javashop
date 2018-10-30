package com.enation.app.shop.core.order.model;

/**
 * 订单类型
 * @author kingapex
 * @version 1.0
 * @since pangu1.0
 * 2017年4月5日下午5:12:55
 */
public enum OrderType {
	
	order("订单");
	
	private String description;

	OrderType(String _description){
		  this.description=_description;
	}
}
