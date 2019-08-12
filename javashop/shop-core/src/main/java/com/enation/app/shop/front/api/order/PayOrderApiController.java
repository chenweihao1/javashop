package com.enation.app.shop.front.api.order;


import com.enation.app.base.core.model.Member;
import com.enation.app.base.core.service.IMemberManager;
import com.enation.app.shop.core.goods.model.Product;
import com.enation.app.shop.core.goods.service.IProductManager;
import com.enation.app.shop.core.member.model.MemberAddress;
import com.enation.app.shop.core.member.service.IMemberAddressManager;
import com.enation.app.shop.core.order.model.OrderType;
import com.enation.app.shop.core.order.model.PayCfg;
import com.enation.app.shop.core.order.model.Transaction;
import com.enation.app.shop.core.order.model.support.CartItem;
import com.enation.app.shop.core.order.model.support.OrderPrice;
import com.enation.app.shop.core.order.plugin.cart.CartPluginBundle;
import com.enation.app.shop.core.order.service.*;
import com.enation.app.shop.core.payment.model.enums.ClientType;
import com.enation.app.shop.core.payment.model.vo.PayBill;
import com.enation.app.shop.core.payment.service.IPaymentPlugin;
import com.enation.app.shop.front.api.order.enums.PayStatusEnum;
import com.enation.app.shop.front.api.order.enums.RespCodeEnum;
import com.enation.app.shop.front.api.order.exception.ParamsIsNullException;
import com.enation.app.shop.front.api.order.model.OrderPay;
import com.enation.app.shop.front.api.order.model.ResultModel;
import com.enation.app.shop.core.order.model.Order;
import com.enation.app.shop.front.api.order.publicmethod.CartPublicMethod;
import com.enation.framework.action.JsonResult;
import com.enation.framework.context.spring.SpringContextHolder;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import com.enation.framework.database.IDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/api/shop/pay")
public class PayOrderApiController {

    private static Logger logger = LoggerFactory.getLogger(PayOrderApiController.class);

    @Autowired
    private IMemberManager memberManager;
    @Autowired
    private IOrderFlowManager orderFlowManager;
    @Autowired
    private IMemberAddressManager memberAddressManager;
    @Autowired
    private ICartManager cartManager;
    @Autowired
    private CartPluginBundle cartPluginBundle;
    @Autowired
    private IProductManager productManager;
    @Autowired
    private CartPublicMethod cartPublicMethod;
    @Autowired
    private IPaymentManager paymentManager;
    @Autowired
    private IOrderManager orderManager;
    @Autowired
    private IDaoSupport daoSupport;
    @Autowired
    private ITradingManager tradingManager;


    @ResponseBody
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public ResultModel payOrder(OrderPay orderPay){
        this.checkParams(orderPay);
        //查找会员
        Member member = memberManager.getMemberById(orderPay.getMemberId());
        if(member == null ){
            return ResultModel.fail("无用户信息");
        }
        //添加商品到购物车
        Product product = productManager.getByGoodsId(orderPay.getGoodsId());
        JsonResult result = cartPublicMethod.addCart(product, orderPay.getGoodsNum(),
        orderPay.getShowCartData(), orderPay.getActivityId());
        if(result.getResult()!=1){
            return ResultModel.fail("订单创建失败");
        }
        //创建订单
        Order order = this.PayOrder(orderPay,member);
        //创建交易记录
        createOrderLog(orderPay,order.getSn());
        //进行订单结算
        String payhtml = execute(order,orderPay.getReturnUrl(),product.getName());
        return ResultModel.success(payhtml);
    }


    private void createOrderLog(OrderPay orderPay,String sn){
        Transaction order = new Transaction();
        order.setThirdOrderNum(orderPay.getOrderNum());
        order.setStatus(PayStatusEnum.UNPAID.getCode());
        order.setSn(sn);
        order.setCallBackUrl(orderPay.getCallBackUrl());
        order.setReturnUrl(orderPay.getReturnUrl());
        order.setCreateTime(new Date());
        tradingManager.saveOrder(order);
    }


