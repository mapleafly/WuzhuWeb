package org.lifxue.wuzhu.module.infra.api.logger;

import org.lifxue.wuzhu.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import org.lifxue.wuzhu.module.infra.service.logger.ApiErrorLogService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

/**
 * API 访问日志的 API 接口
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ApiErrorLogApiImpl implements ApiErrorLogApi {

    @Resource
    private ApiErrorLogService apiErrorLogService;

    @Override
    public void createApiErrorLog(ApiErrorLogCreateReqDTO createDTO) {
        apiErrorLogService.createApiErrorLog(createDTO);
    }

}
