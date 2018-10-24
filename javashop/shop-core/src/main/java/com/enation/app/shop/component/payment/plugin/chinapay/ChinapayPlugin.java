package com.enation.app.shop.component.payment.plugin.chinapay;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import com.chinapay.secss.SecssUtil;
import com.enation.app.shop.core.order.model.PaymentResult;
import com.enation.app.shop.core.order.model.Refund;
import com.enation.app.shop.core.order.model.RefundBill;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.payment.service.AbstractPaymentPlugin;
import com.enation.app.shop.core.payment.service.IPaymentMethodManager;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.enation.app.base.core.model.ConfigItem;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import com.enation.framework.util.CurrencyUtil;
import com.enation.framework.util.StringUtil;

@Component("chinaPay")
@Order(3)
public class ChinapayPlugin extends AbstractPaymentPlugin implements IPaymentPlugin {
	
	@Autowired
	private IPaymentMethodManager paymentMethodManager;
	
	/**
	 * 生成自动提交表单
	 * @param actionUrl
	 * @param paramMap
	 * @return
	 */
	private String generateAutoSubmitForm(String actionUrl, Map<String, String> paramMap) {
		StringBuilder html = new StringBuilder();
		html.append("<script language=\"javascript\">window.onload=function(){document.pay_form.submit();}</script>\n");
		html.append("<form id=\"pay_form\" name=\"pay_form\" action=\"").append(actionUrl).append("\" method=\"post\">\n");

		for (String key : paramMap.keySet()) {
			html.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + paramMap.get(key) + "\">\n");
		}
		html.append("</form>\n");
		return html.toString();
	}
	
	protected String payBack(String ordertype) {
		Map<String, String> config = this.getConfig();
		String merPath = config.get("merPath");

		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		String merId = request.getParameter("merid");
		String orderno = request.getParameter("orderno");
		String transdate = request.getParameter("transdate");
		String amount = request.getParameter("amount");
		String currencycode = request.getParameter("currencycode");
		String transtype = request.getParameter("transtype");
		String status = request.getParameter("status");
		String checkvalue = request.getParameter("checkvalue");
		String Priv1 = request.getParameter("Priv1");

		chinapay.PrivateKey key = new chinapay.PrivateKey();
		chinapay.SecureLink t;
		boolean flag = key.buildKey(merId, 0, merPath);
		if (flag == false) {
			//System.out.println("build key error!");
			return "<div>系统设置错误</div>";
		}
		t = new chinapay.SecureLink(key);
		flag = t.verifyTransResponse(merId, orderno, amount, currencycode,
				transdate, transtype, status, checkvalue); // ChkValue为ChinaPay应答传回的域段
		if (flag == false) {
			// 签名验证错误处理
		}

		// 对一段字符串的签名验证
		String MsgBody = merId + orderno +  amount + currencycode + transdate + transtype + Priv1;
		flag = t.verifyAuthToken(MsgBody, checkvalue); // ChkValue2为ChinaPay应答传回的域段
		String ordersn = orderno.substring(2);
		if (flag) {
			// 签名验证错误处理
		} else {
			double payprice = StringUtil.toDouble(Priv1, 0d);
			PaymentResult paymentResult = new PaymentResult();
			paymentResult.setOrdersn(orderno);
			paymentResult.setPay_order_no(currencycode);
			paymentResult.setPay_price(payprice);
			paymentResult.setOrderType(ordertype);
			this.paySuccess(paymentResult);
		}

		return "";
	}
	

	@Override
	public String onPay(PayBill bill) {
		Map<String, String> config = this.getConfig();
		String merId = config.get("merId");
		String merPath = config.get("merchant_private_key");
		String payUrl = config.get("payUrl");

		Map<String,String> param = new TreeMap<String,String>();
		SecssUtil secssUtil = getSecssUtil(merPath);
		// 签名
		param.put("Version", "20140728");
		param.put("MerId", merId);
		param.put("MerOrderNo", bill.getTrade_sn());
		String TransDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
		param.put("TranDate", TransDate);
		String TranTime = new SimpleDateFormat("hhmmss").format(new Date());
		param.put("TranTime", TranTime);
		Double txnAmt = CurrencyUtil.mul(bill.getOrder_price(), 100);
		param.put("OrderAmt", ""+txnAmt.intValue());
		param.put("BusiType", "0001");
		param.put("MerPageUrl", this.getReturnUrl(bill));
		param.put("MerBgUrl", this.getCallBackUrl(bill.getOrdertype()));
		param.put("RemoteAddr", "127.0.0.1");
		// 签名
        secssUtil.sign(param);
        param.put("Signature", secssUtil.getSign());
		
		System.out.println(String.format("sendMap = %s", param));
		
		String html = "<div style='margin:50px auto;width:500px'>正在跳转到银联在线支付平台，请稍等...</div>";
		html = html + generateAutoSubmitForm(payUrl,param);//跳转到银联页面支付
		
		return html;
	}

	@Override
	public String onReturn(String ordertype) {
		
		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		String queryId = request.getParameter("AcqSeqId");
		String tradeno = request.getParameter("MerOrderNo");	//商户订单号
		String settleAmt = request.getParameter("OrderAmt");	//交易金额
		String orderStatus = request.getParameter("OrderStatus");	//订单支付状态  0000 为支付成功状态，0001 为未支付
		double payprice = StringUtil.toDouble(settleAmt, 0d);
		// 传回来的是分，转为元
		payprice = CurrencyUtil.mul(payprice, 0.01);
		
		if("0000".equals(orderStatus)){
			PaymentResult paymentResult = new PaymentResult();
			paymentResult.setOrdersn(tradeno);
			paymentResult.setPay_order_no(queryId);
			paymentResult.setOrderType(ordertype);
			paymentResult.setPay_price(payprice);
			this.paySuccess(paymentResult);
			return tradeno;
		}
		
		return null;
	}

	@Override
	public String onCallback(String ordertype) {
		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		String queryId = request.getParameter("AcqSeqId");
		String tradeno = request.getParameter("MerOrderNo");	//商户订单号
		String settleAmt = request.getParameter("OrderAmt");	//交易金额
		String orderStatus = request.getParameter("OrderStatus");	//订单支付状态  0000 为支付成功状态，0001 为未支付
		double payprice = StringUtil.toDouble(settleAmt, 0d);
		// 传回来的是分，转为元
		payprice = CurrencyUtil.mul(payprice, 0.01);
		
		if("0000".equals(orderStatus)){
			PaymentResult paymentResult = new PaymentResult();
			paymentResult.setOrdersn(tradeno);
			paymentResult.setPay_order_no(queryId);
			paymentResult.setOrderType(ordertype);
			paymentResult.setPay_price(payprice);
			this.paySuccess(paymentResult);
			return tradeno;
		}
		
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
	public String getPluginId() {
		return "chinaPay";
	}

	@Override
	public String getPluginName() {
		return "银联在线支付";
	}

	@Override
	public List<ConfigItem> definitionConfigItem() {
		List<ConfigItem> list = new ArrayList<>();
		ConfigItem seller_merIdItem = new ConfigItem();
		seller_merIdItem.setName("merId");
		seller_merIdItem.setText("商户代码");
		ConfigItem seller_payUrlItem = new ConfigItem();
		seller_payUrlItem.setName("payUrl");
		seller_payUrlItem.setText("支付接口地址");
		ConfigItem seller_merPathItem = new ConfigItem();
		seller_merPathItem.setName("merchant_private_key");
		seller_merPathItem.setText("配置文件security.properties存放位置");
		list.add(seller_merIdItem);
		list.add(seller_payUrlItem);
		list.add(seller_merPathItem);
		return list;
	}

	@Override
	public Integer getIsRetrace() {
		return 0;
	}
	
	/**
     * 加载安全秘钥 .
     * 
     * @param ownerId
     *            所有者id
     * @return SecssUtil .
     */
    protected SecssUtil getSecssUtil(String ownerId) {
        SecssUtil secssUtil = new SecssUtil();
        secssUtil.init("C:/Users/javashop/Desktop/chinapay/security.properties");
        return secssUtil;
    }

}
