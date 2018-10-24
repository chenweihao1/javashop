package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 蓝牙设备模板信息
 *
 * @author auto create
 * @since 1.0, 2015-02-03 19:55:34
 */
public class BeaconTemplate extends AlipayObject {

	private static final long serialVersionUID = 1489955592552421971L;

	/**
	 * 模板参数信息
	 */
	@ApiField("context")
	private String context;

	/**
	 * 模板ID
	 */
	@ApiField("templateid")
	private String templateid;

	public String getContext() {
		return this.context;
	}
	public void setContext(String context) {
		this.context = context;
	}

	public String getTemplateid() {
		return this.templateid;
	}
	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

}
