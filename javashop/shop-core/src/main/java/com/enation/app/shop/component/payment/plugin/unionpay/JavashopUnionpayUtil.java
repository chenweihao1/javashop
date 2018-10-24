package com.enation.app.shop.component.payment.plugin.unionpay;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.util.AlipaySignature;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.config.AlipayConfig;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.config.AlipayConfig34;
import com.enation.app.shop.component.payment.plugin.unionpay.sdk.AcpService;
import com.enation.app.shop.component.payment.plugin.unionpay.sdk.LogUtil;
import com.enation.framework.context.webcontext.ThreadContextHolder;


/**
 * 支付宝工具
 * 提供验证方法
 * @author kingapex
 * @version 1.0
 *2015年9月24日下午1:47:42
 */
public abstract class JavashopUnionpayUtil {
	
	/**
	 * 验权
	 * @return
	 */
	public static boolean validaeData(){
		HttpServletRequest req = ThreadContextHolder.getHttpRequest();
		Map<String, String> respParam = getAllRequestParam(req);

		// 打印请求报文
		LogUtil.printRequestLog(respParam);

		Map<String, String> valideData = null;
		if (null != respParam && !respParam.isEmpty()) {
			Iterator<Entry<String, String>> it = respParam.entrySet()
					.iterator();
			valideData = new HashMap<String, String>(respParam.size());
			while (it.hasNext()) {
				Entry<String, String> e = it.next();
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				try {
					value = new String(value.getBytes(UnionpayPlugin.encoding), UnionpayPlugin.encoding);
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 
				valideData.put(key, value);
			}
		}
		if (!AcpService.validate(valideData, UnionpayPlugin.encoding)) {
			LogUtil.writeLog("验证签名结果[失败].");
			return false;
			
		} else {
			LogUtil.writeLog("验证签名结果[成功].");
			return true;
		}
	}
	
	/**
	 * 获取请求参数中所有的信息
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getAllRequestParam(
			final HttpServletRequest request) {
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				// 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
				if (res.get(en) == null || "".equals(res.get(en))) {
					// System.out.println("======为空的字段名===="+en);
					res.remove(en);
				}
			}
		}
		return res;
	}
}
