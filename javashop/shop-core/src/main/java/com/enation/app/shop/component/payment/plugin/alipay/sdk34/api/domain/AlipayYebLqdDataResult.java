package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 余额宝负债端预测数据
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:39
 */
public class AlipayYebLqdDataResult extends AlipayObject {

	private static final long serialVersionUID = 5888743129626282783L;

	/**
	 * 申购预测，单位:元
	 */
	@ApiField("predict_purchase_amt")
	private String predictPurchaseAmt;

	/**
	 * 赎回预测,单位:元
	 */
	@ApiField("predict_redeem_amt")
	private String predictRedeemAmt;

	/**
	 * 预测日期，格式为yyyymmdd
	 */
	@ApiField("target_date")
	private String targetDate;

	public String getPredictPurchaseAmt() {
		return this.predictPurchaseAmt;
	}
	public void setPredictPurchaseAmt(String predictPurchaseAmt) {
		this.predictPurchaseAmt = predictPurchaseAmt;
	}

	public String getPredictRedeemAmt() {
		return this.predictRedeemAmt;
	}
	public void setPredictRedeemAmt(String predictRedeemAmt) {
		this.predictRedeemAmt = predictRedeemAmt;
	}

	public String getTargetDate() {
		return this.targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

}
