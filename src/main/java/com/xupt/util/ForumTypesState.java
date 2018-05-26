package com.xupt.util;

import com.xupt.vo.ForumType2;

import java.util.List;

public class ForumTypesState {
    private Integer state;
    private String msg;
    private List<ForumType2> list;

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

    public List<ForumType2> getList() {
        return list;
    }

    public void setList(List<ForumType2> list) {
        this.list = list;
    }
}