    /**
     * 进行支付页面跳转
     * @return
     */
    private String execute(Order order,String returnUrl,String goodsName){

        if(order==null){
            return "该订单不存在";
        }

        PayCfg payCfg = this.paymentManager.get(order.getPayment_id());

        IPaymentPlugin paymentPlugin = SpringContextHolder.getBean(payCfg.getType());
        PayBill bill = this.daoSupport.queryForObject(
                "select order_id ,sn as order_sn,order_amount as order_price ,payment_method_id,payment_plugin_id,payment_method_name " +
                        "from es_order  where order_id=?", PayBill.class, order.getOrder_id());

        if(bill==null){
            throw new RuntimeException("未找到相应的交易["+order.getOrder_id()+"]");
        }

        bill.setOrderType(OrderType.order);
        bill.setClientType(ClientType.WAP);
        bill.setReturnUrl(returnUrl);
        bill.setGoods_name(goodsName);
        String payhtml = paymentPlugin.onPay(bill);
        //String payhtml = "";
        // 用户更换了支付方式，更新订单的数据
        if (order.getPayment_id().intValue() != order.getPayment_id().intValue()) {
            this.orderManager.updatePayMethod(order.getOrder_id(), order.getPayment_id(), payCfg.getType(), payCfg.getName());
        }
        return payhtml;
    }


    /**
     * 进行订单结算
     * @param orderPay
     * @param member
     * @return
     */
    private Order PayOrder(OrderPay orderPay,Member member){
        Order order = new Order() ;
        order.setShipping_id(orderPay.getShippingId()); //配送方式
        order.setPayment_id(orderPay.getPaymentId());//支付方式

        Integer addressId = orderPay.getAddressId();

        MemberAddress address = memberAddressManager.getMemberDefault(member.getMember_id());
        order.setShip_provinceid(address.getProvince_id());
        order.setShip_cityid(address.getCity_id());
        order.setShip_regionid(address.getRegion_id());
        if(address.getTown_id()!=null&&!address.getTown_id().equals(-1)){
            order.setShip_townid(address.getTown_id());
        }
        order.setShip_addr(address.getAddr());
        order.setShip_mobile(address.getMobile());
        order.setShip_tel(address.getTel());
        order.setShip_zip(address.getZip());
        if(address.getTown_id()!=null&&!address.getTown_id().equals(-1)){
            order.setShipping_area(address.getProvince()+"-"+ address.getCity()+"-"+ address.getRegion()+"-"+address.getTown());
        }else{
            order.setShipping_area(address.getProvince()+"-"+ address.getCity()+"-"+ address.getRegion());
        }
        order.setShip_name(address.getName());
        order.setRegionid(address.getRegion_id());


        address.setAddr_id(addressId);
        order.setMemberAddress(address);
        order.setShip_day(orderPay.getShipDay());
        order.setShip_time(orderPay.getShipTime());
        order.setRemark(orderPay.getRemark());
        order.setAddress_id(address.getAddr_id());//保存本订单的会员id

        HttpServletRequest request  = ThreadContextHolder.getHttpRequest();
        String sessionid =  request.getSession().getId();
        List<CartItem> itemList  = this.cartManager.selectListGoods(sessionid);
        if(itemList==null||itemList.size()==0){
            throw new RuntimeException("购物车不能为空");
        }
        OrderPrice orderPrice =   this.cartManager.countPrice(itemList, orderPay.getShippingId(),address.getRegion_id()+"");

        //激发价格计算事件
        orderPrice  = this.cartPluginBundle.coutPrice(orderPrice);
        order.setOrderprice(orderPrice);

        return	this.orderFlowManager.add(order,itemList,sessionid);

    }


    /**
     * 参数校验
     * @param orderPay
     */
    private void checkParams(OrderPay orderPay){
        if(null==orderPay.getMemberId()){
            throw new ParamsIsNullException(RespCodeEnum.PARAM_IS_ERROR,"memberId is null");
        }
        if(null==orderPay.getGoodsId()){
            throw new ParamsIsNullException(RespCodeEnum.PARAM_IS_ERROR,"goodsId is null");
        }
        if(null==orderPay.getPaymentId()){
            throw new ParamsIsNullException(RespCodeEnum.PARAM_IS_ERROR,"paymentId s null");
        }

    }


}
