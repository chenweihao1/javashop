package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 权益等级折扣积分
 *
 * @author auto create
 * @since 1.0, 2016-07-06 15:04:00
 */
public class GradeDiscountPoint extends AlipayObject {

	private static final long serialVersionUID = 4137592326123668386L;

	/**
	 * 蚂蚁会员权益配置的ID
	 */
	@ApiField("benefit_id")
	private Long benefitId;

	/**
	 * 各个等级的等级折扣后的积分
	 */
	@ApiField("discount_point")
	private String discountPoint;

	/**
	 * 蚂蚁会员等级
	 */
	@ApiField("grade")
	private String grade;

	public Long getBenefitId() {
		return this.benefitId;
	}
	public void setBenefitId(Long benefitId) {
		this.benefitId = benefitId;
	}

	public String getDiscountPoint() {
		return this.discountPoint;
	}
	public void setDiscountPoint(String discountPoint) {
		this.discountPoint = discountPoint;
	}

	public String getGrade() {
		return this.grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
