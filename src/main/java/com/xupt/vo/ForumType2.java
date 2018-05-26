package com.xupt.vo;

public class ForumType2 {
    private Integer forum_label_id;     //类型编号
    private String forum_label_name;    //类型名称
    private Boolean forum_label_status; //类型状态

    public Integer getForum_label_id() {
        return forum_label_id;
    }

    public void setForum_label_id(Integer forum_label_id) {
        this.forum_label_id = forum_label_id;
    }

    public String getForum_label_name() {
        return forum_label_name;
    }

    public void setForum_label_name(String forum_label_name) {
        this.forum_label_name = forum_label_name;
    }

    public Boolean getForum_label_status() {
        return forum_label_status;
    }

    public void setForum_label_status(Boolean forum_label_status) {
        this.forum_label_status = forum_label_status;
    }
}
