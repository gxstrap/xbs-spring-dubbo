package com.xuebusi.xbs.user.api;

import com.xuebusi.xbs.rpc.storage.Request;
import com.xuebusi.xbs.rpc.storage.Response;
import com.xuebusi.xbs.user.dto.MallActivityMRPDto;
import com.xuebusi.xbs.user.dto.MallActivityMRPTimeDto;
import com.xuebusi.xbs.user.vo.MallActivityMRPVo;

/**
 * 每人拼黑盒校验接口
 */
public interface IMallActivityApi {

    /**
     * 活动时间验证
     * @param paramRequest
     * @return
     */
    Response<Boolean> activityMRPCheckTime(Request<MallActivityMRPTimeDto> paramRequest);

    /**
     * 添加商品验证
     * @param paramRequest
     * @return
     */
    Response<MallActivityMRPVo> activityMRPAddGoods(Request<MallActivityMRPDto> paramRequest);

    /**
     * 成拼人数验证
     * @param paramRequest
     * @return
     */
    Response<MallActivityMRPVo> activityMRPCheckMemberCount(Request<MallActivityMRPDto> paramRequest);

    /**
     * 更新/保存活动验证
     * @param paramRequest
     * @return
     */
    Response<MallActivityMRPVo> activityMRPCreate(Request<MallActivityMRPDto> paramRequest);

    /**
     * 商品下线验证
     * @param paramRequest
     * @return
     */
    Response<MallActivityMRPVo> activityMRPRemoveGoods(Request<MallActivityMRPDto> paramRequest);
}
