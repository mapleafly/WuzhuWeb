package org.lifxue.wuzhu.module.trade.framework.delivery.core.client;

import org.lifxue.wuzhu.module.trade.framework.delivery.core.client.dto.ExpressTrackQueryReqDTO;
import org.lifxue.wuzhu.module.trade.framework.delivery.core.client.dto.ExpressTrackRespDTO;

import java.util.List;

/**
 * 快递客户端接口
 *
 * @author jason
 */
public interface ExpressClient {

    /**
     * 快递实时查询
     *
     * @param reqDTO 查询请求参数
     */
    // TODO @jason：返回字段可以参考 https://doc.youzanyun.com/detail/API/0/5 响应的 data
    List<ExpressTrackRespDTO> getExpressTrackList(ExpressTrackQueryReqDTO reqDTO);

}