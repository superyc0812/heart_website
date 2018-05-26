package com.xupt.vo;

/**
 * 试题类型信息
 */
public class TestPaperType {
    private Integer test_type_id;     //类型编号
    private String test_type_name;    //类型名称
    private Boolean test_type_status; //类型状态

    public Integer getTest_type_id() {
        return test_type_id;
    }

    public void setTest_type_id(Integer test_type_id) {
        this.test_type_id = test_type_id;
    }

    public String getTest_type_name() {
        return test_type_name;
    }

    public void setTest_type_name(String test_type_name) {
        this.test_type_name = test_type_name;
    }

    public Boolean getTest_type_status() {
        return test_type_status;
    }

    public void setTest_type_status(Boolean test_type_status) {
        this.test_type_status = test_type_status;
    }
}
