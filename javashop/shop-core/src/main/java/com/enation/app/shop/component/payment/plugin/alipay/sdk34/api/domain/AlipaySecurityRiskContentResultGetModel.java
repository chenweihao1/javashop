package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 内容风险识别结果查询接口服务
 *
 * @author auto create
 * @since 1.0, 2016-10-31 17:32:43
 */
public class AlipaySecurityRiskContentResultGetModel extends AlipayObject {

	private static final long serialVersionUID = 5357771525942552438L;

	/**
	 * 应用场景
	 */
	@ApiField("app_scene")
	private String appScene;

	/**
	 * alipay.security.risk.content.analyze （内容风险识别接口服务）中的内容业务ID，用于进行异步识别结果的索引查询
	 */
	@ApiField("app_scene_data_id")
	private String appSceneDataId;

	public String getAppScene() {
		return this.appScene;
	}
	public void setAppScene(String appScene) {
		this.appScene = appScene;
	}

	public String getAppSceneDataId() {
		return this.appSceneDataId;
	}
	public void setAppSceneDataId(String appSceneDataId) {
		this.appSceneDataId = appSceneDataId;
	}

}
