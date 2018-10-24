package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.RechargeBill;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.commerce.cityfacilitator.deposit.query response.
 * 
 * @author auto create
 * @since 1.0, 2015-12-15 11:37:56
 */
public class AlipayCommerceCityfacilitatorDepositQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4332384748516711817L;

	/** 
	 * 待圈存明细
	 */
	@ApiListField("recharge_bills")
	@ApiField("recharge_bill")
	private List<RechargeBill> rechargeBills;

	public void setRechargeBills(List<RechargeBill> rechargeBills) {
		this.rechargeBills = rechargeBills;
	}
	public List<RechargeBill> getRechargeBills( ) {
		return this.rechargeBills;
	}

}
