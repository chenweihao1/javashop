package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * 保险凭证批量创建
 *
 * @author auto create
 * @since 1.0, 2016-10-13 19:50:45
 */
public class AlipayInsMarketingCertificateBatchcreateModel extends AlipayObject {

	private static final long serialVersionUID = 3558162286178154646L;

	/**
	 * 批量创建凭证请求
	 */
	@ApiListField("ins_create_certificate_requests")
	@ApiField("ins_create_certificate_request")
	private List<InsCreateCertificateRequest> insCreateCertificateRequests;

	public List<InsCreateCertificateRequest> getInsCreateCertificateRequests() {
		return this.insCreateCertificateRequests;
	}
	public void setInsCreateCertificateRequests(List<InsCreateCertificateRequest> insCreateCertificateRequests) {
		this.insCreateCertificateRequests = insCreateCertificateRequests;
	}

}
