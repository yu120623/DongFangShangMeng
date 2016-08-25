package com.szdfc.entitylib;

import java.util.Date;

/**
 * Created by FreeMason on 2016/8/23.
 */
public class StudyTourDetailEntity {

    private String resulecode;
    private String reason;

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
        private int sid;
        private String sintro;
        private String sname;
        private String sdesc;
        private String saddress;
        private Date sstartTime;
        private Date sendTime;

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

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public String getSintro() {
            return sintro;
        }

        public void setSintro(String sintro) {
            this.sintro = sintro;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getSdesc() {
            return sdesc;
        }

        public void setSdesc(String sdesc) {
            this.sdesc = sdesc;
        }

        public String getSaddress() {
            return saddress;
        }

        public void setSaddress(String saddress) {
            this.saddress = saddress;
        }

        public Date getSstartTime() {
            return sstartTime;
        }

        public void setSstartTime(Date sstartTime) {
            this.sstartTime = sstartTime;
        }

        public Date getSendTime() {
            return sendTime;
        }

        public void setSendTime(Date sendTime) {
            this.sendTime = sendTime;
        }
    }
}
