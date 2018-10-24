package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response;

import java.util.List;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiListField;

/**
 * ALIPAY API: alipay.offline.material.image.download response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-14 11:37:33
 */
public class AlipayOfflineMaterialImageDownloadResponse extends AlipayResponse {

	private static final long serialVersionUID = 6599146692888811512L;

	/** 
	 * 图片地址列表，按入参id顺序返回，如果某个id转化失败，则用空字符占位
	 */
	@ApiListField("image_urls")
	@ApiField("string")
	private List<String> imageUrls;

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	public List<String> getImageUrls( ) {
		return this.imageUrls;
	}

}
