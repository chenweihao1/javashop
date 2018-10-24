package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.data.feedbackurl.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-02-16 15:46:19
 */
public class ZhimaDataFeedbackurlQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7634377663974529115L;

	/** 
	 * 反馈模板地址
	 */
	@ApiField("feedback_url")
	private String feedbackUrl;

	public void setFeedbackUrl(String feedbackUrl) {
		this.feedbackUrl = feedbackUrl;
	}
	public String getFeedbackUrl( ) {
		return this.feedbackUrl;
	}

}
