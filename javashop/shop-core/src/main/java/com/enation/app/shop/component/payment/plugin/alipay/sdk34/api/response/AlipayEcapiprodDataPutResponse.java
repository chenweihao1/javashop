package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ecapiprod.data.put response.
 * 
 * @author auto create
 * @since 1.0, 2015-04-02 16:45:23
 */
public class AlipayEcapiprodDataPutResponse extends AlipayResponse {

	private static final long serialVersionUID = 8596541817945176199L;

	/** 
	 * 数据版本
	 */
	@ApiField("data_version")
	private String dataVersion;

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}
	public String getDataVersion( ) {
		return this.dataVersion;
	}

}
