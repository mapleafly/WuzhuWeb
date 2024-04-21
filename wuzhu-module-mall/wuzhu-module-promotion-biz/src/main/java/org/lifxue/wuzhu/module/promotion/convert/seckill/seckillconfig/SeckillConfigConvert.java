package org.lifxue.wuzhu.module.promotion.convert.seckill.seckillconfig;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.module.promotion.controller.admin.seckill.vo.config.SeckillConfigCreateReqVO;
import org.lifxue.wuzhu.module.promotion.controller.admin.seckill.vo.config.SeckillConfigRespVO;
import org.lifxue.wuzhu.module.promotion.controller.admin.seckill.vo.config.SeckillConfigSimpleRespVO;
import org.lifxue.wuzhu.module.promotion.controller.admin.seckill.vo.config.SeckillConfigUpdateReqVO;
import org.lifxue.wuzhu.module.promotion.controller.app.seckill.vo.config.AppSeckillConfigRespVO;
import org.lifxue.wuzhu.module.promotion.dal.dataobject.seckill.SeckillConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 秒杀时段 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SeckillConfigConvert {

    SeckillConfigConvert INSTANCE = Mappers.getMapper(SeckillConfigConvert.class);

    SeckillConfigDO convert(SeckillConfigCreateReqVO bean);

    SeckillConfigDO convert(SeckillConfigUpdateReqVO bean);

    SeckillConfigRespVO convert(SeckillConfigDO bean);

    List<SeckillConfigRespVO> convertList(List<SeckillConfigDO> list);

    List<SeckillConfigSimpleRespVO> convertList1(List<SeckillConfigDO> list);

    PageResult<SeckillConfigRespVO> convertPage(PageResult<SeckillConfigDO> page);

    List<AppSeckillConfigRespVO> convertList2(List<SeckillConfigDO> list);

    AppSeckillConfigRespVO convert1(SeckillConfigDO filteredConfig);
}
