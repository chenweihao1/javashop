package com.enation.app.shop.component.payment.plugin.weixin.app;

import java.util.ArrayList;
import java.util.List;

import com.enation.app.shop.component.payment.plugin.weixin.WeixinPayPlugin;
import com.enation.app.shop.component.payment.plugin.weixin.executor.WeixinAppPaymentExecutor;
import com.enation.app.shop.core.order.model.RefundBill;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enation.app.base.core.model.ConfigItem;

/**
 * app原生支付
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年10月31日 下午2:25:19
 */
@Service
@Order(2)
public class WeixinAppPayPlugin extends WeixinPayPlugin implements IPaymentPlugin {

	@Autowired
	private WeixinAppPaymentExecutor appWeixinExecutor;
	
	@Override
	public String onPay(PayBill bill) {
		
		return appWeixinExecutor.onPay(bill);
	}
	
	@Override
	public List<ConfigItem> definitionConfigItem() {
		List<ConfigItem> list = new ArrayList<>();
		ConfigItem seller_mchidItem = new ConfigItem();
		seller_mchidItem.setName("mchid");
		seller_mchidItem.setText("商户号MCHID");
		ConfigItem seller_appidItem = new ConfigItem();
		seller_appidItem.setName("appid");
		seller_appidItem.setText("APPID");
		ConfigItem seller_keyItem = new ConfigItem();
		seller_keyItem.setName("key");
		seller_keyItem.setText("API密钥(key)");
		ConfigItem seller_secretItem = new ConfigItem();
		seller_secretItem.setName("appSecret");
		seller_secretItem.setText("应用密钥(AppScret)");
		ConfigItem seller_p12Item = new ConfigItem();
		seller_p12Item.setName("p12_path");
		seller_p12Item.setText("证书路径");
		list.add(seller_mchidItem);
		list.add(seller_appidItem);
		list.add(seller_keyItem);
		list.add(seller_secretItem);
		list.add(seller_p12Item);
		return list;
	}
	
	@Override
	public String getPluginId() {
		
		return "weixinAppPayPlugin";
	}


	@Override
	public String getPluginName() {
		
		return "微信app原生";
	}
	
	@Override
	public String onCallback(String ordertype) {
		
		return appWeixinExecutor.onCallback(ordertype);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean returnPay(RefundBill bill) {
		return appWeixinExecutor.returnPay(bill);
	}
	
	
}
