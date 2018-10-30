package com.enation.app.shop.core.payment.service;


import com.enation.app.shop.core.order.model.Refund;

/**
 * 订单支付管理
 * @author kingapex
 * @version 1.0
 * @since pangu1.0
 * 2017年4月3日下午11:17:35
 */
public interface IOrderPayManager {
	
	
	/**
	 * 对某订单支付
	 * @param ordersn 订单sn
	 * @param payment_method_id 支付方式id
	 * @param payMode 支付模式：
	 * normal:正常的网页跳转
	 * qr:二维码扫描
	 * 如果为空默认为normal模式
	 * @return 支付跳转HTML
	 */
	String payOrder(String ordersn ,Integer payment_method_id,String payMode,String client_type);
	
	
	/**
	 * 支付同步回调
	 * @param pluginId
	 */
	String payReturn(String ordertype,String pluginId);
	
	
	/**
	 * 支付异步回调
	 * @param pluginId
	 * @return
	 */
	String payCallback(String ordertype,String pluginId);


	/**
	 * 订单退款，原路退回

	 */
	boolean returnOrder(Refund refund);


	/**
	 * 查询退款进度情况
	 */
	void queryRefundOrderStatus();


	boolean getType(String tSn);

}
