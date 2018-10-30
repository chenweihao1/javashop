package com.enation.app.shop.core.payment.service.impl;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.enation.app.base.core.model.Member;
import com.enation.app.base.core.service.IMemberManager;
import com.enation.app.shop.core.order.model.Order;
import com.enation.app.shop.core.order.service.IOrderFlowManager;
import com.enation.app.shop.core.order.service.IOrderManager;
import com.enation.app.shop.core.order.service.OrderStatus;
import com.enation.app.shop.core.payment.service.IOrderPayManager;
import com.enation.eop.sdk.context.UserConext;
import com.enation.framework.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enation.app.shop.core.payment.model.po.PaymentBill;
import com.enation.app.shop.core.payment.model.vo.OrderPayReturnParam;
import com.enation.app.shop.core.payment.service.IPaymentBillManager;
import com.enation.framework.database.IDaoSupport;

/**
 * 支付流水manager
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年8月30日 上午11:15:58
 */
@Service
public class PaymentBillManager implements IPaymentBillManager {

	@Autowired
	private IDaoSupport daoSupport;

	@Autowired
	private IOrderPayManager orderPayManager;

	@Autowired
	private IMemberManager memberManager;

	@Autowired
	private IOrderFlowManager orderFlowManager;

	@Autowired
	private IOrderManager orderManager;

	@Override
	public PaymentBill add(PaymentBill paymentStream) {

		this.daoSupport.insert("es_payment_bill", paymentStream);

		return paymentStream;
	}

	@Override
	public PaymentBill getByPayKey(String pay_key) {

		String sql = "select * from es_payment_bill where pay_key = ? ";

		return this.daoSupport.queryForObject(sql, PaymentBill.class, pay_key);
	}

	@Override
	public void update(PaymentBill paymentStream) {

		this.daoSupport.update("es_payment_bill", paymentStream, "id="+paymentStream.getId());
	}

	@Override
	public PaymentBill getBySn(String sn) {

		String sql = "select * from es_payment_bill where sn = ? order by id desc limit 0,1";

		return this.daoSupport.queryForObject(sql, PaymentBill.class, sn);
	}

	@Override
	public void Pay(OrderPayReturnParam orderPayReturnParam) {

		PaymentBill bill = this.getByPayKey(orderPayReturnParam.getPay_key());
		/** 更新流水中的动态 */
		bill.setPay_order_no(orderPayReturnParam.getPay_order_no());
		bill.setIs_pay(1);
		this.update(bill);

		Order order = this.orderManager.get(bill.getSn());
		//对订单进行支付
		this.orderFlowManager.payConfirm(order.getOrder_id());

		/** 对交易支付 */
//		if(orderPayReturnParam.getTrade().equals("trade")){
//			List<Order> orderList = this.orderQueryManager.queryByTradeSnGetOrder(bill.getSn());
//			if(orderList.size()>0){
//			for (int i = 0; i < orderList.size(); i++) {
//				orderOperateManager.payOrder(orderList.get(i).getSn(), orderList.get(i).getOrder_price(), OrderPermission.client);
//				//修改订单交易号
//				String sql = "update es_order set pay_order_no = ? where trade_sn = ? ";
//				this.daoSupport.execute(sql,bill.getPay_order_no(), bill.getSn());
//			}
//			return;
//			}else{
//				/** 充值记录 */
//				RechargePo  rechargePoNew = this.rechargeQueryManager.getOneBySn(bill.getSn());
//				if(rechargePoNew!=null){
//					long rc_time = DateUtil.getDateline();
//					String sql = "update es_order_recharge set rc_state = ?,rc_time = ? where recharge_id=? ";
//					this.daoSupport.execute(sql, "1",rc_time,rechargePoNew.getRecharge_id());
//					/** 修改交易状态*/
//					this.daoSupport.execute("update es_trade set trade_status = ? where trade_sn =?", OrderStatus.PAID_OFF.name(),bill.getSn() );
//					/** 账户充值*/
//					memberManager.updateMemberAdd(rechargePoNew.getRc_memId(),orderPayReturnParam.getPayprice());
//					return;
//				}
//			}
//		}
//		String sql = "update es_order set pay_order_no = ? where sn = ? ";
//		this.daoSupport.execute(sql,bill.getPay_order_no(), bill.getSn());
//		/**对订单支付 */
//		OrderDetail order = this.orderQueryManager.getOneBySn(bill.getSn());
//		/**账户支付订单记录 */
//		orderOperateManager.payOrder(order.getSn(), orderPayReturnParam.getPayprice(), OrderPermission.client);
	}
}
