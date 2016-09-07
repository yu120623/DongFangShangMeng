package com.szdfc.entitylib;

import java.util.List;

/**
 * Created by HGo on 2016/8/23.
 */
public class ResultBean {
    private String createdBy;
    private long createdTime;
    private String updatedBy;
    private long updatedTime;
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

    public ResourceEntity getResourceEntity() {
        return resourceEntity;
    }

    public void setResourceEntity(ResourceEntity resourceEntity) {
        this.resourceEntity = resourceEntity;
    }

    //展会
    private int enrolNum;
    private int eid;
    private String etitle;
    private String eaddress;
    private String edesc;
    private long estartDate;
    private long eendDate;
    private String econtent;

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

    public void setEstartDate(long estartDate) {
        this.estartDate = estartDate;
    }

    public long getEendDate() {
        return eendDate;
    }

    public void setEendDate(long eendDate) {
        this.eendDate = eendDate;
    }

    public String getEcontent() {
        return econtent;
    }

    public void setEcontent(String econtent) {
        this.econtent = econtent;
    }

    //智库
    private TType thinkTankType;
    private int tid;
    private String tname;
    private String tdesc;
    private String tintro;

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


    //新闻
    private int nid;
    private String ntitle;
    private String neditor;
    private String ndesc;
    private long ntimePublish;
    private String ncontent;

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

    //游学
    private String sdesc;
    private String sname;
    private String sintro;
    private int sid;
    private String saddress;
    private long sstartTime;
    private long sendTime;

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

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public long getSstartTime() {
        return sstartTime;
    }

    public void setSstartTime(long sstartTime) {
        this.sstartTime = sstartTime;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    //商学院
    private int bid;
    private String bdesc;
    private String bshare;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBdesc() {
        return bdesc;
    }

    public void setBdesc(String bdesc) {
        this.bdesc = bdesc;
    }

    public String getBshare() {
        return bshare;
    }

    public void setBshare(String bshare) {
        this.bshare = bshare;
    }

    //活动列表
    private int conId;
    private String conTitle;
    private String conDesc;
    private String conContent;
    private long startTime;
    private long endTime;
    private ResourceEntity resource;

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

    //服务平台
//    private int tid;  上面已存在
//    private String tname;
//    private String tdesc;
    private String turl;

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }

    //商务中心
    //private int bid;
    //private String bdesc;
    private String btitle;
    private String baddress;
    private long bstartTime;
    private long bendTime;
    private String bintro;

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
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

    //时尚中心
    private int fid;
    private String ftitle;
    private String fdesc;
    private String faddress;
    private long fstartDate;
    private long fendDate;
    private String fcontent;

    private FashionCentreType fashionCentreType;

    public static class FashionCentreType {
        private String createdBy;
        private long createdTime;
        private String updatedBy;
        private long updatedTime;
        private int fid;
        private String fname;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle;
    }

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public long getFstartDate() {
        return fstartDate;
    }

    public void setFstartDate(long fstartDate) {
        this.fstartDate = fstartDate;
    }

    public long getFendDate() {
        return fendDate;
    }

    public void setFendDate(long fendDate) {
        this.fendDate = fendDate;
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent;
    }

    public FashionCentreType getFashionCentreType() {
        return fashionCentreType;
    }

    public void setFashionCentreType(FashionCentreType fashionCentreType) {
        this.fashionCentreType = fashionCentreType;
    }

    //创业大赛
//    private int enrolNum;
//    private int eid;
//    private String etitle;
    private long eenrolStartTime;
    private String rdesc;
    private String eintro;
    private long estartTime;
    private long eenrolEndTime;
    private long eendTime;

    public long getEenrolStartTime() {
        return eenrolStartTime;
    }

    public void setEenrolStartTime(long eenrolStartTime) {
        this.eenrolStartTime = eenrolStartTime;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public String getEintro() {
        return eintro;
    }

    public void setEintro(String eintro) {
        this.eintro = eintro;
    }

    public long getEstartTime() {
        return estartTime;
    }

    public void setEstartTime(long estartTime) {
        this.estartTime = estartTime;
    }

    public long getEenrolEndTime() {
        return eenrolEndTime;
    }

    public void setEenrolEndTime(long eenrolEndTime) {
        this.eenrolEndTime = eenrolEndTime;
    }

    public long getEendTime() {
        return eendTime;
    }

    public void setEendTime(long eendTime) {
        this.eendTime = eendTime;
    }

    //商务中心详情
    private List<ResourceEntity> resourceEntities;

    public List<ResourceEntity> getResourceEntities() {
        return resourceEntities;
    }

    public void setResourceEntities(List<ResourceEntity> resourceEntities) {
        this.resourceEntities = resourceEntities;
    }

    //预定时间列表
    private String timeSlot;
    private long btime;
    private String bisSelected;
    private String bselectUser;
    private int bpid;

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public long getBtime() {
        return btime;
    }

    public void setBtime(long btime) {
        this.btime = btime;
    }

    public String getBisSelected() {
        return bisSelected;
    }

    public void setBisSelected(String bisSelected) {
        this.bisSelected = bisSelected;
    }

    public String getBselectUser() {
        return bselectUser;
    }

    public void setBselectUser(String bselectUser) {
        this.bselectUser = bselectUser;
    }

    public int getBpid() {
        return bpid;
    }

    public void setBpid(int bpid) {
        this.bpid = bpid;
    }
}
