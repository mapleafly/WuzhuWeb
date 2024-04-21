package org.lifxue.wuzhu.module.statistics.dal.mysql.trade;

import org.lifxue.wuzhu.framework.mybatis.core.mapper.BaseMapperX;
import org.lifxue.wuzhu.module.statistics.dal.dataobject.trade.TradeStatisticsDO;
import org.lifxue.wuzhu.module.statistics.service.trade.bo.AfterSaleSummaryRespBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * 售后订单的统计 Mapper
 *
 * @author owen
 */
@Mapper
public interface AfterSaleStatisticsMapper extends BaseMapperX<TradeStatisticsDO> {

    AfterSaleSummaryRespBO selectSummaryByRefundTimeBetween(@Param("beginTime") LocalDateTime beginTime,
                                                            @Param("endTime") LocalDateTime endTime);

    Long selectCountByStatus(@Param("status") Integer status);

}
