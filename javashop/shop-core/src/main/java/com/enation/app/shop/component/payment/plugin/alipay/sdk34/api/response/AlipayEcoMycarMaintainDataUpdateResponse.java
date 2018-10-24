package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.mycar.maintain.data.update response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-14 15:11:26
 */
public class AlipayEcoMycarMaintainDataUpdateResponse extends AlipayResponse {

	private static final long serialVersionUID = 4298833156772491822L;

	/** 
	 * 具体返回的处理结果
	 */
	@ApiField("info")
	private String info;

	public void setInfo(String info) {
		this.info = info;
	}
	public String getInfo( ) {
		return this.info;
	}

}
