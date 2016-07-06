package com.szdfc.dfsm.http;

/**
 * Created by FreeMason on 2016/5/4.
 */
public class HttpError {

    private ErrorType errorType;
    private String msg;


    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public enum ErrorType{
        SERVER_ERROR//服务器异常
        ,APP_ERROR//数据逻辑异常
    };
}
