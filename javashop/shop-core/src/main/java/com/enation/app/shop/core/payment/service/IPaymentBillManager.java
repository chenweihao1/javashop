package com.enation.app.shop.core.payment.service;

import com.enation.app.shop.core.payment.model.po.PaymentBill;
import com.enation.app.shop.core.payment.model.vo.OrderPayReturnParam;

/**
 * 支付流水manager
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年8月30日 上午11:15:27
 */
public interface IPaymentBillManager {

	/**
	 * 添加流水
	 * @param paymentStream
	 * @return
	 */
	PaymentBill add(PaymentBill paymentStream);

	/**
	 * 使用支付编号查询某个流水
	 * @param pay_key
	 * @return
	 */
	PaymentBill getByPayKey(String pay_key);

	/**
	 * 更新支付流水中的交易流水号
	 * @param paymentStream
	 */
	void update(PaymentBill paymentStream);

	/**
	 * 使用sn查询某个流水
	 * @param sn
	 * @return
	 */
	PaymentBill getBySn(String sn);
	
	/**
	 * 支付接口
	 * @param orderPayReturnParam	订单支付回调参数
	 */
	void Pay(OrderPayReturnParam orderPayReturnParam);

}
