package com.szdfc.entitylib;

import java.util.Comparator;
import java.util.List;

/**
 * Created by HGo on 2016/7/25.
 */
public class CityEntity {

    private String resultcode;
    private String reason;

    private List<ResultBean> result;
    private int error_code;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean implements Comparator<ResultBean> {
        private String city;
        private String spell;

        private String sortLetters;

        public String getSortLetters() {
            return sortLetters;
        }

        public void setSortLetters(String sortLetters) {
            this.sortLetters = sortLetters;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getSpell() {
            return spell;
        }

        public void setSpell(String spell) {
            this.spell = spell;
        }

        @Override
        public int compare(ResultBean resultBean, ResultBean t1) {
            return resultBean.getSortLetters().compareTo(t1.getSortLetters());
        }
    }
}
