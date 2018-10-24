package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 风险解释
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:42
 */
public class InfoCode extends AlipayObject {

	private static final long serialVersionUID = 4322542828451213421L;

	/**
	 * 风险描述
	 */
	@ApiField("risk_description")
	private String riskDescription;

	/**
	 * 风险因素编码
	 */
	@ApiField("risk_factor_code")
	private String riskFactorCode;

	/**
	 * 风险因素名称
	 */
	@ApiField("risk_factor_name")
	private String riskFactorName;

	/**
	 * 风险度量
	 */
	@ApiField("risk_magnitude")
	private String riskMagnitude;

	public String getRiskDescription() {
		return this.riskDescription;
	}
	public void setRiskDescription(String riskDescription) {
		this.riskDescription = riskDescription;
	}

	public String getRiskFactorCode() {
		return this.riskFactorCode;
	}
	public void setRiskFactorCode(String riskFactorCode) {
		this.riskFactorCode = riskFactorCode;
	}

	public String getRiskFactorName() {
		return this.riskFactorName;
	}
	public void setRiskFactorName(String riskFactorName) {
		this.riskFactorName = riskFactorName;
	}

	public String getRiskMagnitude() {
		return this.riskMagnitude;
	}
	public void setRiskMagnitude(String riskMagnitude) {
		this.riskMagnitude = riskMagnitude;
	}

}
