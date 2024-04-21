package org.lifxue.wuzhu.module.promotion.controller.app.article.vo.article;

import org.lifxue.wuzhu.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "应用 App - 文章的分页 Request VO")
@Data
public class AppArticlePageReqVO extends PageParam {

    @Schema(description = "分类编号", example = "2048")
    private Long categoryId;

}
