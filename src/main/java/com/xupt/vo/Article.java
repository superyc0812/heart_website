package com.xupt.vo;

/**
 * 文章信息
 */
public class Article {
    private Integer article_id;     //编号

    private String title;           //标题

    private String upload_date;     //上传日期

    private Integer type;           //类型

    private String typeName;        //类型名称

    private String author;          //作者

    private String description;     //文章描述

    private String content;         //内容

    private Integer read_num;       //阅读量

    private String picture_addr;    //图片地址

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(String upload_date) {
        this.upload_date = upload_date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRead_num() {
        return read_num;
    }

    public void setRead_num(Integer read_num) {
        this.read_num = read_num;
    }

    public String getPicture_addr() {
        return picture_addr;
    }

    public void setPicture_addr(String picture_addr) {
        this.picture_addr = picture_addr;
    }
}
