package com.xupt.service_impl_user;

import java.util.List;

import com.xupt.dao_user.ArticleDao;
import com.xupt.service_user.ArticleService;
import com.xupt.vo.Article;
import com.xupt.vo.ArticleType;
import com.xupt.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImple implements ArticleService{

	@Autowired
	private ArticleDao articleDao;
	
	public List<Article> getArticle(PageBean pageBean) {
		return articleDao.getArticle(pageBean);
	}

	public List<Article> findArticle(PageBean pageBean) {
		return articleDao.findArticle(pageBean);
	}

	public Article getArticleById(int article_id) {
		return articleDao.getArticleById(article_id);
	}

	public Integer getTotalArticlesByType(Integer type) {
		return articleDao.getTotalArticlesByType(type);
	}

	public List<ArticleType> getArticleType() {
		return articleDao.getArticleType();
	}

	public Integer addReadNum(Integer articleId) {
		return articleDao.addReadNum(articleId);
	}

	public List<Article> getArticleList(String typename) {
		return articleDao.getArticleList(typename);
	}

	public List<Article> getArticles(Integer[] item) {
		return articleDao.getArticles(item);
	}
}
