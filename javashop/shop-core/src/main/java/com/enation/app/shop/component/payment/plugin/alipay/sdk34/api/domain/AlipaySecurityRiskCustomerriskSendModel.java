package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 商户数据同步
 *
 * @author auto create
 * @since 1.0, 2017-05-26 21:53:59
 */
public class AlipaySecurityRiskCustomerriskSendModel extends AlipayObject {

	private static final long serialVersionUID = 8725837737691936744L;

	/**
	 * 身份证号码
	 */
	@ApiField("cert_no")
	private String certNo;

	/**
	 * 手机号
	 */
	@ApiField("mobile")
	private String mobile;

	public String getCertNo() {
		return this.certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
