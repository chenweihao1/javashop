package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 会员卡模板外部权益删除
 *
 * @author auto create
 * @since 1.0, 2017-04-20 22:01:49
 */
public class AlipayMarketingCardBenefitDeleteModel extends AlipayObject {

	private static final long serialVersionUID = 6487218666266866379L;

	/**
	 * 权益ID
	 */
	@ApiField("benefit_id")
	private String benefitId;

	/**
	 * 会员卡模板ID
	 */
	@ApiField("template_id")
	private String templateId;

	public String getBenefitId() {
		return this.benefitId;
	}
	public void setBenefitId(String benefitId) {
		this.benefitId = benefitId;
	}

	public String getTemplateId() {
		return this.templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
