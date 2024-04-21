package org.lifxue.wuzhu.module.trade.convert.order;

import org.lifxue.wuzhu.module.trade.dal.dataobject.order.TradeOrderLogDO;
import org.lifxue.wuzhu.module.trade.service.order.bo.TradeOrderLogCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TradeOrderLogConvert {

    TradeOrderLogConvert INSTANCE = Mappers.getMapper(TradeOrderLogConvert.class);

    TradeOrderLogDO convert(TradeOrderLogCreateReqBO bean);

}
