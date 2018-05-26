package com.xupt.service_impl_user;


import com.xupt.dao_user.ForumCommentDao;
import com.xupt.service_user.ForumCommentService;
import com.xupt.vo.ForumComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumCommentServiceImple implements ForumCommentService {

	@Autowired
	private ForumCommentDao forumCommentDao;

	public List<ForumComment> getCommentByForumId(int forum_id) {
		return forumCommentDao.getCommentByForumId(forum_id);
	}

	public int commitComment(ForumComment forumComment) {
		return forumCommentDao.commitComment(forumComment);
	}

}

