package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 行业平台写请求
 *
 * @author auto create
 * @since 1.0, 2016-10-26 18:05:15
 */
public class AlipayEcoMycarDataExternalSendModel extends AlipayObject {

	private static final long serialVersionUID = 5552527569357629425L;

	/**
	 * external_system_name
	 */
	@ApiField("external_system_name")
	private String externalSystemName;

	/**
	 * is_transfer_uid
	 */
	@ApiField("is_transfer_uid")
	private String isTransferUid;

	/**
	 * operate_type
	 */
	@ApiField("operate_type")
	private String operateType;

	/**
	 * send_data
	 */
	@ApiField("send_data")
	private String sendData;

	public String getExternalSystemName() {
		return this.externalSystemName;
	}
	public void setExternalSystemName(String externalSystemName) {
		this.externalSystemName = externalSystemName;
	}

	public String getIsTransferUid() {
		return this.isTransferUid;
	}
	public void setIsTransferUid(String isTransferUid) {
		this.isTransferUid = isTransferUid;
	}

	public String getOperateType() {
		return this.operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getSendData() {
		return this.sendData;
	}
	public void setSendData(String sendData) {
		this.sendData = sendData;
	}

}
