package com.xupt.vo;

/**
 * 文章类型信息
 */
public class ArticleType {
    private Integer article_type_id;       //类型编号
    private String article_type_name;      //类型名称
    private Boolean article_type_status;   //类型状态

    public Integer getArticle_type_id() {
        return article_type_id;
    }

    public void setArticle_type_id(Integer article_type_id) {
        this.article_type_id = article_type_id;
    }

    public String getArticle_type_name() {
        return article_type_name;
    }

    public void setArticle_type_name(String article_type_name) {
        this.article_type_name = article_type_name;
    }

    public Boolean getArticle_type_status() {
        return article_type_status;
    }

    public void setArticle_type_status(Boolean article_type_status) {
        this.article_type_status = article_type_status;
    }
}
