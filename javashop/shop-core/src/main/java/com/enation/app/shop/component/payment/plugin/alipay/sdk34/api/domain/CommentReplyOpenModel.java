package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.Date;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 评价回复模型
 *
 * @author auto create
 * @since 1.0, 2017-03-03 10:40:31
 */
public class CommentReplyOpenModel extends AlipayObject {

	private static final long serialVersionUID = 5643719346397747485L;

	/**
	 * 回复内容，最多500字，不区分中英文
	 */
	@ApiField("content")
	private String content;

	/**
	 * 发表回复的操作员id
	 */
	@ApiField("operator_id")
	private String operatorId;

	/**
	 * 回复发表时间
	 */
	@ApiField("reply_publish_time")
	private Date replyPublishTime;

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getOperatorId() {
		return this.operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public Date getReplyPublishTime() {
		return this.replyPublishTime;
	}
	public void setReplyPublishTime(Date replyPublishTime) {
		this.replyPublishTime = replyPublishTime;
	}

}
