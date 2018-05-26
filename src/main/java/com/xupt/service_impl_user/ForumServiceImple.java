package com.xupt.service_impl_user;

import java.util.List;

import com.xupt.dao_user.ForumDao;
import com.xupt.service_user.ForumService;
import com.xupt.vo.Forum;
import com.xupt.vo.Forum2;
import com.xupt.vo.ForumType2;
import com.xupt.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumServiceImple implements ForumService {

	@Autowired
	private ForumDao forumDao;

	public Integer getTotalForums() {
		return forumDao.getTotalForums();
	}

	public List<Forum> getForums(PageBean pageBean) {
		return forumDao.getForums(pageBean);
	}

	public Forum getForumByForumId(int forum_id) {
		return forumDao.getForumByForumId(forum_id);
	}

	public List<Forum> getForumList(String typename) {
		return forumDao.getForumList(typename);
	}

	public List<ForumType2> getLabels() {
		return forumDao.getLabels();
	}

	public Integer addForum(Forum forum) {
		return forumDao.addForum(forum);
	}

	public List<Forum2> getMyforums(Integer userId) {
		return forumDao.getMyforums(userId);
	}

	public Integer deleteOneForum(Integer forumId) {
		return forumDao.deleteOneForum(forumId);
	}
}
