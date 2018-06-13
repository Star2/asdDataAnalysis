package com.aisidi.analysis.enums;

public enum UserStatus {

	NORMAL("1" ,"正常"),
	ARREARS("2" ,"欠费");
	
	
	private String value ;
	private String name ;
	
	private UserStatus(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserStatus parse(String value) {
		for(UserStatus status : values()) {
			if(status.equals(value)) {
				return status ;
			}
		}
		return null ;
	}
}
