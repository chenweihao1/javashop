package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 口碑广告系统账单查询结果(结算账单)
 *
 * @author auto create
 * @since 1.0, 2017-04-17 10:53:54
 */
public class KbAdvertSettleBillResponse extends AlipayObject {

	private static final long serialVersionUID = 4785481372795217754L;

	/**
	 * 账单下载地址(为空表示查无账单)
	 */
	@ApiField("download_url")
	private String downloadUrl;

	/**
	 * 结算账单打款日期(为空表示未打款)
	 */
	@ApiField("paid_date")
	private String paidDate;

	public String getDownloadUrl() {
		return this.downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getPaidDate() {
		return this.paidDate;
	}
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}

}
