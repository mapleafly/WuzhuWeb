package org.lifxue.wuzhu.module.product.service.comment;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.module.member.api.user.MemberUserApi;
import org.lifxue.wuzhu.module.member.api.user.dto.MemberUserRespDTO;
import org.lifxue.wuzhu.module.product.api.comment.dto.ProductCommentCreateReqDTO;
import org.lifxue.wuzhu.module.product.controller.admin.comment.vo.ProductCommentCreateReqVO;
import org.lifxue.wuzhu.module.product.controller.admin.comment.vo.ProductCommentPageReqVO;
import org.lifxue.wuzhu.module.product.controller.admin.comment.vo.ProductCommentReplyReqVO;
import org.lifxue.wuzhu.module.product.controller.admin.comment.vo.ProductCommentUpdateVisibleReqVO;
import org.lifxue.wuzhu.module.product.controller.app.comment.vo.AppCommentPageReqVO;
import org.lifxue.wuzhu.module.product.convert.comment.ProductCommentConvert;
import org.lifxue.wuzhu.module.product.dal.dataobject.comment.ProductCommentDO;
import org.lifxue.wuzhu.module.product.dal.dataobject.sku.ProductSkuDO;
import org.lifxue.wuzhu.module.product.dal.dataobject.spu.ProductSpuDO;
import org.lifxue.wuzhu.module.product.dal.mysql.comment.ProductCommentMapper;
import org.lifxue.wuzhu.module.product.service.sku.ProductSkuService;
import org.lifxue.wuzhu.module.product.service.spu.ProductSpuService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

import static org.lifxue.wuzhu.framework.common.exception.util.ServiceExceptionUtil.exception;
import static org.lifxue.wuzhu.module.product.enums.ErrorCodeConstants.*;

/**
 * 商品评论 Service 实现类
 *
 * @author wangzhs
 */
@Service
@Validated
public class ProductCommentServiceImpl implements ProductCommentService {

    @Resource
    private ProductCommentMapper productCommentMapper;

    @Resource
    private ProductSpuService productSpuService;

    @Resource
    @Lazy
    private ProductSkuService productSkuService;

    @Resource
    private MemberUserApi memberUserApi;

    @Override
    public void createComment(ProductCommentCreateReqVO createReqVO) {
        // 校验 SKU
        ProductSkuDO sku = validateSku(createReqVO.getSkuId());
        // 校验 SPU
        ProductSpuDO spu = validateSpu(sku.getSpuId());

        // 创建评论
        ProductCommentDO comment = ProductCommentConvert.INSTANCE.convert(createReqVO, spu, sku);
        productCommentMapper.insert(comment);
    }

    @Override
    public Long createComment(ProductCommentCreateReqDTO createReqDTO) {
        // 校验 SKU
        ProductSkuDO sku = validateSku(createReqDTO.getSkuId());
        // 校验 SPU
        ProductSpuDO spu = validateSpu(sku.getSpuId());
        // 校验评论
        validateCommentExists(createReqDTO.getUserId(), createReqDTO.getOrderId());
        // 获取用户详细信息
        MemberUserRespDTO user = memberUserApi.getUser(createReqDTO.getUserId());

        // 创建评论
        ProductCommentDO comment = ProductCommentConvert.INSTANCE.convert(createReqDTO, spu, sku, user);
        productCommentMapper.insert(comment);
        return comment.getId();
    }

    /**
     * 判断当前订单的当前商品用户是否评价过
     *
     * @param userId      用户编号
     * @param orderItemId 订单项编号
     */
    private void validateCommentExists(Long userId, Long orderItemId) {
        ProductCommentDO exist = productCommentMapper.selectByUserIdAndOrderItemId(userId, orderItemId);
        if (exist != null) {
            throw exception(COMMENT_ORDER_EXISTS);
        }
    }

    private ProductSkuDO validateSku(Long skuId) {
        ProductSkuDO sku = productSkuService.getSku(skuId);
        if (sku == null) {
            throw exception(SKU_NOT_EXISTS);
        }
        return sku;
    }

    private ProductSpuDO validateSpu(Long spuId) {
        ProductSpuDO spu = productSpuService.getSpu(spuId);
        if (null == spu) {
            throw exception(SPU_NOT_EXISTS);
        }
        return spu;
    }

    @Override
    public void updateCommentVisible(ProductCommentUpdateVisibleReqVO updateReqVO) {
        // 校验评论是否存在
        validateCommentExists(updateReqVO.getId());

        // 更新可见状态
        productCommentMapper.updateById(new ProductCommentDO().setId(updateReqVO.getId())
                .setVisible(true));
    }

    @Override
    public void replyComment(ProductCommentReplyReqVO replyVO, Long userId) {
        // 校验评论是否存在
        validateCommentExists(replyVO.getId());
        // 回复评论
        productCommentMapper.updateById(new ProductCommentDO().setId(replyVO.getId())
                .setReplyTime(LocalDateTime.now()).setReplyUserId(userId)
                .setReplyStatus(Boolean.TRUE).setReplyContent(replyVO.getReplyContent()));
    }

    private ProductCommentDO validateCommentExists(Long id) {
        ProductCommentDO productComment = productCommentMapper.selectById(id);
        if (productComment == null) {
            throw exception(COMMENT_NOT_EXISTS);
        }
        return productComment;
    }

    @Override
    public PageResult<ProductCommentDO> getCommentPage(AppCommentPageReqVO pageVO, Boolean visible) {
        return productCommentMapper.selectPage(pageVO, visible);
    }

    @Override
    public PageResult<ProductCommentDO> getCommentPage(ProductCommentPageReqVO pageReqVO) {
        return productCommentMapper.selectPage(pageReqVO);
    }

}
