package com.xupt.service_impl_user;


import com.xupt.dao_user.AmlCommentDao;
import com.xupt.service_user.AmlCommentService;
import com.xupt.vo.AmlComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmlCommentServiceImple implements AmlCommentService{

	@Autowired
	private AmlCommentDao amlCommentDao;

	public int commitComment(AmlComment amlComment) {
		return amlCommentDao.commitComment(amlComment);
	}

}

