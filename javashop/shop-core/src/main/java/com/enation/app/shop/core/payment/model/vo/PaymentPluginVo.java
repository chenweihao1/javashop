package com.enation.app.shop.core.payment.model.vo;

import java.io.Serializable;
import java.util.List;

import com.enation.app.base.core.model.ConfigItem;
import com.enation.app.shop.core.payment.model.enums.OpenType;
import com.enation.app.shop.core.payment.model.po.PaymentMethod;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * 支付插件vo
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年9月30日 下午2:29:23
 */
public class PaymentPluginVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8418953348138006672L;
	
	//@ApiModelProperty(value = "支付方式id" )
    private int  method_id;
	
	//@ApiModelProperty(value = "支付方式名称" )
	private String  method_name;
	
	//@ApiModelProperty(value = "支付插件名称" )
	private String plugin_id;
	
	//@ApiModelProperty(value = "支付方式图片" )
	private String img_url;
	
	//@ApiModelProperty(value = "是否支持pc" )
	private String pc_enable;
	
	//@ApiModelProperty(value = "是否支持wap" )
	private String wap_enable;
	
	//@ApiModelProperty(value = "是否支持app" )
	private String app_enable;
	
	//@ApiModelProperty(value = "是否支持原路退回，0不支持  1支持" )
	private Integer is_retrace;
	
	//@ApiModelProperty(value = "配置项" )
	private List<ConfigItem> configItems;

	public PaymentPluginVo(PaymentMethod payment) {
		
		this.method_id = payment.getMethod_id();
		this.method_name = payment.getMethod_name();
		this.plugin_id = payment.getPlugin_id();
		this.img_url = payment.getImg_url();
		this.pc_enable = payment.getPc_enable();
		this.wap_enable = payment.getWap_enable();
		this.app_enable = payment.getApp_enable();
		this.is_retrace = payment.getIs_retrace();
		
		Gson gson = new Gson();
		this.configItems = gson.fromJson(payment.getConfig(),  new TypeToken< List<ConfigItem> >() {  }.getType());
		
	}
	
	public PaymentPluginVo(IPaymentPlugin plugin) {
		
		this.method_id = 0;
		this.method_name = plugin.getPluginName();
		this.plugin_id = plugin.getPluginId();
		this.pc_enable = OpenType.NO.name();
		this.wap_enable = OpenType.NO.name();
		this.app_enable = OpenType.NO.name();
		this.configItems = plugin.definitionConfigItem();
		this.is_retrace = plugin.getIsRetrace();
		
	}
	
	public PaymentPluginVo() {
		
	}

	public int getMethod_id() {
		return method_id;
	}

	public void setMethod_id(int method_id) {
		this.method_id = method_id;
	}

	public String getMethod_name() {
		return method_name;
	}

	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}

	public String getPlugin_id() {
		return plugin_id;
	}

	public void setPlugin_id(String plugin_id) {
		this.plugin_id = plugin_id;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
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

	public List<ConfigItem> getConfigItems() {
		return configItems;
	}

	public void setConfigItems(List<ConfigItem> configItems) {
		this.configItems = configItems;
	}

	public Integer getIs_retrace() {
		return is_retrace;
	}

	public void setIs_retrace(Integer is_retrace) {
		this.is_retrace = is_retrace;
	}
	
}
