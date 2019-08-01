package com.enation.app.shop.core.payment;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.config.AlipayConfig;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class junit {



    @Test
    public void doPost() throws ServletException, IOException {
        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDanQOA9b2RbmjB\n" +
                "gSpQvtnVvgPoJk3ZwiZW4WTEE5HJbWnWAvRNK9JwBC4LJTin+L7SwJoxSBzwSkod\n" +
                "aFmin2wExZ+9LegXdudBoc+osQpGn+i3jH+ZM4bqMUpFjvhC/URQhDwEnJ4D5tA1\n" +
                "WHx0IMj4Oq2nNYX8dRKEsdd4XG1Z1axGsnVkjawFU/HYyoVvgw+AYgHlzGmA2wYc\n" +
                "xA+Hlf4tbbs912fxdTXXUxfKaZeZLGQ/CBBSy1ONKjcRvB8f7v1WaIUtE5OrHg41\n" +
                "jdoXCBrhkmnVxJX+WTnCeJB16HLOO7WDJfQFXAct9oONJs78PjzCR64DH7fYcMyH\n" +
                "3pMlJnqHAgMBAAECggEATfj4ufNsRMXbiUEXpascqRbX7+JRnByabhyAQ0szkWN7\n" +
                "/0AYgLnjmd5zybfh6E9ZSHQ3yuIMqEvm+WwxpEY2UdFm8yO/hzb6rrcXCPT0VFJO\n" +
                "v8DV9f+h3D/uXLbsp4AL8KfpfD+cQIn/szc3VHgpFhhfvabifjQHgdqonp5gxkw9\n" +
                "/7GsTwlMLJxobw27O+qwJcEjXRRu9FEvBimJ2VlvXPeci6CJAvSII+QixJqWFXP+\n" +
                "rKE64nL7SD95GxbnVKRvOxzQYWg35V7LGgyurIh8Y00K0UApqP3yCwlx3z8KXDwx\n" +
                "hUJTdci0XbnlLkwnXyTtHHd2oVolqYzbtnWQOj35AQKBgQD10Fb+kFOIB8YWu9Z+\n" +
                "2EkRT0ENr0mPrS0/RZn1om8fDyePTcbukAi2PkAOm5S6iyxeuOFOJYKBQp9VABEk\n" +
                "mIw/hMn4bO/X7OQ3+nASuvB8t5SVrTMhr1+AhLQDPb98CpMctvI+jZkbdIvWAwqe\n" +
                "qh3LtosPIsQHQVM9dfaH/vEegQKBgQDjrB+lIDGQHojnuX9aMLIqyHgx/XRAbT6U\n" +
                "ISj742Ku0OvbXLpaQsvjYDWPVdPFj/94+5bgzUVXeXDsW4ySVnSPwp1iLZ5vUICl\n" +
                "fy9AANFOw+pVRx/GXoJyRfnxaRU+cPdET1oyYjefTvCTlNmo5cxqgNbALt0WBNYp\n" +
                "JfppzCYlBwKBgQClLwPGvSXk25R54nAZfS5cu21zzL8aFb26LwNu1WDm9kAXRKTR\n" +
                "22h/TwWsy0/+q1d9r6933Cz+v85iSFE8zmYwqQMwNcRWzZHvLBP0AjtpE9R9YI5j\n" +
                "rH341zRAmVX7/P8u5KGU94JTuNXfUtvoE1lCc8CuwyYH2hYdzw+EBAX0AQKBgQCS\n" +
                "sAafjHOCiLnqmxCbmn5gpFMU2lk5XWmRZSAT0rh1K/SanE8Q8rKM6CL6G/Fa++E9\n" +
                "INRgOMFxj7QbBQ04B+4H5fsjE4Nd8v9AIgbedOhmmEH1+eJWG/RuDfnw+aSPW5dk\n" +
                "8r+JcNCnmuPUInZupMik4if7IPafRjR5xJdn7PmypwKBgCQSMCCf5yopUdSEpdMK\n" +
                "pIkkbwc+yTMJECWbBTHATbHBGPBVq+J0Hgr7M1KOWZ/PFK6d/terPcmaalKbPWJb\n" +
                "Of6aYhfDmNvDnwrVawlBDKcayCmANr9uHgxSGI7h/E3oLi7hElnxtO//HCIKa6bx\n" +
                "N14Yv+WC0yYuL73ui4UlryYv";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
        String appId = "2016100200644648";
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", appId, privateKey, "json", AlipayConfig.charset, publicKey, AlipayConfig.sign_type); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101001\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":88.88," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"body\":\"Iphone6 16G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(form);
    }


}
