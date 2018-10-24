package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 产品模型创建接口
 *
 * @author auto create
 * @since 1.0, 2016-12-22 21:53:37
 */
public class AlipayEbppIsvProdmodeCreateModel extends AlipayObject {

	private static final long serialVersionUID = 6349188661316174511L;

	/**
	 * 参数内容包含：ISV录入产品模型相关信息，具体分类如下：1.销账机构信息
2.对账配置信息
3.清算配置信息
4.产品模型和出账机构信息
5.机构拓展信息
	 */
	@ApiField("biz_data")
	private String bizData;

	public String getBizData() {
		return this.bizData;
	}
	public void setBizData(String bizData) {
		this.bizData = bizData;
	}

}
