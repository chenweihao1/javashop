package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.ExtItem;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.item.extitem.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-06 10:47:56
 */
public class KoubeiItemExtitemQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4368753437658742433L;

	/** 
	 * 商品信息
	 */
	@ApiField("extitem")
	private ExtItem extitem;

	public void setExtitem(ExtItem extitem) {
		this.extitem = extitem;
	}
	public ExtItem getExtitem( ) {
		return this.extitem;
	}

}
