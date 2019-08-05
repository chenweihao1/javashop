package com.enation.app.shop.front.api.order.model;

import com.alibaba.fastjson.JSONObject;
import com.enation.app.shop.front.api.order.enums.RespCodeEnum;

public class ResultModel {

    public ResultModel(){

    }

    public ResultModel(RespCodeEnum code){
        this.code = code;
    }

    public ResultModel(RespCodeEnum code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultModel(RespCodeEnum code,Object data){
        this.code = code;
        this.data = data;
    }

    public ResultModel(RespCodeEnum code,Object data,String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }



    public static String save(RespCodeEnum code,String msg){
        return JSONObject.toJSONString(new ResultModel(code,msg));
    }


    public static String save(RespCodeEnum code,Object data,String msg){
        return JSONObject.toJSONString(new ResultModel(code,data,msg));
    }



    public static ResultModel success(){
        return new ResultModel(RespCodeEnum.SUCCESS);
    }

    public static ResultModel fail(String msg){
        return new ResultModel(RespCodeEnum.FAIL,msg);
    }

    public static ResultModel success(Object data){
        return new ResultModel(RespCodeEnum.SUCCESS,data);
    }



    private RespCodeEnum code;

    private Object data;

    private String msg;

    public RespCodeEnum getCode() {
        return code;
    }

    public void setCode(RespCodeEnum code) {
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
