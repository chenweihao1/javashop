package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 签约情况
 *
 * @author auto create
 * @since 1.0, 2017-02-10 14:26:07
 */
public class KbadvertRoleInfoResponse extends AlipayObject {

	private static final long serialVersionUID = 1232514669229379541L;

	/**
	 * 角色code
	 */
	@ApiField("role_code")
	private String roleCode;

	/**
	 * NOT_OPEN:未开通
OPENED:已经开通
	 */
	@ApiField("status")
	private String status;

	public String getRoleCode() {
		return this.roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
