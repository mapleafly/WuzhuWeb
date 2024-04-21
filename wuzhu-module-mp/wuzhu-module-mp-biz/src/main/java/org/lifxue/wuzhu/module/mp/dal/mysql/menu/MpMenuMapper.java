package org.lifxue.wuzhu.module.mp.dal.mysql.menu;

import org.lifxue.wuzhu.framework.mybatis.core.mapper.BaseMapperX;
import org.lifxue.wuzhu.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.lifxue.wuzhu.module.mp.dal.dataobject.menu.MpMenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MpMenuMapper extends BaseMapperX<MpMenuDO> {

    default MpMenuDO selectByAppIdAndMenuKey(String appId, String menuKey) {
        return selectOne(MpMenuDO::getAppId, appId,
                MpMenuDO::getMenuKey, menuKey);
    }

    default List<MpMenuDO> selectListByAccountId(Long accountId) {
        return selectList(MpMenuDO::getAccountId, accountId);
    }

    default void deleteByAccountId(Long accountId) {
        delete(new LambdaQueryWrapperX<MpMenuDO>().eq(MpMenuDO::getAccountId, accountId));
    }
}
