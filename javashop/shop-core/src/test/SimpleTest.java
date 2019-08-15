import com.enation.framework.util.HttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SimpleTest {

    @Test
    public void testJsoup() {
        String form = "<form name=\"punchout_form\" method=\"post\" action=\"https://openapi.alipay.com/gateway.do?charset=utf-8&method=alipay.trade.wap.pay&sign=dmAnFd%2FxgT5RrBrw5IucPkGIcEpRvtNbaCD8yXs4xphRb04Eget4wACOs3Xv%2BHWl3pkrQ%2BjugV3Zq6Mqkz8Mun6l3nYK3Eap9ZGmkBrV1EZcOiORr08vqAcwylYVACN1MW8n2htVuWLqq%2FYFkqJ9EafM04jz5ErppazgMZ%2F6OvS7bB7xSdIaAoSNE1OzT%2B1aa9entwTM6sEEb7pJQ3zKz%2BAwhKZQzt0kRy4uWX8%2F4Phx72IKfZI2fvbJUBt3yUFuB2nnWI9vVxQrTQLH6hos3YLIWLFjygslgV6fJ1VzJlJOTjSS7jcLWpzUBKivaR%2BkvjRtotNHogh%2BDwaZuejyHw%3D%3D&return_url=http%3A%2F%2F47.75.212.93%3A8012%2FReceive%2FDSPT%2FReturnUrl.aspx&notify_url=http%3A%2F%2F39.100.137.200%3A8080%2Fb2c%2Fapi%2Fshop%2Forder-pay%2Fcallback%2Forder%2FalipayDirectPlugin.do&version=1.0&app_id=2019081266183316&sign_type=RSA2&timestamp=2019-08-13+22%3A31%3A53&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json\">\n" +
                "<input type=\"hidden\" name=\"biz_content\" value=\"{&quot;out_trade_no&quot;:&quot;156570671312&quot;,&quot;total_amount&quot;:&quot;1.0&quot;,&quot;subject&quot;:&quot;SDD商家平台订单&quot;,&quot;product_code&quot;:&quot;FAST_INSTANT_TRADE_PAY&quot;,&quot;body&quot;:&quot;花花公子男包商务 单肩包休闲横款大包 潮男皮包公文包手提包男士x1&quot;}\">\n" +
                "<input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n" +
                "</form>\n" +
                "<script>document.forms[0].submit();</script>";

        Document doc = Jsoup.parse(form);
        String action = doc.select("form").attr("action");
        String biz_content = doc.select("input").first().attr("value");
        System.out.println(action);
        System.out.println(biz_content);

        Map<String, String> params = new HashMap<>();
        params.put("biz_content", biz_content);
        HttpClientUtil.post(action, params, "UTF-8");
    }
}
