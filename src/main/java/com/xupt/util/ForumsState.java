package com.xupt.util;

import com.xupt.vo.Forum;

import java.util.List;

public class ForumsState {
    private Integer state;
    private String msg;
    private Integer total;
    private Integer currentPage;
    private List<?> forums;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<?> getForums() {
        return forums;
    }

    public void setForums(List<?> forums) {
        this.forums = forums;
    }
}
