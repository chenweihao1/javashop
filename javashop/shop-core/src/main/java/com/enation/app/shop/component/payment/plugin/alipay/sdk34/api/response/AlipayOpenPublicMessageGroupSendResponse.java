package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.message.group.send response.
 * 
 * @author auto create
 * @since 1.0, 2017-06-14 11:02:07
 */
public class AlipayOpenPublicMessageGroupSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 5847489836176551231L;

	/** 
	 * 2013121100055554f1000b64-3f05-4581-a5e1-16e29d242950
	 */
	@ApiField("message_id")
	private String messageId;

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getMessageId( ) {
		return this.messageId;
	}

}
