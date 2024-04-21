package org.lifxue.wuzhu.module.mp.framework.mp.config;

import org.lifxue.wuzhu.module.mp.framework.mp.core.DefaultMpServiceFactory;
import org.lifxue.wuzhu.module.mp.framework.mp.core.MpServiceFactory;
import org.lifxue.wuzhu.module.mp.service.handler.menu.MenuHandler;
import org.lifxue.wuzhu.module.mp.service.handler.message.MessageReceiveHandler;
import org.lifxue.wuzhu.module.mp.service.handler.message.MessageAutoReplyHandler;
import org.lifxue.wuzhu.module.mp.service.handler.other.KfSessionHandler;
import org.lifxue.wuzhu.module.mp.service.handler.other.NullHandler;
import org.lifxue.wuzhu.module.mp.service.handler.other.ScanHandler;
import org.lifxue.wuzhu.module.mp.service.handler.other.StoreCheckNotifyHandler;
import org.lifxue.wuzhu.module.mp.service.handler.user.LocationHandler;
import org.lifxue.wuzhu.module.mp.service.handler.user.SubscribeHandler;
import org.lifxue.wuzhu.module.mp.service.handler.user.UnsubscribeHandler;
import com.binarywang.spring.starter.wxjava.mp.properties.WxMpProperties;
import me.chanjar.weixin.common.redis.RedisTemplateWxRedisOps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 微信公众号的配置类
 *
 * @author 芋道源码
 */
@Configuration
public class MpConfiguration {

    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public RedisTemplateWxRedisOps redisTemplateWxRedisOps(StringRedisTemplate stringRedisTemplate) {
        return new RedisTemplateWxRedisOps(stringRedisTemplate);
    }

    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public MpServiceFactory mpServiceFactory(RedisTemplateWxRedisOps redisTemplateWxRedisOps,
                                             WxMpProperties wxMpProperties,
                                             MessageReceiveHandler messageReceiveHandler,
                                             KfSessionHandler kfSessionHandler,
                                             StoreCheckNotifyHandler storeCheckNotifyHandler,
                                             MenuHandler menuHandler,
                                             NullHandler nullHandler,
                                             SubscribeHandler subscribeHandler,
                                             UnsubscribeHandler unsubscribeHandler,
                                             LocationHandler locationHandler,
                                             ScanHandler scanHandler,
                                             MessageAutoReplyHandler messageAutoReplyHandler) {
        return new DefaultMpServiceFactory(redisTemplateWxRedisOps, wxMpProperties,
                messageReceiveHandler, kfSessionHandler, storeCheckNotifyHandler, menuHandler,
                nullHandler, subscribeHandler, unsubscribeHandler, locationHandler, scanHandler, messageAutoReplyHandler);
    }

}
