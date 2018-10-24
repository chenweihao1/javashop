package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.security.prod.facerepo.search response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-30 08:29:21
 */
public class AlipaySecurityProdFacerepoSearchResponse extends AlipayResponse {

	private static final long serialVersionUID = 7725379985928972198L;

	/** 
	 * 扩展参数
	 */
	@ApiField("ext_info")
	private String extInfo;

	/** 
	 * 从入参指定的人脸库分组中搜索出来的相似度最高的人脸id
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
