package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 对账配置查询接口
 *
 * @author auto create
 * @since 1.0, 2016-12-22 21:53:37
 */
public class AlipayEbppProdmodeReconconfQueryModel extends AlipayObject {

	private static final long serialVersionUID = 6296557274726726854L;

	/**
	 * 缴费业务类型
	 */
	@ApiField("biz_type")
	private String bizType;

	/**
	 * 销账机构编码
	 */
	@ApiField("chargeoff_code")
	private String chargeoffCode;

	public String getBizType() {
		return this.bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getChargeoffCode() {
		return this.chargeoffCode;
	}
	public void setChargeoffCode(String chargeoffCode) {
		this.chargeoffCode = chargeoffCode;
	}

}
