package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.QueryMenu;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.open.public.menu.batchquery response.
 * 
 * @author auto create
 * @since 1.0, 2017-05-25 11:39:51
 */
public class AlipayOpenPublicMenuBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4891332658337179862L;

	/** 
	 * 菜单数量，包括默认菜单和个性化菜单
	 */
	@ApiField("count")
	private String count;

	/** 
	 * 菜单列表
	 */
	@ApiListField("menus")
	@ApiField("query_menu")
	private List<QueryMenu> menus;

	public void setCount(String count) {
		this.count = count;
	}
	public String getCount( ) {
		return this.count;
	}

	public void setMenus(List<QueryMenu> menus) {
		this.menus = menus;
	}
	public List<QueryMenu> getMenus( ) {
		return this.menus;
	}

}
