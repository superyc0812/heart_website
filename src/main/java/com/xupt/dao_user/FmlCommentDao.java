package com.xupt.dao_user;

import com.xupt.vo.FmlComment;

public interface FmlCommentDao {

	/**
	 * 提交复合评论
	 * @param fmlComment
	 * @return
	 */
	public int commitComment(FmlComment fmlComment);
}
