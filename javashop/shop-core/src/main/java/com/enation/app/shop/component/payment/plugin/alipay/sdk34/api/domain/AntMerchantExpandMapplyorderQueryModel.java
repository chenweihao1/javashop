package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 商户入驻单查询接口
 *
 * @author auto create
 * @since 1.0, 2016-07-28 23:35:07
 */
public class AntMerchantExpandMapplyorderQueryModel extends AlipayObject {

	private static final long serialVersionUID = 8239571218414446586L;

	/**
	 * 支付宝端商户入驻申请单据号
	 */
	@ApiField("order_no")
	private String orderNo;

	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
