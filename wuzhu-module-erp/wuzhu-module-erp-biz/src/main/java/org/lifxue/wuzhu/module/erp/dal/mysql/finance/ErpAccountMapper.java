package org.lifxue.wuzhu.module.erp.dal.mysql.finance;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.framework.mybatis.core.mapper.BaseMapperX;
import org.lifxue.wuzhu.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.lifxue.wuzhu.module.erp.controller.admin.finance.vo.account.ErpAccountPageReqVO;
import org.lifxue.wuzhu.module.erp.dal.dataobject.finance.ErpAccountDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ERP 结算账户 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ErpAccountMapper extends BaseMapperX<ErpAccountDO> {

    default PageResult<ErpAccountDO> selectPage(ErpAccountPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpAccountDO>()
                .likeIfPresent(ErpAccountDO::getName, reqVO.getName())
                .likeIfPresent(ErpAccountDO::getNo, reqVO.getNo())
                .eqIfPresent(ErpAccountDO::getRemark, reqVO.getRemark())
                .orderByDesc(ErpAccountDO::getId));
    }

    default ErpAccountDO selectByDefaultStatus() {
        return selectOne(ErpAccountDO::getDefaultStatus, true);
    }

    default List<ErpAccountDO> selectListByStatus(Integer status) {
        return selectList(ErpAccountDO::getStatus, status);
    }

}