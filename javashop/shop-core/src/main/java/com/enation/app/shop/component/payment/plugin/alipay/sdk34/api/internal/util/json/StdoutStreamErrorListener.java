package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.util.json;

public class StdoutStreamErrorListener extends BufferErrorListener {
    
    public void end() {
        System.out.print(buffer.toString());
    }
}
