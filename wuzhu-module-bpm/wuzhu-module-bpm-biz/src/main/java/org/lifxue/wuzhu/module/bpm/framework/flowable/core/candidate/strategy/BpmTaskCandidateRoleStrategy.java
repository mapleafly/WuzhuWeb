package org.lifxue.wuzhu.module.bpm.framework.flowable.core.candidate.strategy;

import org.lifxue.wuzhu.framework.common.util.string.StrUtils;
import org.lifxue.wuzhu.module.bpm.framework.flowable.core.candidate.BpmTaskCandidateStrategy;
import org.lifxue.wuzhu.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
import org.lifxue.wuzhu.module.system.api.permission.PermissionApi;
import org.lifxue.wuzhu.module.system.api.permission.RoleApi;
import jakarta.annotation.Resource;
import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 角色 {@link BpmTaskCandidateStrategy} 实现类
 *
 * @author kyle
 */
@Component
public class BpmTaskCandidateRoleStrategy implements BpmTaskCandidateStrategy {

    @Resource
    private RoleApi roleApi;
    @Resource
    private PermissionApi permissionApi;

    @Override
    public BpmTaskCandidateStrategyEnum getStrategy() {
        return BpmTaskCandidateStrategyEnum.ROLE;
    }

    @Override
    public void validateParam(String param) {
        Set<Long> roleIds = StrUtils.splitToLongSet(param);
        roleApi.validRoleList(roleIds);
    }

    @Override
    public Set<Long> calculateUsers(DelegateExecution execution, String param) {
        Set<Long> roleIds = StrUtils.splitToLongSet(param);
        return permissionApi.getUserRoleIdListByRoleIds(roleIds);
    }

}