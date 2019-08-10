package com.enation.app.shop.front.api.order.enums;

public enum PayStatusEnum {

    UNPAID(0,"未支付"),
    SUCCESS(1,"支付成功");

    PayStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
