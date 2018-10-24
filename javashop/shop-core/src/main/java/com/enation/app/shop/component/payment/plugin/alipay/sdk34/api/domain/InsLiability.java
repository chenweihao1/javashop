package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 险种责任
 *
 * @author auto create
 * @since 1.0, 2017-06-14 10:39:56
 */
public class InsLiability extends AlipayObject {

	private static final long serialVersionUID = 7647324561954196148L;

	/**
	 * 责任描述
	 */
	@ApiField("liability_desc")
	private String liabilityDesc;

	/**
	 * 责任名称
	 */
	@ApiField("liability_name")
	private String liabilityName;

	/**
	 * 保额
	 */
	@ApiField("sum_insured")
	private InsSumInsured sumInsured;

	public String getLiabilityDesc() {
		return this.liabilityDesc;
	}
	public void setLiabilityDesc(String liabilityDesc) {
		this.liabilityDesc = liabilityDesc;
	}

	public String getLiabilityName() {
		return this.liabilityName;
	}
	public void setLiabilityName(String liabilityName) {
		this.liabilityName = liabilityName;
	}

	public InsSumInsured getSumInsured() {
		return this.sumInsured;
	}
	public void setSumInsured(InsSumInsured sumInsured) {
		this.sumInsured = sumInsured;
	}

}
