package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.AlipayOfflinePayMasterKey;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.commerce.transport.offlinepay.key.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-05-20 21:41:51
 */
public class AlipayCommerceTransportOfflinepayKeyQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4892927768259114683L;

	/** 
	 * 支付宝脱机交易公钥列表。列表中每一项为一个有效的支付宝公钥信息, 其中id字段表示支付宝公钥id。
	 */
	@ApiListField("keys")
	@ApiField("alipay_offline_pay_master_key")
	private List<AlipayOfflinePayMasterKey> keys;

	public void setKeys(List<AlipayOfflinePayMasterKey> keys) {
		this.keys = keys;
	}
	public List<AlipayOfflinePayMasterKey> getKeys( ) {
		return this.keys;
	}

}
