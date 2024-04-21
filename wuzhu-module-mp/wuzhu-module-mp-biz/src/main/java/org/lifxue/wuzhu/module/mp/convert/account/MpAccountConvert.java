package org.lifxue.wuzhu.module.mp.convert.account;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.module.mp.controller.admin.account.vo.MpAccountCreateReqVO;
import org.lifxue.wuzhu.module.mp.controller.admin.account.vo.MpAccountRespVO;
import org.lifxue.wuzhu.module.mp.controller.admin.account.vo.MpAccountSimpleRespVO;
import org.lifxue.wuzhu.module.mp.controller.admin.account.vo.MpAccountUpdateReqVO;
import org.lifxue.wuzhu.module.mp.dal.dataobject.account.MpAccountDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MpAccountConvert {

    MpAccountConvert INSTANCE = Mappers.getMapper(MpAccountConvert.class);

    MpAccountDO convert(MpAccountCreateReqVO bean);

    MpAccountDO convert(MpAccountUpdateReqVO bean);

    MpAccountRespVO convert(MpAccountDO bean);

    List<MpAccountRespVO> convertList(List<MpAccountDO> list);

    PageResult<MpAccountRespVO> convertPage(PageResult<MpAccountDO> page);

    List<MpAccountSimpleRespVO> convertList02(List<MpAccountDO> list);

}
