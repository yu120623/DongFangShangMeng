package com.szdfc.entitylib;

import java.util.List;

/**
 * Created by HGo on 2016/8/12.
 */
public class NewsEntity {
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

        private int nid;
        private String ntitle;
        private String neditor;
        private String ndesc;
        private long ntimePublish;
        private String ncontent;

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

        public int getNid() {
            return nid;
        }

        public void setNid(int nid) {
            this.nid = nid;
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

        public String getNdesc() {
            return ndesc;
        }

        public void setNdesc(String ndesc) {
            this.ndesc = ndesc;
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

        public ResourceEntity getResourceEntity() {
            return resourceEntity;
        }

        public void setResourceEntity(ResourceEntity resourceEntity) {
            this.resourceEntity = resourceEntity;
        }

        public static class ResourceEntity {
            private boolean searchFromPage;
            private int resourceId;
            private String resourceName;
            private String resourceType;
            private String resourceLocation;
            private String referrenceObjectId;

            private String createdBy;
            private long createdTime;
            private String updatedBy;
            private long updatedTime;

            public boolean isSearchFromPage() {
                return searchFromPage;
            }

            public void setSearchFromPage(boolean searchFromPage) {
                this.searchFromPage = searchFromPage;
            }

            public int getResourceId() {
                return resourceId;
            }

            public void setResourceId(int resourceId) {
                this.resourceId = resourceId;
            }

            public String getResourceName() {
                return resourceName;
            }

            public void setResourceName(String resourceName) {
                this.resourceName = resourceName;
            }

            public String getResourceType() {
                return resourceType;
            }

            public void setResourceType(String resourceType) {
                this.resourceType = resourceType;
            }

            public String getResourceLocation() {
                return resourceLocation;
            }

            public void setResourceLocation(String resourceLocation) {
                this.resourceLocation = resourceLocation;
            }

            public String getReferrenceObjectId() {
                return referrenceObjectId;
            }

            public void setReferrenceObjectId(String referrenceObjectId) {
                this.referrenceObjectId = referrenceObjectId;
            }

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
        }
    }
}
