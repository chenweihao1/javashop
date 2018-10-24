package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 推送新支持违章查询的城市
 *
 * @author auto create
 * @since 1.0, 2016-05-12 09:57:36
 */
public class AlipayEcoMycarViolationCityPushModel extends AlipayObject {

	private static final long serialVersionUID = 1847698967778586221L;

	/**
	 * 城市编码
	 */
	@ApiField("city_code")
	private String cityCode;

	/**
	 * 该城市规则是新增还是更新, 0:新增,1:更新
	 */
	@ApiField("push_type")
	private String pushType;

	/**
	 * 该城市是否支持违章查询,0:支持,1:不支持
	 */
	@ApiField("service_status")
	private String serviceStatus;

	public String getCityCode() {
		return this.cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getPushType() {
		return this.pushType;
	}
	public void setPushType(String pushType) {
		this.pushType = pushType;
	}

	public String getServiceStatus() {
		return this.serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

}
