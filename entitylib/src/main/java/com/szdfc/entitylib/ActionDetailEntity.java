package com.szdfc.entitylib;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by FreeMason on 2016/8/25.
 */
public class ActionDetailEntity implements Serializable {

    /**
     * resulecode : 10000
     * reason : 请求成功
     * result : {"conId":2,"conTitle":"走心辞职信","conDesc":"asdas","conContent":"自行车从自行车自行车自行车现在从自行车自行车","startTime":"2016/08/08 06:14","endTime":"2016/08/08 06:14","createdBy":"啊啊啊","createdTime":"2016/07/27 05:13","updatedBy":"啊啊啊","updatedTime":"2016/07/27 05:14"}
     */

    private String resulecode;
    private String reason;
    /**
     * conId : 2
     * conTitle : 走心辞职信
     * conDesc : asdas
     * conContent : 自行车从自行车自行车自行车现在从自行车自行车
     * startTime : 2016/08/08 06:14
     * endTime : 2016/08/08 06:14
     * createdBy : 啊啊啊
     * createdTime : 2016/07/27 05:13
     * updatedBy : 啊啊啊
     * updatedTime : 2016/07/27 05:14
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
        private int conId;
        private String conTitle;
        private String conDesc;
        private String conContent;
        private Date startTime;
        private Date endTime;
        private String createdBy;
        private String createdTime;
        private String updatedBy;
        private String updatedTime;

        public int getConId() {
            return conId;
        }

        public void setConId(int conId) {
            this.conId = conId;
        }

        public String getConTitle() {
            return conTitle;
        }

        public void setConTitle(String conTitle) {
            this.conTitle = conTitle;
        }

        public String getConDesc() {
            return conDesc;
        }

        public void setConDesc(String conDesc) {
            this.conDesc = conDesc;
        }

        public String getConContent() {
            return conContent;
        }

        public void setConContent(String conContent) {
            this.conContent = conContent;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public String getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(String updatedTime) {
            this.updatedTime = updatedTime;
        }
    }
}
