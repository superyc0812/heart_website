package com.xupt.service_user;

import com.xupt.vo.Forum;
import com.xupt.vo.Forum2;
import com.xupt.vo.ForumType2;
import com.xupt.vo.PageBean;

import java.util.List;

public interface ForumService {

	/**
	 * 获取分页论坛帖子
	 * @param pageBean
	 * @return
	 */
	public List<Forum> getForums(PageBean pageBean);

	/**
	 * 根据forumID获取forum
	 * @param forum_id
	 * @return
	 */
	public Forum getForumByForumId(int forum_id);

	/**
	 * 获取所有的论坛帖子总数
	 * @return
	 */
	public Integer getTotalForums();

	/**
	 * 根据类型名称，获取推荐论坛列表
	 * @param typename
	 * @return
	 */
	public List<Forum> getForumList(String typename);

	/**
	 * 获取评论类型列表
	 * @return
	 */
	public List<ForumType2> getLabels();

	/**
	 * 发布帖子
	 * @param forum
	 * @return
	 */
	public Integer addForum(Forum forum);

	/**
	 * 根据用户编号，获取评论列表
	 * @param userId
	 * @return
	 */
	public List<Forum2> getMyforums(Integer userId);

	/**
	 * 根据编号，删除评论
	 * @param forumId
	 * @return
	 */
	public Integer deleteOneForum(Integer forumId);
}