package org.lifxue.wuzhu.module.trade.service.price.calculator;

import cn.hutool.core.util.ObjectUtil;
import org.lifxue.wuzhu.module.member.api.level.MemberLevelApi;
import org.lifxue.wuzhu.module.member.api.level.dto.MemberLevelRespDTO;
import org.lifxue.wuzhu.module.member.api.user.MemberUserApi;
import org.lifxue.wuzhu.module.member.api.user.dto.MemberUserRespDTO;
import org.lifxue.wuzhu.module.promotion.enums.common.PromotionTypeEnum;
import org.lifxue.wuzhu.module.trade.enums.order.TradeOrderTypeEnum;
import org.lifxue.wuzhu.module.trade.service.price.bo.TradePriceCalculateReqBO;
import org.lifxue.wuzhu.module.trade.service.price.bo.TradePriceCalculateRespBO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

import static org.lifxue.wuzhu.module.trade.service.price.calculator.TradePriceCalculatorHelper.formatPrice;

/**
 * 会员 VIP 折扣的 {@link TradePriceCalculator} 实现类
 *
 * @author 芋道源码
 */
@Component
@Order(TradePriceCalculator.ORDER_MEMBER_LEVEL)
public class TradeMemberLevelPriceCalculator implements TradePriceCalculator {

    @Resource
    private MemberLevelApi memberLevelApi;
    @Resource
    private MemberUserApi memberUserApi;

    @Override
    public void calculate(TradePriceCalculateReqBO param, TradePriceCalculateRespBO result) {
        // 0. 只有【普通】订单，才计算该优惠
        if (ObjectUtil.notEqual(result.getType(), TradeOrderTypeEnum.NORMAL.getType())) {
            return;
        }
        // 1. 获得用户的会员等级
        MemberUserRespDTO user = memberUserApi.getUser(param.getUserId());
        if (user.getLevelId() == null || user.getLevelId() <= 0) {
            return;
        }
        MemberLevelRespDTO level = memberLevelApi.getMemberLevel(user.getLevelId());
        if (level == null || level.getDiscountPercent() == null) {
            return;
        }

        // 2. 计算每个 SKU 的优惠金额
        result.getItems().forEach(orderItem -> {
            // 2.1 计算优惠金额
            Integer vipPrice = calculateVipPrice(orderItem.getPayPrice(), level.getDiscountPercent());
            if (vipPrice <= 0) {
                return;
            }

            // 2.2 记录优惠明细
            if (orderItem.getSelected()) {
                // 注意，只有在选中的情况下，才会记录到优惠明细。否则仅仅是更新 SKU 优惠金额，用于展示
                TradePriceCalculatorHelper.addPromotion(result, orderItem,
                        level.getId(), level.getName(), PromotionTypeEnum.MEMBER_LEVEL.getType(),
                        String.format("会员等级折扣：省 %s 元", formatPrice(vipPrice)),
                        vipPrice);
            }

            // 2.3 更新 SKU 的优惠金额
            orderItem.setVipPrice(vipPrice);
            TradePriceCalculatorHelper.recountPayPrice(orderItem);
        });
        TradePriceCalculatorHelper.recountAllPrice(result);
    }

    /**
     * 计算会员 VIP 优惠价格
     *
     * @param price 原价
     * @param discountPercent 折扣
     * @return 优惠价格
     */
    public Integer calculateVipPrice(Integer price, Integer discountPercent) {
        if (discountPercent == null) {
            return 0;
        }
        Integer newPrice = price * discountPercent / 100;
        return price - newPrice;
    }

}
