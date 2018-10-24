package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: ssdata.dataservice.risk.alixiaohao.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-21 10:28:22
 */
public class SsdataDataserviceRiskAlixiaohaoQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2561987329335552768L;

	/** 
	 * 是否阿里小号
	 */
	@ApiField("is_alixiaohao")
	private Boolean isAlixiaohao;

	public void setIsAlixiaohao(Boolean isAlixiaohao) {
		this.isAlixiaohao = isAlixiaohao;
	}
	public Boolean getIsAlixiaohao( ) {
		return this.isAlixiaohao;
	}

}
