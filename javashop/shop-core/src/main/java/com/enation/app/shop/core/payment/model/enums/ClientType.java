package com.enation.app.shop.core.payment.model.enums;

/**
 * 支付客户端类型
 * 
 * @author fk
 * @version v6.4
 * @since v6.4 2017年10月17日 上午10:49:25
 */
public enum ClientType {

	PC("pc_enable", "PC"), WAP("wap_enable", "WAP"), APP("app_enable", "APP");

	private String description;
	private String client;

	ClientType(String _description, String _client) {
		this.description = _description;
		this.client = _client;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	public String description() {
		return this.description;
	}

	public String value() {
		return this.name();
	}
	

}
