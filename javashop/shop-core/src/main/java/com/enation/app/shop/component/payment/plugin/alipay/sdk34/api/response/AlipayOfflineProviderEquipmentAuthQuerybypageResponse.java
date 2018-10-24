package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.EquipmentAuthRemoveQueryBypageDTO;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.offline.provider.equipment.auth.querybypage response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-29 17:00:49
 */
public class AlipayOfflineProviderEquipmentAuthQuerybypageResponse extends AlipayResponse {

	private static final long serialVersionUID = 7186155981616428866L;

	/** 
	 * 机具解绑按照条件分页查询返回信息
	 */
	@ApiListField("equipmentauthremovequerybypagelist")
	@ApiField("equipment_auth_remove_query_bypage_d_t_o")
	private List<EquipmentAuthRemoveQueryBypageDTO> equipmentauthremovequerybypagelist;

	/** 
	 * 总记录数
	 */
	@ApiField("total")
	private Long total;

	public void setEquipmentauthremovequerybypagelist(List<EquipmentAuthRemoveQueryBypageDTO> equipmentauthremovequerybypagelist) {
		this.equipmentauthremovequerybypagelist = equipmentauthremovequerybypagelist;
	}
	public List<EquipmentAuthRemoveQueryBypageDTO> getEquipmentauthremovequerybypagelist( ) {
		return this.equipmentauthremovequerybypagelist;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getTotal( ) {
		return this.total;
	}

}
