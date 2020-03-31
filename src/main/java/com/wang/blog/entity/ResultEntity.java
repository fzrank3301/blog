package com.wang.blog.entity;


public class ResultEntity {
    public static final int SUCCESS = 10;
    public static final int FAILED = 20;
    public static final int ERROR = 30;

    private Integer state;
    private String msg;
    private String errormsg;
    private Object Data;

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public Integer getState() {
        return state;
    }

    public ResultEntity setState(Integer state) {
        this.state = state;
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public ResultEntity setMsg(String msg) {
        this.msg = msg;
        return null;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }


    @Override
    public String toString() {
        return "ResultEntity{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", errormsg='" + errormsg + '\'' +
                '}';
    }
}
