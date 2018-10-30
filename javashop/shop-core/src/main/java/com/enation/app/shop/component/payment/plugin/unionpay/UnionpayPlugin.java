package com.enation.app.shop.component.payment.plugin.unionpay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.enation.app.shop.core.order.model.PaymentResult;
import com.enation.app.shop.core.order.model.Refund;
import com.enation.app.shop.core.order.model.RefundBill;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enation.app.base.core.model.ConfigItem;
import com.enation.app.shop.component.payment.plugin.unionpay.sdk.AcpService;
import com.enation.app.shop.component.payment.plugin.unionpay.sdk.LogUtil;
import com.enation.app.shop.component.payment.plugin.unionpay.sdk.SDKConfig;
import com.enation.framework.cache.ICache;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import com.enation.framework.util.CurrencyUtil;
import com.enation.framework.util.StringUtil;
 
 
/**
 * 中国银联在线支付
 * @author xulipeng
 *	2015年09月03日13:29:34
 *
 * v2.0 ：重构，采用界面化配置参数，并将sdk源码引入，去掉jar的依赖
 * by kingapex 2017年01月22日 13:29:34
 */
@Component("unPay")
public class UnionpayPlugin extends UnionpayPluginConfig implements IPaymentPlugin {
	
	public static String encoding = "UTF-8";
	
	/**
	 * 5.0.0
	 */
	public static String version = "5.0.0";
	
	@Autowired
	private ICache cache;
	

