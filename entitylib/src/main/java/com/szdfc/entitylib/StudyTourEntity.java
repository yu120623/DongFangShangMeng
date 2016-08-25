package com.szdfc.entitylib;

import java.util.Date;
import java.util.List;

/**
 * Created by HGo on 2016/8/15.
 */
public class StudyTourEntity {
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
        private Date createdTime;
        private String updatedBy;
        private Date updatedTime;

        private String sdesc;
        private String sname;
        private String sintro;
        private int sid;

        private ResourceEntity resourceEntity;

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public Date getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(Date createdTime) {
            this.createdTime = createdTime;
        }

        public String getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public Date getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(Date updatedTime) {
            this.updatedTime = updatedTime;
        }

        public String getSdesc() {
            return sdesc;
        }

        public void setSdesc(String sdesc) {
            this.sdesc = sdesc;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getSintro() {
            return sintro;
        }

        public void setSintro(String sintro) {
            this.sintro = sintro;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public ResourceEntity getResourceEntity() {
            return resourceEntity;
        }

        public void setResourceEntity(ResourceEntity resourceEntity) {
            this.resourceEntity = resourceEntity;
        }
    }
}
