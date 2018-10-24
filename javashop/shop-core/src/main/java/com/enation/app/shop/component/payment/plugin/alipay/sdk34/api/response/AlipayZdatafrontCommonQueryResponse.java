package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.zdatafront.common.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-28 16:52:16
 */
public class AlipayZdatafrontCommonQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7529417487414532641L;

	/** 
	 * 数据的时间戳：
如果fromCache=false,timestamp就是从外部返回的数据时间，如果外部返回的数据没有时间字段，就以系统取到的时间；
如果fromCache=true，timestamp就是从cache中获取的数据时间
	 */
	@ApiField("cache_timestamp")
	private Long cacheTimestamp;

	/** 
	 * 数据结果集，统一按照String类型返回
	 */
	@ApiField("values")
	private String values;

	public void setCacheTimestamp(Long cacheTimestamp) {
		this.cacheTimestamp = cacheTimestamp;
	}
	public Long getCacheTimestamp( ) {
		return this.cacheTimestamp;
	}

	public void setValues(String values) {
		this.values = values;
	}
	public String getValues( ) {
		return this.values;
	}

}
