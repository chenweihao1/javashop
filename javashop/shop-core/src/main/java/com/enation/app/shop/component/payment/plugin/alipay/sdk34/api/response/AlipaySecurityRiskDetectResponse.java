package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.security.risk.detect response.
 * 
 * @author auto create
 * @since 1.0, 2016-03-04 14:55:25
 */
public class AlipaySecurityRiskDetectResponse extends AlipayResponse {

	private static final long serialVersionUID = 2191317257374147444L;

	/** 
	 * 结果码
	 */
	@ApiField("risk_code")
	private String riskCode;

	/** 
	 * 风险等级
	 */
	@ApiField("risk_level")
	private Long riskLevel;

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getRiskCode( ) {
		return this.riskCode;
	}

	public void setRiskLevel(Long riskLevel) {
		this.riskLevel = riskLevel;
	}
	public Long getRiskLevel( ) {
		return this.riskLevel;
	}

}
