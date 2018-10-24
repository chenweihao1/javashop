package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.ExRefRateInfoVO;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.account.exrate.ratequery response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-27 18:11:27
 */
public class AlipayAccountExrateRatequeryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5898431969527859551L;

	/** 
	 * 查询到的汇率对象列表，如果没有查询到则返回空列表
	 */
	@ApiListField("rate_query_response_list")
	@ApiField("ex_ref_rate_info_v_o")
	private List<ExRefRateInfoVO> rateQueryResponseList;

	public void setRateQueryResponseList(List<ExRefRateInfoVO> rateQueryResponseList) {
		this.rateQueryResponseList = rateQueryResponseList;
	}
	public List<ExRefRateInfoVO> getRateQueryResponseList( ) {
		return this.rateQueryResponseList;
	}

}
