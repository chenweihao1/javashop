package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.std.public.express.user.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-14 20:18:49
 */
public class AlipayMobileStdPublicExpressUserQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4279928758262531545L;

	/** 
	 * 证件号
	 */
	@ApiField("cert_no")
	private String certNo;

	/** 
	 * 证件类型，身份证
	 */
	@ApiField("cert_type")
	private String certType;

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getCertNo( ) {
		return this.certNo;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertType( ) {
		return this.certType;
	}

}
