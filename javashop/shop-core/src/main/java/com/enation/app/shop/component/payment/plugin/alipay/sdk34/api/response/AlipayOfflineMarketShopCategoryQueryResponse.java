package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.ShopCategoryConfigInfo;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.offline.market.shop.category.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-02-07 16:47:06
 */
public class AlipayOfflineMarketShopCategoryQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6889579982989741947L;

	/** 
	 * 门店类目配置信息，包括能够开店的叶子节点类目信息，以及类目约束配置信息。
	 */
	@ApiListField("shop_category_config_infos")
	@ApiField("shop_category_config_info")
	private List<ShopCategoryConfigInfo> shopCategoryConfigInfos;

	public void setShopCategoryConfigInfos(List<ShopCategoryConfigInfo> shopCategoryConfigInfos) {
		this.shopCategoryConfigInfos = shopCategoryConfigInfos;
	}
	public List<ShopCategoryConfigInfo> getShopCategoryConfigInfos( ) {
		return this.shopCategoryConfigInfos;
	}

}
