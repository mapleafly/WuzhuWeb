package org.lifxue.wuzhu.module.system.framework.datapermission.config;

import org.lifxue.wuzhu.module.system.dal.dataobject.dept.DeptDO;
import org.lifxue.wuzhu.module.system.dal.dataobject.user.AdminUserDO;
import org.lifxue.wuzhu.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * system 模块的数据权限 Configuration
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
public class DataPermissionConfiguration {

    @Bean
    public DeptDataPermissionRuleCustomizer sysDeptDataPermissionRuleCustomizer() {
        return rule -> {
            // dept
            rule.addDeptColumn(AdminUserDO.class);
            rule.addDeptColumn(DeptDO.class, "id");
            // user
            rule.addUserColumn(AdminUserDO.class, "id");
        };
    }

}
