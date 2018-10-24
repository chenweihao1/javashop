package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.ShopDiscountInfo;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.offline.market.shop.discount.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-11 15:21:56
 */
public class AlipayOfflineMarketShopDiscountQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 1139892722916818741L;

	/** 
	 * 优惠信息列表，最大20条，按生效时间排序
	 */
	@ApiListField("discount_list")
	@ApiField("shop_discount_info")
	private List<ShopDiscountInfo> discountList;

	/** 
	 * 商品列表，最大20条，按申领数量排序
	 */
	@ApiListField("item_list")
	@ApiField("shop_discount_info")
	private List<ShopDiscountInfo> itemList;

	public void setDiscountList(List<ShopDiscountInfo> discountList) {
		this.discountList = discountList;
	}
	public List<ShopDiscountInfo> getDiscountList( ) {
		return this.discountList;
	}

	public void setItemList(List<ShopDiscountInfo> itemList) {
		this.itemList = itemList;
	}
	public List<ShopDiscountInfo> getItemList( ) {
		return this.itemList;
	}

}
