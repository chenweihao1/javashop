package com.enation.app.shop.core.payment.service;

import java.util.List;

import com.enation.app.base.core.model.ConfigItem;
import com.enation.app.shop.core.order.model.RefundBill;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.order.model.Refund;


/**
 * @Author Sylow
 * @Description //TODO 在线支付事件
 * @Date 17:59 2018/9/18
 */
public interface IPaymentPlugin {

	/**
	 * 生成跳转至第三方支付平台的html和脚本
	 *
	 * @param bill
	 *            可支付的对象
	 * @return 跳转到第三方支付平台的html和脚本
	 */
	String onPay(PayBill bill);

	/**
	 * 同步回调
	 *
	 */
	String onReturn(String ordertype);

	/**
	 * 异步回调
	 *
	 * @return 原样返回插件的返回值。
	 */
	String onCallback(String ordertype);


	/**
	 * 退款，原路退回
	 * @param bill
	 * @return
	 */
    boolean returnPay(RefundBill bill);
	/**
	 * 查询退款的结果
	 * @param refund
	 * @return
	 */
    Refund queryRefundStatus(Refund refund);

	/**
	 * 获取支付插件id
	 * @return
	 */
	String getPluginId();
	
	/**
	 * 支付名称
	 * @return
	 */
	String getPluginName();
	
	/**
	 * 定义
	 *
	 * @return
	 */
	List<ConfigItem> definitionConfigItem();

	/**
	 * 是否支持原路退回   0 不支持  1支持
	 * @return
	 */
	Integer getIsRetrace();


}
