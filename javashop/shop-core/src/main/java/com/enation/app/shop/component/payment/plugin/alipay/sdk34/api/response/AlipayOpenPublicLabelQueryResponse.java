package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.PublicLabel;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.open.public.label.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-12-08 11:50:28
 */
public class AlipayOpenPublicLabelQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6689957954636828528L;

	/** 
	 * 该服务窗拥有的标签列表
	 */
	@ApiListField("label_list")
	@ApiField("public_label")
	private List<PublicLabel> labelList;

	public void setLabelList(List<PublicLabel> labelList) {
		this.labelList = labelList;
	}
	public List<PublicLabel> getLabelList( ) {
		return this.labelList;
	}

}
