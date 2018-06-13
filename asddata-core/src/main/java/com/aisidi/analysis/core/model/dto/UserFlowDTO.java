package com.aisidi.analysis.core.model.dto;

import java.io.Serializable;

public class UserFlowDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8569968658928973528L;

	private String phoneNo ; //手机号
	 
	private String months ;  //月份   ,分割
	
	private String traffics ; //每月流量使用量  ,分割
	
	private String products ; //套餐ID ,分隔 
	
	private String changeDate ; //套餐变更日期

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getTraffics() {
		return traffics;
	}

	public void setTraffics(String traffics) {
		this.traffics = traffics;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	
	
}
