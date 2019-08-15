package com.enation.app.shop.core.order.service;

import com.enation.app.shop.core.order.model.Transaction;


public interface ITradingManager {

    Transaction findBySn(String sn);

    void saveOrder(Transaction order);

    void edit(Transaction order);

    Transaction queryByOrderNo(String orderNo);

}
