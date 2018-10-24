package com.enation.app.shop.component.payment.plugin.weixin;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;

import com.enation.app.shop.core.payment.service.AbstractPaymentPlugin;
import com.enation.framework.context.webcontext.ThreadContextHolder;

public class WeixinPuginConfig  extends AbstractPaymentPlugin {

	public static final String OPENID_SESSION_KEY = "weixin_openid";
	public static final String UNIONID_SESSION_KEY = "weixin_unionid";

	// 微信二维码前缀
	public static final String QR_URL_PREFIX = "weixin:\\/\\/wxpay\\/bizpayurl\\?pr=";
	public static final String CACHE_KEY_PREFIX = "pay_";
	
	@Override
	public String getPluginId() {
		
		return "weixinPayPlugin";
	}

	/**
	 * double转成分
	 * @param money
	 * @return
	 */
	protected String toFen(Double money) {
		String value = BigDecimal.valueOf(money).multiply(new BigDecimal(100)).toString();
		
		NumberFormat numberFormat = new DecimalFormat("##");
		
		return numberFormat.format(new BigDecimal(value));
	}
	
	/**
	 * 获取支付成功调取页面
	 * @param tradetype
	 * @return
	 */
	public String getPay_wap_success_url(String tradetype,String out_trade_no) {
		
		HttpServletRequest request  =  ThreadContextHolder.getHttpRequest();
		String serverName =request.getServerName();
		int port =request.getServerPort();
		String portstr = "";
		if(port!=80){
			portstr = ":"+port;
		}
		String contextPath = request.getContextPath();
		
		return "http://"+serverName+portstr+contextPath+"/"+tradetype+"_"+out_trade_no+"_payment-wap-result.html" ;
	}
}
