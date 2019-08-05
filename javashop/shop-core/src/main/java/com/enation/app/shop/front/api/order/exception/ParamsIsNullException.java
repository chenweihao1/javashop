package com.enation.app.shop.front.api.order.exception;

import com.enation.app.shop.front.api.order.enums.RespCodeEnum;

public class ParamsIsNullException extends RuntimeException {

    private RespCodeEnum code;

    private String msg;

    public ParamsIsNullException(){
        super();
    }

    public ParamsIsNullException(RespCodeEnum code,String msg){
        super();
        this.code = code;
        this.msg = msg;
    }

    public RespCodeEnum getCode() {
        return code;
    }

    public void setCode(RespCodeEnum code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
