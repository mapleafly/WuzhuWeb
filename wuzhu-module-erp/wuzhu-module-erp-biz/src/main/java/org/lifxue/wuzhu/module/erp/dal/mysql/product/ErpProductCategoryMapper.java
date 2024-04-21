package org.lifxue.wuzhu.module.erp.dal.mysql.product;

import org.lifxue.wuzhu.framework.mybatis.core.mapper.BaseMapperX;
import org.lifxue.wuzhu.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.lifxue.wuzhu.module.erp.controller.admin.product.vo.category.ErpProductCategoryListReqVO;
import org.lifxue.wuzhu.module.erp.dal.dataobject.product.ErpProductCategoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ERP 产品分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ErpProductCategoryMapper extends BaseMapperX<ErpProductCategoryDO> {

    default List<ErpProductCategoryDO> selectList(ErpProductCategoryListReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ErpProductCategoryDO>()
                .likeIfPresent(ErpProductCategoryDO::getName, reqVO.getName())
                .eqIfPresent(ErpProductCategoryDO::getStatus, reqVO.getStatus())
                .orderByDesc(ErpProductCategoryDO::getId));
    }

	default ErpProductCategoryDO selectByParentIdAndName(Long parentId, String name) {
	    return selectOne(ErpProductCategoryDO::getParentId, parentId, ErpProductCategoryDO::getName, name);
	}

    default Long selectCountByParentId(Long parentId) {
        return selectCount(ErpProductCategoryDO::getParentId, parentId);
    }

}