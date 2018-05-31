package com.aisidi.analysis.core.model;

import java.util.Date;

public class ChangeHistory {
    private String id;

    private String phoneNo;

    private String oldOfferId;

    private String newOfferId;

    private Date changeTime;

    private String type;

    private String isHandle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getOldOfferId() {
        return oldOfferId;
    }

    public void setOldOfferId(String oldOfferId) {
        this.oldOfferId = oldOfferId == null ? null : oldOfferId.trim();
    }

    public String getNewOfferId() {
        return newOfferId;
    }

    public void setNewOfferId(String newOfferId) {
        this.newOfferId = newOfferId == null ? null : newOfferId.trim();
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(String isHandle) {
        this.isHandle = isHandle == null ? null : isHandle.trim();
    }
}