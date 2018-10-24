package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 口碑广告系统吱口令内容详情
 *
 * @author auto create
 * @since 1.0, 2017-02-15 13:57:59
 */
public class KbAdvertContentShareCode extends AlipayObject {

	private static final long serialVersionUID = 6337382213311176669L;

	/**
	 * 吱口令内容详情
	 */
	@ApiField("share_code_desc")
	private String shareCodeDesc;

	public String getShareCodeDesc() {
		return this.shareCodeDesc;
	}
	public void setShareCodeDesc(String shareCodeDesc) {
		this.shareCodeDesc = shareCodeDesc;
	}

}
