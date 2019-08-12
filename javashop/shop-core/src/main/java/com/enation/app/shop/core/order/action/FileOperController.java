package com.enation.app.shop.core.order.action;


import com.enation.app.shop.core.order.service.IOrderManager;
import com.enation.app.shop.front.api.order.model.ResultModel;
import com.enation.framework.util.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/file/oper")
public class FileOperController {


    @Autowired
    private IOrderManager orderManager;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static Logger log = LoggerFactory.getLogger(FileOperController.class);


    @RequestMapping("output/order")
    public ResultModel orderOutput(String startDate,String endDate){
        String filePath = "E:/demo";
        try {
            orderManager.output(filePath,sdf.parse(startDate),sdf.parse(endDate));
        } catch (ParseException e) {
            log.error("系统异常:{}",e);
        }
        return ResultModel.success();
    }

    @RequestMapping("input/order")
    public ResultModel orderInput(String filePath){
        List<Object> objects = ExcelUtils.readMoreThan1000Row(filePath);
        return null;
    }


}
