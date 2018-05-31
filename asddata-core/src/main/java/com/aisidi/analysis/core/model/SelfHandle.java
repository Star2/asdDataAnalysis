package com.aisidi.analysis.core.model;

import java.util.Date;

public class SelfHandle {
    private String id;

    private String userId;

    private String phoneNo;

    private String productOfferId;

    private String productOfferName;

    private Date handleTime;

    private Date effectiveTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getProductOfferId() {
        return productOfferId;
    }

    public void setProductOfferId(String productOfferId) {
        this.productOfferId = productOfferId == null ? null : productOfferId.trim();
    }

    public String getProductOfferName() {
        return productOfferName;
    }

    public void setProductOfferName(String productOfferName) {
        this.productOfferName = productOfferName == null ? null : productOfferName.trim();
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}