package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.tool.points.update response.
 * 
 * @author auto create
 * @since 1.0, 2016-11-15 18:49:47
 */
public class KoubeiMarketingToolPointsUpdateResponse extends AlipayResponse {

	private static final long serialVersionUID = 3799889259338884494L;

	/** 
	 * 集点变更流水号
	 */
	@ApiField("point_log_no")
	private String pointLogNo;

	public void setPointLogNo(String pointLogNo) {
		this.pointLogNo = pointLogNo;
	}
	public String getPointLogNo( ) {
		return this.pointLogNo;
	}

}
