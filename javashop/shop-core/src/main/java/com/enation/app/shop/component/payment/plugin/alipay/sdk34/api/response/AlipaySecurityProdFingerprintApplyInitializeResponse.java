package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.security.prod.fingerprint.apply.initialize response.
 * 
 * @author auto create
 * @since 1.0, 2017-01-12 17:27:31
 */
public class AlipaySecurityProdFingerprintApplyInitializeResponse extends AlipayResponse {

	private static final long serialVersionUID = 3866887328671121453L;

	/** 
	 * server_response:服务端返回的协议体数据，对应《IFAA本地免密技术规范》中的IFAFMessage，内容中包含服务端的校验数据。
	 */
	@ApiField("server_response")
	private String serverResponse;

	public void setServerResponse(String serverResponse) {
		this.serverResponse = serverResponse;
	}
	public String getServerResponse( ) {
		return this.serverResponse;
	}

}
