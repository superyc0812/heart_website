package com.xupt.service_user;


import com.xupt.vo.ArticleComment;

import java.util.List;

public interface ArticleCommentService {

	/**
	 * 根据文章ID获取评论
	 * @param articleId
	 * @return
	 */
	public List<ArticleComment> getCommentByArticleId(int articleId);

	/**
	 * 提交对文章的评论
	 * @param content
	 * @return
	 */
	public int commitComment(ArticleComment articleComment);
}
