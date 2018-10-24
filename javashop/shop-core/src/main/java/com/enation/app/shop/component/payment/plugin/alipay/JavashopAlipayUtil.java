package com.enation.app.shop.component.payment.plugin.alipay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.util.AlipaySignature;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.config.AlipayConfig;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.config.AlipayConfig34;
import com.enation.framework.context.webcontext.ThreadContextHolder;


/**
 * 支付宝工具
 * 提供验证方法
 * @author kingapex
 * @version 1.0
 *2015年9月24日下午1:47:42
 */
public abstract class JavashopAlipayUtil {
	
	/**
	 * 新版验证  2017年8月1日15:27:48
	 * @return
	 */
	public static boolean verify() {
		try {

			HttpServletRequest request = ThreadContextHolder.getHttpRequest();
			Map<String,String> params = new HashMap<String,String>();
			Map<String,String[]> requestParams = request.getParameterMap();
			for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				
				//乱码解决，这段代码在出现乱码时使用
				//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
			
			return signVerified;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
