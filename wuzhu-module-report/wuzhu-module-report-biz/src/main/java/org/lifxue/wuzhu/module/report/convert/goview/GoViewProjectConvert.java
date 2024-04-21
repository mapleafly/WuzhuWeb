package org.lifxue.wuzhu.module.report.convert.goview;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.module.report.controller.admin.goview.vo.project.GoViewProjectCreateReqVO;
import org.lifxue.wuzhu.module.report.controller.admin.goview.vo.project.GoViewProjectRespVO;
import org.lifxue.wuzhu.module.report.controller.admin.goview.vo.project.GoViewProjectUpdateReqVO;
import org.lifxue.wuzhu.module.report.dal.dataobject.goview.GoViewProjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoViewProjectConvert {

    GoViewProjectConvert INSTANCE = Mappers.getMapper(GoViewProjectConvert.class);

    GoViewProjectDO convert(GoViewProjectCreateReqVO bean);

    GoViewProjectDO convert(GoViewProjectUpdateReqVO bean);

    GoViewProjectRespVO convert(GoViewProjectDO bean);

    PageResult<GoViewProjectRespVO> convertPage(PageResult<GoViewProjectDO> page);

}
