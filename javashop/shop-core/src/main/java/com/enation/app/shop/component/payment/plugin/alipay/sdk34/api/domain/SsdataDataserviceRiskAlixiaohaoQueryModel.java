package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 查询阿里通信小号信息
 *
 * @author auto create
 * @since 1.0, 2017-03-21 10:28:22
 */
public class SsdataDataserviceRiskAlixiaohaoQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4467476115351351699L;

	/**
	 * 电话号码
	 */
	@ApiField("mobile_no")
	private String mobileNo;

	public String getMobileNo() {
		return this.mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
