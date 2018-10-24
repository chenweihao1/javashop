package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * 老版本复杂Listlist对象
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:39
 */
public class OldListListComplexMockModel extends AlipayObject {

	private static final long serialVersionUID = 6498865411361951984L;

	/**
	 * 复杂模型list
	 */
	@ApiListField("cm_list")
	@ApiField("old_complext_mock_model")
	private List<OldComplextMockModel> cmList;

	public List<OldComplextMockModel> getCmList() {
		return this.cmList;
	}
	public void setCmList(List<OldComplextMockModel> cmList) {
		this.cmList = cmList;
	}

}
