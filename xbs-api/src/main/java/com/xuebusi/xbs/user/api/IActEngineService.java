package com.xuebusi.xbs.user.api;

import com.xuebusi.xbs.rpc.storage.Request;
import com.xuebusi.xbs.rpc.storage.Response;
import com.xuebusi.xbs.user.dto.ActEveryGoodsValidDto;
import com.xuebusi.xbs.user.vo.ActEveryGoodsValidVo;

/**
 * 引擎Dubbo活动接口
 *
 * @Author: syj
 * @CreateDate: 2018/7/30 18:28
 */
public interface IActEngineService {

    /**
     * 每人拼时间验证(黑盒)
     * @param request
     * @return
     */
    Response<Boolean> actEveryGoodsTimeValid(Request<ActEveryGoodsValidDto> request);

    /**
     * 每人拼添加商品验证(黑盒)
     * @param request
     * @return
     */
    Response<ActEveryGoodsValidVo> actEveryGoodsAddValid(Request<ActEveryGoodsValidDto> request);

    /**
     * 每人拼成拼人数校验(黑盒)
     * @param request
     * @return
     */
    Response<ActEveryGoodsValidVo> actEveryGoodsCountValid(Request<ActEveryGoodsValidDto> request);

    /**
     * 保存每人拼活动验证(黑盒)
     * @param request
     * @return
     */
    Response<ActEveryGoodsValidVo> actEveryActiveSubmitValid(Request<ActEveryGoodsValidDto> request);

    /**
     * 每人拼商品下架验证(黑盒)
     * @param request
     * @return
     */
    Response<ActEveryGoodsValidVo> actEveryGoodsUnderValid(Request<ActEveryGoodsValidDto> request);

}
