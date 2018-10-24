package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.Date;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 发放规则
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:38
 */
public class GetRuleInfo extends AlipayObject {

	private static final long serialVersionUID = 8874786185578822746L;

	/**
	 * 截至时间
	 */
	@ApiField("end_time")
	private Date endTime;

	/**
	 * 发放次数限制
	 */
	@ApiField("get_count_limit")
	private PeriodInfo getCountLimit;

	/**
	 * 开始时间
	 */
	@ApiField("start_time")
	private Date startTime;

	public Date getEndTime() {
		return this.endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public PeriodInfo getGetCountLimit() {
		return this.getCountLimit;
	}
	public void setGetCountLimit(PeriodInfo getCountLimit) {
		this.getCountLimit = getCountLimit;
	}

	public Date getStartTime() {
		return this.startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

}
