package com.enation.app.shop.component.payment.plugin.alipay;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kingapex on 29/12/2017.
 *
 * @author kingapex
 * @version 1.0
 * @since 6.4.0
 * 29/12/2017
 */

@Configuration
@ComponentScan({"com.alipay.api..*"})
public class AlipayConfig {

}
