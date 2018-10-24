package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * context 保存操作者信息
 *
 * @author auto create
 * @since 1.0, 2016-12-22 09:37:28
 */
public class KoubeiOperationContext extends AlipayObject {

	private static final long serialVersionUID = 3438978277491674478L;

	/**
	 * 如果是isv代操作，请传入ISV；如果是其他角色（商户MERCHANT、服务商PROVIDER、服务商员工S_STAFF、商户员工M_STAFF）操作，不用填写。
	 */
	@ApiField("op_role")
	private String opRole;

	public String getOpRole() {
		return this.opRole;
	}
	public void setOpRole(String opRole) {
		this.opRole = opRole;
	}

}
