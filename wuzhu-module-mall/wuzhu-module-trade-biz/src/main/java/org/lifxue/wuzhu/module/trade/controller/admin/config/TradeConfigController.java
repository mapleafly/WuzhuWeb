package org.lifxue.wuzhu.module.trade.controller.admin.config;

import org.lifxue.wuzhu.framework.common.pojo.CommonResult;
import org.lifxue.wuzhu.module.trade.controller.admin.config.vo.TradeConfigRespVO;
import org.lifxue.wuzhu.module.trade.controller.admin.config.vo.TradeConfigSaveReqVO;
import org.lifxue.wuzhu.module.trade.convert.config.TradeConfigConvert;
import org.lifxue.wuzhu.module.trade.dal.dataobject.config.TradeConfigDO;
import org.lifxue.wuzhu.module.trade.service.config.TradeConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

import static org.lifxue.wuzhu.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 交易中心配置")
@RestController
@RequestMapping("/trade/config")
@Validated
public class TradeConfigController {

    @Resource
    private TradeConfigService tradeConfigService;

    @Value("${wuzhu.tencent-lbs-key}")
    private String tencentLbsKey;

    @PutMapping("/save")
    @Operation(summary = "更新交易中心配置")
    @PreAuthorize("@ss.hasPermission('trade:config:save')")
    public CommonResult<Boolean> updateConfig(@Valid @RequestBody TradeConfigSaveReqVO updateReqVO) {
        tradeConfigService.saveTradeConfig(updateReqVO);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得交易中心配置")
    @PreAuthorize("@ss.hasPermission('trade:config:query')")
    public CommonResult<TradeConfigRespVO> getConfig() {
        TradeConfigDO config = tradeConfigService.getTradeConfig();
        TradeConfigRespVO configVO = TradeConfigConvert.INSTANCE.convert(config);
        if (configVO != null) {
            configVO.setTencentLbsKey(tencentLbsKey);
        }
        return success(configVO);
    }

}
