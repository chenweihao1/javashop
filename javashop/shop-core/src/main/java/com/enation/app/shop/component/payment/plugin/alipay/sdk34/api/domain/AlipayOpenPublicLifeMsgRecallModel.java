package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 生活号消息撤回接口
 *
 * @author auto create
 * @since 1.0, 2016-12-19 20:51:25
 */
public class AlipayOpenPublicLifeMsgRecallModel extends AlipayObject {

	private static final long serialVersionUID = 5489838313935534213L;

	/**
	 * 消息id
	 */
	@ApiField("message_id")
	private String messageId;

	public String getMessageId() {
		return this.messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

}
