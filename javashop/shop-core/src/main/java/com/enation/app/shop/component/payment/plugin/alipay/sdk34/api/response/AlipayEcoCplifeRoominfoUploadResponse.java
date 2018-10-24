package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.CplifeRoomInfoResp;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.eco.cplife.roominfo.upload response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-24 11:43:11
 */
public class AlipayEcoCplifeRoominfoUploadResponse extends AlipayResponse {

	private static final long serialVersionUID = 7331185959296397343L;

	/** 
	 * 业主所在物业小区ID(支付宝平台唯一小区ID标示)
	 */
	@ApiField("community_id")
	private String communityId;

	/** 
	 * 已经成功上传的房屋信息列表.
	 */
	@ApiListField("room_info_set")
	@ApiField("cplife_room_info_resp")
	private List<CplifeRoomInfoResp> roomInfoSet;

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}
	public String getCommunityId( ) {
		return this.communityId;
	}

	public void setRoomInfoSet(List<CplifeRoomInfoResp> roomInfoSet) {
		this.roomInfoSet = roomInfoSet;
	}
	public List<CplifeRoomInfoResp> getRoomInfoSet( ) {
		return this.roomInfoSet;
	}

}
