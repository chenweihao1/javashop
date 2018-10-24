package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.VoucherTemplateLiteInfo;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.marketing.voucher.templatelist.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-28 22:18:14
 */
public class AlipayMarketingVoucherTemplatelistQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3516455533769258544L;

	/** 
	 * 当前页码,页码从1开始
	 */
	@ApiField("current_page")
	private Long currentPage;

	/** 
	 * 每页条数
	 */
	@ApiField("items_per_page")
	private Long itemsPerPage;

	/** 
	 * 总条数
	 */
	@ApiField("total_items")
	private Long totalItems;

	/** 
	 * 总页数
	 */
	@ApiField("total_pages")
	private Long totalPages;

	/** 
	 * 券模板列表
	 */
	@ApiListField("voucher_templates")
	@ApiField("voucher_template_lite_info")
	private List<VoucherTemplateLiteInfo> voucherTemplates;

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}
	public Long getCurrentPage( ) {
		return this.currentPage;
	}

	public void setItemsPerPage(Long itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	public Long getItemsPerPage( ) {
		return this.itemsPerPage;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}
	public Long getTotalItems( ) {
		return this.totalItems;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	public Long getTotalPages( ) {
		return this.totalPages;
	}

	public void setVoucherTemplates(List<VoucherTemplateLiteInfo> voucherTemplates) {
		this.voucherTemplates = voucherTemplates;
	}
	public List<VoucherTemplateLiteInfo> getVoucherTemplates( ) {
		return this.voucherTemplates;
	}

}
