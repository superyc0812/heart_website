package com.xupt.service_impl_user;

import java.util.List;

import com.xupt.dao_user.TestTitleDao;
import com.xupt.service_user.TestTitleService;
import com.xupt.vo.TestTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTitleServiceImple implements TestTitleService{

	@Autowired
	private TestTitleDao testTitleDao;
	
	public List<TestTitle> getQuestionByPaperId(int test_id) {
		return testTitleDao.getQuestionByPaperId(test_id);
	}

}
