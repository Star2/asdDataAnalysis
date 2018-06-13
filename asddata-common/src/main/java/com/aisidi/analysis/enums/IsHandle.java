package com.aisidi.analysis.enums;

/**
 * @author zhaojy
 * @date 2018/6/13
 */
public enum IsHandle {
    NO_HANDLE("1" ,"未处理"),
    HANDLE("2" ,"已处理");

    private String value ;
    private String name ;

    private IsHandle(String value, String name) {
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

    public IsHandle parse(String value) {
        for(IsHandle handle : values()) {
            if(handle.equals(value)) {
                return handle ;
            }
        }
        return null ;
    }
}
