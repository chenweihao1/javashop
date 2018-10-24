package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 自定义数据报表删除接口
 *
 * @author auto create
 * @since 1.0, 2016-08-29 14:52:26
 */
public class KoubeiMarketingDataCustomreportDeleteModel extends AlipayObject {

	private static final long serialVersionUID = 6366369596448943241L;

	/**
	 * 自定义报表规则的KEY
	 */
	@ApiField("condition_key")
	private String conditionKey;

	public String getConditionKey() {
		return this.conditionKey;
	}
	public void setConditionKey(String conditionKey) {
		this.conditionKey = conditionKey;
	}

}
