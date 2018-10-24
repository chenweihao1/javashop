package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: koubei.item.extitem.existed.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-06 10:48:15
 */
public class KoubeiItemExtitemExistedQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4515842192473848856L;

	/** 
	 * 商品库中存在的商品编码
	 */
	@ApiListField("existed_list")
	@ApiField("string")
	private List<String> existedList;

	public void setExistedList(List<String> existedList) {
		this.existedList = existedList;
	}
	public List<String> getExistedList( ) {
		return this.existedList;
	}

}
