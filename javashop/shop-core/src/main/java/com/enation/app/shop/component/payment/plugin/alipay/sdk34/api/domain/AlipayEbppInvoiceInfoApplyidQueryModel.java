package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 根据发票申请id查询发票信息
 *
 * @author auto create
 * @since 1.0, 2017-05-09 19:40:03
 */
public class AlipayEbppInvoiceInfoApplyidQueryModel extends AlipayObject {

	private static final long serialVersionUID = 3732639585493224464L;

	/**
	 * 申请开票时支付宝返回的申请id，具有全局唯一性。
	 */
	@ApiField("apply_id")
	private String applyId;

	public String getApplyId() {
		return this.applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

}
