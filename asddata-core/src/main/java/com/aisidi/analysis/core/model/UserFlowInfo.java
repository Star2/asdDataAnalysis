package com.aisidi.analysis.core.model;

import java.util.Date;

public class UserFlowInfo extends UserFlowInfoKey {
    private String userId;

    private Integer phoneNo;

    private String userStatus;

    private Date statusChangeDate;

    private String productOfferId;

    private Date activeTime;

    private String trafficUse;

    private Double yet;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public Date getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(Date statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }

    public String getProductOfferId() {
        return productOfferId;
    }

    public void setProductOfferId(String productOfferId) {
        this.productOfferId = productOfferId == null ? null : productOfferId.trim();
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public String getTrafficUse() {
        return trafficUse;
    }

    public void setTrafficUse(String trafficUse) {
        this.trafficUse = trafficUse == null ? null : trafficUse.trim();
    }

    public Double getYet() {
        return yet;
    }

    public void setYet(Double yet) {
        this.yet = yet;
    }
}