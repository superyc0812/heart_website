package com.xupt.util;

import com.xupt.vo.UserTestRecord;

import java.util.List;

public class UserTestRecordsState {
    private Integer state;
    private String msg;
    private List<UserTestRecord> records;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<UserTestRecord> getRecords() {
        return records;
    }

    public void setRecords(List<UserTestRecord> records) {
        this.records = records;
    }
}
