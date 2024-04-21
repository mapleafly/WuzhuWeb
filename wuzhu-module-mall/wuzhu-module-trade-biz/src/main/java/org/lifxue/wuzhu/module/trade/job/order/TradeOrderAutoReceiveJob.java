package org.lifxue.wuzhu.module.trade.job.order;

import org.lifxue.wuzhu.framework.quartz.core.handler.JobHandler;
import org.lifxue.wuzhu.framework.tenant.core.job.TenantJob;
import org.lifxue.wuzhu.module.trade.service.order.TradeOrderUpdateService;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * 交易订单的自动收货 Job
 *
 * @author 芋道源码
 */
@Component
public class TradeOrderAutoReceiveJob implements JobHandler {

    @Resource
    private TradeOrderUpdateService tradeOrderUpdateService;

    @Override
    @TenantJob
    public String execute(String param) {
        int count = tradeOrderUpdateService.receiveOrderBySystem();
        return String.format("自动收货 %s 个", count);
    }

}
