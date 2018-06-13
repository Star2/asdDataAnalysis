package com.aisidi.analysis.enums;

public enum ChangeType {

	INIT("1" ,"初始变更"),
	AGAIN("2" ,"再次变更");
	
	
	private String value ;
	private String name ;
	
	private ChangeType(String value, String name) {
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

	public ChangeType parse(String value) {
		for(ChangeType status : values()) {
			if(status.equals(value)) {
				return status ;
			}
		}
		return null ;
	}
}
