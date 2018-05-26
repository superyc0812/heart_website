package com.xupt.service_impl_user;


import com.xupt.dao_user.FmlCommentDao;
import com.xupt.service_user.FmlCommentService;
import com.xupt.vo.FmlComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FmlCommentServiceImple implements FmlCommentService{

	@Autowired
	private FmlCommentDao fmlCommentDao;

	public int commitComment(FmlComment fmlComment) {
		return fmlCommentDao.commitComment(fmlComment);
	}

}
