package com.xuebusi.xbs.rpc.storage;

import java.io.Serializable;
import java.util.UUID;

public class Response<T> implements Serializable {
    private static final long serialVersionUID = -4255935577442133607L;
    private int code = 200;
    private String sid;
    private T data;
    private boolean success;
    private String performance;
    private String errorCode;
    private String errorMsg;
    private Throwable exception;
    private long requestTime;

    public Response() {
    }

    private Response(String sid, long requestTime) {
        this.sid = sid;
        this.requestTime = requestTime;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return this.data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return this.sid;
    }

    public static <T> Response<T> create() {
        String sid = UUID.randomUUID().toString();
        long requestTime = System.currentTimeMillis();
        return new Response(sid, requestTime);
    }

    public static <T> Response<T> create(String sid) {
        long requestTime = System.currentTimeMillis();
        return new Response(sid, requestTime);
    }

    public void setData(T data) {
        this.data = data;
        this.setSuccess(true);
        this.setPerformance(this.executionTime());
    }

    public void success(T data) {
        this.data = data;
        this.setSuccess(true);
        this.setPerformance(this.executionTime());
    }

    public void failure(String errorCode, String errorMsg) {
        this.setErrorCode(errorCode);
        this.setErrorMsg(errorMsg);
        this.setSuccess(false);
        this.setPerformance(this.executionTime());
    }

    public void failure(String errorMsg) {
        this.failure((String)null, errorMsg);
        this.setSuccess(false);
        this.setPerformance(this.executionTime());
    }

    public void failure(Throwable exception) {
        this.exception = exception;
        this.setSuccess(false);
        this.setPerformance(this.executionTime());
    }

    public long executionTime() {
        long performance = (System.currentTimeMillis() - this.requestTime) / 1000L;
        return performance;
    }

    public String toString() {
        return "Response [code=" + this.code + ", sid=" + this.sid + ", data=" + this.data + ", success=" + this.success + ", performance=" + this.performance + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", exception=" + this.exception + "]";
    }

    public String getPerformance() {
        return this.performance;
    }

    public void setPerformance(long performance) {
    }

    public static void main(String[] args) throws InterruptedException {
        Response<String> response = create();
        Thread.sleep(1000L);
        response.setData("Hello");
        System.out.println(response);
    }
}
