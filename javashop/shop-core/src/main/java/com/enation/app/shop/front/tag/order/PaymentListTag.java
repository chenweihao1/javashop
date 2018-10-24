package com.enation.app.shop.front.tag.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enation.app.shop.core.payment.model.enums.ClientType;
import com.enation.app.shop.core.payment.model.vo.PaymentMethodVo;
import com.enation.app.shop.core.payment.service.IPaymentMethodManager;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.enation.app.shop.core.order.service.IPaymentManager;
import com.enation.framework.taglib.BaseFreeMarkerTag;

import freemarker.template.TemplateModelException;

import javax.servlet.http.HttpServletRequest;

/**
 * 读取支付方式
 * 付款台页面读取所有支付方式
 * @author xulipeng
 * 2016年08月03日
 */
@Component
@Scope("prototype")
public class PaymentListTag extends BaseFreeMarkerTag {

	@Autowired
	private IPaymentMethodManager paymentMethodManager;
	
	
	@Override
	protected Object exec(Map params) throws TemplateModelException {
		String client_type = (String) params.get("client_type");
		List<PaymentMethodVo> list = this.paymentMethodManager.list(ClientType.valueOf(client_type));
		//微信浏览器，去掉支付宝支付
		HttpServletRequest request = ThreadContextHolder.getHttpRequest();
		String ua = request.getHeader("user-agent").toLowerCase();
		if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
			List<PaymentMethodVo> res = new ArrayList<>();
			for(PaymentMethodVo method:list ){
				if(!method.getPlugin_id().equals("alipayDirectPlugin")){
					res.add(method);
				}
			}
			return res;
		}

		return list;
	}

}
