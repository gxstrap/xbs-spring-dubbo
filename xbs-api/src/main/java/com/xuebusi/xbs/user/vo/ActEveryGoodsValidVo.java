package com.xuebusi.xbs.user.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 每人拼统一黑盒验证Vo
 *
 * @Author: syj
 * @CreateDate: 2018/7/31 16:19
 */
public class ActEveryGoodsValidVo implements Serializable {

    /**
     * 活动id
     */
    private String activeId;

    /**
     * 商品列表
     */
    private List<ActEveryGoodVo> goodVoList;

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public List<ActEveryGoodVo> getGoodVoList() {
        return goodVoList;
    }

    public void setGoodVoList(List<ActEveryGoodVo> goodVoList) {
        this.goodVoList = goodVoList;
    }
}
