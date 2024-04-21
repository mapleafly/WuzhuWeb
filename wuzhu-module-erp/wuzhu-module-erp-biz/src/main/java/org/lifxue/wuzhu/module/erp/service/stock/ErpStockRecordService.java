package org.lifxue.wuzhu.module.erp.service.stock;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.module.erp.controller.admin.stock.vo.record.ErpStockRecordPageReqVO;
import org.lifxue.wuzhu.module.erp.dal.dataobject.stock.ErpStockRecordDO;
import org.lifxue.wuzhu.module.erp.service.stock.bo.ErpStockRecordCreateReqBO;
import jakarta.validation.Valid;

/**
 * ERP 产品库存明细 Service 接口
 *
 * @author 芋道源码
 */
public interface ErpStockRecordService {

    /**
     * 获得产品库存明细
     *
     * @param id 编号
     * @return 产品库存明细
     */
    ErpStockRecordDO getStockRecord(Long id);

    /**
     * 获得产品库存明细分页
     *
     * @param pageReqVO 分页查询
     * @return 产品库存明细分页
     */
    PageResult<ErpStockRecordDO> getStockRecordPage(ErpStockRecordPageReqVO pageReqVO);

    /**
     * 创建库存明细
     *
     * @param createReqBO 创建库存明细 BO
     */
    void createStockRecord(@Valid ErpStockRecordCreateReqBO createReqBO);

}