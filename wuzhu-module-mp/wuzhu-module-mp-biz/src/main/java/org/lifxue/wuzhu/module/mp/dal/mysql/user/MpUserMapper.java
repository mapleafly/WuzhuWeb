package org.lifxue.wuzhu.module.mp.dal.mysql.user;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.framework.mybatis.core.mapper.BaseMapperX;
import org.lifxue.wuzhu.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.lifxue.wuzhu.module.mp.controller.admin.user.vo.MpUserPageReqVO;
import org.lifxue.wuzhu.module.mp.dal.dataobject.user.MpUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MpUserMapper extends BaseMapperX<MpUserDO> {

    default PageResult<MpUserDO> selectPage(MpUserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MpUserDO>()
                .likeIfPresent(MpUserDO::getOpenid, reqVO.getOpenid())
                .likeIfPresent(MpUserDO::getNickname, reqVO.getNickname())
                .eqIfPresent(MpUserDO::getAccountId, reqVO.getAccountId())
                .orderByDesc(MpUserDO::getId));
    }

    default MpUserDO selectByAppIdAndOpenid(String appId, String openid) {
        return selectOne(MpUserDO::getAppId, appId,
                MpUserDO::getOpenid, openid);
    }

    default List<MpUserDO> selectListByAppIdAndOpenid(String appId, List<String> openids) {
        return selectList(new LambdaQueryWrapperX<MpUserDO>()
                .eq(MpUserDO::getAppId, appId)
                .in(MpUserDO::getOpenid, openids));

    }

}
