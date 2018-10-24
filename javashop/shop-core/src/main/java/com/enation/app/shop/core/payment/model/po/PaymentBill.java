package com.enation.app.shop.core.payment.model.po;

import java.io.Serializable;

import com.enation.framework.database.PrimaryKeyField;

/**
 * 支付流水表
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年8月30日 上午11:12:31
 */
public class PaymentBill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8743028542597042408L;
	
	private Integer id;

	/**  交易或订单的编号 **/
	private String sn;

	/**  提交给第三方平台的单号 **/
	private String pay_key;

	/**  第三方平台返回的交易号 **/
	private String pay_order_no;
	
	private Integer is_pay;

	@PrimaryKeyField
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getPay_key() {
		return pay_key;
	}

	public void setPay_key(String pay_key) {
		this.pay_key = pay_key;
	}

	public String getPay_order_no() {
		return pay_order_no;
	}

	public void setPay_order_no(String pay_order_no) {
		this.pay_order_no = pay_order_no;
	}

	public Integer getIs_pay() {
		return is_pay;
	}

	public void setIs_pay(Integer is_pay) {
		this.is_pay = is_pay;
	}
	
	
}
