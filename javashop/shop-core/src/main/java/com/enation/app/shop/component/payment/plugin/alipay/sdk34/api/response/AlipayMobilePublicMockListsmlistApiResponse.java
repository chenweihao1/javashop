package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.ListListSmMockModel;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.mobile.public.mock.listsmlist.api response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-14 20:33:04
 */
public class AlipayMobilePublicMockListsmlistApiResponse extends AlipayResponse {

	private static final long serialVersionUID = 7732721613933764924L;

	/** 
	 * 简单模型嵌套list
	 */
	@ApiListField("list_sm_model_list")
	@ApiField("list_list_sm_mock_model")
	private List<ListListSmMockModel> listSmModelList;

	public void setListSmModelList(List<ListListSmMockModel> listSmModelList) {
		this.listSmModelList = listSmModelList;
	}
	public List<ListListSmMockModel> getListSmModelList( ) {
		return this.listSmModelList;
	}

}
