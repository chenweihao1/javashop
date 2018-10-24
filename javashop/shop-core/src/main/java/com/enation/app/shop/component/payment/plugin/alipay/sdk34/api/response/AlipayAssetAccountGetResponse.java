package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.AssetAccountResult;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.asset.account.get response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-07 18:05:33
 */
public class AlipayAssetAccountGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 8557691614167439214L;

	/** 
	 * 账户绑定关系列表
	 */
	@ApiListField("asset_list")
	@ApiField("asset_account_result")
	private List<AssetAccountResult> assetList;

	public void setAssetList(List<AssetAccountResult> assetList) {
		this.assetList = assetList;
	}
	public List<AssetAccountResult> getAssetList( ) {
		return this.assetList;
	}

}
