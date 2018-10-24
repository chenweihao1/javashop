package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.point.order.add response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-14 15:15:57
 */
public class AlipayPointOrderAddResponse extends AlipayResponse {

	private static final long serialVersionUID = 2751429629657255668L;

	/** 
	 * 支付宝集分宝发放流水号
	 */
	@ApiField("alipay_order_no")
	private String alipayOrderNo;

	/** 
	 * 此参数已废弃。
	 */
	@ApiField("result_code")
	private Boolean resultCode;

	public void setAlipayOrderNo(String alipayOrderNo) {
		this.alipayOrderNo = alipayOrderNo;
	}
	public String getAlipayOrderNo( ) {
		return this.alipayOrderNo;
	}

	public void setResultCode(Boolean resultCode) {
		this.resultCode = resultCode;
	}
	public Boolean getResultCode( ) {
		return this.resultCode;
	}

}
