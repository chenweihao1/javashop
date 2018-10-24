package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.util.json;

public interface JSONErrorListener {
    void start(String text);
    void error(String message, int column);
    void end();
}
