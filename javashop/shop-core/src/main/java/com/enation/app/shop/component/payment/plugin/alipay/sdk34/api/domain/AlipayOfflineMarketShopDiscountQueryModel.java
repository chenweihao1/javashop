package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 基于门店id的优惠查询服务
 *
 * @author auto create
 * @since 1.0, 2016-10-31 11:21:25
 */
public class AlipayOfflineMarketShopDiscountQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4339556425322833653L;

	/**
	 * 门店id
	 */
	@ApiField("shop_id")
	private String shopId;

	public String getShopId() {
		return this.shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}
