package com.szdfc.entitylib;

/**
 * Created by FreeMason on 2016/8/25.
 */
public class NewsDetailEntity {

    /**
     * resulecode : 10000
     * reason : 请求成功
     * result : {"createdBy":"啊啊啊","createdTime":1469590000000,"updatedBy":"啊啊啊","updatedTime":1469590005000,"ndesc":"现在从中选出","ntitle":"是电风扇的","neditor":"第三方第三方士大夫士大夫的身份","ntimePublish":1469589985000,"ncontent":"v分v梵蒂冈梵蒂冈的风格的风格的风格的非官方大哥大法官 ","nid":1}
     */

    private String resulecode;
    private String reason;
    /**
     * createdBy : 啊啊啊
     * createdTime : 1469590000000
     * updatedBy : 啊啊啊
     * updatedTime : 1469590005000
     * ndesc : 现在从中选出
     * ntitle : 是电风扇的
     * neditor : 第三方第三方士大夫士大夫的身份
     * ntimePublish : 1469589985000
     * ncontent : v分v梵蒂冈梵蒂冈的风格的风格的风格的非官方大哥大法官
     * nid : 1
     */

    private ResultBean result;

    public String getResulecode() {
        return resulecode;
    }

    public void setResulecode(String resulecode) {
        this.resulecode = resulecode;
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

    public static class ResultBean {
        private String createdBy;
        private long createdTime;
        private String updatedBy;
        private long updatedTime;
        private String ndesc;
        private String ntitle;
        private String neditor;
        private long ntimePublish;
        private String ncontent;
        private int nid;

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public long getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(long createdTime) {
            this.createdTime = createdTime;
        }

        public String getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public long getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(long updatedTime) {
            this.updatedTime = updatedTime;
        }

        public String getNdesc() {
            return ndesc;
        }

        public void setNdesc(String ndesc) {
            this.ndesc = ndesc;
        }

        public String getNtitle() {
            return ntitle;
        }

        public void setNtitle(String ntitle) {
            this.ntitle = ntitle;
        }

        public String getNeditor() {
            return neditor;
        }

        public void setNeditor(String neditor) {
            this.neditor = neditor;
        }

        public long getNtimePublish() {
            return ntimePublish;
        }

        public void setNtimePublish(long ntimePublish) {
            this.ntimePublish = ntimePublish;
        }

        public String getNcontent() {
            return ncontent;
        }

        public void setNcontent(String ncontent) {
            this.ncontent = ncontent;
        }

        public int getNid() {
            return nid;
        }

        public void setNid(int nid) {
            this.nid = nid;
        }
    }
}
