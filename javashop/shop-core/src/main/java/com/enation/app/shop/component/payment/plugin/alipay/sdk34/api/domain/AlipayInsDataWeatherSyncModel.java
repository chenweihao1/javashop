package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 天气数据同步接口
 *
 * @author auto create
 * @since 1.0, 2017-04-01 17:49:38
 */
public class AlipayInsDataWeatherSyncModel extends AlipayObject {

	private static final long serialVersionUID = 2739373539114459994L;

	/**
	 * 天气信息描述信息
	 */
	@ApiField("content")
	private String content;

	/**
	 * 外部业务幂等字段
	 */
	@ApiField("out_biz_no")
	private String outBizNo;

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getOutBizNo() {
		return this.outBizNo;
	}
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

}
