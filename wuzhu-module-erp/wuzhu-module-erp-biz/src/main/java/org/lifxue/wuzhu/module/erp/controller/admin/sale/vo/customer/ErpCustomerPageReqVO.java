package org.lifxue.wuzhu.module.erp.controller.admin.sale.vo.customer;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import org.lifxue.wuzhu.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static org.lifxue.wuzhu.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - ERP 客户分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpCustomerPageReqVO extends PageParam {

    @Schema(description = "客户名称", example = "张三")
    private String name;

    @Schema(description = "手机号码", example = "15601691300")
    private String mobile;

    @Schema(description = "联系电话", example = "15601691300")
    private String telephone;

}