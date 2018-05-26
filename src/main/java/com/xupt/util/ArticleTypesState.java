package com.xupt.util;

import com.xupt.vo.ArticleType;

import java.util.List;

public class ArticleTypesState {
    private Integer state;
    private String msg;
    private List<ArticleType> labels;

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

    public List<ArticleType> getLabels() {
        return labels;
    }

    public void setLabels(List<ArticleType> labels) {
        this.labels = labels;
    }
}
