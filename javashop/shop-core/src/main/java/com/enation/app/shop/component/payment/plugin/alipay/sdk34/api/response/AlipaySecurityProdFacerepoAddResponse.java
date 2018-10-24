package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.security.prod.facerepo.add response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-30 08:29:39
 */
public class AlipaySecurityProdFacerepoAddResponse extends AlipayResponse {

	private static final long serialVersionUID = 4485854556378133644L;

	/** 
	 * 扩展信息
	 */
	@ApiField("ext_info")
	private String extInfo;

	/** 
	 * 对此次插入人脸库分组的人脸id标识
	 */
	@ApiField("face_id")
	private String faceId;

	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}
	public String getExtInfo( ) {
		return this.extInfo;
	}

	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}
	public String getFaceId( ) {
		return this.faceId;
	}

}
