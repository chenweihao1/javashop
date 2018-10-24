package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 圈人规则查询
 *
 * @author auto create
 * @since 1.0, 2016-12-19 15:27:36
 */
public class AlipayMarketingCampaignRuleRulelistQueryModel extends AlipayObject {

	private static final long serialVersionUID = 3324485879666354664L;

	/**
	 * 签约商户下属子机构唯一编号
	 */
	@ApiField("mpid")
	private String mpid;

	/**
	 * 页码，从1开始
	 */
	@ApiField("pageno")
	private String pageno;

	/**
	 * 每页大小
	 */
	@ApiField("pagesize")
	private String pagesize;

	public String getMpid() {
		return this.mpid;
	}
	public void setMpid(String mpid) {
		this.mpid = mpid;
	}

	public String getPageno() {
		return this.pageno;
	}
	public void setPageno(String pageno) {
		this.pageno = pageno;
	}

	public String getPagesize() {
		return this.pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

}
