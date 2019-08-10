package com.enation.app.shop.front.api.order.enums;

/**
 * 处理状态枚举
 *
 * @author X-TAN
 * @date 2018-08-30
 */
public enum RespCodeEnum {
    HANDLING(1100, "处理中"),
    SUCCESS(1000, "成功"),
    FAIL(1001, "失败"),
    SIGN_ERROR(1002, "签名错误"),
    NO_RESULT(1004, "未查询到相关信息"),
    PARAM_IS_ERROR(1011, "参数异常"),
    UP_SYSTEM_ERROR(9998, "服务繁忙"),
    SYSTEM_ERROR(9999, "系统异常");

    private Integer respCode;

    private String respDesc;

    RespCodeEnum(Integer respCode, String respDesc) {
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public Integer getRespCode() {
        return respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespCode(Integer respCode) {
        this.respCode = respCode;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

}
