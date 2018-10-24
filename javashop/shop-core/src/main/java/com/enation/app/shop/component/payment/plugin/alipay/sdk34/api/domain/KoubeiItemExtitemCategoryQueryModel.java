package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 品类查询接口
 *
 * @author auto create
 * @since 1.0, 2016-10-26 18:05:10
 */
public class KoubeiItemExtitemCategoryQueryModel extends AlipayObject {

	private static final long serialVersionUID = 8854289725432757623L;

	/**
	 * 父品类编码. (查询顶级类目时值传0)
	 */
	@ApiField("parent_id")
	private String parentId;

	public String getParentId() {
		return this.parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
