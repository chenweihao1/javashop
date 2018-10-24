package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * 渠道新增接口
 *
 * @author auto create
 * @since 1.0, 2017-03-03 10:40:48
 */
public class KoubeiAdvertCommissionChannelCreateModel extends AlipayObject {

	private static final long serialVersionUID = 6894858815629579337L;

	/**
	 * 新增渠道列表
	 */
	@ApiListField("channels")
	@ApiField("kb_advert_add_channel_request")
	private List<KbAdvertAddChannelRequest> channels;

	public List<KbAdvertAddChannelRequest> getChannels() {
		return this.channels;
	}
	public void setChannels(List<KbAdvertAddChannelRequest> channels) {
		this.channels = channels;
	}

}
