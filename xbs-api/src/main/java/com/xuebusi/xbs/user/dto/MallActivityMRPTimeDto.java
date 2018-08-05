package com.xuebusi.xbs.user.dto;

import java.io.Serializable;

public class MallActivityMRPTimeDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 活动开始时间 必填
     * 如 2018-08-02 19:23:22
     */
    private String xswccmetiartstxswcc;

    /**
     * 活动结束时间 必填
     * 如 2018-08-02 19:23:22
     */
    private String xswccmetienexswcc;

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
}
