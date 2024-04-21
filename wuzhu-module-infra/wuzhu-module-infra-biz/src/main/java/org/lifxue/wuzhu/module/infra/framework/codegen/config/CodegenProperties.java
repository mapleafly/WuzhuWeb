package org.lifxue.wuzhu.module.infra.framework.codegen.config;

import org.lifxue.wuzhu.module.infra.enums.codegen.CodegenFrontTypeEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Collection;

@ConfigurationProperties(prefix = "wuzhu.codegen")
@Validated
@Data
public class CodegenProperties {

    /**
     * 生成的 Java 代码的基础包
     */
    @NotNull(message = "Java 代码的基础包不能为空")
    private String basePackage;

    /**
     * 数据库名数组
     */
    @NotEmpty(message = "数据库不能为空")
    private Collection<String> dbSchemas;

    /**
     * 代码生成的前端类型（默认）
     *
     * 枚举 {@link CodegenFrontTypeEnum#getType()}
     */
    @NotNull(message = "代码生成的前端类型不能为空")
    private Integer frontType;

}
