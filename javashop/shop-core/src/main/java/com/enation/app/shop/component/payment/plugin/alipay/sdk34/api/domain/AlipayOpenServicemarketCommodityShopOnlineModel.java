package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 门店上架处理
 *
 * @author auto create
 * @since 1.0, 2016-08-25 11:12:07
 */
public class AlipayOpenServicemarketCommodityShopOnlineModel extends AlipayObject {

	private static final long serialVersionUID = 1451673946649789544L;

	/**
	 * 服务插件ID
	 */
	@ApiField("commodity_id")
	private String commodityId;

	/**
	 * 店铺ID
	 */
	@ApiField("shop_id")
	private String shopId;

	public String getCommodityId() {
		return this.commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getShopId() {
		return this.shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}
