package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * 匹配用户标签删除接口
 *
 * @author auto create
 * @since 1.0, 2017-06-01 11:25:22
 */
public class AlipayOpenPublicMatchuserLabelDeleteModel extends AlipayObject {

	private static final long serialVersionUID = 1174445585397277437L;

	/**
	 * 标签id
	 */
	@ApiField("label_id")
	private String labelId;

	/**
	 * 支付宝用户匹配器列表，最多传入10条
	 */
	@ApiListField("matchers")
	@ApiField("matcher")
	private List<Matcher> matchers;

	public String getLabelId() {
		return this.labelId;
	}
	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public List<Matcher> getMatchers() {
		return this.matchers;
	}
	public void setMatchers(List<Matcher> matchers) {
		this.matchers = matchers;
	}

}
