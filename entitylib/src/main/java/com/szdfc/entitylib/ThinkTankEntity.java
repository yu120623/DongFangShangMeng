package com.szdfc.entitylib;

import java.util.List;

/**
 * Created by HGo on 2016/8/11.
 */
public class ThinkTankEntity {

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

        private TType thinkTankType;

        private String createdBy;
        private long createdTime;
        private String updatedBy;
        private long updatedTime;

        private int tid;
        private String tname;
        private String tdesc;
        private String tintro;

        private ResourceEntity resourceEntity;

        public static class TType {
            private String createdBy;
            private long createdTime;
            private String updatedBy;
            private long updatedTime;

            private int ttypeId;
            private String ttypeName;

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

            public int getTtypeId() {
                return ttypeId;
            }

            public void setTtypeId(int ttypeId) {
                this.ttypeId = ttypeId;
            }

            public String getTtypeName() {
                return ttypeName;
            }

            public void setTtypeName(String ttypeName) {
                this.ttypeName = ttypeName;
            }
        }

        public TType getThinkTankType() {
            return thinkTankType;
        }

        public void setThinkTankType(TType thinkTankType) {
            this.thinkTankType = thinkTankType;
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

        public String getTintro() {
            return tintro;
        }

        public void setTintro(String tintro) {
            this.tintro = tintro;
        }

        public ResourceEntity getResourceEntity() {
            return resourceEntity;
        }

        public void setResourceEntity(ResourceEntity resourceEntity) {
            this.resourceEntity = resourceEntity;
        }
    }
}
