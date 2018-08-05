package com.xuebusi.xbs.user.vo;

import java.io.Serializable;
import java.util.List;

public class MallActivityMRPVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
    private String xswccprmuksmxswcc;

    private List<MallActivityMRPGoodsVo> xswccdsgoostlixswcc;

    public String getXswccprmuksmxswcc() {
        return this.xswccprmuksmxswcc;
    }

    public void setXswccprmuksmxswcc(String xswccprmuksmxswcc) {
        this.xswccprmuksmxswcc = xswccprmuksmxswcc;
    }

    public List<MallActivityMRPGoodsVo> getXswccdsgoostlixswcc() {
        return this.xswccdsgoostlixswcc;
    }

    public void setXswccdsgoostlixswcc(List<MallActivityMRPGoodsVo> xswccdsgoostlixswcc) {
        this.xswccdsgoostlixswcc = xswccdsgoostlixswcc;
    }
}
