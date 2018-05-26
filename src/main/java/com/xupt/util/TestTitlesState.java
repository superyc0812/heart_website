package com.xupt.util;

import com.xupt.vo.TestTitle;
import com.xupt.vo.TestTitle2;

import java.util.List;

public class TestTitlesState {
    private Integer state;
    private String msg;
    List<TestTitle2> questions;

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

    public List<TestTitle2> getQuestions() {
        return questions;
    }

    public void setQuestions(List<TestTitle2> questions) {
        this.questions = questions;
    }
}
