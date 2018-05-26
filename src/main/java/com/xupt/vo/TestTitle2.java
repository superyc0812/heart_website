package com.xupt.vo;

public class TestTitle2 {
    private Integer title_id;       //编号
    private Integer test_id;        //测试标题编号
    private String title_name;      //题目名称
    private String chooses[];

    public Integer getTitle_id() {
        return title_id;
    }

    public void setTitle_id(Integer title_id) {
        this.title_id = title_id;
    }

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String[] getChooses() {
        return chooses;
    }

    public void setChooses(String[] chooses) {
        this.chooses = chooses;
    }
}
