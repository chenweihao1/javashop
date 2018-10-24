package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: monitor.heartbeat.syn response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-06 22:21:41
 */
public class MonitorHeartbeatSynResponse extends AlipayResponse {

	private static final long serialVersionUID = 5529472753922257774L;

	/** 
	 * 商户pid
	 */
	@ApiField("pid")
	private String pid;

	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPid( ) {
		return this.pid;
	}

}
