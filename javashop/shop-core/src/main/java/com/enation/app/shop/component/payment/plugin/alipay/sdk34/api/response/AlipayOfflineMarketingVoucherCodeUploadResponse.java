package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.offline.marketing.voucher.code.upload response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-23 17:58:11
 */
public class AlipayOfflineMarketingVoucherCodeUploadResponse extends AlipayResponse {

	private static final long serialVersionUID = 3337551149615467138L;

	/** 
	 * 码库id
	 */
	@ApiField("code_inventory_id")
	private String codeInventoryId;

	public void setCodeInventoryId(String codeInventoryId) {
		this.codeInventoryId = codeInventoryId;
	}
	public String getCodeInventoryId( ) {
		return this.codeInventoryId;
	}

}
