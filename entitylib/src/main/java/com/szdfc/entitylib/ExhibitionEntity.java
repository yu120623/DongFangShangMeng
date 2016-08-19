package com.szdfc.entitylib;

import java.util.List;

/**
 * Created by HGo on 2016/8/9.
 */
public class ExhibitionEntity {

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

        private int enrolNum;
        private int eid;
        private String etitle;
        private String eaddress;
        private String edesc;
        private long estartDate;
        private long eendDate;
        private String econtent;

        private ResourceEntity resourceEntity;

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public long getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(int createdTime) {
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

        public void setUpdatedTime(int updatedTime) {
            this.updatedTime = updatedTime;
        }

        public int getEnrolNum() {
            return enrolNum;
        }

        public void setEnrolNum(int enrolNum) {
            this.enrolNum = enrolNum;
        }

        public int getEid() {
            return eid;
        }

        public void setEid(int eid) {
            this.eid = eid;
        }

        public String getEtitle() {
            return etitle;
        }

        public void setEtitle(String etitle) {
            this.etitle = etitle;
        }

        public String getEaddress() {
            return eaddress;
        }

        public void setEaddress(String eaddress) {
            this.eaddress = eaddress;
        }

        public String getEdesc() {
            return edesc;
        }

        public void setEdesc(String edesc) {
            this.edesc = edesc;
        }

        public long getEstartDate() {
            return estartDate;
        }

        public void setEstartDate(int estartDate) {
            this.estartDate = estartDate;
        }

        public long getEendDate() {
            return eendDate;
        }

        public void setEendDate(int eendDate) {
            this.eendDate = eendDate;
        }

        public String getEcontent() {
            return econtent;
        }

        public void setEcontent(String econtent) {
            this.econtent = econtent;
        }

        public ResourceEntity getResourceEntity() {
            return resourceEntity;
        }

        public void setResourceEntity(ResourceEntity resourceEntity) {
            this.resourceEntity = resourceEntity;
        }
    }
}