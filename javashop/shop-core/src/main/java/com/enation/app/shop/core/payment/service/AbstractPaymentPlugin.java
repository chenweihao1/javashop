package com.enation.app.shop.core.payment.service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.enation.app.shop.core.order.model.OrderType;
import com.enation.app.shop.core.order.model.PaymentResult;
import com.enation.framework.plugin.AutoRegisterPlugin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.enation.app.base.core.model.ConfigItem;
import com.enation.app.shop.core.payment.model.po.PaymentMethod;
import com.enation.app.shop.core.payment.model.vo.OrderPayReturnParam;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.payment.service.IPaymentBillManager;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import com.enation.framework.database.IDaoSupport;
import com.enation.framework.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 支付插件父类<br>
 * 具有读取配置的能力
 * @author kingapex
 * @version 1.0
 * @since pangu1.0
 * 2017年4月3日下午11:38:38
 */
public abstract class AbstractPaymentPlugin  extends AutoRegisterPlugin {
	
	protected final Log logger = LogFactory.getLog(getClass());
	

	@Autowired
	private IDaoSupport daoSupport;
	
//	@Autowired
//	private IOrderOperateManager orderOperateManager;
	
	@Autowired
	private IPaymentMethodManager paymentMethodManager ;
	
	@Autowired
	private IPaymentBillManager paymentBillManager;
	
	
	/**
	 * 获取插件的配置方式
	 * @return
	 */
	protected Map<String, String> getConfig(){
		//获取当前支付插件的id
		String paymentMethodId = this.getPluginId();
		String config  = daoSupport.queryForString("select config from es_payment_method where plugin_id=?", paymentMethodId);
		if(StringUtil.isEmpty(config)){
			return new HashMap<>();
		}
		Gson gson = new Gson();
		List<ConfigItem> list = gson.fromJson(config,   new TypeToken<List<ConfigItem>>() {  
                }.getType());
		Map<String, String> result = new HashMap<>();
		if(list!=null){
			for(ConfigItem item : list){
				result.put(item.getName(), item.getValue());
			}
		}
		return result;
	}

	
	protected void paySuccess(PaymentResult paymentResult){

		//查询支付方式
		PaymentMethod payment = paymentMethodManager.getByPluginId(this.getPluginId());
		String sn  = paymentResult.getOrdersn();
		String orderType = paymentResult.getOrderType();
		
		double payPrice  = paymentResult.getPay_price();
		
		OrderPayReturnParam param = new OrderPayReturnParam();
		
		param.setPayment_method_id(payment.getMethod_id());
		param.setPayment_method_name(payment.getMethod_name());
		param.setPayment_plugin_id(payment.getPlugin_id());
		param.setPayprice(payPrice);
		param.setPay_key(sn);
		param.setPay_order_no(paymentResult.getPay_order_no());
		param.setTrade(orderType);
		paymentBillManager.Pay(param);
		
		
	}

	/**
	 * 获取同步通知url
	 * @param bill
	 * @return
	 */
	protected String getReturnUrl( PayBill bill){
		String tradeType = bill.getOrderType().name();
		String payMode = bill.getPay_mode();
		
		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		String serverName =request.getServerName();
		int port = request.getServerPort();
		String portstr = "";
		if(port!=80){
			portstr = ":"+port;
		}
		String contextPath = request.getContextPath();
		
		return "http://"+serverName+portstr+contextPath+"/api/shop/order-pay/return/" +tradeType+"/"+payMode+"/" + this.getPluginId()+".do";
	}
	

	
	
	/**
	 * 供支付插件获取显示url
	 * @return
	 */
	private String showUrlPrefix;
	
	
	/**
	 * 显示账单详细url
	 * @param bill
	 * @return
	 */
	protected String getShowUrl(PayBill bill){
		return showUrlPrefix+bill.getOrder_id();
	}
	
	protected String getCallBackUrl(OrderType order_type){
		
		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		String serverName = request.getServerName();
		int port = request.getServerPort();
		String portstr = "";
		if(port!=80){
			portstr = ":"+port;
		}
		String contextPath = request.getContextPath();
		
		return "http://"+serverName+portstr+contextPath+"/api/shop/order-pay/callback/"+order_type.name()+"/" + this.getPluginId()+".do";
	}	
	
	/**
	 * 返回价格字符串
	 * @param price
	 * @return
	 */
	protected String formatPrice(Double price){
		NumberFormat nFormat=NumberFormat.getNumberInstance();
        nFormat.setMaximumFractionDigits(0); 
        nFormat.setGroupingUsed(false);
        return nFormat.format(price);
	}

	
	public String getRefundErrorMessageCode() {
		return "REFUND_ERROR_MESSAGE";
	}

	public abstract String getPluginId();
	
}
