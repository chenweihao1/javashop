package com.enation.app.shop.front.api.order;

import com.enation.app.shop.core.order.model.OrderType;
import com.enation.app.shop.core.payment.model.enums.ClientType;
import com.enation.app.shop.core.payment.service.IOrderPayManager;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import com.enation.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;


/**
 * 支付api
 * @author kingapex
 * 2013-9-4下午7:21:31
 * @author Sylow
 * @version v2.0,2016年2月20日
 * @since v6.0
 */
@Controller
@RequestMapping("/api/shop/order-pay")
public class OrderPayController {

    @Autowired
    private IOrderPayManager orderPayManager;


    /**
     * 对订单发起支付
     * @param order_sn
     * @param payment_method_id
     * @param pay_mode      normal：跳转第三方支付平台 , qr：二维码
     * @param client_type
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/order/{order_sn}", produces = MediaType.TEXT_HTML_VALUE,method= RequestMethod.GET)
    public String payOrder(@PathVariable String order_sn, Integer payment_method_id, String pay_mode, String client_type){
        //默认值为normal
        if( StringUtil.isEmpty( pay_mode) ){
            pay_mode = "normal";
        }
        if( StringUtil.isEmpty(client_type) ){
            client_type = ClientType.PC.name();
        }

        String html = orderPayManager.payOrder(order_sn, payment_method_id, pay_mode,client_type);
        return html;
    }


    /**
     * 接收支付同步回调，get请求
     * @param tradetype     交易类型:目前只有 order 类型
     * @param payment_plugin_id 支付方式插件id
     * @param paymode   支付形式
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/return/{tradetype}/{paymode}/{payment_plugin_id}", produces = MediaType.TEXT_HTML_VALUE,method=RequestMethod.GET)
    public String payReturn( @PathVariable  String tradetype,@PathVariable String payment_plugin_id, @PathVariable String paymode){

        OrderType type = OrderType.valueOf(tradetype);
        String out_trade_no = this.orderPayManager.payReturn(type.name(),payment_plugin_id);

        String jump_html ="<script>";
        //扫码支付
        if("qr".equals(paymode)){
            jump_html+="window.parent.location.href='"+getPay_success_url(tradetype,out_trade_no) +"'" ;
        }else{
            jump_html+="location.href='"+getPay_success_url(tradetype,out_trade_no) +"'" ;
        }
        jump_html+="</script>";
        return jump_html;
    }

    /**
     * 接收支付同步回调,post请求
     * @param tradetype
     * @param payment_plugin_id
     * @param paymode
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/return/{tradetype}/{paymode}/{payment_plugin_id}", produces = MediaType.TEXT_HTML_VALUE,method=RequestMethod.POST)
    public String payPostReturn(@PathVariable  String tradetype,@PathVariable String payment_plugin_id, @PathVariable String paymode){

        OrderType type = OrderType.valueOf(tradetype);
        String out_trade_no = this.orderPayManager.payReturn(type.name(),payment_plugin_id);

        String jump_html ="<script>";
        //扫码支付
        if("qr".equals(paymode)){
            jump_html+="window.parent.location.href='"+getPay_success_url(tradetype,out_trade_no) +"'";
        }else{
            jump_html+="location.href='"+getPay_success_url(tradetype,out_trade_no) +"'" ;
        }

        jump_html+="</script>";

        return jump_html;
    }


    @ResponseBody
    @RequestMapping(value="/callback/{tradetype}/{pluginid}", produces = MediaType.TEXT_HTML_VALUE,method=RequestMethod.POST)
    public String payCallback(@PathVariable String tradetype,@PathVariable String pluginid){
        OrderType type = OrderType.valueOf(tradetype);
        String result  = this.orderPayManager.payCallback(type.name(),pluginid);
        return result;
    }


    /**
     * 获取支付成功调取页面
     * @param tradetype
     * @return
     */
    private String getPay_success_url(String tradetype,String out_trade_no) {

        HttpServletRequest request  =  ThreadContextHolder.getHttpRequest();
        String serverName =request.getServerName();
        int port =request.getServerPort();
        String portstr = "";
        if(port!=80){
            portstr = ":"+port;
        }
        String contextPath = request.getContextPath();
        boolean getType =orderPayManager.getType(out_trade_no);
        if(getType){
            return "http://"+serverName+portstr+contextPath+"/"+tradetype+"_"+out_trade_no+"_paymentac-result.html" ;

        }
        return "http://"+serverName+portstr+contextPath+"/"+tradetype+"_"+out_trade_no+"_payment-result.html" ;
    }



}
