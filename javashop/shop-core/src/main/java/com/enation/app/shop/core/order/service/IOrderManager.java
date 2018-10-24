package com.enation.app.shop.core.order.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enation.app.shop.core.order.model.Order;
import com.enation.app.shop.core.order.model.OrderItem;
import com.enation.app.shop.core.order.model.SellBackGoodsList;
import com.enation.app.shop.core.order.model.support.CartItem;
import com.enation.framework.database.ObjectNotFoundException;
import com.enation.framework.database.Page;

/**
 * 订单管理
 * 
 * @author kingapex 2010-4-6上午11:09:53
 * @author LiFenLong 2014-4-22;4.0订单流程改版
 */
public interface IOrderManager {
	/**
	 * 记录订单操作日志
	 * @author LiFenLong
	 * @param order_id 订单Id
	 * @param message 日志信息
	 * @param op_name 管理员名称
	 */
	void addLog(Integer order_id, String message,String op_name);
	
	/**
	 * 记录订单操作日志
	 * @author Kanon
	 * @param order_id 订单Id
	 * @param message 日志信息
	 */
	void addLog(Integer order_id,String message);
	
	/**
	 * 记录会员操作订单日志
	 * @author Kanon
	 * @param order_id 订单Id
	 * @param message 日志信息
	 */
	void frontAddLog(Integer order_id,String message);
	/**
	 * 修改订单价格
	 * @param price 订单总金额
	 * @param orderid
	 */
	void savePrice(double price,int orderid);
	
	/**
	 * 修改订单配送费用
	 * @param shipmoney
	 * @param orderid
	 * @return
	 */
	double saveShipmoney(double shipmoney, int orderid);
	
	
	boolean saveAddrDetail(String addr, int orderid);
	
	
	boolean saveShipInfo(String remark,String ship_day,String ship_name,String ship_tel,String ship_mobile,String ship_zip, int orderid);//修改收货人信息
	
	/**
	 * 拒绝退货
	 */
	void refuseReturn(String orderSn);
	
	
	/**
	 * 修改订单信息
	 * @param order
	 */
	void edit(Order order);

	/**
	 * 分页读取订单列表
	 * 
	 * @param page
	 *            页数
	 * @param pageSize
	 *            每页显示数量
	 * @param disabled
	 *            是否读回收站列表(1为读取回收站列表,0为读取正常订单列表)
	 * @param order
	 *            排序值
	 * @return 订单分页列表对象
	 */
	Page list(int page, int pageSize, int disabled,  String order);
	/**
	 * 分页读取订单列表
	 * @param page页数
	 * @param pageSize 每页显示数量
	 * @param status 订单状态
	 * @param depotid 仓库标识
	 * @param order  排序值
	 * @return 订单分页列表对象
	 */
	Page list(int page,int pageSize,int status,int depotid,String order);

	/**
	 * 查询确认付款订单
	 * @param pageNo
	 * @param pageSize
	 * @param order
	 * @return
	 */
	Page listConfirmPay(int pageNo,int pageSize,String sort,String order);
	/**
	 * 根据订单id获取订单详细
	 * 
	 * @param orderId
	 *            订单id
	 * @return 订单实体 对象
	 * @throws ObjectNotFoundException
	 *             当订单不存在时
	 */
	Order get(Integer orderId);

	
	

	
	/**
	 * 查询上一订单或者下一订单
	 * @param orderId
	 * @return
	 */
	Order getNext(String next,Integer orderId,Integer status,int disabled, String sn,
			String logi_no, String uname, String ship_name);
	
	/**
	 * 根据订单号获取订单
	 * @param ordersn
	 * @return
	 */
	Order get(String ordersn);
	
	
	
	/**
	 * 读取某个订单的商品货物列表
	 * 
	 * @param orderId
	 *            订单id
	 * @return list中为map，对应order_items表
	 */
	List<OrderItem> listGoodsItems(Integer orderId);

	/**
	 * 读取某个订单的商品货物列表(包含es_goods表信息)
	 * 
	 * @param orderId
	 *            订单id
	 * @return list中为map，对应order_items表
	 */
	List getOrderItem(int order_id);
	
 
	
	
	
