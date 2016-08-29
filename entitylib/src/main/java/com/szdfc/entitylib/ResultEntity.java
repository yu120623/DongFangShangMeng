package com.szdfc.entitylib;

/**
 * Created by HGo on 2016/8/23.
 */
public class ResultEntity {
    private String resultcode;
    private String reason;

    private ResultBean result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }
}
