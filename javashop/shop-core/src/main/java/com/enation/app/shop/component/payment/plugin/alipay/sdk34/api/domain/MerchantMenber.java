package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 商户会员
 *
 * @author auto create
 * @since 1.0, 2017-06-07 13:29:46
 */
public class MerchantMenber extends AlipayObject {

	private static final long serialVersionUID = 4122633467553919866L;

	/**
	 * 生日 yyyy-MM-dd
	 */
	@ApiField("birth")
	private String birth;

	/**
	 * 手机号
	 */
	@ApiField("cell")
	private String cell;

	/**
	 * 性别（男：MALE；女：FEMALE）
	 */
	@ApiField("gende")
	private String gende;

	/**
	 * 姓名
	 */
	@ApiField("name")
	private String name;

	public String getBirth() {
		return this.birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getCell() {
		return this.cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getGende() {
		return this.gende;
	}
	public void setGende(String gende) {
		this.gende = gende;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
