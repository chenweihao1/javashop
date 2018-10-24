package com.enation.app.shop.component.payment.plugin.abcpay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.enation.app.shop.core.order.model.Refund;
import com.enation.app.shop.core.order.model.RefundBill;
import org.springframework.stereotype.Component;

import com.enation.app.base.core.model.ConfigItem;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.payment.service.AbstractPaymentPlugin;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;
import com.enation.framework.context.webcontext.ThreadContextHolder;

@Component
public class AbcpayPlugin extends AbstractPaymentPlugin implements IPaymentPlugin {

	@Override
	public String onPay(PayBill bill) {
		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		
		String callBackUrl = this.getCallBackUrl(bill.getOrdertype());
		
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		//	生成订单对象
		com.hitrust.trustpay.client.b2c.Order tOrder = new com.hitrust.trustpay.client.b2c.Order();
		tOrder.setOrderNo(bill.getTrade_sn());		// 设定订单编号 （必要信息）
		tOrder.setExpiredDate(30); // 设定订单有效期（必要信息）
		tOrder.setOrderDesc(""); // 设定订单说明
		tOrder.setOrderDate(date.format(today)); // 设定订单日期 （必要信息 - YYYY/MM/DD）
		tOrder.setOrderTime(time.format(today)); // 设定订单时间 （必要信息 - HH:MM:SS）
		tOrder.setOrderAmount(bill.getOrder_price()); // 设定订单金额 （必要信息）
		tOrder.setOrderURL(this.getShowUrl(bill)); // 设定订单网址
		tOrder.setBuyIP(request.getRemoteAddr()); // 设定订单IP

		//	生成定单订单对象，并将订单明细加入定单中（可选信息）
		//tOrder.addOrderItem(new com.hitrust.trustpay.client.b2c.OrderItem("IP000001", "中国移动IP卡", 100.00f, 1));
		//tOrder.addOrderItem(new com.hitrust.trustpay.client.b2c.OrderItem("IP000002", "网通IP卡", 90.00f, 2));
		
		//	生成支付请求对象
		com.hitrust.trustpay.client.b2c.PaymentRequest tPaymentRequest = new com.hitrust.trustpay.client.b2c.PaymentRequest();
		tPaymentRequest.setOrder(tOrder); // 设定支付请求的订单 （必要信息）
		tPaymentRequest.setProductType("2"); // 设定商品种类 （必要信息）
                                             //	PaymentRequest.PRD_TYPE_ONE：非实体商品，如服务、IP卡、下载MP3、...
                                             //	PaymentRequest.PRD_TYPE_TWO：实体商品
		tPaymentRequest.setPaymentType("1"); //	设定支付类型
		                                     //	PaymentRequest.PAY_TYPE_ABC：农行卡支付
		                                     //	PaymentRequest.PAY_TYPE_INT：国际卡支付
		tPaymentRequest.setNotifyType("0");  //	设定商户通知方式
											 //	0：URL页面通知
		                                     //	1：服务器通知
		tPaymentRequest.setResultNotifyURL(callBackUrl); //设定支付结果回传网址 （必要信息）
		tPaymentRequest.setMerchantRemarks("Javashop abcpayPlugIn"); //设定商户备注信息
		tPaymentRequest.setPaymentLinkType("1");//设定支付接入方式
		
		//	传送支付请求并取得支付网址
		com.hitrust.trustpay.client.TrxResponse tTrxResponse = tPaymentRequest.extendPostRequest(1);
		if (tTrxResponse.isSuccess()) {
			// 支付请求提交成功，将客户端导向支付页面
			return "<h2>正在转向中国农业银行网上支付页面，请稍后...</h2><script>location.href='" + tTrxResponse.getValue("PaymentURL") + "';</script>";
		} else {
			// 支付请求提交失败，商户自定后续动作
			return "ReturnCode = [" + tTrxResponse.getReturnCode() + "]<br>" + "ErrorMessage = [" + tTrxResponse.getErrorMessage() + "]<br>";
		}
	}

	@Override
	public String onReturn(String ordertype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String onCallback(String ordertype) {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	public boolean returnPay(RefundBill bill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Refund queryRefundStatus(Refund refund) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPluginName() {
		return "中国农业银行网上支付";
	}

	@Override
	public List<ConfigItem> definitionConfigItem() {
		List<ConfigItem> list = new ArrayList<>();
		return list;
	}

	@Override
	public Integer getIsRetrace() {
		return 0;
	}

	@Override
	public String getPluginId() {
		return "abcpayPlugin";
	}


}
