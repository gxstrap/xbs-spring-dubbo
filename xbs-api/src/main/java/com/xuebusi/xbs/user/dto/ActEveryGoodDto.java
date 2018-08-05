package com.xuebusi.xbs.user.dto;

import java.io.Serializable;

/**
 * 每人拼活动商品Dto
 *
 * @Author: syj
 * @CreateDate: 2018/7/31 16:04
 */
public class ActEveryGoodDto implements Serializable {

    /**
     * objID
     */
    private String goodsObjectID;

    /**
     * skuid
     */
    private String goodsSKUID;

    /**
     * 锁定库存
     */
    private String goodsLockedInventory;

    /**
     * 市场价
     */
    private String goodsMarketPrice;

    /**
     * 结算价
     */
    private String goodsBalancePrice;

    /**
     * 每人拼价
     */
    private String goodsMRPPrice;

    /**
     * 成团人数
     */
    private String goodsGroupMember;

    /**
     * 最小成团人数
     */
    private String goodsGroupMemberMin;

    /**
     * 成团有效时间
     */
    private String goodsActivityEffectiveTime;

    /**
     * sku价格更新时间
     */
    private String skuPriceUpdateTime;

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

    public String getGoodsLockedInventory() {
        return goodsLockedInventory;
    }

    public void setGoodsLockedInventory(String goodsLockedInventory) {
        this.goodsLockedInventory = goodsLockedInventory;
    }

    public String getGoodsMarketPrice() {
        return goodsMarketPrice;
    }

    public void setGoodsMarketPrice(String goodsMarketPrice) {
        this.goodsMarketPrice = goodsMarketPrice;
    }

    public String getGoodsBalancePrice() {
        return goodsBalancePrice;
    }

    public void setGoodsBalancePrice(String goodsBalancePrice) {
        this.goodsBalancePrice = goodsBalancePrice;
    }

    public String getGoodsMRPPrice() {
        return goodsMRPPrice;
    }

    public void setGoodsMRPPrice(String goodsMRPPrice) {
        this.goodsMRPPrice = goodsMRPPrice;
    }

    public String getGoodsGroupMember() {
        return goodsGroupMember;
    }

    public void setGoodsGroupMember(String goodsGroupMember) {
        this.goodsGroupMember = goodsGroupMember;
    }

    public String getGoodsGroupMemberMin() {
        return goodsGroupMemberMin;
    }

    public void setGoodsGroupMemberMin(String goodsGroupMemberMin) {
        this.goodsGroupMemberMin = goodsGroupMemberMin;
    }

    public String getGoodsActivityEffectiveTime() {
        return goodsActivityEffectiveTime;
    }

    public void setGoodsActivityEffectiveTime(String goodsActivityEffectiveTime) {
        this.goodsActivityEffectiveTime = goodsActivityEffectiveTime;
    }

    public String getSkuPriceUpdateTime() {
        return skuPriceUpdateTime;
    }

    public void setSkuPriceUpdateTime(String skuPriceUpdateTime) {
        this.skuPriceUpdateTime = skuPriceUpdateTime;
    }
}
