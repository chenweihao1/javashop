package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 获取数据反馈模板
 *
 * @author auto create
 * @since 1.0, 2017-02-16 15:46:19
 */
public class ZhimaDataFeedbackurlQueryModel extends AlipayObject {

	private static final long serialVersionUID = 2794254787266397595L;

	/**
	 * 在支付宝商户版注册支付宝账号id
	 */
	@ApiField("merchant_id")
	private String merchantId;

	public String getMerchantId() {
		return this.merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

}
