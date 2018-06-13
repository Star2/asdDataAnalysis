package com.aisidi.analysis.core.model;

import java.util.Date;

import com.aisidi.analysis.enums.ChangeType;
import com.aisidi.analysis.enums.IsHandle;
import com.aisidi.analysis.util.AsdUtil;

public class ChangeHistory {
    private String id;

    private String phoneNo;

    private String oldOfferId;

    private String newOfferId;

    private Date changeTime;

    private String type;

    private String isHandle;

    public ChangeHistory(String phone , String oldOfferId , String newOfferId/* ,String changeTime*/){
    	this.id = AsdUtil.getId();
    	this.phoneNo = phone ;
    	this.oldOfferId = oldOfferId ;
    	this.newOfferId = newOfferId ;
    	//this.changeTime = DateUtil.parseDate(changeTime);
    	this.changeTime = new Date();
    	type = ChangeType.INIT.getValue() ;
    	isHandle = IsHandle.NO_HANDLE.getValue();
    }
    
    
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


	public ChangeHistory(String id, String phoneNo, String oldOfferId, String newOfferId, Date changeTime, String type,
			String isHandle) {
		super();
		this.id = id;
		this.phoneNo = phoneNo;
		this.oldOfferId = oldOfferId;
		this.newOfferId = newOfferId;
		this.changeTime = changeTime;
		this.type = type;
		this.isHandle = isHandle;
	}


	public ChangeHistory() {
		super();
	}
    
    
}