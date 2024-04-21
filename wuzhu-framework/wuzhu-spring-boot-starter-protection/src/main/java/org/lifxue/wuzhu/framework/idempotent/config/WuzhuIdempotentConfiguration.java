package org.lifxue.wuzhu.framework.idempotent.config;

import org.lifxue.wuzhu.framework.idempotent.core.aop.IdempotentAspect;
import org.lifxue.wuzhu.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import org.lifxue.wuzhu.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import org.lifxue.wuzhu.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import org.lifxue.wuzhu.framework.idempotent.core.keyresolver.impl.UserIdempotentKeyResolver;
import org.lifxue.wuzhu.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.lifxue.wuzhu.framework.redis.config.WuzhuRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = WuzhuRedisAutoConfiguration.class)
public class WuzhuIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public UserIdempotentKeyResolver userIdempotentKeyResolver() {
        return new UserIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
