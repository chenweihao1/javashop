package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.OpenActivity;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: koubei.quality.test.cloudacpt.activity.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-15 15:07:41
 */
public class KoubeiQualityTestCloudacptActivityQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3145648756281189484L;

	/** 
	 * 活动列表
	 */
	@ApiListField("activity_list")
	@ApiField("open_activity")
	private List<OpenActivity> activityList;

	public void setActivityList(List<OpenActivity> activityList) {
		this.activityList = activityList;
	}
	public List<OpenActivity> getActivityList( ) {
		return this.activityList;
	}

}
