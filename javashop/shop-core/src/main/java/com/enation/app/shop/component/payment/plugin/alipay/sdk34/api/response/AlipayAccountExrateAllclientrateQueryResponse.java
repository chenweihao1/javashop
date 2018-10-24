package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.ExClientRateVO;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.account.exrate.allclientrate.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-05-23 14:55:48
 */
public class AlipayAccountExrateAllclientrateQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2866324112215682178L;

	/** 
	 * 汇率信息列表
	 */
	@ApiListField("client_rate_list")
	@ApiField("ex_client_rate_v_o")
	private List<ExClientRateVO> clientRateList;

	public void setClientRateList(List<ExClientRateVO> clientRateList) {
		this.clientRateList = clientRateList;
	}
	public List<ExClientRateVO> getClientRateList( ) {
		return this.clientRateList;
	}

}
