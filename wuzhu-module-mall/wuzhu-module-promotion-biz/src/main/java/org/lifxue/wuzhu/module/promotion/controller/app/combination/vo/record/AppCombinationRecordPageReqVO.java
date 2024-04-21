package org.lifxue.wuzhu.module.promotion.controller.app.combination.vo.record;

import org.lifxue.wuzhu.framework.common.pojo.PageParam;
import org.lifxue.wuzhu.framework.common.validation.InEnum;
import org.lifxue.wuzhu.module.promotion.enums.combination.CombinationRecordStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "用户 App - 拼团记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppCombinationRecordPageReqVO extends PageParam {

    @Schema(description = "拼团状态", example = "1")
    @InEnum(value = CombinationRecordStatusEnum.class, message = "拼团状态必须是 {value}")
    private Integer status;

}
