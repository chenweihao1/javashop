package com.enation.app.shop.core.payment.controller.backend;

import com.enation.app.shop.core.payment.model.vo.PaymentPluginVo;
import com.enation.app.shop.core.payment.service.IPaymentMethodManager;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.util.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Api(description="支付方式controller")
@RestController
@RequestMapping("/order-pay/admin/payment")
@Validated
public class PaymentMethodController{

	@Autowired
	private IPaymentMethodManager paymentMethodManager;
	
	
	//@ApiOperation("后台获取所有支付方式插件")
	@RequestMapping("/list-json")
	public GridJsonResult listJson(){
		
		return JsonResultUtil.getGridJson(paymentMethodManager.getAllPlugins());
	}
	
	
	//@ApiOperation("后台保存支付方式")
	@RequestMapping("/save")
	public PaymentPluginVo save(@RequestBody PaymentPluginVo vo){
		paymentMethodManager.save(vo);
		
		return vo;
	}
	
}
