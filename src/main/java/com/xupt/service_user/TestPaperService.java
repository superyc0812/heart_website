package com.xupt.service_user;


import com.xupt.vo.PageBean;
import com.xupt.vo.TestPaper;
import com.xupt.vo.TestPaperType;

import java.util.List;

public interface TestPaperService {

	/**
	 * 首页测试展示
	 * @param pageBean
	 * @return
	 */
	public List<TestPaper> getTestPaper(PageBean pageBean);

	/**
	 * 根据测试类型得到测试列表
	 * @param pageBean
	 * @return
	 */
	public List<TestPaper> getTestPaperByType(PageBean pageBean);

	/**
	 * 根据测试ID得到测试题目和已测人数
	 * @param test_id
	 * @return
	 */
	public TestPaper getTestPaperNameById(Integer test_id);

	/**
	 * 根据类型，获取试题总数
	 * @param type
	 * @return
	 */
	public Integer getTotalPapersByType(Integer type);

	/**
	 * 获取测试题类型列表
	 * @return
	 */
	public List<TestPaperType> getTestType();

	/**
	 * 增加测试次数
	 * @param paperId
	 * @return
	 */
	public Integer addTestNum(Integer paperId);

	/**
	 * 根据试题编号，获取试题信息
	 * @param paperId
	 * @return
	 */
	public TestPaper getTestPaperById(Integer paperId);
}

