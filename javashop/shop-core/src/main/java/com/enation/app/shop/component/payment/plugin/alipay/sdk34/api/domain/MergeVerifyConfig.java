package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 券核销的叠加标识
 *
 * @author auto create
 * @since 1.0, 2016-10-31 12:00:30
 */
public class MergeVerifyConfig extends AlipayObject {

	private static final long serialVersionUID = 8677334488233445759L;

	/**
	 * 可以与任意其他券叠加
	 */
	@ApiField("general_merge_others")
	private Boolean generalMergeOthers;

	/**
	 * 全场和单品叠加标识
	 */
	@ApiField("general_merge_single")
	private Boolean generalMergeSingle;

	public Boolean getGeneralMergeOthers() {
		return this.generalMergeOthers;
	}
	public void setGeneralMergeOthers(Boolean generalMergeOthers) {
		this.generalMergeOthers = generalMergeOthers;
	}

	public Boolean getGeneralMergeSingle() {
		return this.generalMergeSingle;
	}
	public void setGeneralMergeSingle(Boolean generalMergeSingle) {
		this.generalMergeSingle = generalMergeSingle;
	}

}
