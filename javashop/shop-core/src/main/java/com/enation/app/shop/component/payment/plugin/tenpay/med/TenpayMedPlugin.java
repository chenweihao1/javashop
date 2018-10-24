package com.enation.app.shop.component.payment.plugin.tenpay.med;


import com.enation.app.shop.core.order.model.Refund;
import com.enation.app.shop.core.order.model.RefundBill;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.payment.service.AbstractPaymentPlugin;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;
import org.springframework.stereotype.Component;

import com.enation.app.base.core.model.ConfigItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 财付通(中介担保)支付插件
 * @author kingapex
 *2010-4-13下午03:48:25
 */
@Component
public class TenpayMedPlugin extends AbstractPaymentPlugin implements IPaymentPlugin {

	public String onCallBack(String ordertype) {
//		HttpServletRequest request  =  ThreadContextHolder.getHttpRequest();
//		HttpServletResponse response  = ThreadContextHolder.getHttpResponse();
//		
//		Map<String, String> params = this.getConfig();
//		//平台商密钥
//		String key =params.get("key");
//
//		//创建MediPayResponseHandler实例
//		MediPayResponseHandler resHandler = new MediPayResponseHandler(request, response);
//
//		resHandler.setKey(key);
//
//		//判断签名
//		if(resHandler.isTenpaySign()) {
//			//交易单号
//			String cft_tid = resHandler.getParameter("cft_tid");
//			
//			//金额金额,以分为单位
//			String total_fee = resHandler.getParameter("total_fee");
//			
//			//支付结果
//			String retcode = resHandler.getParameter("retcode");
//			
//			//状态码
//			String status = resHandler.getParameter("status");
//			
//			if( "0".equals(retcode) ) {
//				//------------------------------
//				//处理业务开始
//				//------------------------------ 
//				
//				//注意交易单不要重复处理
//				//注意判断返回金额
//				
//				int iStatus = TenpayUtil.toInt(status);
//				switch(iStatus) {
//					case 1:		//交易创建
//						
//						break;
//					case 2:		//收获地址填写完毕
//					
//						break;
//					case 3:		//买家付款成功，注意判断订单是否重复的逻辑
//						String orderSn =  request.getParameter("mch_vno" ) ;
//						this.paySuccess(orderSn,cft_tid,ordertype);
//						break;
//					case 4:		//卖家发货成功
//					
//						break;
//					case 5:		//买家收货确认，交易成功
//						
//						break;
//					case 6:		//交易关闭，未完成超时关闭
//					
//						break;
//					case 7:		//修改交易价格成功
//					
//						break;
//					case 8:		//买家发起退款
//					
//						break;
//					case 9:		//退款成功
//					
//						break;
//					case 10:	//退款关闭
//					
//						break;
//					default:
//						//nothing to do
//					
//				}
//				
//				//------------------------------
//				//处理业务完毕
//				//------------------------------
//					
//				//调用doShow, 打印meta值,告诉财付通处理成功.
//				 
//					String strHtml = "<html><head>\r\n" +
//					"<meta name=\"TENCENT_ONLINE_PAYMENT\" content=\"China TENCENT\">\r\n" +
//					"</head><body></body></html>";
//					return strHtml;
//		 
//			} else {
//				//当做不成功处理
//				return ("支付失败");
//			}
//			
//		} else {
//			return ("认证签名失败");
//			//String debugInfo = resHandler.getDebugInfo();
//			////System.out.println("debugInfo:" + debugInfo);
//		}
		
		return null;
	}

	public String onPay() {

//		HttpServletRequest request  =  ThreadContextHolder.getHttpRequest();
//		
//		Map<String,String> params = this.getConfigParams();
//		
//		
//		//平台商密钥
//		String key = params.get("key");
//
//		//平台商帐号
//		String chnid = params.get("chnid");
//
//		//卖家
//		String seller =params.get("chnid");
//
//		//回调通知URL
//		String mch_returl = this.getCallBackUrl(payCfg,order);
//
//		//支付显示URL
//		String show_url = this.getCallBackUrl(payCfg,order);
//
//
//		//商家订单号
//		String mch_vno = ""+order.getSn();
//
//		//创建MediPayRequestHandler实例
//		MediPayRequestHandler reqHandler = new MediPayRequestHandler(request, ThreadContextHolder.getHttpResponse());
//
//		//设置密钥
//		reqHandler.setKey(key);
//
//		//初始化
//		reqHandler.init();
//
//		//-----------------------------
//		//设置支付参数
//		//-----------------------------
//		reqHandler.setParameter("chnid", chnid);			//平台商帐号
//		reqHandler.setParameter("encode_type", "2");		//编码类型 1:gbk 2:utf-8
//		reqHandler.setParameter("mch_desc", "支付订单"+order.getSn());//交易说明
//		reqHandler.setParameter("mch_name","网站订单["+order.getSn()+"]");		//商品名称
//		reqHandler.setParameter("mch_price",formatPrice( order.getNeedPayMoney()*100 )); 			//商品总价，单位为分
//		reqHandler.setParameter("mch_returl", mch_returl); 	//回调通知URL
//		reqHandler.setParameter("mch_type", "1");			//交易类型：1、实物交易，2、虚拟交易
//		reqHandler.setParameter("mch_vno", mch_vno);		//商家的定单号
//		reqHandler.setParameter("need_buyerinfo", "2");		//是否需要在财付通填定物流信息，1：需要，2：不需要。
//		reqHandler.setParameter("seller", seller);			//卖家财付通帐号
//		reqHandler.setParameter("show_url", show_url);		//支付后的商户支付结果展示页面
//		reqHandler.setParameter("transport_desc", "");		//物流公司或物流方式说明
//		reqHandler.setParameter("transport_fee", "");		//需买方另支付的物流费用
//
//		//获取请求带参数的url
//		
//		try {
//			String requestUrl = reqHandler.getRequestURL();
//			return "<script>location.href=\""+requestUrl+"\"</script>";
//						
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//			return "财付通支付错误!";
//		}
		return null;
	}
	 

	@Override
	public String onPay(PayBill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String onReturn(String ordertype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String onCallback(String ordertypee) {
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
	public String getPluginId() {
		return "tenpayMedPlugin";
	}

	@Override
	public String getPluginName() {
		return "财付通（中介担保）";
	}

	@Override
	public List<ConfigItem> definitionConfigItem() {
		List<ConfigItem> list = new ArrayList<>();
		ConfigItem seller_chnidItem = new ConfigItem();
		seller_chnidItem.setName("chnid");
		seller_chnidItem.setText("客户号");
		ConfigItem seller_keyItem = new ConfigItem();
		seller_keyItem.setName("app_id");
		seller_keyItem.setText("应用ID");
		list.add(seller_keyItem);
		list.add(seller_chnidItem);
		return list;
	}

	@Override
	public Integer getIsRetrace() {
		return 0;
	}


	
	
}
