package com.xupt.util;

import com.xupt.vo.TestPaper;

public class TestPaperState {
    private Integer state;
    private String msg;
    private TestPaper paper;

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

    public TestPaper getPaper() {
        return paper;
    }

    public void setPaper(TestPaper paper) {
        this.paper = paper;
    }
}
