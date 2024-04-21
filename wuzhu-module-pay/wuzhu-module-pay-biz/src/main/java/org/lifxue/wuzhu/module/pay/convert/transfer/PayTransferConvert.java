package org.lifxue.wuzhu.module.pay.convert.transfer;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.framework.pay.core.client.dto.transfer.PayTransferUnifiedReqDTO;
import org.lifxue.wuzhu.module.pay.api.transfer.dto.PayTransferCreateReqDTO;
import org.lifxue.wuzhu.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferCreateReqVO;
import org.lifxue.wuzhu.module.pay.controller.admin.transfer.vo.PayTransferCreateReqVO;
import org.lifxue.wuzhu.module.pay.controller.admin.transfer.vo.PayTransferPageItemRespVO;
import org.lifxue.wuzhu.module.pay.controller.admin.transfer.vo.PayTransferRespVO;
import org.lifxue.wuzhu.module.pay.dal.dataobject.transfer.PayTransferDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayTransferConvert {

    PayTransferConvert INSTANCE = Mappers.getMapper(PayTransferConvert.class);

    PayTransferDO convert(PayTransferCreateReqDTO dto);

    PayTransferUnifiedReqDTO convert2(PayTransferDO dto);

    PayTransferCreateReqDTO convert(PayTransferCreateReqVO vo);

    PayTransferCreateReqDTO convert(PayDemoTransferCreateReqVO vo);

    PayTransferRespVO  convert(PayTransferDO bean);

    PageResult<PayTransferPageItemRespVO> convertPage(PageResult<PayTransferDO> pageResult);
}
