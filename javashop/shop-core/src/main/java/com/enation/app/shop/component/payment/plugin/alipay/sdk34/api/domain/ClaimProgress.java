package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.Date;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 赔案进度
 *
 * @author auto create
 * @since 1.0, 2017-01-09 14:04:56
 */
public class ClaimProgress extends AlipayObject {

	private static final long serialVersionUID = 2872935551619787437L;

	/**
	 * 更新内容
	 */
	@ApiField("update_content")
	private String updateContent;

	/**
	 * 更新时间
	 */
	@ApiField("update_time")
	private Date updateTime;

	public String getUpdateContent() {
		return this.updateContent;
	}
	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
