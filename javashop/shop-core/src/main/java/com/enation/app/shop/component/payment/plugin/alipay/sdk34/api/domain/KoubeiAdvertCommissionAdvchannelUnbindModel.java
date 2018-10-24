package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * 创建广告推广内容
 *
 * @author auto create
 * @since 1.0, 2017-01-17 10:33:35
 */
public class KoubeiAdvertCommissionAdvchannelUnbindModel extends AlipayObject {

	private static final long serialVersionUID = 8451751495243366356L;

	/**
	 * 广告ID
	 */
	@ApiField("adv_id")
	private String advId;

	/**
	 * 渠道ID列表
	 */
	@ApiListField("channel_id_list")
	@ApiField("string")
	private List<String> channelIdList;

	public String getAdvId() {
		return this.advId;
	}
	public void setAdvId(String advId) {
		this.advId = advId;
	}

	public List<String> getChannelIdList() {
		return this.channelIdList;
	}
	public void setChannelIdList(List<String> channelIdList) {
		this.channelIdList = channelIdList;
	}

}
