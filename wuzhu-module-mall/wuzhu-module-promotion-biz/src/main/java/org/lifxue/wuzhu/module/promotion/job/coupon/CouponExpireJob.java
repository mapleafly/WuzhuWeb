package org.lifxue.wuzhu.module.promotion.job.coupon;

import cn.hutool.core.util.StrUtil;
import org.lifxue.wuzhu.framework.quartz.core.handler.JobHandler;
import org.lifxue.wuzhu.framework.tenant.core.job.TenantJob;
import org.lifxue.wuzhu.module.promotion.service.coupon.CouponService;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

// TODO 芋艿：配置一个 Job
/**
 * 优惠券过期 Job
 *
 * @author owen
 */
@Component
public class CouponExpireJob implements JobHandler {

    @Resource
    private CouponService couponService;

    @Override
    @TenantJob
    public String execute(String param) {
        int count = couponService.expireCoupon();
        return StrUtil.format("过期优惠券 {} 个", count);
    }

}
