package com.xupt.vo;

import java.util.List;

/**
 * 文章评论信息
 */
public class ArticleComment {

    private Integer id;     //编号

    private Integer user_id;        //用户编号

    private String name;            //用户昵称

    private Integer article_id;     //文章编号

    private String comment_date;    //评论日期

    private String content;         //内容

    private List<AmlComment> childComments;    //二级评论

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
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

    public List<AmlComment> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<AmlComment> childComments) {
        this.childComments = childComments;
    }
}
