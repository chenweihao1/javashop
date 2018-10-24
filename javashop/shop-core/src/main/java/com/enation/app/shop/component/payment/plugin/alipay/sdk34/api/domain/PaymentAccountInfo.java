package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 账号信息
 *
 * @author auto create
 * @since 1.0, 2017-06-14 15:31:40
 */
public class PaymentAccountInfo extends AlipayObject {

	private static final long serialVersionUID = 7378719347463759411L;

	/**
	 * 账号名称
	 */
	@ApiField("account_name")
	private String accountName;

	/**
	 * 账号
	 */
	@ApiField("account_no")
	private String accountNo;

	/**
	 * 账号类型：ALIPAY(支付宝)，MYBK(网商银行卡)
	 */
	@ApiField("account_type")
	private String accountType;

	/**
	 * 金额：单位分
	 */
	@ApiField("amount")
	private Long amount;

	/**
	 * 账单备注
	 */
	@ApiField("content")
	private String content;

	public String getAccountName() {
		return this.accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return this.accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return this.accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getAmount() {
		return this.amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
