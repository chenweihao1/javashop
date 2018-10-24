package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.card.template.modify response.
 * 
 * @author auto create
 * @since 1.0, 2017-06-06 17:13:41
 */
public class AlipayMarketingCardTemplateModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 4257422939533154976L;

	/** 
	 * 模板ID
	 */
	@ApiField("template_id")
	private String templateId;

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getTemplateId( ) {
		return this.templateId;
	}

}
