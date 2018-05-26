package com.xupt.util;

import com.xupt.vo.ArticleComment;

import java.util.List;

public class CommentsState {

    private Integer state;
    private String msg;
    private List<?> comments;

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

    public List<?> getComments() {
        return comments;
    }

    public void setComments(List<?> comments) {
        this.comments = comments;
    }
}
