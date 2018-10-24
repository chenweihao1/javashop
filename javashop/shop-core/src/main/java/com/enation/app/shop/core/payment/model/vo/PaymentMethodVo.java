package com.enation.app.shop.core.payment.model.vo;


/**
 * 支付方式
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年8月29日 下午4:43:31
 */
public class PaymentMethodVo {
	
	//@ApiModelProperty(value = "支付方式id" )
    private int  method_id;
	
	//@ApiModelProperty(value = "支付方式名称" )
	private String  method_name;
	
	//@ApiModelProperty(value = "支付插件名称" )
	private String plugin_id;
	
	//@ApiModelProperty(value = "支付方式图片" )
	private String img_url;
	
	//@ApiModelProperty(value = "客户端类型" )
	private String client_type;

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

	public String getClient_type() {
		
		return client_type;
	}

	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}
	
	
}
