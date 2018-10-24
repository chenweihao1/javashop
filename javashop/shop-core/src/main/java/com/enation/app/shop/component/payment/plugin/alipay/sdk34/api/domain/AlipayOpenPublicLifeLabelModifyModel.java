package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 标签修改接口
 *
 * @author auto create
 * @since 1.0, 2017-06-01 11:26:26
 */
public class AlipayOpenPublicLifeLabelModifyModel extends AlipayObject {

	private static final long serialVersionUID = 5126646447768675647L;

	/**
	 * 标签id，调用创建标签接口后由支付宝返回
	 */
	@ApiField("label_id")
	private String labelId;

	/**
	 * 标签名
	 */
	@ApiField("label_name")
	private String labelName;

	public String getLabelId() {
		return this.labelId;
	}
	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return this.labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

}
