package org.lifxue.wuzhu.module.infra.dal.mysql.demo.demo02;

import java.util.*;

import org.lifxue.wuzhu.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.lifxue.wuzhu.framework.mybatis.core.mapper.BaseMapperX;
import org.lifxue.wuzhu.module.infra.controller.admin.demo.demo02.vo.Demo02CategoryListReqVO;
import org.lifxue.wuzhu.module.infra.dal.dataobject.demo.demo02.Demo02CategoryDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 示例分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface Demo02CategoryMapper extends BaseMapperX<Demo02CategoryDO> {

    default List<Demo02CategoryDO> selectList(Demo02CategoryListReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<Demo02CategoryDO>()
                .likeIfPresent(Demo02CategoryDO::getName, reqVO.getName())
                .eqIfPresent(Demo02CategoryDO::getParentId, reqVO.getParentId())
                .betweenIfPresent(Demo02CategoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(Demo02CategoryDO::getId));
    }

	default Demo02CategoryDO selectByParentIdAndName(Long parentId, String name) {
	    return selectOne(Demo02CategoryDO::getParentId, parentId, Demo02CategoryDO::getName, name);
	}

    default Long selectCountByParentId(Long parentId) {
        return selectCount(Demo02CategoryDO::getParentId, parentId);
    }

}