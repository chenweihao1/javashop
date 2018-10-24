package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.MerchantInstConfig;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.ebpp.merchant.config.get response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-07 17:12:49
 */
public class AlipayEbppMerchantConfigGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 7829751793444428712L;

	/** 
	 * 商户机构配置信息
	 */
	@ApiListField("inst_configs")
	@ApiField("merchant_inst_config")
	private List<MerchantInstConfig> instConfigs;

	/** 
	 * 商户的用户ID
	 */
	@ApiField("merchant_user_id")
	private String merchantUserId;

	public void setInstConfigs(List<MerchantInstConfig> instConfigs) {
		this.instConfigs = instConfigs;
	}
	public List<MerchantInstConfig> getInstConfigs( ) {
		return this.instConfigs;
	}

	public void setMerchantUserId(String merchantUserId) {
		this.merchantUserId = merchantUserId;
	}
	public String getMerchantUserId( ) {
		return this.merchantUserId;
	}

}
