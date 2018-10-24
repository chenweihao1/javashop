package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 营销报表下载
 *
 * @author auto create
 * @since 1.0, 2016-11-11 19:58:38
 */
public class KoubeiMarketingDataActivityBillDownloadModel extends AlipayObject {

	private static final long serialVersionUID = 8134649682969669836L;

	/**
	 * 活动id
	 */
	@ApiField("camp_id")
	private String campId;

	public String getCampId() {
		return this.campId;
	}
	public void setCampId(String campId) {
		this.campId = campId;
	}

}
