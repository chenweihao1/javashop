package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 洗车保养评论统计信息
 *
 * @author auto create
 * @since 1.0, 2016-11-16 10:02:20
 */
public class MerchantshopCommentStatistic extends AlipayObject {

	private static final long serialVersionUID = 7688766362432192521L;

	/**
	 * 评论总数
	 */
	@ApiField("comment_count")
	private Long commentCount;

	/**
	 * 评分（平均分），两位小数
	 */
	@ApiField("score")
	private Long score;

	public Long getCommentCount() {
		return this.commentCount;
	}
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Long getScore() {
		return this.score;
	}
	public void setScore(Long score) {
		this.score = score;
	}

}
