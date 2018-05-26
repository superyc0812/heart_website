package com.xupt.vo;

/**
 * 测试标题信息
 */
public class TestPaper {
    private Integer test_id;        //编号
    private Integer type;           //类型
    private String typeName;        //类型名称
    private String test_name;       //标题名称
    private Integer test_num;       //测试人数
    private String picture_addr;    //图片地址

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
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

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public Integer getTest_num() { return test_num; }

    public void setTest_num(Integer test_num) { this.test_num = test_num;
    }

    public String getPicture_addr() {
        return picture_addr;
    }

    public void setPicture_addr(String picture_addr) {
        this.picture_addr = picture_addr;
    }
}
