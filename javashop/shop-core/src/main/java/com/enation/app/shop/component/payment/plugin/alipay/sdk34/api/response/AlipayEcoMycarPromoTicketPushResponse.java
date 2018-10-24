package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.mycar.promo.ticket.push response.
 * 
 * @author auto create
 * @since 1.0, 2016-05-12 09:57:45
 */
public class AlipayEcoMycarPromoTicketPushResponse extends AlipayResponse {

	private static final long serialVersionUID = 5718376736487484587L;

	/** 
	 * 处理结果返回码
	 */
	@ApiField("sp_apply_no")
	private String spApplyNo;

	public void setSpApplyNo(String spApplyNo) {
		this.spApplyNo = spApplyNo;
	}
	public String getSpApplyNo( ) {
		return this.spApplyNo;
	}

}
