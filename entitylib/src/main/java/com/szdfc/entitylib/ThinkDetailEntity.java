package com.szdfc.entitylib;

/**
 * Created by HGo on 2016/8/12.
 */
public class ThinkDetailEntity {

    /**
     * resulecode : 10000
     * reason : 请求成功
     * result : {"thinkTankType":{"createdBy":"啊啊啊","createdTime":1469503106000,"updatedBy":"啊啊啊","updatedTime":1469503115000,"ttypeName":"智囊团","ttypeId":2},"createdBy":"啊啊啊","createdTime":1470636963000,"updatedBy":"啊啊啊","updatedTime":1469503187000,"tid":1,"tintro":"v深V给对方高富帅","tdesc":"阿斯顿撒旦","tname":"我问问"}
     */

    private String resulecode;
    private String reason;
    /**
     * thinkTankType : {"createdBy":"啊啊啊","createdTime":1469503106000,"updatedBy":"啊啊啊","updatedTime":1469503115000,"ttypeName":"智囊团","ttypeId":2}
     * createdBy : 啊啊啊
     * createdTime : 1470636963000
     * updatedBy : 啊啊啊
     * updatedTime : 1469503187000
     * tid : 1
     * tintro : v深V给对方高富帅
     * tdesc : 阿斯顿撒旦
     * tname : 我问问
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
        /**
         * createdBy : 啊啊啊
         * createdTime : 1469503106000
         * updatedBy : 啊啊啊
         * updatedTime : 1469503115000
         * ttypeName : 智囊团
         * ttypeId : 2
         */

        private ThinkTankTypeBean thinkTankType;
        private String createdBy;
        private long createdTime;
        private String updatedBy;
        private long updatedTime;
        private int tid;
        private String tintro;
        private String tdesc;
        private String tname;

        public ThinkTankTypeBean getThinkTankType() {
            return thinkTankType;
        }

        public void setThinkTankType(ThinkTankTypeBean thinkTankType) {
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

        public String getTintro() {
            return tintro;
        }

        public void setTintro(String tintro) {
            this.tintro = tintro;
        }

        public String getTdesc() {
            return tdesc;
        }

        public void setTdesc(String tdesc) {
            this.tdesc = tdesc;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public static class ThinkTankTypeBean {
            private String createdBy;
            private long createdTime;
            private String updatedBy;
            private long updatedTime;
            private String ttypeName;
            private int ttypeId;

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

            public String getTtypeName() {
                return ttypeName;
            }

            public void setTtypeName(String ttypeName) {
                this.ttypeName = ttypeName;
            }

            public int getTtypeId() {
                return ttypeId;
            }

            public void setTtypeId(int ttypeId) {
                this.ttypeId = ttypeId;
            }
        }
    }
}
