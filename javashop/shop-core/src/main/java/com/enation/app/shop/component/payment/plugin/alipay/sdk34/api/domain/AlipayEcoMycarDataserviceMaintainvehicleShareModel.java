package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 同步评论接口
 *
 * @author auto create
 * @since 1.0, 2017-04-12 11:49:20
 */
public class AlipayEcoMycarDataserviceMaintainvehicleShareModel extends AlipayObject {

	private static final long serialVersionUID = 8644529759823324755L;

	/**
	 * 车辆ID
	 */
	@ApiField("vid")
	private String vid;

	public String getVid() {
		return this.vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}

}
