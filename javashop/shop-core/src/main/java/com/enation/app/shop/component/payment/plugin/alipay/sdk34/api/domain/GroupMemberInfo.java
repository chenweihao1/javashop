package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 群成员基本信息
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:39
 */
public class GroupMemberInfo extends AlipayObject {

	private static final long serialVersionUID = 2812342671932628257L;

	/**
	 * 用户在这个群里的昵称
	 */
	@ApiField("group_nickname")
	private String groupNickname;

	/**
	 * 个人昵称
	 */
	@ApiField("nickname")
	private String nickname;

	/**
	 * 用户的uid
	 */
	@ApiField("user_id")
	private String userId;

	public String getGroupNickname() {
		return this.groupNickname;
	}
	public void setGroupNickname(String groupNickname) {
		this.groupNickname = groupNickname;
	}

	public String getNickname() {
		return this.nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
