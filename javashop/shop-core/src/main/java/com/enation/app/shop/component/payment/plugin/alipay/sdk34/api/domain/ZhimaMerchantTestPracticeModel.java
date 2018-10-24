package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * asd
 *
 * @author auto create
 * @since 1.0, 2016-10-26 18:05:09
 */
public class ZhimaMerchantTestPracticeModel extends AlipayObject {

	private static final long serialVersionUID = 2185622334453788375L;

	/**
	 * a d
	 */
	@ApiListField("add")
	@ApiField("string")
	private List<String> add;

	/**
	 * zzz
	 */
	@ApiField("xxxx")
	private XXXXsdasdasd xxxx;

	public List<String> getAdd() {
		return this.add;
	}
	public void setAdd(List<String> add) {
		this.add = add;
	}

	public XXXXsdasdasd getXxxx() {
		return this.xxxx;
	}
	public void setXxxx(XXXXsdasdasd xxxx) {
		this.xxxx = xxxx;
	}

}
