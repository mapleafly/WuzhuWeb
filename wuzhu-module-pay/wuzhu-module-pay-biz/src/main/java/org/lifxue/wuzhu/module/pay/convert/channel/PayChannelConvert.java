package org.lifxue.wuzhu.module.pay.convert.channel;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.module.pay.controller.admin.channel.vo.PayChannelCreateReqVO;
import org.lifxue.wuzhu.module.pay.controller.admin.channel.vo.PayChannelRespVO;
import org.lifxue.wuzhu.module.pay.controller.admin.channel.vo.PayChannelUpdateReqVO;
import org.lifxue.wuzhu.module.pay.dal.dataobject.channel.PayChannelDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayChannelConvert {

    PayChannelConvert INSTANCE = Mappers.getMapper(PayChannelConvert.class);

    @Mapping(target = "config",ignore = true)
    PayChannelDO convert(PayChannelCreateReqVO bean);

    @Mapping(target = "config",ignore = true)
    PayChannelDO convert(PayChannelUpdateReqVO bean);

    @Mapping(target = "config",expression = "java(org.lifxue.wuzhu.framework.common.util.json.JsonUtils.toJsonString(bean.getConfig()))")
    PayChannelRespVO convert(PayChannelDO bean);

    PageResult<PayChannelRespVO> convertPage(PageResult<PayChannelDO> page);

}
