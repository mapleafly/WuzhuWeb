package org.lifxue.wuzhu.module.bpm.framework.flowable.core.candidate.strategy;

import org.lifxue.wuzhu.framework.common.util.string.StrUtils;
import org.lifxue.wuzhu.module.bpm.dal.dataobject.definition.BpmUserGroupDO;
import org.lifxue.wuzhu.module.bpm.framework.flowable.core.candidate.BpmTaskCandidateStrategy;
import org.lifxue.wuzhu.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
import org.lifxue.wuzhu.module.bpm.service.definition.BpmUserGroupService;
import jakarta.annotation.Resource;
import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.lifxue.wuzhu.framework.common.util.collection.CollectionUtils.convertSetByFlatMap;

/**
 * 用户组 {@link BpmTaskCandidateStrategy} 实现类
 *
 * @author kyle
 */
@Component
public class BpmTaskCandidateGroupStrategy implements BpmTaskCandidateStrategy {

    @Resource
    private BpmUserGroupService userGroupService;

    @Override
    public BpmTaskCandidateStrategyEnum getStrategy() {
        return BpmTaskCandidateStrategyEnum.USER_GROUP;
    }

    @Override
    public void validateParam(String param) {
        Set<Long> groupIds = StrUtils.splitToLongSet(param);
        userGroupService.getUserGroupList(groupIds);
    }

    @Override
    public Set<Long> calculateUsers(DelegateExecution execution, String param) {
        Set<Long> groupIds = StrUtils.splitToLongSet(param);
        List<BpmUserGroupDO> groups = userGroupService.getUserGroupList(groupIds);
        return convertSetByFlatMap(groups, BpmUserGroupDO::getUserIds, Collection::stream);
    }

}