package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 动态相关的地理位置
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:38
 */
public class NewsfeedLocationInfo extends AlipayObject {

	private static final long serialVersionUID = 6515927611285668949L;

	/**
	 * 地理信息
	 */
	@ApiField("ad_code")
	private String adCode;

	/**
	 * 纬度 latitude（填写非0非1）
	 */
	@ApiField("lat")
	private String lat;

	/**
	 * 经度 longitude（填写非0非1）
	 */
	@ApiField("lon")
	private String lon;

	public String getAdCode() {
		return this.adCode;
	}
	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	public String getLat() {
		return this.lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return this.lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}

}
