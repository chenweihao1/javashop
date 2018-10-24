package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 查询车型详情信息接口
 *
 * @author auto create
 * @since 1.0, 2017-04-12 11:47:21
 */
public class AlipayEcoMycarCarmodelQueryModel extends AlipayObject {

	private static final long serialVersionUID = 7316857438455136255L;

	/**
	 * 支付宝车型库车型编号,系统唯一。
	 */
	@ApiField("model_id")
	private String modelId;

	public String getModelId() {
		return this.modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

}
