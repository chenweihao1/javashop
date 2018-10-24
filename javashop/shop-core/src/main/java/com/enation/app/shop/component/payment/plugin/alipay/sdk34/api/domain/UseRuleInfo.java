package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * 使用规则信息
 *
 * @author auto create
 * @since 1.0, 2016-06-23 17:38:07
 */
public class UseRuleInfo extends AlipayObject {

	private static final long serialVersionUID = 8143598813977538477L;

	/**
	 * 适用门店列表
	 */
	@ApiListField("suitable_shops")
	@ApiField("string")
	private List<String> suitableShops;

	/**
	 * 核销方式
	 */
	@ApiListField("use_mode")
	@ApiField("string")
	private List<String> useMode;

	public List<String> getSuitableShops() {
		return this.suitableShops;
	}
	public void setSuitableShops(List<String> suitableShops) {
		this.suitableShops = suitableShops;
	}

	public List<String> getUseMode() {
		return this.useMode;
	}
	public void setUseMode(List<String> useMode) {
		this.useMode = useMode;
	}

}
