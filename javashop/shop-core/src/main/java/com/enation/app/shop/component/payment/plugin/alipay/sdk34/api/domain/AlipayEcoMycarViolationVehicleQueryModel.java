package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ISV获取用户违章车辆信息
 *
 * @author auto create
 * @since 1.0, 2017-04-12 11:48:16
 */
public class AlipayEcoMycarViolationVehicleQueryModel extends AlipayObject {

	private static final long serialVersionUID = 2826872225139525258L;

	/**
	 * 用户车辆ID,支付宝系统唯一
	 */
	@ApiField("vi_id")
	private String viId;

	public String getViId() {
		return this.viId;
	}
	public void setViId(String viId) {
		this.viId = viId;
	}

}
