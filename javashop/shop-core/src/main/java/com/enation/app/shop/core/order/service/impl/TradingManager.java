package com.enation.app.shop.core.order.service.impl;

import com.enation.app.shop.core.order.model.Transaction;
import com.enation.app.shop.core.order.service.ITradingManager;
import com.enation.framework.database.IDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Service("tradingManager")
public class TradingManager implements ITradingManager {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public Transaction findBySn(String sn) {
        String sql = "select * from es_tran where sn = ?";
        return this.daoSupport.queryForObject(sql,Transaction.class,sn);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrder(Transaction order) {
        Map<String,Object> map = new HashMap<>();
        map.put("third_order_num",order.getThirdOrderNum());
        map.put("sn",order.getSn());
        map.put("pay_order_num",order.getPayOrderNum());
        map.put("call_back_url",order.getCallBackUrl());
        map.put("return_url",order.getReturnUrl());
        map.put("status",order.getStatus());
        map.put("create_time",sdf.format(order.getCreateTime()));
        this.daoSupport.insert("es_tran",map);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void edit(Transaction order) {
        String sql = "update es_tran set status = ?,pay_order_num = ? where sn = ?";
        this.daoSupport.execute(sql,order.getStatus(),order.getPayOrderNum(),order.getSn());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Transaction queryByOrderNo(String orderNo){
        String sql = "select * from es_tran where thirdOrderNum = ?";
        Transaction tran = this.daoSupport.queryForObject(sql,Transaction.class,orderNo);
        return tran;
    }
}
