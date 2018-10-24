package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * 简单模型嵌套list
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:42
 */
public class ListListSmMockModel extends AlipayObject {

	private static final long serialVersionUID = 5248414944473387994L;

	/**
	 * 简单模型列表
	 */
	@ApiListField("list_simple_model_list")
	@ApiField("simple_mock_model")
	private List<SimpleMockModel> listSimpleModelList;

	public List<SimpleMockModel> getListSimpleModelList() {
		return this.listSimpleModelList;
	}
	public void setListSimpleModelList(List<SimpleMockModel> listSimpleModelList) {
		this.listSimpleModelList = listSimpleModelList;
	}

}