	/**
	 * 读取某订单的订单日志
	 * 
	 * @param orderId
	 * @return lisgt中为map ，对应order_log表
	 */
	List listLogs(Integer orderId);

	/**
	 * 批量将某些订单放入回收站<br>
	 * 
	 * @param orderId
	 *            要删除的订单Id数组
	 */
	boolean delete(Integer[] orderId);

	/**
	 * 彻底删除某些订单 <br>
	 * 同时删除以下信息： <li>订单购物项</li> <li>订单日志</li> <li>订单支付、退款数据</li> <li>订单发货、退货数据</li>
	 * 
	 * @param orderId
	 *            要删除的订单Id数组
	 */
	void clean(Integer[] orderId);

	/**
	 * 批量还原某些订单
	 * 
	 * @param orderId
	 */
	void revert(Integer[] orderId);

	/**
	 * 列表某会员的订单<br/>
	 * lzf add
	 * 
	 * @param member_id
	 * @return
	 */
	List listOrderByMemberId(int member_id);
	
	/**
	 * 取某一会员的关于订单的统计信息
	 * @param member_id
	 * @return
	 */
	Map mapOrderByMemberId(int member_id);

	
	
	/**
	 * 读取某订单的配件发货项
	 * @param orderid
	 * @return
	 */
	List<Map> listAdjItem(Integer orderid);
	
	
	/**
	 * 统计订单状态
	 * @return key为状态值 ，value为此状态订单的数量
	 */
	Map  censusState();


	
	/**
	 * 根据订单ID查所有货物
	 * @param order_id 订单ID
	 * @return
	 */
	List<Map> getItemsByOrderid(Integer order_id);

	/**
	 * 游客订单查询
	 * @param page
	 * @param pageSize
	 * @param ship_name
	 * @param ship_tel	手机或固定电话
	 * @return
	 */
	Page searchForGuest(int page, int pageSize, String ship_name,String ship_tel);

	/**
	 * 查询某一用户的订单列表
	 * @param memberid
	 * @return
	 */
	Page listByStatus(int pageNo, int pageSize,int memberid);

	/**
	 * 
	 * @param pageNO 页数
	 * @param pageSize 页面行数
	 * @param disabled 是否作废0是正常
	 * @param sn 订单编号
	 * @param logi_no 物流单号
	 * @param uname 会员用户名
	 * @param ship_name 收货人姓名
	 * @return
	 */
	Page search(int pageNO, int pageSize,int disabled, String sn,String logi_no, String uname,String ship_name,int status);
	Page search(int pageNO, int pageSize, int disabled, String sn, String logi_no, String uname, String ship_name, int status,Integer paystatus);


	
	/**
	 * 更新付款方式 
	 * @param orderid
	 * @param payid
	 * @param paytype
	 */
	void updatePayMethod(int orderid,int payid,String paytype,String payname);
	
	
	/**
	 * 检测某个货品是否有订单使用
	 * @param productid
	 * @return
	 */
	boolean checkProInOrder(int productid);
	
	
	/**
	 * 检测某个货品是否有订单使用
	 * @param goodsid
	 * @return
	 */
	boolean checkGoodsInOrder(int goodsid);
	
	List listByOrderIds(Integer[] orderids,String order);
	
