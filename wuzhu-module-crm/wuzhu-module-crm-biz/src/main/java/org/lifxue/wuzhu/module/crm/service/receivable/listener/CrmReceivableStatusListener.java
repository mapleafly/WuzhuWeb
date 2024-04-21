package org.lifxue.wuzhu.module.crm.service.receivable.listener;

import org.lifxue.wuzhu.module.bpm.event.BpmProcessInstanceStatusEvent;
import org.lifxue.wuzhu.module.bpm.event.BpmProcessInstanceStatusEventListener;
import org.lifxue.wuzhu.module.crm.service.receivable.CrmReceivableService;
import org.lifxue.wuzhu.module.crm.service.receivable.CrmReceivableServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 回款审批的结果的监听器实现类
 *
 * @author HUIHUI
 */
@Component
public class CrmReceivableStatusListener extends BpmProcessInstanceStatusEventListener {

    @Resource
    private CrmReceivableService receivableService;

    @Override
    public String getProcessDefinitionKey() {
        return CrmReceivableServiceImpl.BPM_PROCESS_DEFINITION_KEY;
    }

    @Override
    public void onEvent(BpmProcessInstanceStatusEvent event) {
        receivableService.updateReceivableAuditStatus(Long.parseLong(event.getBusinessKey()), event.getStatus());
    }

}
