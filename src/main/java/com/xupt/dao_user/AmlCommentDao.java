package com.xupt.dao_user;

import com.xupt.vo.AmlComment;

public interface AmlCommentDao {

	/**
	 * 提交复合结论
	 * @param amlComment
	 * @return
	 */
	public int commitComment(AmlComment amlComment);
}