	/**
	 * 查询订单列表
	 * @author xulipeng 2014年5月15日11:18
	 * @param map 过滤条件<br>
	 * <li>stype:搜索类型(integer,0为基本搜索)</li>
	 * <li>keyword:关键字(String)</li>
	 * <li>order_state:订单状态特殊查询(String型，可以是如下的值：
	 * wait_ship:待发货
	 * wait_pay:待付款
	 * wait_rog:待收货
	 * )</li>
	 * <li>start_time:(开始时间,String型，如2015-10-10 )</li>
	 * <li>end_time(结束时间,String型，如2015-10-10 )</li>
	 * <li>status:订单状态(int型，对应status字段，{@link OrderStatus})</li>
	 * <li>paystatus:付款状态(int型，对应pay_status字段，{@link OrderStatus})</li>
	 * <li>shipstatus发货状态(int型，对应ship_status字段，{@link OrderStatus})</li>
	 * <li>sn:订单编号(String)</li>
	 * <li>ship_name:收货人(String 对应ship_name字段)</li>
	 * <li>shipping_type:配送方式(Integer，对应shipping_id字段)</li>
	 * <li>payment_id:支付方式(Integer 对应payment_id字段)</li>
	 * <li>depotid:仓库id(Integer 对应depotid字段)</li>
	 * @param page
	 * @param pageSize
	 * @param sortField 排序字段
	 * @param sortType 排序方式
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED) 
	Page listOrder(Map map,int page,int pageSize,String sortField,String sortType);
	/**
	 * 保存库房
	 * @author LiFenLong
	 * @param orderid
	 * @param depotid
	 */
	void saveDepot(int orderid, int depotid);
	/**
	 * 保存付款方式
	 * @author LiFenLong
	 * @param orderId
	 * @param paytypeid
	 */
	void savePayType(int orderId,int paytypeid);
	/**
	 *  保存配送方式
	 *  @author LiFenLong
	 * @param orederId
	 * @param shiptypeid
	 */
	void saveShipType(int orederId,int shiptypeid);
	
	/**
	 * 测试用
	 * @param order
	 * @author xulipeng
	 * @return 
	 */
	void add(Order order);
	/**
	 * 修改配送地区
	 * @param ship_provinceid
	 * @param ship_cityid
	 * @param ship_regionid
	 */
	void saveAddr(int orderId, int ship_provinceid,int ship_cityid,int ship_regionid,String Attr);
	
	/**
	 * 通过订单ID，获得该订单ID下的商品个数
	 */
	
	Integer getOrderGoodsNum(int order_id);
	

	/**
	 * 通过itemid 获取订单项  为了增加is_pack属性
	 * @param itemId
	 * @return
	 */
	List listGoodsItemsByItemId(Integer itemId);
	

	
	/**
	 * 获得该会员订单在各个状态的个数
	 * whj    2015-08-11
	 */
	Integer orderStatusNum(Integer status);
	
	/**
	 * 检验收货地区是否支持货到付款
	 * add by DMRain 2016-3-15
	 * @param regionList 收货地区省市县的id字符串，例：1,2,3
	 * @return result 0：支持，不为0则不支持
	 */
	int checkCod(String regionList);
	
	/**
	 * 根据商品id获取成功交易记录
	 * add by Kanon 2016-4-21
	 * @param goods_id 商品id
	 * @param pageNo 分页数
	 * @param pageSize 每页显示数量
	 * @return
	 */
	Page getRecordList(Integer goods_id,Integer pageNo,Integer pageSize);

	
	/**
	 * 根据订单id和要退货的goodsid 获取货物
	 * @param orderid
	 * @param goodsList
	 * @return
	 */
	List<Map> getItemsByOrderidAndGoodsList(int orderid,List<SellBackGoodsList> goodsList);
	
	/**
	 * 获取取消订单申请列表
	 * @param pageNo 页数
	 * @param pageSize 每页显示数量
	 * @return
	 */
	Page getCancelApplicationList(Integer pageNo,Integer pageSize);
	
	/**
	 * 审核取消订单详细
	 * @param order_id 订单Id
	 * @param status 状态
	 */
	void authCancelApplication(Integer order_id,Integer status);
	/**
	 * 后台提交取消订单申请
	 * @param order_id 订单Id
	 */
	
	void addCancelApplicationAdmin(Integer order_id,String reason);

	/**
	 * 前台取消订单，不需要到平台审核
	 * @author xulipeng
	 * @param order_id
	 * @param reason
	 * 2016年10月22日
	 */
	void cancel(Integer order_id,String reason);

	/**
	 * 带有城镇修改地区
	 * @param orderId
	 * @param ship_provinceid
	 * @param ship_cityid
	 * @param ship_regionid
	 * @param town_id
	 * @param Attr
	 */
	void saveAddrAndTown(int orderId, int ship_provinceid,int ship_cityid,int ship_regionid,int town_id,String Attr);

	/**
	 * 得到子订单列表
	 * @param orderid
	 * @return
	 */
	List<Order> getChildOrders(Integer orderid);
	
	
}
