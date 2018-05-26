package com.xupt.service_user;

import com.xupt.vo.UserTestRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTestRecordService {

	/**
	 * 获取测试结果
	 * @param test_id
	 * @param test_result
	 * @return
	 */
	public UserTestRecord getResultByPaperId(@Param("test_id") int test_id, @Param("test_result")String test_result);

	/**
	 * 保存测试结果
	 * @param userTestRecord
	 * @return
	 */
	public int save(UserTestRecord userTestRecord);

	/**
	 * 得到用户的有效测试记录
	 * @param user_id
	 * @return
	 */
	public List<UserTestRecord> getTestRecord(int user_id);

	/**
	 * 删除测试记录
	 * @param record_id
	 * @return
	 */
	public int delete(int record_id);
}
