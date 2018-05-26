package com.xupt.util;

import com.xupt.vo.MusicType;

import java.util.List;

public class MusicTypesState {
    private Integer state;
    private String msg;
    private List<MusicType> labels;

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

    public List<MusicType> getLabels() {
        return labels;
    }

    public void setLabels(List<MusicType> labels) {
        this.labels = labels;
    }
}
