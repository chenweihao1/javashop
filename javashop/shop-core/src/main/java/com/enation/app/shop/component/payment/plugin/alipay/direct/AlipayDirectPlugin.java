package com.enation.app.shop.component.payment.plugin.alipay.direct;

import java.util.ArrayList;
import java.util.List;

import com.enation.app.shop.core.order.model.Refund;
import com.enation.app.shop.core.order.model.RefundBill;
import com.enation.framework.plugin.AutoRegisterPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.enation.app.base.core.model.ConfigItem;
import com.enation.app.shop.component.payment.plugin.alipay.direct.executor.AlipayAppPaymentExecutor;
import com.enation.app.shop.component.payment.plugin.alipay.direct.executor.AlipayPaymentExecutor;
import com.enation.app.shop.component.payment.plugin.alipay.direct.executor.AlipayWapPaymentExecutor;
import com.enation.app.shop.core.payment.model.enums.ClientType;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;

/**
 * 支付宝及时到付插件
 * 
 * @author kingapex
 * @version 1.0
 * @since pangu1.0 2017年4月3日下午11:30:18
 */
@Component
@Order(1)
public class AlipayDirectPlugin extends AutoRegisterPlugin implements IPaymentPlugin {

	@Autowired
	private AlipayPaymentExecutor alipayPaymentExecutor;
	
	@Autowired
	private AlipayAppPaymentExecutor appAlipayExecutor;
	
	@Autowired
	private AlipayWapPaymentExecutor wapAlipayExecutor;
	
	@Autowired
	private AlipayRefundExcutor alipayRefundExcutor;
	
	@Override
	public String onPay(PayBill bill) {
		//使用支付客户端判断调用哪个执行者
		if(bill.getClientType().equals(ClientType.PC)){
			
			return alipayPaymentExecutor.onPay(bill);
		}
		
		if(bill.getClientType().equals(ClientType.WAP)){
			
			return wapAlipayExecutor.onPay(bill);
		}
		
		if(bill.getClientType().equals(ClientType.APP)){
			
			return appAlipayExecutor.onPay(bill);
		}
		
		return "客户端类型错误";
	}

	@Override
	public String onReturn(String ordertype) {
		
		return alipayPaymentExecutor.onReturn(ordertype);
	}

	@Override
	public String onCallback(String ordertype) {
		
		return alipayPaymentExecutor.onCallback(ordertype);
	}

	@Override
	public boolean returnPay(RefundBill bill) {
		
		return alipayRefundExcutor.refundPay(bill);
	}

	@Override
	public Refund queryRefundStatus(Refund refund) {
		
		return alipayRefundExcutor.queryRefundStatus(refund);
	}

	@Override
	public List<ConfigItem> definitionConfigItem() {
		List<ConfigItem> list = new ArrayList<>();
		ConfigItem seller_emailItem = new ConfigItem();
		seller_emailItem.setName("alipay_public_key");
		seller_emailItem.setText("支付宝公钥");
		ConfigItem seller_partnerItem = new ConfigItem();
		seller_partnerItem.setName("app_id");
		seller_partnerItem.setText("应用ID");
		ConfigItem seller_keyItem = new ConfigItem();
		seller_keyItem.setName("merchant_private_key");
		seller_keyItem.setText("商户私钥");
		list.add(seller_keyItem);
		list.add(seller_partnerItem);
		list.add(seller_emailItem);
		return list;
	}

	@Override
	public String getPluginId() {
		
		return "alipayDirectPlugin";
	}

	@Override
	public String getPluginName() {
		
		return "支付宝";
	}

	@Override
	public Integer getIsRetrace() {

		return 1;
	}

}
