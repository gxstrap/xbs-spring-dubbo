package com.xuebusi.xbs.user.dto;

import java.io.Serializable;
import java.util.List;

public class MallActivityMRPDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 活动id 非必填 有就填
     */
    private String xswccprmuksmxswcc;

    /**
     * 活动开始时间
     */
    private String xswccmetiartstxswcc;

    /**
     * 活动结束时间
     */
    private String xswccmetienexswcc;

    private List<MallActivityMRPGoodsDto> xswccdsgoostlixswcc;

    public String getXswccprmuksmxswcc() {
        return this.xswccprmuksmxswcc;
    }

    public void setXswccprmuksmxswcc(String xswccprmuksmxswcc) {
        this.xswccprmuksmxswcc = xswccprmuksmxswcc;
    }

    public String getXswccmetiartstxswcc() {
        return this.xswccmetiartstxswcc;
    }

    public void setXswccmetiartstxswcc(String xswccmetiartstxswcc) {
        this.xswccmetiartstxswcc = xswccmetiartstxswcc;
    }

    public String getXswccmetienexswcc() {
        return this.xswccmetienexswcc;
    }

    public void setXswccmetienexswcc(String xswccmetienexswcc) {
        this.xswccmetienexswcc = xswccmetienexswcc;
    }

    public List<MallActivityMRPGoodsDto> getXswccdsgoostlixswcc() {
        return this.xswccdsgoostlixswcc;
    }

    public void setXswccdsgoostlixswcc(List<MallActivityMRPGoodsDto> xswccdsgoostlixswcc) {
        this.xswccdsgoostlixswcc = xswccdsgoostlixswcc;
    }
}
