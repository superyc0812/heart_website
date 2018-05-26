package com.xupt.vo;

/**
 * 论坛多级评论
 */
public class FmlComment {
    private Integer id;          //编号
    private Integer comment_id;             //一级评论编号
    private Integer user_one;               //评论者
    private String userName1;
    private Integer user_two;               //被评论者
    private String userName2;
    private String fml_content;             //内容
    private String fml_comment_date;        //日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUser_one() {
        return user_one;
    }

    public void setUser_one(Integer user_one) {
        this.user_one = user_one;
    }

    public String getUserName1() {
        return userName1;
    }

    public void setUserName1(String userName1) {
        this.userName1 = userName1;
    }

    public String getUserName2() {
        return userName2;
    }

    public void setUserName2(String userName2) {
        this.userName2 = userName2;
    }

    public Integer getUser_two() {
        return user_two;
    }

    public void setUser_two(Integer user_two) {
        this.user_two = user_two;
    }

    public String getFml_content() {
        return fml_content;
    }

    public void setFml_content(String fml_content) {
        this.fml_content = fml_content;
    }

    public String getFml_comment_date() {
        return fml_comment_date;
    }

    public void setFml_comment_date(String fml_comment_date) {
        this.fml_comment_date = fml_comment_date;
    }
}
