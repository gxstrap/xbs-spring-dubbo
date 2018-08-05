package com.xuebusi.xbs.user.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 每人拼统一黑盒验证Dto
 *
 * @Author: syj
 * @CreateDate: 2018/7/31 15:34
 */
public class ActEveryGoodsValidDto implements Serializable {

    /**
     * 活动id
     */
    private String activeId;

    /**
     * 活动开始时间
     */
    private String activeStartTime;

    /**
     * 活动结束时间
     */
    private String activeEndTime;

    /**
     * 商品列表
     */
    private List<ActEveryGoodDto> goodsList;

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getActiveStartTime() {
        return activeStartTime;
    }

    public void setActiveStartTime(String activeStartTime) {
        this.activeStartTime = activeStartTime;
    }

    public String getActiveEndTime() {
        return activeEndTime;
    }

    public void setActiveEndTime(String activeEndTime) {
        this.activeEndTime = activeEndTime;
    }

    public List<ActEveryGoodDto> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ActEveryGoodDto> goodsList) {
        this.goodsList = goodsList;
    }
}
