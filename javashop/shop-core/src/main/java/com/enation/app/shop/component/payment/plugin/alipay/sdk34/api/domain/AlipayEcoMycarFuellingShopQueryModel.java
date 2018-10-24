package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 加油站门店信息查询接口
 *
 * @author auto create
 * @since 1.0, 2017-04-12 11:46:43
 */
public class AlipayEcoMycarFuellingShopQueryModel extends AlipayObject {

	private static final long serialVersionUID = 8146356241615858221L;

	/**
	 * 外部门店编号系统唯一，该值添加后不可修改，与字段shop_id不能同时为空
	 */
	@ApiField("out_shop_id")
	private String outShopId;

	/**
	 * 车主平台内部门店编号，系统唯一,与字段out_shop_id不能同时为空
	 */
	@ApiField("shop_id")
	private String shopId;

	public String getOutShopId() {
		return this.outShopId;
	}
	public void setOutShopId(String outShopId) {
		this.outShopId = outShopId;
	}

	public String getShopId() {
		return this.shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}
