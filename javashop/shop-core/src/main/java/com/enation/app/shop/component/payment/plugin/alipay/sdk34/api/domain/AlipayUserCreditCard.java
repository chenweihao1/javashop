package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 包含两个String成员变量
String cardNo; //获取前6后2
String instId; //如ICBC
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:38
 */
public class AlipayUserCreditCard extends AlipayObject {

	private static final long serialVersionUID = 6456593794276686575L;

	/**
	 * 信用卡卡号，显示前6后2
	 */
	@ApiField("card_no")
	private String cardNo;

	/**
	 * 开户行代码
	 */
	@ApiField("inst_id")
	private String instId;

	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getInstId() {
		return this.instId;
	}
	public void setInstId(String instId) {
		this.instId = instId;
	}

}
