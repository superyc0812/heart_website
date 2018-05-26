package com.xupt.service_user;


import com.xupt.vo.FmlComment;

public interface FmlCommentService {

	/**
	 * 提交复合评论
	 * @param fmlComment
	 * @return
	 */
	public int commitComment(FmlComment fmlComment);
}
