package org.lifxue.wuzhu.module.crm.controller.admin.statistics.vo.portrait;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static org.lifxue.wuzhu.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - CRM 客户画像 Request VO")
@Data
public class CrmStatisticsPortraitReqVO {

    @Schema(description = "部门 id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "部门 id 不能为空")
    private Long deptId;

    /**
     * 负责人用户 id, 当用户为空, 则计算部门下用户
     */
    @Schema(description = "负责人用户 id", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1")
    private Long userId;

    /**
     * userIds 目前不用前端传递，目前是方便后端通过 deptId 读取编号后，设置回来
     * 后续，可能会支持选择部分用户进行查询
     */
    @Schema(description = "负责人用户 id 集合", hidden = true, example = "2")
    private List<Long> userIds;

    /**
     * 前端如果选择自定义时间, 那么前端传递起始-终止时间, 如果选择其他时间间隔类型, 则由后台计算起始-终止时间
     * 并作为参数传递给Mapper
     */
    @Schema(description = "时间范围", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] times;

}
