package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.parser.json;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayApiException;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayParser;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayRequest;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayResponse;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.SignItem;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.Converter;

/**
 * 单个JSON对象解释器。
 * 
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class ObjectJsonParser<T extends AlipayResponse> implements AlipayParser<T> {

    private Class<T> clazz;

    public ObjectJsonParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T parse(String rsp) throws AlipayApiException {
        Converter converter = new JsonConverter();
        return converter.toResponse(rsp, clazz);
    }

    public Class<T> getResponseClass() {
        return clazz;
    }

    /** 
     * @see com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayParser#getSignItem(com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayRequest, String)
     */
    public SignItem getSignItem(AlipayRequest<?> request, String responseBody)
                                                                              throws AlipayApiException {

        Converter converter = new JsonConverter();

        return converter.getSignItem(request, responseBody);
    }

    /** 
     * @see com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayParser#encryptSourceData(com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayRequest, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public String encryptSourceData(AlipayRequest<?> request, String body, String format,
                                       String encryptType, String encryptKey, String charset)
                                                                                             throws AlipayApiException {

        Converter converter = new JsonConverter();

        return converter.encryptSourceData(request, body, format, encryptType, encryptKey,
            charset);
    }

}
