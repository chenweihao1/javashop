package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 支付宝脱机操作信息验证
 *
 * @author auto create
 * @since 1.0, 2016-07-01 22:05:47
 */
public class AlipayCommerceTransportOfflinepayRecordVerifyModel extends AlipayObject {

	private static final long serialVersionUID = 3239269871693892681L;

	/**
	 * 原始脱机记录信息
	 */
	@ApiField("record")
	private String record;

	public String getRecord() {
		return this.record;
	}
	public void setRecord(String record) {
		this.record = record;
	}

}
