package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.AccountFreeze;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.user.account.freeze.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-08-11 15:48:05
 */
public class AlipayUserAccountFreezeGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 3364437493482438313L;

	/** 
	 * 冻结金额列表
	 */
	@ApiListField("freeze_items")
	@ApiField("account_freeze")
	private List<AccountFreeze> freezeItems;

	/** 
	 * 冻结总条数
	 */
	@ApiField("total_results")
	private String totalResults;

	public void setFreezeItems(List<AccountFreeze> freezeItems) {
		this.freezeItems = freezeItems;
	}
	public List<AccountFreeze> getFreezeItems( ) {
		return this.freezeItems;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}
	public String getTotalResults( ) {
		return this.totalResults;
	}

}
