package org.lifxue.wuzhu.module.promotion.api.combination;

import org.lifxue.wuzhu.module.promotion.api.combination.dto.CombinationRecordCreateReqDTO;
import org.lifxue.wuzhu.module.promotion.api.combination.dto.CombinationRecordCreateRespDTO;
import org.lifxue.wuzhu.module.promotion.api.combination.dto.CombinationValidateJoinRespDTO;
import org.lifxue.wuzhu.module.promotion.convert.combination.CombinationActivityConvert;
import org.lifxue.wuzhu.module.promotion.dal.dataobject.combination.CombinationRecordDO;
import org.lifxue.wuzhu.module.promotion.enums.combination.CombinationRecordStatusEnum;
import org.lifxue.wuzhu.module.promotion.service.combination.CombinationRecordService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static org.lifxue.wuzhu.framework.common.exception.util.ServiceExceptionUtil.exception;
import static org.lifxue.wuzhu.module.promotion.enums.ErrorCodeConstants.COMBINATION_RECORD_NOT_EXISTS;

/**
 * 拼团活动 API 实现类
 *
 * @author HUIHUI
 */
@Service
@Validated
public class CombinationRecordApiImpl implements CombinationRecordApi {

    @Resource
    private CombinationRecordService combinationRecordService;

    @Override
    public void validateCombinationRecord(Long userId, Long activityId, Long headId, Long skuId, Integer count) {
        combinationRecordService.validateCombinationRecord(userId, activityId, headId, skuId, count);
    }

    @Override
    public CombinationRecordCreateRespDTO createCombinationRecord(CombinationRecordCreateReqDTO reqDTO) {
        return CombinationActivityConvert.INSTANCE.convert4(combinationRecordService.createCombinationRecord(reqDTO));
    }

    @Override
    public boolean isCombinationRecordSuccess(Long userId, Long orderId) {
        CombinationRecordDO record = combinationRecordService.getCombinationRecord(userId, orderId);
        if (record == null) {
            throw exception(COMBINATION_RECORD_NOT_EXISTS);
        }
        return CombinationRecordStatusEnum.isSuccess(record.getStatus());
    }

    @Override
    public CombinationValidateJoinRespDTO validateJoinCombination(Long userId, Long activityId, Long headId, Long skuId, Integer count) {
        return combinationRecordService.validateJoinCombination(userId, activityId, headId, skuId, count);
    }

}
