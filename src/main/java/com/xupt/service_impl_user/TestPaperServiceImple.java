package com.xupt.service_impl_user;

import java.util.List;

import com.xupt.dao_user.TestPaperDao;
import com.xupt.service_user.TestPaperService;
import com.xupt.vo.PageBean;
import com.xupt.vo.TestPaper;
import com.xupt.vo.TestPaperType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPaperServiceImple implements TestPaperService {

	@Autowired
	private TestPaperDao testPaperDao;
	
	public List<TestPaper> getTestPaper(PageBean pageBean) {
		return testPaperDao.getTestPaper(pageBean);
	}

	public List<TestPaper> getTestPaperByType(PageBean pageBean) {
		return testPaperDao.getTestPaperByType(pageBean);
	}

	public TestPaper getTestPaperNameById(Integer test_id) {
		return testPaperDao.getTestPaperNameById(test_id);
	}

	public Integer getTotalPapersByType(Integer type) {
		return testPaperDao.getTotalPapersByType(type);
	}

	public List<TestPaperType> getTestType() {
		return testPaperDao.getTestType();
	}

	public Integer addTestNum(Integer paperId) {
		return testPaperDao.addTestNum(paperId);
	}

	public TestPaper getTestPaperById(Integer paperId) {
		return testPaperDao.getTestPaperById(paperId);
	}
}
