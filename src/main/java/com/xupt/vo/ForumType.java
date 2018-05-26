package com.xupt.vo;

/**
 * 论坛类型信息
 */
public class ForumType {
    private Integer forum_type_id;     //类型编号
    private String forum_type_name;    //类型名称
    private Boolean forum_type_status; //类型状态

    public Integer getForum_type_id() {
        return forum_type_id;
    }

    public void setForum_type_id(Integer forum_type_id) {
        this.forum_type_id = forum_type_id;
    }

    public String getForum_type_name() {
        return forum_type_name;
    }

    public void setForum_type_name(String forum_type_name) {
        this.forum_type_name = forum_type_name;
    }

    public Boolean getForum_type_status() {
        return forum_type_status;
    }

    public void setForum_type_status(Boolean forum_type_status) {
        this.forum_type_status = forum_type_status;
    }
}
