package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 商户反洗钱风险检查发现的风险，包含命中的实体类型和命中详情等信息。
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:38
 */
public class MerchantScreenHit extends AlipayObject {

	private static final long serialVersionUID = 3548145675359854571L;

	/**
	 * 送检的实体类型，如CEO，控股人，等
	 */
	@ApiField("input_type")
	private String inputType;

	/**
	 * 命中详情
	 */
	@ApiField("risk_detail")
	private String riskDetail;

	public String getInputType() {
		return this.inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getRiskDetail() {
		return this.riskDetail;
	}
	public void setRiskDetail(String riskDetail) {
		this.riskDetail = riskDetail;
	}

}
