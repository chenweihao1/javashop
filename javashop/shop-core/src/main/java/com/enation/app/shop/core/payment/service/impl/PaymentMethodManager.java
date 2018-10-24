package com.enation.app.shop.core.payment.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enation.framework.util.DesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enation.app.shop.core.payment.model.enums.ClientType;
import com.enation.app.shop.core.payment.model.enums.OpenType;
import com.enation.app.shop.core.payment.model.po.PaymentMethod;
import com.enation.app.shop.core.payment.model.vo.PaymentMethodVo;
import com.enation.app.shop.core.payment.model.vo.PaymentPluginVo;
import com.enation.app.shop.core.payment.service.IPaymentMethodManager;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;
import com.enation.framework.context.spring.SpringContextHolder;
import com.enation.framework.database.IDaoSupport;
import com.enation.framework.util.StringUtil;
import com.google.gson.Gson;


/**
 * 支付方式业务管理类
 * @author kingapex
 * @version 1.0
 * @since pangu1.0
 * 2017年4月27日下午3:52:02
 */
@Service
public class PaymentMethodManager implements IPaymentMethodManager {

	
	@Autowired
	private IDaoSupport daoSupport;
	
	@Autowired
	private List<IPaymentPlugin> paymentPluginList;
	
	@Override
	public List<PaymentMethodVo> list(ClientType clientType) {
		
		if(clientType!=null){
			String sql="select method_id,method_name,plugin_id,img_url from es_payment_method where "+clientType.description()+" = ?";
			return this.daoSupport.queryForList(sql, PaymentMethodVo.class, OpenType.YES.name());
		}else{
			String sql="select method_id,method_name,plugin_id,img_url from es_payment_method  ";
			return this.daoSupport.queryForList(sql, PaymentMethodVo.class);
		}
		
	}

	@Override
	public String listApp() {
		String sql="select * from es_payment_method where client_type= ?" ;
		List<Map> list = daoSupport.queryForList(sql ,ClientType.APP.name());
		Gson gson = new Gson();
		String json ="";
		try {
			
		for (Map map : list) {
			String config = (String)map.get("config");
			if(StringUtil.notEmpty(config)){
				config= DesUtils.encode(config);
				map.put("config", config);
			}
		}
		
		 json = gson.toJson(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public PaymentMethod getByPluginId(String payment_plugin_id) {
		if(payment_plugin_id == null){//后台确认收款，没有支付方式
			return null;
		}
	
		String sql = "select * from es_payment_method where plugin_id = ?";
		
		return this.daoSupport.queryForObject(sql, PaymentMethod.class, payment_plugin_id);
	}

	@Override
	public List<PaymentPluginVo> getAllPlugins() {
		
		List<PaymentPluginVo> resultList = new ArrayList<>();
		
		//查询数据库中的支付方式
		String sql = "select * from es_payment_method ";
		List<PaymentMethod> list = this.daoSupport.queryForList(sql,PaymentMethod.class);
		Map<String,PaymentMethod> map = new HashMap<>();
		
		for(PaymentMethod payment : list){
			map.put(payment.getPlugin_id(), payment);
		}
		
		for(IPaymentPlugin plugin: paymentPluginList){
			PaymentMethod payment = map.get(plugin.getPluginId());
			PaymentPluginVo result = null;
			
			if(payment != null){//数据库中已经有支付方式
				result = new PaymentPluginVo(payment);
			}else{
				result = new PaymentPluginVo(plugin);
			}
			
			resultList.add(result);
		}
		
		return resultList;
	}

	@Override
	public PaymentPluginVo getByPlugin(String plugin_id) {
		PaymentMethod paymentMethod = this.getByPluginId(plugin_id);
		if(paymentMethod == null){
			IPaymentPlugin plugin = SpringContextHolder.getBean(plugin_id);
			
			return new PaymentPluginVo(plugin);
		}else{
			
			return new PaymentPluginVo(paymentMethod);
		}
		
	}

	@Override
	public PaymentPluginVo save(PaymentPluginVo vo) {
		
		PaymentMethod method = new PaymentMethod(vo);
		if(vo.getMethod_id()==0){
			this.daoSupport.insert("es_payment_method", method);
		}else{
			this.daoSupport.update("es_payment_method", method, "method_id="+vo.getMethod_id());
		}
		
		return vo;
	}


}
