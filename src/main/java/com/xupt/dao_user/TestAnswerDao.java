package com.xupt.dao_user;

import com.xupt.vo.TestAnswer;

public interface TestAnswerDao {

	/**
	 * 根据testID查询对应的结果
	 * @param test_id
	 * @return
	 */
	public TestAnswer getResultByPaperId(int test_id);
}
