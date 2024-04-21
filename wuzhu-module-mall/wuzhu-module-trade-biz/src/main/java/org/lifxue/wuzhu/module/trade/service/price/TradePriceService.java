package org.lifxue.wuzhu.module.trade.service.price;

import org.lifxue.wuzhu.module.trade.service.price.bo.TradePriceCalculateReqBO;
import org.lifxue.wuzhu.module.trade.service.price.bo.TradePriceCalculateRespBO;

import jakarta.validation.Valid;

/**
 * 价格计算 Service 接口
 *
 * @author 芋道源码
 */
public interface TradePriceService {

    /**
     * 价格计算
     *
     * @param calculateReqDTO 计算信息
     * @return 计算结果
     */
    TradePriceCalculateRespBO calculatePrice(@Valid TradePriceCalculateReqBO calculateReqDTO);

}
