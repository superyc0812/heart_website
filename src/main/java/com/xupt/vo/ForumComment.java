package com.xupt.vo;

import java.util.List;

/**
 * 论坛评论信息
 */
public class ForumComment {
    private Integer id;     //编号

    private Integer forum_id;       //论坛编号

    private Integer user_id;        //用户编号

    private String name;

    private String comment_date;    //评论日期

    private String content;         //内容

    private List<FmlComment> childComments;    //二级评论列表

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getForum_id() {
        return forum_id;
    }

    public void setForum_id(Integer forum_id) {
        this.forum_id = forum_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<FmlComment> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<FmlComment> childComments) {
        this.childComments = childComments;
    }
}
