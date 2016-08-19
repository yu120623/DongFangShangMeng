package com.szdfc.entitylib;

import java.util.List;

/**
 * Created by HGo on 2016/8/16.
 */
public class ThirdPartyEntity {
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

        private ResourceEntity resourceEntity;

        private int tid;
        private String tname;
        private String tdesc;
        private String turl;

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

        public ResourceEntity getResourceEntity() {
            return resourceEntity;
        }

        public void setResourceEntity(ResourceEntity resourceEntity) {
            this.resourceEntity = resourceEntity;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getTdesc() {
            return tdesc;
        }

        public void setTdesc(String tdesc) {
            this.tdesc = tdesc;
        }

        public String getTurl() {
            return turl;
        }

        public void setTurl(String turl) {
            this.turl = turl;
        }
    }

}
