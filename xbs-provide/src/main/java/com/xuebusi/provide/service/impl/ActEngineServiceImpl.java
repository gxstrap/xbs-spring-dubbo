package com.xuebusi.provide.service.impl;

import com.xuebusi.xbs.rpc.storage.Request;
import com.xuebusi.xbs.rpc.storage.Response;
import com.xuebusi.xbs.user.api.IActEngineService;
import com.xuebusi.xbs.user.api.IMallActivityApi;
import com.xuebusi.xbs.user.dto.*;
import com.xuebusi.xbs.user.vo.ActEveryGoodVo;
import com.xuebusi.xbs.user.vo.ActEveryGoodsValidVo;
import com.xuebusi.xbs.user.vo.MallActivityMRPGoodsVo;
import com.xuebusi.xbs.user.vo.MallActivityMRPVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: syj
 * @CreateDate: 2018/7/30 18:31
 */
@Service("actEngineServiceImplRpc")
public class ActEngineServiceImpl implements IActEngineService {

    @Autowired
    private IMallActivityApi mallActivityApi;

    /**
     * 每人拼时间验证
     *
     * @param request
     * @return
     */
    @Override
    public Response<Boolean> actEveryGoodsTimeValid(Request<ActEveryGoodsValidDto> request) {
        Request<MallActivityMRPTimeDto> req = Request.create();
        ActEveryGoodsValidDto validDto = request.getData();

        MallActivityMRPTimeDto dto = new MallActivityMRPTimeDto();
        dto.setXswccmetiartstxswcc(validDto.getActiveStartTime());
        dto.setXswccmetienexswcc(validDto.getActiveEndTime());

        req.setData(dto);
        Response<Boolean> result = null;
        try {
            result = mallActivityApi.activityMRPCheckTime(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 每人拼添加商品验证
     *
     * @param request
     * @return
     */
    @Override
    public Response<ActEveryGoodsValidVo> actEveryGoodsAddValid(Request<ActEveryGoodsValidDto> request) {
        Request<MallActivityMRPDto> req = Request.create(Request.clientUID());
        Response<ActEveryGoodsValidVo> res = Response.create(request.getSid());

        /*ActEveryGoodsValidDto validDto = request.getData();
        MallActivityMRPDto dto = new MallActivityMRPDto();
        dto.setXswccprmuksmxswcc(validDto.getActiveId());
        List<ActEveryGoodDto> goodsList = validDto.getGoodsList();
        List<MallActivityMRPGoodsDto> dtoList = new ArrayList<>();
        for (ActEveryGoodDto goodDto : goodsList) {
            MallActivityMRPGoodsDto goodsDto = new MallActivityMRPGoodsDto();
            goodsDto.setXswccyuksmxswcc(goodDto.getGoodsSKUID());
            goodsDto.setXswccprmjgxswcc(goodDto.getGoodsMRPPrice());
            goodsDto.setXswccsxxptrxswcc(goodDto.getGoodsGroupMemberMin());
            dtoList.add(goodsDto);
        }
        dto.setXswccdsgoostlixswcc(dtoList);*/

        ActEveryGoodsValidDto validDto = request.getData();
        MallActivityMRPDto dto = getMallActivityMRPDto(validDto);

        req.setData(dto);
        Response<MallActivityMRPVo> result = null;
        try {
            result = mallActivityApi.activityMRPAddGoods(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null) {
            res.setErrorCode("");
            res.setErrorMsg("");
            return res;
        }
        MallActivityMRPVo vo = result.getData();
        ActEveryGoodsValidVo validVo = getActEveryGoodsValidVo(vo);
        res.success(validVo);
        return res;
    }

    /**
     * 每人拼成拼人数校验
     *
     * @param request
     * @return
     */
    @Override
    public Response<ActEveryGoodsValidVo> actEveryGoodsCountValid(Request<ActEveryGoodsValidDto> request) {
        Request<MallActivityMRPDto> req = Request.create(request.getSid());
        Response<ActEveryGoodsValidVo> res = Response.create(request.getSid());

        /*ActEveryGoodsValidDto validDto = request.getData();
        MallActivityMRPDto dto = new MallActivityMRPDto();
        dto.setXswccprmuksmxswcc(validDto.getActiveId());

        List<MallActivityMRPGoodsDto> mrpGoodsDtoList = new ArrayList<>();
        List<ActEveryGoodDto> goodsList = validDto.getGoodsList();
        for (ActEveryGoodDto goodDto : goodsList) {
            MallActivityMRPGoodsDto mrpGoodsDto = new MallActivityMRPGoodsDto();
            mrpGoodsDto.setXswccodogsjectobdixwscc(goodDto.getGoodsObjectID());
            mrpGoodsDto.setXswccyuksmxswcc(goodDto.getGoodsSKUID());
            mrpGoodsDto.setXswccctrsxswcc(goodDto.getGoodsGroupMember());
            mrpGoodsDtoList.add(mrpGoodsDto);
        }
        dto.setXswccdsgoostlixswcc(mrpGoodsDtoList);*/

        ActEveryGoodsValidDto validDto = request.getData();
        MallActivityMRPDto dto = getMallActivityMRPDto(validDto);

        req.setData(dto);
        Response<MallActivityMRPVo> result = null;
        try {
            result = mallActivityApi.activityMRPCheckMemberCount(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null) {
            res.setErrorCode("");
            res.setErrorMsg("");
            return res;
        }
        MallActivityMRPVo vo = result.getData();
        ActEveryGoodsValidVo validVo = getActEveryGoodsValidVo(vo);
        res.success(validVo);
        return res;
    }

    /**
     * 保存每人拼活动验证
     *
     * @param request
     * @return
     */
    @Override
    public Response<ActEveryGoodsValidVo> actEveryActiveSubmitValid(Request<ActEveryGoodsValidDto> request) {
        Request<MallActivityMRPDto> req = Request.create(request.getSid());
        Response<ActEveryGoodsValidVo> res = Response.create(request.getSid());

       /* ActEveryGoodsValidDto validDto = request.getData();
        MallActivityMRPDto dto = new MallActivityMRPDto();
        dto.setXswccprmuksmxswcc(validDto.getActiveId());
        dto.setXswccmetiartstxswcc(validDto.getActiveStartTime());
        dto.setXswccmetienexswcc(validDto.getActiveEndTime());

        List<ActEveryGoodDto> goodsList = validDto.getGoodsList();
        List<MallActivityMRPGoodsDto> mrpGoodsDtoList = new ArrayList<>();
        for (ActEveryGoodDto goodDto : goodsList) {
            MallActivityMRPGoodsDto mrpGoodsDto = new MallActivityMRPGoodsDto();
            mrpGoodsDto.setXswccodogsjectobdixwscc(goodDto.getGoodsObjectID());
            mrpGoodsDto.setXswccyuksmxswcc(goodDto.getGoodsSKUID());
            mrpGoodsDto.setXswccctrsxswcc(goodDto.getGoodsGroupMember());
            mrpGoodsDto.setXswcckskczvxswcc(goodDto.getGoodsLockedInventory());
            mrpGoodsDto.setXswccdgptzqxswcc(goodDto.getGoodsActivityEffectiveTime());
            mrpGoodsDto.setXswccprmjgxswcc(goodDto.getGoodsMRPPrice());
            mrpGoodsDtoList.add(mrpGoodsDto);
        }
        dto.setXswccdsgoostlixswcc(mrpGoodsDtoList);*/

        ActEveryGoodsValidDto validDto = request.getData();
        MallActivityMRPDto dto = getMallActivityMRPDto(validDto);

        req.setData(dto);
        Response<MallActivityMRPVo> result = mallActivityApi.activityMRPCreate(req);
        if (result == null) {
            res.setErrorCode("");
            res.setErrorMsg("");
            return res;
        }
        MallActivityMRPVo vo = result.getData();
        ActEveryGoodsValidVo validVo = getActEveryGoodsValidVo(vo);
        res.success(validVo);
        return res;
    }

    /**
     * 每人拼商品下架验证
     *
     * @param request
     * @return
     */
    @Override
    public Response<ActEveryGoodsValidVo> actEveryGoodsUnderValid(Request<ActEveryGoodsValidDto> request) {

        Response<ActEveryGoodsValidVo> res = Response.create(request.getSid());
        Request<MallActivityMRPDto> req = Request.create(request.getSid());

        /*ActEveryGoodsValidDto validDto = request.getData();
        MallActivityMRPDto dto = new MallActivityMRPDto();
        dto.setXswccprmuksmxswcc(validDto.getActiveId());

        List<ActEveryGoodDto> goodsList = validDto.getGoodsList();
        List<MallActivityMRPGoodsDto> mrpGoodsDtoList = new ArrayList<>();
        for (ActEveryGoodDto goodDto : goodsList) {
            MallActivityMRPGoodsDto mrpGoodsDto = new MallActivityMRPGoodsDto();
            mrpGoodsDto.setXswccodogsjectobdixwscc(goodDto.getGoodsObjectID());
            mrpGoodsDto.setXswccyuksgxsjxswcc(goodDto.getGoodsSKUID());
            mrpGoodsDtoList.add(mrpGoodsDto);
        }

        dto.setXswccdsgoostlixswcc(mrpGoodsDtoList);*/

        ActEveryGoodsValidDto validDto = request.getData();
        MallActivityMRPDto dto = getMallActivityMRPDto(validDto);

        req.setData(dto);
        Response<MallActivityMRPVo> result = mallActivityApi.activityMRPRemoveGoods(req);
        if (result == null) {
            res.setErrorCode("");
            res.setErrorMsg("");
            return res;
        }
        MallActivityMRPVo vo = result.getData();
        ActEveryGoodsValidVo validVo = getActEveryGoodsValidVo(vo);
        res.success(validVo);
        return res;
    }

    /**
     * 每人拼黑盒接口统一入参
     *
     * @param validDto
     * @return
     */
    private MallActivityMRPDto getMallActivityMRPDto(ActEveryGoodsValidDto validDto) {
        MallActivityMRPDto dto = new MallActivityMRPDto();
        dto.setXswccprmuksmxswcc(validDto.getActiveId());
        List<ActEveryGoodDto> goodsList = validDto.getGoodsList();
        List<MallActivityMRPGoodsDto> dtoList = new ArrayList<>();
        for (ActEveryGoodDto goodDto : goodsList) {
            MallActivityMRPGoodsDto mrpGoodsDto = new MallActivityMRPGoodsDto();
            mrpGoodsDto.setXswccodogsjectobdixwscc(goodDto.getGoodsObjectID());
            mrpGoodsDto.setXswccyuksmxswcc(goodDto.getGoodsSKUID());
            mrpGoodsDto.setXswcckskczvxswcc(goodDto.getGoodsLockedInventory());
            mrpGoodsDto.setXswccjscxswcc(goodDto.getGoodsMarketPrice());
            mrpGoodsDto.setXswccjjsxswcc(goodDto.getGoodsBalancePrice());
            mrpGoodsDto.setXswccprmjgxswcc(goodDto.getGoodsMRPPrice());
            mrpGoodsDto.setXswccctrsxswcc(goodDto.getGoodsGroupMember());
            // TODO 校正后的拼团人数
            mrpGoodsDto.setXswccsxxptrxswcc("");
            mrpGoodsDto.setXswccdgptzqxswcc(goodDto.getGoodsActivityEffectiveTime());
            // TODO sku价格更新时间
            mrpGoodsDto.setXswccyuksgxsjxswcc(goodDto.getSkuPriceUpdateTime());
            dtoList.add(mrpGoodsDto);
        }
        dto.setXswccdsgoostlixswcc(dtoList);
        return dto;
    }

    /**
     * 每人拼黑盒接口统一出参
     *
     * @param vo
     * @return
     */
    private ActEveryGoodsValidVo getActEveryGoodsValidVo(MallActivityMRPVo vo) {
        ActEveryGoodsValidVo validVo = new ActEveryGoodsValidVo();
        validVo.setActiveId(vo.getXswccprmuksmxswcc());

        List<MallActivityMRPGoodsVo> mrpGoodsVoList = vo.getXswccdsgoostlixswcc();
        List<ActEveryGoodVo> everyGoodVoList = new ArrayList<>();
        for (MallActivityMRPGoodsVo mrpGoodsVo : mrpGoodsVoList) {
            ActEveryGoodVo everyGoodVo = new ActEveryGoodVo();
            everyGoodVo.setGoodsObjectID(mrpGoodsVo.getXswccodogsjectobdixwscc());
            everyGoodVo.setGoodsSKUID(mrpGoodsVo.getXswccyuksmxswcc());
            everyGoodVo.setGoodsMRPPrice(mrpGoodsVo.getXswccsxxptrxswcc());
            everyGoodVo.setGoodsGroupMemberMin(mrpGoodsVo.getXswccprmjgxswcc());
            everyGoodVo.setResult(mrpGoodsVo.getXswccltresuxswcc());
            everyGoodVo.setMsg(mrpGoodsVo.getXswccgmsxswcc());
            everyGoodVoList.add(everyGoodVo);
        }
        validVo.setGoodVoList(everyGoodVoList);
        return validVo;
    }

}
