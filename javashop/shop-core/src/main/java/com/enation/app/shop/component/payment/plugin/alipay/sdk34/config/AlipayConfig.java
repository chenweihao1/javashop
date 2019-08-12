package com.enation.app.shop.component.payment.plugin.alipay.sdk34.config;

/**
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2019072665926841";
	//public static String app_id = "2016100200644648";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key =
					"MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDanQOA9b2RbmjB" +
					"gSpQvtnVvgPoJk3ZwiZW4WTEE5HJbWnWAvRNK9JwBC4LJTin+L7SwJoxSBzwSkod" +
					"aFmin2wExZ+9LegXdudBoc+osQpGn+i3jH+ZM4bqMUpFjvhC/URQhDwEnJ4D5tA1" +
					"WHx0IMj4Oq2nNYX8dRKEsdd4XG1Z1axGsnVkjawFU/HYyoVvgw+AYgHlzGmA2wYc" +
					"xA+Hlf4tbbs912fxdTXXUxfKaZeZLGQ/CBBSy1ONKjcRvB8f7v1WaIUtE5OrHg41" +
					"jdoXCBrhkmnVxJX+WTnCeJB16HLOO7WDJfQFXAct9oONJs78PjzCR64DH7fYcMyH" +
					"3pMlJnqHAgMBAAECggEATfj4ufNsRMXbiUEXpascqRbX7+JRnByabhyAQ0szkWN7" +
					"/0AYgLnjmd5zybfh6E9ZSHQ3yuIMqEvm+WwxpEY2UdFm8yO/hzb6rrcXCPT0VFJO" +
					"v8DV9f+h3D/uXLbsp4AL8KfpfD+cQIn/szc3VHgpFhhfvabifjQHgdqonp5gxkw9" +
					"/7GsTwlMLJxobw27O+qwJcEjXRRu9FEvBimJ2VlvXPeci6CJAvSII+QixJqWFXP+" +
					"rKE64nL7SD95GxbnVKRvOxzQYWg35V7LGgyurIh8Y00K0UApqP3yCwlx3z8KXDwx" +
					"hUJTdci0XbnlLkwnXyTtHHd2oVolqYzbtnWQOj35AQKBgQD10Fb+kFOIB8YWu9Z+" +
					"2EkRT0ENr0mPrS0/RZn1om8fDyePTcbukAi2PkAOm5S6iyxeuOFOJYKBQp9VABEk" +
					"mIw/hMn4bO/X7OQ3+nASuvB8t5SVrTMhr1+AhLQDPb98CpMctvI+jZkbdIvWAwqe" +
					"qh3LtosPIsQHQVM9dfaH/vEegQKBgQDjrB+lIDGQHojnuX9aMLIqyHgx/XRAbT6U" +
					"ISj742Ku0OvbXLpaQsvjYDWPVdPFj/94+5bgzUVXeXDsW4ySVnSPwp1iLZ5vUICl" +
					"fy9AANFOw+pVRx/GXoJyRfnxaRU+cPdET1oyYjefTvCTlNmo5cxqgNbALt0WBNYp" +
					"JfppzCYlBwKBgQClLwPGvSXk25R54nAZfS5cu21zzL8aFb26LwNu1WDm9kAXRKTR" +
					"22h/TwWsy0/+q1d9r6933Cz+v85iSFE8zmYwqQMwNcRWzZHvLBP0AjtpE9R9YI5j" +
					"rH341zRAmVX7/P8u5KGU94JTuNXfUtvoE1lCc8CuwyYH2hYdzw+EBAX0AQKBgQCS" +
					"sAafjHOCiLnqmxCbmn5gpFMU2lk5XWmRZSAT0rh1K/SanE8Q8rKM6CL6G/Fa++E9" +
					"INRgOMFxj7QbBQ04B+4H5fsjE4Nd8v9AIgbedOhmmEH1+eJWG/RuDfnw+aSPW5dk" +
					"8r+JcNCnmuPUInZupMik4if7IPafRjR5xJdn7PmypwKBgCQSMCCf5yopUdSEpdMK" +
					"pIkkbwc+yTMJECWbBTHATbHBGPBVq+J0Hgr7M1KOWZ/PFK6d/terPcmaalKbPWJb" +
					"Of6aYhfDmNvDnwrVawlBDKcayCmANr9uHgxSGI7h/E3oLi7hElnxtO//HCIKa6bx" +
					"N14Yv+WC0yYuL73ui4UlryYv";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAogmU/Qtv49LU4K2b9jmTsFKRFp2cNLdlAMOA+w++X782LHZTlHVwbx6HLEyxD/Ny1cJTgu6GOGzJI2XepbIGU/9PulhNCK8OIYzTwsn5CLWBgjt9IL6blnY2p1XkPvje99gMKyUuOrf1IOKDDd5tkAnT5bul6rhkrwIiO6fvoLFrDdafOib5hoK8kU3cvxQfz9SWJ2GW5g+9xN7p8fPd2h4Bs+1x5tMe/jDTLXjrY7GQGYvhhbNZetUXMrNJkKB7DyRGOM7AkZ11pqKEDvQ4M60PoB7iaZeV+GM7SdSaPpQwduvHXUYl4VNXQTao6ohcLnecujy59YuZpwCiZfmnAwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String notify_url = "http://pay.szyhb.cn/b2c/api/shop/wap_alipayDirectPlugin_payment-callback/execute.do";
	public static String notify_url = "http://310b63dc.nat123.cc/api/shop/wap_alipayDirectPlugin_payment-callback/execute.do";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
//	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	

}

