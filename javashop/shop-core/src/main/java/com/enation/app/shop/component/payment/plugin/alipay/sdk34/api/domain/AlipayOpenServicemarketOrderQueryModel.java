package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 用于服务商回查服务市场订单明细信息
 *
 * @author auto create
 * @since 1.0, 2017-03-01 16:20:58
 */
public class AlipayOpenServicemarketOrderQueryModel extends AlipayObject {

	private static final long serialVersionUID = 5282195691142714589L;

	/**
	 * 商户订单ID号
	 */
	@ApiField("commodity_order_id")
	private String commodityOrderId;

	/**
	 * 从第几页开始查询
	 */
	@ApiField("start_page")
	private String startPage;

	public String getCommodityOrderId() {
		return this.commodityOrderId;
	}
	public void setCommodityOrderId(String commodityOrderId) {
		this.commodityOrderId = commodityOrderId;
	}

	public String getStartPage() {
		return this.startPage;
	}
	public void setStartPage(String startPage) {
		this.startPage = startPage;
	}

}
