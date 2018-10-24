package com.enation.app.shop.core.payment.controller.backend;

import com.enation.app.shop.core.payment.service.IPaymentMethodManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//@Api(description="后台支付方式跳转api")
@Controller
@RequestMapping("/shop/admin/paymethod")
public class PaymentMethodForwordController {

	@Autowired
	private IPaymentMethodManager paymentMethodManager;

	
	/**
	 * 跳转至付款方式列表
	 * @return 付款方式列表
	 */
	@RequestMapping("/list")
	public String list(){
		return "/shop/admin/payment/payment_list";
	}
	
	/**
	 * 跳到修改界面
	 * @param plugin_id
	 * @return
	 */
	@RequestMapping("/{plugin_id}")
	public ModelAndView edit(@PathVariable String plugin_id){
		ModelAndView view= new ModelAndView();
		view.setViewName("/shop/admin/payment/payment_edit");
		view.addObject("paymentPlugin", paymentMethodManager.getByPlugin(plugin_id));
		return view;
	}
	
}
