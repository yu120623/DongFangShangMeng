package com.szdfc.entitylib;

import java.util.Comparator;
import java.util.List;

/**
 * Created by HGo on 2016/7/28.
 */
public class TrainStationEntity {
    private String resultcode;
    private String reason;

    private List<ResultBean> result;
    private int error_code;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public static class ResultBean implements Comparator<ResultBean> {
        private String sta_name;
        private String sta_ename;
        private String sta_code;

        private String sortLetters;

        public String getSortLetters() {
            return sortLetters;
        }

        public void setSortLetters(String sortLetters) {
            this.sortLetters = sortLetters;
        }

        public String getSta_name() {
            return sta_name;
        }

        public void setSta_name(String sta_name) {
            this.sta_name = sta_name;
        }

        public String getSta_ename() {
            return sta_ename;
        }

        public void setSta_ename(String sta_ename) {
            this.sta_ename = sta_ename;
        }

        public String getSta_code() {
            return sta_code;
        }

        public void setSta_code(String sta_code) {
            this.sta_code = sta_code;
        }

        @Override
        public int compare(ResultBean resultBean, ResultBean t1) {
            return resultBean.getSortLetters().compareTo(t1.getSortLetters());
        }
    }
}
