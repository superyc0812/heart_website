package com.xupt.dao_user;

import com.xupt.vo.TestTitle;

import java.util.List;

public interface TestTitleDao {

	/**
	 * 根据测试ID得到具体的测试题目
	 * @param test_id
	 * @return
	 */
	public List<TestTitle> getQuestionByPaperId(int test_id);
}
