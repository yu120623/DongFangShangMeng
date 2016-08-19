package com.szdfc.entitylib;

/**
 * Created by HGo on 2016/8/15.
 */
public class ResourceEntity {
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
