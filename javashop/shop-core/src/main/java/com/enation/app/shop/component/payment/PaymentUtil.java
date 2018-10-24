package com.enation.app.shop.component.payment;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 支付使用的工具类
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年11月6日 下午5:31:06
 */
public class PaymentUtil {

	/**
	 * 生成某种格式
	 * @param params
	 * @return
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			
			if("sign".equals(key)){
				continue;
			}
			
			if ("".equals(prestr)) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr +"&" +key + "=" + value ;
			}
		}
		return prestr;
	}

	/**
	 * 使用某种编码格式对value进行encode
	 * @param params
	 * @param encode
	 * @return
	 */
	public static String createLinkStringEncode(Map<String, String> params, String encode) {
		
		String prestr = "";
		try {
			List<String> keys = new ArrayList<String>(params.keySet());
			Collections.sort(keys);
	
	
			for (int i = 0; i < keys.size(); i++) {
				String key = keys.get(i);
				String value = params.get(key);
				
				if("sign".equals(key)){
					continue;
				}
				
//				if ("".equals(prestr)) {// 拼接时，不包括最后一个&字符
//					
//						prestr = prestr + key + "=" + new String(value.getBytes(),encode);
//					
//				} else {
//					prestr = prestr +"&" +key + "=" + new String(value.getBytes(),encode);
//				}
				if ("".equals(prestr)) {// 拼接时，不包括最后一个&字符
					
						prestr = prestr + key + "=" + java.net.URLEncoder.encode(value, encode);
					
				} else {
					prestr = prestr +"&" +key + "=" + java.net.URLEncoder.encode(value, encode);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return prestr;
		
	}
}
