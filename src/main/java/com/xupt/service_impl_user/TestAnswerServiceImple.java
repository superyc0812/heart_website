package com.xupt.service_impl_user;

import com.xupt.dao_user.TestAnswerDao;
import com.xupt.service_user.TestAnswerService;
import com.xupt.vo.TestAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestAnswerServiceImple implements TestAnswerService{

	@Autowired
	private TestAnswerDao testAnswerDao;
	
	public TestAnswer getResultByPaperId(int test_id) {
		return testAnswerDao.getResultByPaperId(test_id);
	}

}
