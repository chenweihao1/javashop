package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * 根据OpenId获取UserId
 *
 * @author auto create
 * @since 1.0, 2016-02-19 20:04:41
 */
public class AlipayPlatformUseridGetModel extends AlipayObject {

	private static final long serialVersionUID = 4368917762726233244L;

	/**
	 * openId的列表
	 */
	@ApiListField("open_ids")
	@ApiField("string")
	private List<String> openIds;

	public List<String> getOpenIds() {
		return this.openIds;
	}
	public void setOpenIds(List<String> openIds) {
		this.openIds = openIds;
	}

}
