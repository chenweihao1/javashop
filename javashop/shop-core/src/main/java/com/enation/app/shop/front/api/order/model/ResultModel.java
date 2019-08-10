package com.enation.app.shop.front.api.order.model;

import com.alibaba.fastjson.JSONObject;
import com.enation.app.shop.front.api.order.enums.RespCodeEnum;

public class ResultModel {

    public ResultModel(){

    }

    public ResultModel(Integer code){
        this.code = code;
    }

    public ResultModel(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultModel(Integer code,Object data){
        this.code = code;
        this.data = data;
    }

    public ResultModel(Integer code,Object data,String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }



    public static String save(Integer code,String msg){
        return JSONObject.toJSONString(new ResultModel(code,msg));
    }


    public static String save(Integer code,Object data,String msg){
        return JSONObject.toJSONString(new ResultModel(code,data,msg));
    }



    public static ResultModel success(){
        return new ResultModel(RespCodeEnum.SUCCESS.getRespCode());
    }

    public static ResultModel fail(String msg){
        return new ResultModel(RespCodeEnum.FAIL.getRespCode(),msg);
    }

    public static ResultModel success(Object data){
        return new ResultModel(RespCodeEnum.SUCCESS.getRespCode(),data);
    }



    private Integer code;

    private Object data;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
