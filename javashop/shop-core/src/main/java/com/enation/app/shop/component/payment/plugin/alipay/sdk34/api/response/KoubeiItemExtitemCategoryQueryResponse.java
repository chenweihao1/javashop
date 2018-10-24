package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.ExtCategory;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: koubei.item.extitem.category.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-06 10:47:52
 */
public class KoubeiItemExtitemCategoryQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5544196353351184641L;

	/** 
	 * 品类信息列表
	 */
	@ApiListField("category_list")
	@ApiField("ext_category")
	private List<ExtCategory> categoryList;

	public void setCategoryList(List<ExtCategory> categoryList) {
		this.categoryList = categoryList;
	}
	public List<ExtCategory> getCategoryList( ) {
		return this.categoryList;
	}

}
