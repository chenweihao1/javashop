package com.enation.app.shop.component.payment.plugin.alipay.direct.executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.enation.app.shop.component.payment.PaymentUtil;
import com.enation.app.shop.core.order.model.PaymentResult;
import com.enation.app.shop.component.payment.plugin.alipay.JavashopAlipayUtil;
import com.enation.app.shop.component.payment.plugin.alipay.direct.AlipayPluginConfig;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayClient;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.DefaultAlipayClient;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain.AlipayTradeAppPayModel;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.request.AlipayTradeAppPayRequest;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.response.AlipayTradeAppPayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.config.AlipayConfig;
import com.enation.app.shop.component.payment.plugin.alipay.util.SignUtils;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.eop.resource.model.EopSite;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import com.enation.framework.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * 支付宝app支付执行者
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年10月11日 下午4:22:50
 */
@Service
public class AlipayAppPaymentExecutor extends AlipayPluginConfig{
 
	
	/**
	 * 支付
	 * @param bill
	 * @return
	 */
	public String onPay(PayBill bill) {
		try {
			super.setConfig();
			
			AlipayConfig.notify_url = this.getCallBackUrl(bill.getOrdertype());
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			//设置请求参数
			AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
			alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
			
			// 商户网站订单
			String out_trade_no = bill.getTrade_sn();
			double payMoney = bill.getOrder_price();
	
			// 付款金额
			String sitename = EopSite.getInstance().getSitename();
			// 订单名称
			String subject = sitename + "订单";
			
			String body = "";
			
			AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
			model.setBody(body);
			model.setSubject(subject);
			model.setOutTradeNo(out_trade_no);
			model.setTimeoutExpress("30m");
			model.setTotalAmount(payMoney+"");
			model.setProductCode("QUICK_MSECURITY_PAY");
			alipayRequest.setBizModel(model);
			
			//这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(alipayRequest);
			
			return response.getBody();
	   
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 同步支付回调
	 * @param ordertype
	 */
	public String onReturn(String ordertype) {

		try {
			Map<String, String> cfgparams = this.getConfig();

			AlipayConfig.alipay_public_key = cfgparams.get("alipay_public_key");

			HttpServletRequest request = ThreadContextHolder.getHttpRequest();

			// 交易号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 支付宝交易号WAIT_BUYER_PAY	交易创建，等待买家付款 TRADE_CLOSED	未付款交易超时关闭，或支付完成后全额退款 TRADE_SUCCESS	交易支付成功 TRADE_FINISHED	交易结束，不可退款
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 付款金额
			String total_amount = request.getParameter("total_amount");

			if (JavashopAlipayUtil.verify()) {// 验证成功
				//新版本同步没有交易状态
				double payprice = StringUtil.toDouble(total_amount, 0d);
				PaymentResult paymentResult = new PaymentResult();
				paymentResult.setOrdersn(out_trade_no);
				paymentResult.setPay_order_no(trade_no);
				paymentResult.setOrderType(ordertype);
				paymentResult.setPay_price(payprice);
				this.paySuccess(paymentResult);

				//////////////////////////////////////////////////////////////////////////////////////////
			} else {

				throw new RuntimeException("验证失败");

			}
			
			return out_trade_no;
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("验证发生异常", e);
			}
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 异步回调
	 * @param ordertype
	 * @return
	 */
	public String onCallback(String ordertype) {
		try {

			Map<String, String> cfgparams = this.getConfig();

			AlipayConfig.alipay_public_key = cfgparams.get("alipay_public_key");

			HttpServletRequest request = ThreadContextHolder.getHttpRequest();

			// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			// 商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

			// 付款金额
			String total_amount = request.getParameter("total_amount");

			if (JavashopAlipayUtil.verify()) {// 验证成功
				//////////////////////////////////////////////////////////////////////////////////////////
				// 请在这里加上商户的业务逻辑程序代码

				// ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

				if (trade_status.equals("TRADE_FINISHED")) {
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序

					// 注意：
					// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
				} else if (trade_status.equals("TRADE_SUCCESS")) {
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序

					// 注意：
					// 付款完成后，支付宝系统发送该交易状态通知
				}

				// ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

				double payprice = StringUtil.toDouble(total_amount, 0d);

				PaymentResult paymentResult = new PaymentResult();
				paymentResult.setOrdersn(out_trade_no);
				paymentResult.setPay_order_no(trade_no);
				paymentResult.setOrderType(ordertype);
				paymentResult.setPay_price(payprice);

				this.paySuccess(paymentResult);
				return ("success"); // 请不要修改或删除

				//////////////////////////////////////////////////////////////////////////////////////////
			} else {// 验证失败
				return ("fail");
			}
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("验证发生异常", e);
			}
			return ("fail");
		}
	}

	private String getReturn( PayBill bill){
		String tradeType = bill.getOrdertype();
		String payMode = bill.getPay_mode();
		
		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		String serverName =request.getServerName();
		int port = request.getServerPort();
		String portstr = "";
		if(port!=80){
			portstr = ":"+port;
		}
		String contextPath = request.getContextPath();
		
		return "http://"+serverName+portstr+contextPath+"/order-pay/return/" +tradeType+"/"+payMode+"/" + this.getPluginId()+".do";
	}

	
	
}
