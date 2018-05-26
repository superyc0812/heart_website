package com.xupt.service_impl_user;

import com.xupt.dao_user.UserTestRecordDao;
import com.xupt.service_user.UserTestRecordService;
import com.xupt.vo.UserTestRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTestRecordServiceImple implements UserTestRecordService {

	@Autowired
	private UserTestRecordDao userTestRecordDao;
	
	public UserTestRecord getResultByPaperId(int test_id, String test_result) {
		return userTestRecordDao.getResultByPaperId(test_id, test_result);
	}

	public int save(UserTestRecord userTestRecord) {
		return userTestRecordDao.save(userTestRecord);
	}

	public List<UserTestRecord> getTestRecord(int user_id) {
		return userTestRecordDao.getTestRecord(user_id);
	}

	public int delete(int record_id) {
		return userTestRecordDao.delete(record_id);
	}

}
