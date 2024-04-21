package org.lifxue.wuzhu.module.infra.framework.file.config;

import org.lifxue.wuzhu.module.infra.framework.file.core.client.FileClientFactory;
import org.lifxue.wuzhu.module.infra.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件配置类
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
public class WuzhuFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
