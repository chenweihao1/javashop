package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.zdataservice.unidata.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-26 16:20:03
 */
public class AlipayZdataserviceUnidataQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5695417933797549993L;

	/** 
	 * 查询结果集，统一用string方式返回
	 */
	@ApiField("query_result")
	private String queryResult;

	/** 
	 * 查询是否成功具体描述
	 */
	@ApiField("result_code")
	private String resultCode;

	/** 
	 * 查询是否成功
	 */
	@ApiField("success")
	private String success;

	public void setQueryResult(String queryResult) {
		this.queryResult = queryResult;
	}
	public String getQueryResult( ) {
		return this.queryResult;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultCode( ) {
		return this.resultCode;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
	public String getSuccess( ) {
		return this.success;
	}

}
