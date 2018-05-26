package com.xupt.service_user;

import com.xupt.vo.ForumComment;

import java.util.List;

public interface ForumCommentService {

	/**
	 * 根据forum_id获取论坛评论
	 * @param forum_id
	 * @return
	 */
	public List<ForumComment> getCommentByForumId(int forum_id);

	/**
	 * 提交评论
	 * @param forumComment
	 * @return
	 */
	public int commitComment(ForumComment forumComment);
}
