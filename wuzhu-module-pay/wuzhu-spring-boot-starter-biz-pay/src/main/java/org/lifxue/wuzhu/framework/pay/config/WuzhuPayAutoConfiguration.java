package org.lifxue.wuzhu.framework.pay.config;

import org.lifxue.wuzhu.framework.pay.core.client.PayClientFactory;
import org.lifxue.wuzhu.framework.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 支付配置类
 *
 * @author 芋道源码
 */
@AutoConfiguration
public class WuzhuPayAutoConfiguration {

    @Bean
    public PayClientFactory payClientFactory() {
        return new PayClientFactoryImpl();
    }

}