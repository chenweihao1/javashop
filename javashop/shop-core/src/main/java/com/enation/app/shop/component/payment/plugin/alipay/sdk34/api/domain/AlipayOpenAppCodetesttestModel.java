package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 统一对外错误码测试测试
 *
 * @author auto create
 * @since 1.0, 2016-05-11 19:51:24
 */
public class AlipayOpenAppCodetesttestModel extends AlipayObject {

	private static final long serialVersionUID = 1541836552131745658L;

	/**
	 * 测试参数1
	 */
	@ApiField("testparam")
	private String testparam;

	/**
	 * 测试测试
	 */
	@ApiField("testtestparam")
	private String testtestparam;

	public String getTestparam() {
		return this.testparam;
	}
	public void setTestparam(String testparam) {
		this.testparam = testparam;
	}

	public String getTesttestparam() {
		return this.testtestparam;
	}
	public void setTesttestparam(String testtestparam) {
		this.testtestparam = testtestparam;
	}

}
