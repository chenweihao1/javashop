package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.CommentOpenModel;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: koubei.content.comment.data.batchquery response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-03 10:40:31
 */
public class KoubeiContentCommentDataBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7324274948111947889L;

	/** 
	 * 评价结果列表
	 */
	@ApiListField("comments")
	@ApiField("comment_open_model")
	private List<CommentOpenModel> comments;

	/** 
	 * 当前查询条件下评价总数
	 */
	@ApiField("count")
	private Long count;

	public void setComments(List<CommentOpenModel> comments) {
		this.comments = comments;
	}
	public List<CommentOpenModel> getComments( ) {
		return this.comments;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	public Long getCount( ) {
		return this.count;
	}

}
