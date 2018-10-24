package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.DmActivityShopData;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: koubei.marketing.data.retail.dm.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-05-16 17:02:42
 */
public class KoubeiMarketingDataRetailDmQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7523966851914349377L;

	/** 
	 * 内容ID
	 */
	@ApiField("content_id")
	private String contentId;

	/** 
	 * 店面DM营销数据，包括商品的PV、UV、曝光。
	 */
	@ApiListField("dm_marketing_datas")
	@ApiField("dm_activity_shop_data")
	private List<DmActivityShopData> dmMarketingDatas;

	/** 
	 * 商品码
	 */
	@ApiField("item_code")
	private String itemCode;

	/** 
	 * 商品名称
	 */
	@ApiField("item_name")
	private String itemName;

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getContentId( ) {
		return this.contentId;
	}

	public void setDmMarketingDatas(List<DmActivityShopData> dmMarketingDatas) {
		this.dmMarketingDatas = dmMarketingDatas;
	}
	public List<DmActivityShopData> getDmMarketingDatas( ) {
		return this.dmMarketingDatas;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemCode( ) {
		return this.itemCode;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemName( ) {
		return this.itemName;
	}

}
