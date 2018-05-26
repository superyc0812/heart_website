package com.xupt.service_impl_user;

import com.xupt.dao_user.ArticleCommentDao;
import com.xupt.service_user.ArticleCommentService;
import com.xupt.vo.ArticleComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCommentServiceImple implements ArticleCommentService{

	@Autowired
	private ArticleCommentDao articleCommentDao;

	public List<ArticleComment> getCommentByArticleId(int articleId) {
		return articleCommentDao.getCommentByArticleId(articleId);
	}

	public int commitComment(ArticleComment articleComment) {
		return articleCommentDao.commitComment(articleComment);
	}

}
