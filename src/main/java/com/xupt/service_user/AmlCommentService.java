package com.xupt.service_user;

import com.xupt.vo.AmlComment;

public interface AmlCommentService {

	/**
	 * 提交复合结论
	 * @param amlComment
	 * @return
	 */
	public int commitComment(AmlComment amlComment);
}
