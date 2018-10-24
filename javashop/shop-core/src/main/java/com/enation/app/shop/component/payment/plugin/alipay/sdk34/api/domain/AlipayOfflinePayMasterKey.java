package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 描述支付宝脱机交易主秘钥
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:41
 */
public class AlipayOfflinePayMasterKey extends AlipayObject {

	private static final long serialVersionUID = 6245642352492588889L;

	/**
	 * 秘钥id
	 */
	@ApiField("key_id")
	private Long keyId;

	/**
	 * 支付宝脱机服务公钥
	 */
	@ApiField("public_key")
	private String publicKey;

	public Long getKeyId() {
		return this.keyId;
	}
	public void setKeyId(Long keyId) {
		this.keyId = keyId;
	}

	public String getPublicKey() {
		return this.publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

}
