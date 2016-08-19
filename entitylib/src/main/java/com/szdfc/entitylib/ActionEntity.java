package com.szdfc.entitylib;

import java.util.List;

/**
 * Created by HGo on 2016/8/16.
 */
public class ActionEntity {
    private String resultcode;
    private String reason;

    private List<ResultBean> result;

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

    public static class ResultBean {
        private String createdBy;
        private long createdTime;
        private String updatedBy;
        private long updatedTime;

        private int conId;
        private String conTitle;
        private String conDesc;
        private String conContent;
        private long startTime;
        private long endTime;

        private ResourceEntity resource;

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

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public ResourceEntity getResource() {
            return resource;
        }

        public void setResource(ResourceEntity resource) {
            this.resource = resource;
        }
    }


}
