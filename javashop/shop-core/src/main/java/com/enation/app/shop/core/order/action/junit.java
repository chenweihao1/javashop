package com.enation.app.shop.core.order.action;

import com.enation.app.shop.core.order.service.IOrderManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class junit {


    @Autowired
    private IOrderManager orderManager;


    @Test
    public void test1(){
        String filePath = "E:/demo/es.xlsx";
        orderManager.output(filePath,null,new Date());
    }


}
