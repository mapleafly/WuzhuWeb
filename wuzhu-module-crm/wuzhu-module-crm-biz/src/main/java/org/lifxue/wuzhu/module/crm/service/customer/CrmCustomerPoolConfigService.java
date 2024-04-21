package org.lifxue.wuzhu.module.crm.service.customer;

import org.lifxue.wuzhu.module.crm.controller.admin.customer.vo.poolconfig.CrmCustomerPoolConfigSaveReqVO;
import org.lifxue.wuzhu.module.crm.dal.dataobject.customer.CrmCustomerPoolConfigDO;

import jakarta.validation.Valid;

/**
 * 客户公海配置 Service 接口
 *
 * @author Wanwan
 */
public interface CrmCustomerPoolConfigService {

    /**
     * 获得客户公海配置
     *
     * @return 客户公海配置
     */
    CrmCustomerPoolConfigDO getCustomerPoolConfig();

    /**
     * 保存客户公海配置
     *
     * @param saveReqVO 更新信息
     */
    void saveCustomerPoolConfig(@Valid CrmCustomerPoolConfigSaveReqVO saveReqVO);

}
