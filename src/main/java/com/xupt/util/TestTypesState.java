package com.xupt.util;

import com.xupt.vo.TestPaperType;

import java.util.List;

public class TestTypesState {
    private Integer state;
    private String msg;
    private List<TestPaperType> labels;

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

    public List<TestPaperType> getLabels() {
        return labels;
    }

    public void setLabels(List<TestPaperType> labels) {
        this.labels = labels;
    }
}
