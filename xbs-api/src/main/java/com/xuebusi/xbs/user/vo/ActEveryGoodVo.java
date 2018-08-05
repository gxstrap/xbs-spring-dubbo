package com.xuebusi.xbs.user.vo;

import java.io.Serializable;

/**
 * 每人拼活动商品Vo
 *
 * @Author: syj
 * @CreateDate: 2018/7/31 16:19
 */
public class ActEveryGoodVo implements Serializable {

    /**
     * objID
     */
    private String goodsObjectID;

    /**
     * skuid
     */
    private String goodsSKUID;

    /**
     * 每人拼价
     */
    private String goodsMRPPrice;

    /**
     * 最小成团人数
     */
    private String goodsGroupMemberMin;

    /**
     * 本条记录是否可以参加活动 0：否 1：可以
     */
    private String result;

    /**
     * 不可参加原因
     */
    private String msg;

    public String getGoodsObjectID() {
        return goodsObjectID;
    }

    public void setGoodsObjectID(String goodsObjectID) {
        this.goodsObjectID = goodsObjectID;
    }

    public String getGoodsSKUID() {
        return goodsSKUID;
    }

    public void setGoodsSKUID(String goodsSKUID) {
        this.goodsSKUID = goodsSKUID;
    }

    public String getGoodsMRPPrice() {
        return goodsMRPPrice;
    }

    public void setGoodsMRPPrice(String goodsMRPPrice) {
        this.goodsMRPPrice = goodsMRPPrice;
    }

    public String getGoodsGroupMemberMin() {
        return goodsGroupMemberMin;
    }

    public void setGoodsGroupMemberMin(String goodsGroupMemberMin) {
        this.goodsGroupMemberMin = goodsGroupMemberMin;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
