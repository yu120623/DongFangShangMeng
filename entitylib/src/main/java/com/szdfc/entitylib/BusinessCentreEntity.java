package com.szdfc.entitylib;

import java.util.List;

/**
 * Created by HGo on 2016/8/18.
 */
public class BusinessCentreEntity {
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

        private int bid;
        private String btitle;
        private String bdesc;
        private String baddress;
        private long bstartTime;
        private long bendTime;
        private String bintro;

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

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
        }

        public String getBtitle() {
            return btitle;
        }

        public void setBtitle(String btitle) {
            this.btitle = btitle;
        }

        public String getBdesc() {
            return bdesc;
        }

        public void setBdesc(String bdesc) {
            this.bdesc = bdesc;
        }

        public String getBaddress() {
            return baddress;
        }

        public void setBaddress(String baddress) {
            this.baddress = baddress;
        }

        public long getBstartTime() {
            return bstartTime;
        }

        public void setBstartTime(long bstartTime) {
            this.bstartTime = bstartTime;
        }

        public long getBendTime() {
            return bendTime;
        }

        public void setBendTime(long bendTime) {
            this.bendTime = bendTime;
        }

        public String getBintro() {
            return bintro;
        }

        public void setBintro(String bintro) {
            this.bintro = bintro;
        }
    }
}
