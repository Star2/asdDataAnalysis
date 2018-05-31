package com.aisidi.analysis.core.model;

public class UserFlowInfoKey {
    private Integer currentMonth;

    private String id;

    public Integer getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(Integer currentMonth) {
        this.currentMonth = currentMonth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}