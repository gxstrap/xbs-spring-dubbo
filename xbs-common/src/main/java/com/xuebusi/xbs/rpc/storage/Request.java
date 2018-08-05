package com.xuebusi.xbs.rpc.storage;

import java.io.Serializable;
import java.util.UUID;

public class Request<T> implements Serializable {
    private static final long serialVersionUID = -4255935577442133607L;
    private String sid;
    private Long reqTime;
    private T data;
    private String ip;

    private Request(T data) {
        if (data == null) {
            throw new RuntimeException("REQUEST_PARAM_NUMBER_ERROR");
        } else {
            this.data = data;
            this.reqTime = System.currentTimeMillis();
            //this.ip = RpcNetworkUtil.localAddress();
            this.setSid(clientUID());
        }
    }

    private Request(String sid) {
        this.sid = sid;
        this.reqTime = System.currentTimeMillis();
        //this.ip = RpcNetworkUtil.localAddress();
    }

    public void setSid(String sid) {
        if (this.sid == null) {
            this.sid = sid;
        }

    }


    public Request() {
    }

    public static <T> Request<T> create() {
        return new Request();
    }

    public static <T> Request<T> create(String sid) {
        return new Request(sid);
    }

    public static <T> Request<T> create(T data) {
        if (data == null) {
            throw new RuntimeException("REQUEST_PARAM_NUMBER_ERROR");
        } else {
            return new Request(data);
        }
    }

    public static String clientUID() {
        StringBuilder process = new StringBuilder();
        process.append(UUID.randomUUID().toString());
        return process.toString();
    }

    public Long getReqTime() {
        return this.reqTime;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        if (data == null) {
            throw new RuntimeException("REQUEST_PARAM_NUMBER_ERROR");
        } else {
            this.data = data;
            this.setSid(clientUID());
            this.reqTime = System.currentTimeMillis();
            //this.ip = RpcNetworkUtil.localAddress();
        }
    }

    public String getIp() {
        return this.ip;
    }

    public String getSid() {
        return this.sid;
    }

    @Override
    public String toString() {
        return "Request{" +
                "sid='" + sid + '\'' +
                ", reqTime=" + reqTime +
                ", data=" + data +
                ", ip='" + ip + '\'' +
                '}';
    }
}
