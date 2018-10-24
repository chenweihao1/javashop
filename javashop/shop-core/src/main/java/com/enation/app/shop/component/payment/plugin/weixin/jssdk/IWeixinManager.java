package com.enation.app.shop.component.payment.plugin.weixin.jssdk;
/**
 * 
 * 微信管理 
 * @author zh
 * @version v1.0
 * @since v1.0
 * 2017年12月4日 下午6:34:12
 */
public interface IWeixinManager {
	/**
	 * 生成微信config
	 * @param current_url
	 * @return
	 */
	public String createConfigScript(String current_url);
	
}
