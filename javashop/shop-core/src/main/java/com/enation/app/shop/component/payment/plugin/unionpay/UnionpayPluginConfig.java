package com.enation.app.shop.component.payment.plugin.unionpay;

import java.util.Map;
import java.util.Properties;

import com.enation.app.shop.component.payment.plugin.unionpay.sdk.SDKConfig;
import com.enation.app.shop.core.payment.service.AbstractPaymentPlugin;
import com.enation.framework.util.StringUtil;

/**
 * 中国银联
 * 
 * @author fk
 * @version v6.4
 * @since v6.4 2018年5月23日 下午3:37:06
 */
public class UnionpayPluginConfig extends AbstractPaymentPlugin {

	private static int is_load = 0;
	
	private static int is_test = 0;//测试环境 0  生产环境  1
	
	@Override
	public String getPluginId() {

		return "unPay";
	}

	/**
	 * 设置参数
	 */
	public void setConfig() {
		Map<String, String> params = this.getConfig();
		UnionpayConfig.merId = params.get("merId");
		// 是否是测试模式

		// 如果已经加载，并且是生产环境则不用再加载
		if (is_load == 1 && is_test == 1) {
			return;
		}

		// 签名证书路径
		String signCert = params.get("signCert");

		// 签名证书密码
		String pwd = params.get("pwd");

		// 验证签名证书目录
		String validateCert = params.get("validateCert");

		// 敏感信息加密证书路径
		String encryptCert = params.get("encryptCert");

		if (StringUtil.isEmpty(signCert)) {
			throw new RuntimeException("参数配置错误");
		}
		if (StringUtil.isEmpty(pwd)) {
			throw new RuntimeException("参数配置错误");
		}
		if (StringUtil.isEmpty(validateCert)) {
			throw new RuntimeException("参数配置错误");
		}

//		InputStream in = FileUtil
//				.getResourceAsStream("com/enation/app/shop/component/payment/plugin/unionpay/acp_sdk.properties");
		Properties pro = new Properties();
//		try {

//			pro.load(in);
			pro.setProperty("acpsdk.signCert.type", "PKCS12");
			pro.setProperty("acpsdk.signCert.path", signCert);
			pro.setProperty("acpsdk.signCert.pwd", pwd);
			pro.setProperty("acpsdk.validateCert.dir", validateCert);

			// 设置测试环境的提交地址
			if (is_test == 0) {
				pro.setProperty("acpsdk.frontTransUrl", "https://gateway.test.95516.com/gateway/api/frontTransReq.do");
				pro.setProperty("acpsdk.backTransUrl", "https://gateway.test.95516.com/gateway/api/backTransReq.do");
				pro.setProperty("acpsdk.singleQueryUrl", "https://gateway.test.95516.com/gateway/api/queryTrans.do");
				pro.setProperty("acpsdk.batchTransUrl", "https://gateway.test.95516.com/gateway/api/batchTrans.do");
				pro.setProperty("acpsdk.fileTransUrl", "https://filedownload.test.95516.com/");
				pro.setProperty("acpsdk.appTransUrl", "https://gateway.test.95516.com/gateway/api/appTransReq.do");
				pro.setProperty("acpsdk.cardTransUrl", "https://gateway.test.95516.com/gateway/api/cardTransReq.do");
			}

			// 设置生产环境的提交地址
			if (is_test == 1) {
				pro.setProperty("acpsdk.frontTransUrl", "https://gateway.95516.com/gateway/api/frontTransReq.do");
				pro.setProperty("acpsdk.backTransUrl", "https://gateway.95516.com/gateway/api/backTransReq.do");
				pro.setProperty("acpsdk.singleQueryUrl", "https://gateway.95516.com/gateway/api/queryTrans.do");
				pro.setProperty("acpsdk.batchTransUrl", "https://gateway.95516.com/gateway/api/batchTrans.do");
				pro.setProperty("acpsdk.fileTransUrl", "https://filedownload.95516.com/");
				pro.setProperty("acpsdk.appTransUrl", "https://gateway.95516.com/gateway/api/appTransReq.do");
				pro.setProperty("acpsdk.cardTransUrl", "https://gateway.95516.com/gateway/api/cardTransReq.do");

			}

			if (!StringUtil.isEmpty(encryptCert)) {
				pro.setProperty("acpsdk.encryptCert.path", encryptCert);
			}

			SDKConfig.getConfig().loadProperties(pro);

//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		is_load = 1;

	}

}
