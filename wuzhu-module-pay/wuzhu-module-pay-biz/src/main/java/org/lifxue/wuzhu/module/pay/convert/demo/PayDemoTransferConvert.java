package org.lifxue.wuzhu.module.pay.convert.demo;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferCreateReqVO;
import org.lifxue.wuzhu.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferRespVO;
import org.lifxue.wuzhu.module.pay.dal.dataobject.demo.PayDemoTransferDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jason
 */
@Mapper
public interface PayDemoTransferConvert {

    PayDemoTransferConvert INSTANCE = Mappers.getMapper(PayDemoTransferConvert.class);

    PayDemoTransferDO convert(PayDemoTransferCreateReqVO bean);

    PageResult<PayDemoTransferRespVO> convertPage(PageResult<PayDemoTransferDO> pageResult);
}
