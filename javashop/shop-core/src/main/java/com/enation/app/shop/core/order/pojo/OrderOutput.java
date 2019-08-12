package com.enation.app.shop.core.order.pojo;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import groovy.transform.EqualsAndHashCode;

public class OrderOutput extends BaseRowModel {

    @ExcelProperty(value = "订单号", index = 0)
    private String orderNo;

    @ExcelProperty(value = "收货人", index = 1)
    private String shipname;

    @ExcelProperty(value = "手机号", index = 2)
    private String mobile;

    @ExcelProperty(value = "收货地址" ,index = 3)
    private String shipAddress;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }
}
