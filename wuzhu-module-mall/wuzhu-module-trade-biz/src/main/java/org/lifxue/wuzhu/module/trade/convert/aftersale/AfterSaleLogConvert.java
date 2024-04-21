package org.lifxue.wuzhu.module.trade.convert.aftersale;

import org.lifxue.wuzhu.module.trade.dal.dataobject.aftersale.AfterSaleLogDO;
import org.lifxue.wuzhu.module.trade.service.aftersale.bo.AfterSaleLogCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AfterSaleLogConvert {

    AfterSaleLogConvert INSTANCE = Mappers.getMapper(AfterSaleLogConvert.class);

    AfterSaleLogDO convert(AfterSaleLogCreateReqBO bean);

}
