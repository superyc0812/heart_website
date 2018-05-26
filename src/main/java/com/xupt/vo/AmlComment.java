package com.xupt.vo;

/**
 * 多级评论信息
 */
public class AmlComment {
    private Integer id;      //编号
    private Integer comment_id;         //一级评论编号
    private Integer user_one;           //评论者
    private String userName1;
    private Integer user_two;           //被评论者
    private String userName2;
    private String aml_content;         //内容
    private String aml_comment_date;    //日期

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

    public String getAml_content() {
        return aml_content;
    }

    public void setAml_content(String aml_content) {
        this.aml_content = aml_content;
    }

    public String getAml_comment_date() {
        return aml_comment_date;
    }

    public void setAml_comment_date(String aml_comment_date) {
        this.aml_comment_date = aml_comment_date;
    }
}
