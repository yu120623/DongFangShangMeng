package com.szdfc.entitylib;

import java.util.List;

/**
 * Created by FreeMason on 2016/9/7.
 */
public class NewsListEntitiy {

    /**
     * resulecode : 10000
     * reason : 请求成功
     * result : [{"createdBy":"啊啊啊","createdTime":1473152399000,"updatedBy":"啊啊啊","updatedTime":1473152402000,"newsResources":[{"nrId":10,"location":"www.sian.com","createdBy":"admin","createdTime":1473147556000,"updatedBy":"admin","updatedTime":1473147561000},{"nrId":9,"location":"www.baidu.com","createdBy":"admin","createdTime":1473147761000,"updatedBy":"admin","updatedTime":1473147561000},{"nrId":11,"location":"www.sss.com","createdBy":"admin","createdTime":1473147556000,"updatedBy":"admin","updatedTime":1473147561000}],"nid":5,"ntitle":"首页不显示","neditor":"哈哈","ncontent":"不显示的详情","nlocation":"http://7sbp4f.com1.z0.glb.clouddn.com/123124.jpg","ndesc":"不显示","ntimePublish":1473152406000},{"createdBy":"啊啊啊","createdTime":1473152359000,"updatedBy":"啊啊啊","updatedTime":1473152416000,"newsResources":[{"nrId":8,"location":"www.ttt.com","createdBy":"admin","createdTime":1473152599000,"updatedBy":"admin","updatedTime":1473147561000},{"nrId":4,"location":"www.ddd.com","createdBy":"admin","createdTime":1473152595000,"updatedBy":"admin","updatedTime":1473147561000},{"nrId":12,"location":"www.ddd.com","createdBy":"admin","createdTime":1473152595000,"updatedBy":"admin","updatedTime":1473147561000}],"nid":4,"ntitle":"这是新闻","neditor":"编辑","ncontent":"新闻详情","nlocation":"http://7sbp4f.com1.z0.glb.clouddn.com/123124.jpg","ndesc":"新闻简介","ntimePublish":1473152366000},{"createdBy":"啊啊啊","createdTime":1469590025000,"updatedBy":"啊啊啊","updatedTime":1469590030000,"newsResources":[{"nrId":6,"location":"www.vvv.com","createdBy":"admin","createdTime":1473147556000,"updatedBy":"admin","updatedTime":1473147561000},{"nrId":7,"location":"www.eee.com","createdBy":"admin","createdTime":1473147556000,"updatedBy":"admin","updatedTime":1473147561000},{"nrId":5,"location":"www.ccc.com","createdBy":"admin","createdTime":1473147556000,"updatedBy":"admin","updatedTime":1473147561000}],"nid":2,"ntitle":"对方水电费","neditor":"水电费师傅的说法","ncontent":"环境规划及合格机构和几个环节价格和结构化","nlocation":"http://7sbp4f.com1.z0.glb.clouddn.com/123124.jpg","ndesc":"大幅度发斯蒂芬","ntimePublish":1469590014000},{"createdBy":"啊啊啊","createdTime":1469590000000,"updatedBy":"啊啊啊","updatedTime":1469590005000,"newsResources":[{"nrId":1,"location":"www.baidu.com","createdBy":"admin","createdTime":1473147761000,"updatedBy":"admin","updatedTime":1473147561000},{"nrId":2,"location":"www.sian.com","createdBy":"admin","createdTime":1473147556000,"updatedBy":"admin","updatedTime":1473147561000},{"nrId":3,"location":"www.sss.com","createdBy":"admin","createdTime":1473147556000,"updatedBy":"admin","updatedTime":1473147561000}],"nid":1,"ntitle":"是电风扇的","neditor":"第三方第三方士大夫士大夫的身份","ncontent":"v分v梵蒂冈梵蒂冈的风格的风格的风格的非官方大哥大法官 ","nlocation":"http://7sbp4f.com1.z0.glb.clouddn.com/20160224031830753.jpg","ndesc":"现在从中选出","ntimePublish":1469589985000}]
     */

    private String resulecode;
    private String reason;
    /**
     * createdBy : 啊啊啊
     * createdTime : 1473152399000
     * updatedBy : 啊啊啊
     * updatedTime : 1473152402000
     * newsResources : [{"nrId":10,"location":"www.sian.com","createdBy":"admin","createdTime":1473147556000,"updatedBy":"admin","updatedTime":1473147561000},{"nrId":9,"location":"www.baidu.com","createdBy":"admin","createdTime":1473147761000,"updatedBy":"admin","updatedTime":1473147561000},{"nrId":11,"location":"www.sss.com","createdBy":"admin","createdTime":1473147556000,"updatedBy":"admin","updatedTime":1473147561000}]
     * nid : 5
     * ntitle : 首页不显示
     * neditor : 哈哈
     * ncontent : 不显示的详情
     * nlocation : http://7sbp4f.com1.z0.glb.clouddn.com/123124.jpg
     * ndesc : 不显示
     * ntimePublish : 1473152406000
     */

    private List<ResultBean> result;

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
        private String ncontent;
        private String nlocation;
        private String ndesc;
        private long ntimePublish;
        /**
         * nrId : 10
         * location : www.sian.com
         * createdBy : admin
         * createdTime : 1473147556000
         * updatedBy : admin
         * updatedTime : 1473147561000
         */

        private List<NewsResourcesBean> newsResources;

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

        public String getNcontent() {
            return ncontent;
        }

        public void setNcontent(String ncontent) {
            this.ncontent = ncontent;
        }

        public String getNlocation() {
            return nlocation;
        }

        public void setNlocation(String nlocation) {
            this.nlocation = nlocation;
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

        public List<NewsResourcesBean> getNewsResources() {
            return newsResources;
        }

        public void setNewsResources(List<NewsResourcesBean> newsResources) {
            this.newsResources = newsResources;
        }

        public static class NewsResourcesBean {
            private int nrId;
            private String location;
            private String createdBy;
            private long createdTime;
            private String updatedBy;
            private long updatedTime;

            public int getNrId() {
                return nrId;
            }

            public void setNrId(int nrId) {
                this.nrId = nrId;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
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
