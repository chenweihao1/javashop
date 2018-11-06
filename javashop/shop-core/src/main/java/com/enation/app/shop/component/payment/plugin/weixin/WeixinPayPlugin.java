package com.enation.app.shop.component.payment.plugin.weixin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.enation.app.shop.component.payment.plugin.weixin.executor.WeixinAppPaymentExecutor;
import com.enation.app.shop.component.payment.plugin.weixin.executor.WeixinJsapiPaymentExecutor;
import com.enation.app.shop.component.payment.plugin.weixin.executor.WeixinPaymentExecutor;
import com.enation.app.shop.component.payment.plugin.weixin.executor.WeixinWapPaymentExecutor;
import com.enation.app.shop.core.order.model.Refund;
import com.enation.app.shop.core.order.model.RefundBill;
import com.enation.app.shop.core.payment.model.enums.ClientType;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import com.enation.framework.plugin.AutoRegisterPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.enation.app.base.core.model.ConfigItem;


/**
 * 微信支付插件
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年12月21日 上午10:36:29
 */
@SuppressWarnings("unchecked")
@Component
@Order(2)
public class WeixinPayPlugin extends AutoRegisterPlugin implements IPaymentPlugin {
	
	public static final String OPENID_SESSION_KEY = "weixin_openid";
	public static final String UNIONID_SESSION_KEY = "weixin_unionid";
	
	@Autowired
	private WeixinPaymentExecutor weixinPaymentExecutor;
	
	@Autowired
	private WeixinAppPaymentExecutor appWeixinExecutor;
	
	@Autowired
	private WeixinWapPaymentExecutor wapWeixinExecutor;
	
	@Autowired
	private WeixinRefundExcutor weixinRefundExcutor;
	
	@Autowired
	private WeixinJsapiPaymentExecutor jsapiWeixinExecutor;
	
	@Override
	public String onPay(PayBill bill) {
		
		//使用支付客户端判断调用哪个执行者
		if(bill.getClientType().equals(ClientType.PC)){
			
			return weixinPaymentExecutor.onPay(bill);
		}
		
		if(bill.getClientType().equals(ClientType.WAP)){
			
			HttpServletRequest request = ThreadContextHolder.getHttpRequest();
			String ua = request.getHeader("user-agent").toLowerCase();  
			if (ua.indexOf("micromessenger") > 0) {
				
				return jsapiWeixinExecutor.onPay(bill);
			}else{
				
				return wapWeixinExecutor.onPay(bill);
			}
		}
		
		if(bill.getClientType().equals(ClientType.APP)){
			
			return appWeixinExecutor.onPay(bill);
		}
		
		return "客户端类型错误";
		
	}


	@Override
	public String onReturn(String ordertype) {
		
		return null;
	}

	@Override
	public String onCallback(String ordertype) {
		return weixinPaymentExecutor.onCallback(ordertype);
	}

	@Override
	public boolean returnPay(RefundBill bill) {
		
		return weixinRefundExcutor.returnPay(bill);
	}


	@Override
	public Refund queryRefundStatus(Refund refund) {
		
		return weixinRefundExcutor.queryRefundStatus(refund);
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
		
		return "weixinPayPlugin";
	}


	@Override
	public String getPluginName() {
		
		return "微信";
	}


	@Override
	public Integer getIsRetrace() {
		
		return 1;
	}

}
