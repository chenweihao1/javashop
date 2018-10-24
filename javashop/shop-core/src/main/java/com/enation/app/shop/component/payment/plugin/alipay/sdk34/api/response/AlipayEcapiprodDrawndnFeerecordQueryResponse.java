package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.FeeRecords;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.ecapiprod.drawndn.feerecord.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-03-29 11:34:27
 */
public class AlipayEcapiprodDrawndnFeerecordQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 8278322317832566869L;

	/** 
	 * 费用交易流水
	 */
	@ApiListField("fee_records")
	@ApiField("fee_records")
	private List<FeeRecords> feeRecords;

	/** 
	 * 唯一标识这次请求
	 */
	@ApiField("request_id")
	private String requestId;

	public void setFeeRecords(List<FeeRecords> feeRecords) {
		this.feeRecords = feeRecords;
	}
	public List<FeeRecords> getFeeRecords( ) {
		return this.feeRecords;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestId( ) {
		return this.requestId;
	}

}
