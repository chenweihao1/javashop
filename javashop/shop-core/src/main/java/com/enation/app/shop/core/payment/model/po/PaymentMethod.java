package com.enation.app.shop.core.payment.model.po;

import com.enation.app.shop.core.payment.model.vo.PaymentPluginVo;
import com.enation.framework.database.PrimaryKeyField;
import com.google.gson.Gson;

/**
 * 支付方式
 * 
 * @author kingapex
 * @version 1.0
 * @since pangu1.0 2017年4月3日下午11:23:37
 */
public class PaymentMethod {

	private int method_id;
	private String plugin_id;
	private String method_name;
	private String config;
	private String pc_enable;
	private String wap_enable;
	private String app_enable;
	private String img_url;
	private Integer is_retrace;//是否支持原路退回0不支持 1 支持
	
	public PaymentMethod(PaymentPluginVo plugin) {
		this.plugin_id = plugin.getPlugin_id();
		this.method_name = plugin.getMethod_name();
		this.pc_enable = plugin.getPc_enable();
		this.wap_enable = plugin.getWap_enable();
		this.app_enable = plugin.getApp_enable();
		this.img_url = plugin.getImg_url();
		this.is_retrace = plugin.getIs_retrace();
		Gson gson = new Gson();
		this.config = gson.toJson(plugin.getConfigItems());
	}
	
	public PaymentMethod() {
		
	}
	
	@PrimaryKeyField
	public int getMethod_id() {
		return method_id;
	}

	public void setMethod_id(int method_id) {
		this.method_id = method_id;
	}

	public String getPlugin_id() {
		return plugin_id;
	}

	public void setPlugin_id(String plugin_id) {
		this.plugin_id = plugin_id;
	}

	public String getMethod_name() {
		return method_name;
	}

	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public Integer getIs_retrace() {
		return is_retrace;
	}

	public void setIs_retrace(Integer is_retrace) {
		this.is_retrace = is_retrace;
	}

	public String getPc_enable() {
		return pc_enable;
	}

	public void setPc_enable(String pc_enable) {
		this.pc_enable = pc_enable;
	}

	public String getWap_enable() {
		return wap_enable;
	}

	public void setWap_enable(String wap_enable) {
		this.wap_enable = wap_enable;
	}

	public String getApp_enable() {
		return app_enable;
	}

	public void setApp_enable(String app_enable) {
		this.app_enable = app_enable;
	}
	
}