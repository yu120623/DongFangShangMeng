package com.szdfc.entitylib;

import java.io.Serializable;
import java.util.List;

/**
 * Created by FreeMason on 2016/8/25.
 */
public class BussinessSchoolDetailEntity implements Serializable {

    /**
     * resulecode : 10000
     * reason : 请求成功
     * result : {"createdBy":"啊啊啊","createdTime":1470120259000,"updatedBy":"啊啊啊","updatedTime":1470120263000,"resourceEntities":[{"searchFromPage":false,"resourceId":74,"resourceName":"img","resourceType":"BSD_IMG","resourceLocation":"http://oss-cn-shanghai.aliyuncs.com/yqt-tm/1463020081948.jpg","referrenceObjectId":"1","createdBy":"admin","createdTime":1462970154000,"updatedBy":"admin","updatedTime":1462970154000},{"searchFromPage":false,"resourceId":76,"resourceName":"img","resourceType":"BSD_IMG","resourceLocation":"http://oss-cn-shanghai.aliyuncs.com/yqt-tm/1463020081948.jpg","referrenceObjectId":"1","createdBy":"admin","createdTime":1462970154000,"updatedBy":"admin","updatedTime":1462970154000},{"searchFromPage":false,"resourceId":77,"resourceName":"img","resourceType":"BSD_IMG","resourceLocation":"http://oss-cn-shanghai.aliyuncs.com/yqt-tm/1463020081948.jpg","referrenceObjectId":"1","createdBy":"admin","createdTime":1462970154000,"updatedBy":"admin","updatedTime":1462970154000}],"bshare":"收水电费水电费水电费等所发生的法规和规范价格还看见了就看了就看了很快就","bdesc":"正处在现场","bid":1}
     */

    private String resulecode;
    private String reason;
    /**
     * createdBy : 啊啊啊
     * createdTime : 1470120259000
     * updatedBy : 啊啊啊
     * updatedTime : 1470120263000
     * resourceEntities : [{"searchFromPage":false,"resourceId":74,"resourceName":"img","resourceType":"BSD_IMG","resourceLocation":"http://oss-cn-shanghai.aliyuncs.com/yqt-tm/1463020081948.jpg","referrenceObjectId":"1","createdBy":"admin","createdTime":1462970154000,"updatedBy":"admin","updatedTime":1462970154000},{"searchFromPage":false,"resourceId":76,"resourceName":"img","resourceType":"BSD_IMG","resourceLocation":"http://oss-cn-shanghai.aliyuncs.com/yqt-tm/1463020081948.jpg","referrenceObjectId":"1","createdBy":"admin","createdTime":1462970154000,"updatedBy":"admin","updatedTime":1462970154000},{"searchFromPage":false,"resourceId":77,"resourceName":"img","resourceType":"BSD_IMG","resourceLocation":"http://oss-cn-shanghai.aliyuncs.com/yqt-tm/1463020081948.jpg","referrenceObjectId":"1","createdBy":"admin","createdTime":1462970154000,"updatedBy":"admin","updatedTime":1462970154000}]
     * bshare : 收水电费水电费水电费等所发生的法规和规范价格还看见了就看了就看了很快就
     * bdesc : 正处在现场
     * bid : 1
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
        private String bshare;
        private String bdesc;
        private int bid;
        /**
         * searchFromPage : false
         * resourceId : 74
         * resourceName : img
         * resourceType : BSD_IMG
         * resourceLocation : http://oss-cn-shanghai.aliyuncs.com/yqt-tm/1463020081948.jpg
         * referrenceObjectId : 1
         * createdBy : admin
         * createdTime : 1462970154000
         * updatedBy : admin
         * updatedTime : 1462970154000
         */

        private List<ResourceEntitiesBean> resourceEntities;

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

        public String getBshare() {
            return bshare;
        }

        public void setBshare(String bshare) {
            this.bshare = bshare;
        }

        public String getBdesc() {
            return bdesc;
        }

        public void setBdesc(String bdesc) {
            this.bdesc = bdesc;
        }

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
        }

        public List<ResourceEntitiesBean> getResourceEntities() {
            return resourceEntities;
        }

        public void setResourceEntities(List<ResourceEntitiesBean> resourceEntities) {
            this.resourceEntities = resourceEntities;
        }

        public static class ResourceEntitiesBean {
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
