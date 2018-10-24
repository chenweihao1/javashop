package com.enation.app.shop.core.payment.service;

import java.util.List;

import com.enation.app.shop.core.payment.model.enums.ClientType;
import com.enation.app.shop.core.payment.model.po.PaymentMethod;
import com.enation.app.shop.core.payment.model.vo.PaymentMethodVo;
import com.enation.app.shop.core.payment.model.vo.PaymentPluginVo;


/**
 * @Author Sylow
 * @Description //TODO 支付方式业务管理接口
 * @Date 15:19 2018/9/19
 */
public interface IPaymentMethodManager {
	
	/**
	 * 获取某个client可以全名用的支付方式表
	 * @param clientType 客户端类型
	 * @return 支付方式列表
	 */
	List<PaymentMethodVo> list(ClientType clientType);
	
	
	/**
	 * 获取App的支付式列表<br>
	 * 包含所有配置
	 * <br>
	 * 是加密的，密钥在系统设置的
	 * @return
	 */
	String listApp();

	/**
	 * 根据支付插件id获取支付方式详细
	 * @param payment_plugin_id
	 * @return
	 */
	PaymentMethod getByPluginId(String payment_plugin_id);
	
	/**
	 * 后台获取支付插件列表
	 * @return
	 */
	List<PaymentPluginVo> getAllPlugins();

	/**
	 * 根据插件id返回支付方式vo
	 * @param plugin_id
	 * @return
	 */
	PaymentPluginVo getByPlugin(String plugin_id);

	/**
	 * 保存
	 * @param vo
	 * @return
	 */
	PaymentPluginVo save(PaymentPluginVo vo);
	
	
}
