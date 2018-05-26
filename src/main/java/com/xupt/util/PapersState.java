package com.xupt.util;

import com.xupt.vo.TestPaper;

import java.util.List;

public class PapersState {
    private Integer state;
    private String msg;
    private List<TestPaper> papers;

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

    public List<TestPaper> getPapers() {
        return papers;
    }

    public void setPapers(List<TestPaper> papers) {
        this.papers = papers;
    }
}
