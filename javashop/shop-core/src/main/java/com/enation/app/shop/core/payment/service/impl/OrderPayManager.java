package com.enation.app.shop.core.payment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enation.app.shop.core.order.model.OrderType;
import com.enation.app.shop.core.order.model.Refund;
import com.enation.app.shop.core.order.model.RefundBill;
import com.enation.app.shop.core.payment.model.po.PaymentBill;
import com.enation.app.shop.core.payment.model.po.PaymentMethod;
import com.enation.app.shop.core.payment.service.IPaymentBillManager;
import com.enation.app.shop.core.payment.service.IPaymentMethodManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.enation.app.shop.core.payment.model.enums.ClientType;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.payment.service.IOrderPayManager;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;
import com.enation.framework.database.IDaoSupport;


/**
 * 订单支付业务
 * @author kingapex
 * @version 1.0
 * @since pangu1.0
 * 2017年4月3日下午11:18:18
 */
@Service
public class OrderPayManager implements IOrderPayManager {

	@Autowired
	private List<IPaymentPlugin> paymentPluginList;

	@Autowired
	private IDaoSupport daoSupport;

	@Autowired
	private IPaymentBillManager paymentBillManager;

	@Autowired
	private IPaymentMethodManager paymentMethodManager;

//
//	@Autowired
//	private IAfterSaleManager afterSaleManager;
//
//	@Autowired
//	private ITradeQueryManager tradeQueryManager;



	/**
	 * 支付一个账单
	 * @param bill
	 * @param payment_method_id 选择的支付方式，如果没有选择使用bill中的支付方式
	 * @return
	 */
	private String pay(PayBill bill,Integer payment_method_id){
		String pluginid;
		PaymentMethod paymentMethod  =null;
		//指定了支付方式
		if( payment_method_id != null ){
			paymentMethod = this.daoSupport.queryForObject("select * from es_payment_method where method_id=? ", PaymentMethod.class, payment_method_id);
			if( paymentMethod == null ){
				throw new RuntimeException("未找到相应的支付方式["+payment_method_id+"]");
			}
			pluginid = paymentMethod.getPlugin_id();
		}else{
			pluginid = bill.getPayment_plugin_id();
		}

		String sn = System.currentTimeMillis()+""  ;

		//这里生成支付流水
		PaymentBill paymentStream = new PaymentBill();
		paymentStream.setPay_key(sn);
		paymentStream.setSn(bill.getOrder_sn());
		paymentStream.setIs_pay(0);
		paymentBillManager.add(paymentStream);

		//修改订单的支付方式
		Map<String, Object> map = new HashMap<>();
		map.put("payment_method_id", paymentMethod.getMethod_id());
		map.put("payment_plugin_id", paymentMethod.getPlugin_id()); //支付插件id
		map.put("payment_method_name", paymentMethod.getMethod_name()); //支付方式名称

		this.daoSupport.update("es_order", map, "sn = " + paymentStream.getSn());
		bill.setOrder_sn(sn);

		//调起插件
		IPaymentPlugin plugin = this.findPlugin(pluginid);
		String html = plugin.onPay(bill);

		return html;
	}

	@Override
	public String payOrder(String order_sn,Integer payment_method_id,String pay_mode,String client_type) {

		PayBill bill = this.daoSupport.queryForObject(
				"select order_id ,sn as order_sn,order_amount as order_price ,payment_method_id,payment_plugin_id,payment_method_name " +
						"from es_order  where sn=?", PayBill.class, order_sn);

		if(bill==null){
			throw new RuntimeException("未找到相应的交易["+order_sn+"]");
		}

		bill.setOrderType(OrderType.order);
		bill.setPay_mode(pay_mode);
		bill.setClientType(ClientType.valueOf(client_type));

		return this.pay(bill, payment_method_id);

	}

	@Override
	public String payReturn(String ordertype,String pluginId) {
		IPaymentPlugin plugin = this.findPlugin(pluginId);
		return plugin.onReturn(ordertype);
	}


	@Override
	public String payCallback(String ordertype,String pluginId) {
		IPaymentPlugin plugin = this.findPlugin(pluginId);
		String result  = plugin.onCallback(ordertype);
		return result;
	}




	private IPaymentPlugin findPlugin(String pluginid){

		for (IPaymentPlugin plugin : paymentPluginList) {
			if(plugin.getPluginId().equals( pluginid)){
				return plugin;
			}
		}

		throw new RuntimeException("没有找到要应的支付方式["+pluginid+"]");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean returnOrder(Refund refund) {
		//查询该交易的支付方式
		if(refund.getRefund_type().equals("accountPayPlugin")){
			return true;
		}
		String sql = "select payment_plugin_id,order_price from es_order where sn = ?";

		PayBill bill = this.daoSupport.queryForObject(sql,PayBill.class, refund.getSn());

		if(bill.getOrder_price()<refund.getRefund_money()){
			throw new RuntimeException("退款金额不能大于订单金额");
		}

		IPaymentPlugin plugin = this.findPlugin(bill.getPayment_plugin_id());

		RefundBill refundBill = new RefundBill();
		refundBill.setRefund_price(refund.getRefund_money());
		refundBill.setRefund_sn(refund.getSn());
		refundBill.setTrade_sn(refund.getSn());
			refundBill.setTrade_price(bill.getOrder_price());

		return plugin.returnPay(refundBill);

	}


	@Override
	public void queryRefundOrderStatus() {

//		List<RefundPartVo> list = afterSaleManager.queryNoReturnOrder();
//		if(list!=null && list.size()>0){
//			for(RefundPartVo refund : list){
//				IPaymentPlugin plugin = this.findPlugin(refund.getAccount_type());
//				refund = plugin.queryRefundStatus(refund);
//			}
//			this.afterSaleManager.update(list);
//		}
	}

	public boolean getType(String key){
//		PaymentBill payBill = paymentBillManager.getByPayKey(key);
//		TradePo tradePo = this.tradeQueryManager.getOneBySn(payBill.getSn());
//		if(tradePo.getTrade_type().equals("1")){
//                 return  true;
//		}
		return false;
	}

}
