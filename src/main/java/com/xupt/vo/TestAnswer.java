package com.xupt.vo;

/**
 * 测试答案信息
 */
public class TestAnswer {
    private Integer answer_id;      //编号
    private Integer test_id;        //测试题编号
    private String region_one;      //区间一
    private String region_two;      //区间二
    private String region_three;    //区间三

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    public String getRegion_one() {
        return region_one;
    }

    public void setRegion_one(String region_one) {
        this.region_one = region_one;
    }

    public String getRegion_two() {
        return region_two;
    }

    public void setRegion_two(String region_two) {
        this.region_two = region_two;
    }

    public String getRegion_three() {
        return region_three;
    }

    public void setRegion_three(String region_three) {
        this.region_three = region_three;
    }

}
