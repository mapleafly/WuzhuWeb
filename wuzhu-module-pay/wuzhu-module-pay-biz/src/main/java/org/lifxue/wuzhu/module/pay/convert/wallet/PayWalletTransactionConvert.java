package org.lifxue.wuzhu.module.pay.convert.wallet;

import org.lifxue.wuzhu.framework.common.pojo.PageResult;
import org.lifxue.wuzhu.module.pay.controller.admin.wallet.vo.transaction.PayWalletTransactionRespVO;
import org.lifxue.wuzhu.module.pay.controller.app.wallet.vo.transaction.AppPayWalletTransactionRespVO;
import org.lifxue.wuzhu.module.pay.dal.dataobject.wallet.PayWalletTransactionDO;
import org.lifxue.wuzhu.module.pay.service.wallet.bo.WalletTransactionCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletTransactionConvert {

    PayWalletTransactionConvert INSTANCE = Mappers.getMapper(PayWalletTransactionConvert.class);

    PageResult<PayWalletTransactionRespVO> convertPage2(PageResult<PayWalletTransactionDO> page);

    PayWalletTransactionDO convert(WalletTransactionCreateReqBO bean);

}