	@Override
	public String onPay(PayBill bill) {
		
		super.setConfig();
		
		/**
		 * 组装请求报文
		 */
		Map<String, String> data = new HashMap<String, String>();
		// 版本号
		data.put("version", version);
		// 字符集编码 默认"UTF-8"
		data.put("encoding", "UTF-8");
		// 签名方法 01 RSA
		data.put("signMethod", "01");
		// 交易类型 01-消费
		data.put("txnType", "01");
		// 交易子类型 01:自助消费 02:订购 03:分期付款
		data.put("txnSubType", "01");
		// 业务类型
		data.put("bizType", "000201");
		// 渠道类型，07-PC，08-手机
		data.put("channelType", "07");
		// 前台通知地址 ，控件接入方式无作用
		data.put("frontUrl", this.getReturnUrl(bill));
		// 后台通知地址
		data.put("backUrl", this.getCallBackUrl(bill.getOrderType()));
		// 接入类型，商户接入填0 0- 商户 ， 1： 收单， 2：平台商户
		data.put("accessType", "0");
		// 商户号码，请改成自己的商户号
		data.put("merId", UnionpayConfig.merId);
		// 商户订单号，8-40位数字字母
		//因为 银联要求的订单号不能有-号，在javashop中的子订单是有这个符号的，所以改用orderid
		String  orderid = bill.getOrder_sn();
		
		int length  =  orderid.length();
		//保证不小于8位，且不大于40位
		orderid = orderid.substring( (length-40 ) <0?0:length-40,length);
		
		data.put("orderId", orderid);
		// 订单发送时间，取系统时间
		data.put("txnTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		// 交易金额，单位分
		Double txnAmt = CurrencyUtil.mul(bill.getOrder_price(), 100);
		 
		data.put("txnAmt", ""+txnAmt.intValue());
		// 交易币种
		data.put("currencyCode", "156");
		// 请求方保留域，透传字段，查询、通知、对账文件中均会原样出现
		// data.put("reqReserved", "透传信息");
		// 订单描述，可不上送，上送时控件中会显示该信息
		// data.put("orderDesc", "订单描述");

		Map<String, String> submitFromData = AcpService.sign(data,encoding);  //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
		
		// 交易请求url 从配置文件读取
		String requestFrontUrl = SDKConfig.getConfig().getFrontRequestUrl();
		
		/**
		 * 创建表单
		 */
		String html = AcpService.createAutoFormHtml(requestFrontUrl, submitFromData,encoding);   //生成自动跳转的Html表单
		
//		System.out.println("打印请求HTML，此为请求报文，为联调排查问题的依据："+html);
		return html;
	}

	@Override
	public String onReturn(String ordertype) {
		
		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		//商户订单号
		String orderSn = request.getParameter("orderId");
		try {
			String respCode = request.getParameter("respCode");	//应答码			参考：https://open.unionpay.com/ajweb/help/respCode/respCodeList
			String respMsg = request.getParameter("respMsg");	//应答信息
			
			//因为 银联要求的订单号不能有-号，在javashop中的子订单是有这个符号的，所以改用orderid
			String queryId = request.getParameter("queryId");	//流水号
			String tradeno = request.getParameter("traceNo");	//系统追踪号
			String settleAmt = request.getParameter("settleAmt");	//交易金额
			double payprice = StringUtil.toDouble(settleAmt, 0d);
			// 传回来的是分，转为元
			payprice = CurrencyUtil.mul(payprice, 0.01);

			
			if(respCode.equals("00")){	//交易成功
				if(JavashopUnionpayUtil.validaeData()){
					
					PaymentResult paymentResult = new PaymentResult();
					paymentResult.setOrdersn(orderSn);
					paymentResult.setPay_order_no(queryId);
					paymentResult.setOrderType(ordertype);
					paymentResult.setPay_price(payprice);
					this.paySuccess(paymentResult);
					
					return orderSn;
				}else{
					throw new RuntimeException("验证失败");
				}
			}else{
				throw new RuntimeException("验证失败，错误信息:"+respMsg);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("验证失败");
		}
	}

	@Override
	public String onCallback(String ordertype) {
		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		String orderid = request.getParameter("orderId");	//商户订单号
		
		try {
			String respCode = request.getParameter("respCode");	//应答码			参考：https://open.unionpay.com/ajweb/help/respCode/respCodeList
			String respMsg = request.getParameter("respMsg");	//应答信息
			
			//因为 银联要求的订单号不能有-号，在javashop中的子订单是有这个符号的，所以改用orderid
			
			String queryId = request.getParameter("queryId");	//流水号
			String tradeno = request.getParameter("traceNo");	//系统追踪号
			String settleAmt = request.getParameter("settleAmt");	//交易金额
			double payprice = StringUtil.toDouble(settleAmt, 0d);
			// 传回来的是分，转为元
			payprice = CurrencyUtil.mul(payprice, 0.01);
			 
			if(respCode.equals("00")){	//交易成功
				
				if(JavashopUnionpayUtil.validaeData()){
					PaymentResult paymentResult = new PaymentResult();
					paymentResult.setOrdersn(orderid);
					paymentResult.setPay_order_no(queryId);
					paymentResult.setOrderType(ordertype);
					paymentResult.setPay_price(payprice);
					this.paySuccess(paymentResult);
					return orderid;
				}else{
					throw new RuntimeException("验证失败");
				}
				
			}else{
				throw new RuntimeException("验证失败，错误信息:"+respMsg);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("验证失败");
		}
	}

	@Override
	public boolean returnPay(RefundBill bill) {
		super.setConfig();

		/**
		 * 组装请求报文
		 */
		Map<String, String> data = new HashMap<String, String>();
		// 版本号
		data.put("version", "5.0.0");
		// 字符集编码 默认"UTF-8"
		data.put("encoding", "UTF-8");
		// 签名方法 01 RSA
		data.put("signMethod", "01");
		// 交易类型 04-退货
		data.put("txnType", "04");
		// 交易子类型 01:自助消费 02:订购 03:分期付款
		data.put("txnSubType", "00");
		// 业务类型
		data.put("bizType", "000201");
		// 渠道类型，07-PC，08-手机
		data.put("channelType", "07");
		/**
		 * 因中国银联5.0退款接口只有在退款成功的情况下才会回调，如果退款失败则无法回调，所以不通过异步回调获取退款状态
		 * 通过查询退款状态交易查询接口获取退款状态
		 */
		// 后台通知地址

		data.put("backUrl", "http://www.specialurl.com");
		// 接入类型，商户接入填0 0- 商户 ， 1： 收单， 2：平台商户
		data.put("accessType", "0");
		// 商户号码，请改成自己的商户号
		data.put("merId", UnionpayConfig.merId);
		// 商户订单号，8-40位数字字母
		// 因为 银联要求的订单号不能有-号，在javashop中的子订单是有这个符号的，所以改用orderid
		String orderid = bill.getRefund_sn();

		data.put("orderId", orderid);
		// 订单发送时间，取系统时间
		String txnTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		/** 添加退款发起时间 */
		cache.put("refundtime_"+bill.getRefund_sn(), txnTime);
		data.put("txnTime", txnTime);
		// 交易金额，单位分
		Double txnAmt = CurrencyUtil.mul(bill.getRefund_price(), 100);

		data.put("txnAmt", "" + txnAmt.intValue());
		// 交易币种
		data.put("currencyCode", "156");
		/*** 要调通交易以下字段必须修改 ***/
		data.put("origQryId", bill.getTrade_sn()); // ****原消费交易返回的的queryId，可以从消费交易后台通知接口中或者交易状态查询接口中获取
		// 请求方保留域，透传字段，查询、通知、对账文件中均会原样出现
		// data.put("reqReserved", "透传信息");

		Map<String, String> reqData = AcpService.sign(data, encoding); // 报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。

		// 交易请求url 从配置文件读取
		String url = SDKConfig.getConfig().getBackRequestUrl();

		Map<String, String> rspData = AcpService.post(reqData, url, encoding);// 这里调用signData之后，调用submitUrl之前不能对submitFromData中的键值对做任何修改，如果修改会导致验签不通过

		/** 对应答码的处理，请根据您的业务逻辑来编写程序,以下应答码处理逻辑仅供参考-------------> **/
		// 应答码规范参考open.unionpay.com帮助中心 下载 产品接口规范 《平台接入接口规范-第5部分-附录》
		if (!rspData.isEmpty()) {
			if (AcpService.validate(rspData, "UTF-8")) {
				LogUtil.writeLog("验证签名成功");
				String respCode = rspData.get("respCode");
				if ("00".equals(respCode)) {
					// 交易已受理，等待接收后台通知更新订单状态,也可以主动发起 查询交易确定交易状态。
					return true;
				} else if ("03".equals(respCode) || "04".equals(respCode) || "05".equals(respCode)) {
					// 后续需发起交易状态查询交易确定交易状态
					return true;
				} else {
					return false;
				}
			} else {
				LogUtil.writeErrorLog("验证签名失败");
				// TODO 检查验证签名失败的原因
			}
		} else {
			// 未返回正确的http状态
			LogUtil.writeErrorLog("未获取到返回报文或返回http状态码非200");
		}

		return false;
	}

	@Override
	public Refund queryRefundStatus(Refund refund) {
		
		super.setConfig();
		/**
		 * 组装请求报文
		 */
		Map<String, String> data = new HashMap<String, String>();
		// 版本号
		data.put("version", "5.0.0");
		// 字符集编码 默认"UTF-8"
		data.put("encoding", "UTF-8");
		// 签名方法 01 RSA
		data.put("signMethod", "01");
		// 交易类型 00-默认货
		data.put("txnType", "00");
		// 交易子类型 01:自助消费 02:订购 03:分期付款
		data.put("txnSubType", "00");
		// 业务类型
		data.put("bizType", "000201");
		// 接入类型，商户接入填0 0- 商户 ， 1： 收单， 2：平台商户
		data.put("accessType", "0");
		// 商户号码，请改成自己的商户号
		data.put("merId", UnionpayConfig.merId);
		// 商户订单号，8-40位数字字母
		//因为 银联要求的订单号不能有-号，在javashop中的子订单是有这个符号的，所以改用orderid
		String  orderid = refund.getSn();
		data.put("orderId", orderid);
		 //****订单发送时间，被查询的交易的订单发送时间
		data.put("txnTime", (String)cache.get("refundtime_"+refund.getSn()));
		 

		Map<String, String> reqData = AcpService.sign(data,encoding);  //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
		
		String url = SDKConfig.getConfig().getSingleQueryUrl();// 交易请求url从配置文件读取对应属性文件acp_sdk.properties中的 acpsdk.singleQueryUrl
		
		 Map<String, String> rspData = AcpService.post(reqData,url,encoding);//这里调用signData之后，调用submitUrl之前不能对submitFromData中的键值对做任何修改，如果修改会导致验签不通过
			
		 /**对应答码的处理，请根据您的业务逻辑来编写程序,以下应答码处理逻辑仅供参考------------->**/
			//应答码规范参考open.unionpay.com帮助中心 下载  产品接口规范  《平台接入接口规范-第5部分-附录》
			if(!rspData.isEmpty()){
				if(AcpService.validate(rspData,encoding)){
					LogUtil.writeLog("验证签名成功");
					if("00".equals(rspData.get("respCode"))){//如果查询交易成功
						//处理被查询交易的应答码逻辑
						String origRespCode = rspData.get("origRespCode");
						if("00".equals(origRespCode)){
							refund.setStatus(1);
							cache.remove("refundtime_"+refund.getSn());
						}else if("03".equals(origRespCode) ||
								 "04".equals(origRespCode) ||
								 "05".equals(origRespCode)){
							//需再次发起交易状态查询交易 
						}else{
							//其他应答码为失败请排查原因
							refund.setStatus(1);
						}
					}else{//查询交易本身失败，或者未查到原交易，检查查询交易报文要素
						refund.setStatus(1);
					}
				}else{
					LogUtil.writeErrorLog("验证签名失败");
					//TODO 检查验证签名失败的原因
					
				}
			}else{
				//未返回正确的http状态
				LogUtil.writeErrorLog("未获取到返回报文或返回http状态码非200");
			}
		return refund;
	}

	@Override
	public String getPluginId() {
		return "unPay";
	}

	@Override
	public String getPluginName() {
		return "中国银联支付";
	}

	@Override
	public List<ConfigItem> definitionConfigItem() {
		List<ConfigItem> list = new ArrayList<>();
		ConfigItem seller_merIdItem = new ConfigItem();
		seller_merIdItem.setName("merId");
		seller_merIdItem.setText("中国银联商户代码");
		ConfigItem seller_signCertItem = new ConfigItem();
		seller_signCertItem.setName("signCert");
		seller_signCertItem.setText("签名证书路径");
		ConfigItem seller_pwdItem = new ConfigItem();
		seller_pwdItem.setName("pwd");
		seller_pwdItem.setText("签名证书密码");
		ConfigItem seller_validateCertItem = new ConfigItem();
		seller_validateCertItem.setName("validateCert");
		seller_validateCertItem.setText("验证签名证书目录");
		ConfigItem seller_encryptCertItem = new ConfigItem();
		seller_encryptCertItem.setName("encryptCert");
		seller_encryptCertItem.setText("敏感信息加密证书路径");
		list.add(seller_merIdItem);
		list.add(seller_signCertItem);
		list.add(seller_pwdItem);
		list.add(seller_validateCertItem);
		list.add(seller_encryptCertItem);
		return list;
	}

	@Override
	public Integer getIsRetrace() {
		return 0;
	}
	
	
}
