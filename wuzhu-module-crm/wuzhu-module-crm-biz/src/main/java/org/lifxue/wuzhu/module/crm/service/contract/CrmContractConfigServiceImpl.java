package org.lifxue.wuzhu.module.crm.service.contract;

import org.lifxue.wuzhu.framework.common.util.object.BeanUtils;
import org.lifxue.wuzhu.module.crm.controller.admin.contract.vo.config.CrmContractConfigSaveReqVO;
import org.lifxue.wuzhu.module.crm.dal.dataobject.contract.CrmContractConfigDO;
import org.lifxue.wuzhu.module.crm.dal.mysql.contract.CrmContractConfigMapper;
import com.mzt.logapi.context.LogRecordContext;
import com.mzt.logapi.starter.annotation.LogRecord;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

import static org.lifxue.wuzhu.module.crm.enums.LogRecordConstants.*;

/**
 * 合同配置 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CrmContractConfigServiceImpl implements CrmContractConfigService {

    @Resource
    private CrmContractConfigMapper contractConfigMapper;

    @Override
    public CrmContractConfigDO getContractConfig() {
        return contractConfigMapper.selectOne();
    }

    @Override
    @LogRecord(type = CRM_CONTRACT_CONFIG_TYPE, subType = CRM_CONTRACT_CONFIG_SUB_TYPE, bizNo = "{{#configId}}",
            success = CRM_CONTRACT_CONFIG_SUCCESS)
    public void saveContractConfig(CrmContractConfigSaveReqVO saveReqVO) {
        // 1. 存在，则进行更新
        CrmContractConfigDO dbConfig = getContractConfig();
        CrmContractConfigDO config = BeanUtils.toBean(saveReqVO, CrmContractConfigDO.class);
        if (Objects.nonNull(dbConfig)) {
            contractConfigMapper.updateById(config.setId(dbConfig.getId()));
            // 记录操作日志上下文
            LogRecordContext.putVariable("isConfigUpdate", Boolean.TRUE);
            LogRecordContext.putVariable("configId", config.getId());
            return;
        }

        // 2. 不存在，则进行插入
        contractConfigMapper.insert(config);
        // 记录操作日志上下文
        LogRecordContext.putVariable("isConfigUpdate", Boolean.FALSE);
        LogRecordContext.putVariable("configId", config.getId());
    }

}
