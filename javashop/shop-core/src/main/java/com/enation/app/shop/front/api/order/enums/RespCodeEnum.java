package com.enation.app.shop.front.api.order.enums;

/**
 * 处理状态枚举
 *
 * @author X-TAN
 * @date 2018-08-30
 */
public enum RespCodeEnum {
    HANDLING("0100", "处理中"),
    SUCCESS("0000", "成功"),
    FAIL("0001", "失败"),
    SIGN_ERROR("0002", "签名错误"),
    NO_RESULT("0004", "未查询到相关信息"), // 上游未查询到结果
    PARAM_IS_ERROR("1001", "参数异常"),
    UP_SYSTEM_ERROR("9998", "服务繁忙"), // 上游响应超时
    SYSTEM_ERROR("9999", "系统异常"),
    TRADE_STATUS_FINISHED("3", "交易成功"),
    TRADE_STATUS_PAYSUCCESS_SETTLEING("2", "支付成功,结算中"),
    TRADE_STATUS_PAYING("1", "支付中"),
    TRADE_STATUS_WAIT_PAY("0", "待支付"),
    TRADE_STATUS_FAIL("-1", "交易失败");

    private String respCode;

    private String respDesc;

    RespCodeEnum(String respCode, String respDesc) {
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public String getRespCode() {
        return respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

}
