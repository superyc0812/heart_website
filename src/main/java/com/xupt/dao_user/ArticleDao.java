package com.xupt.dao_user;

import com.xupt.vo.Article;
import com.xupt.vo.ArticleType;
import com.xupt.vo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

	/**
	 * 展示一定数目的文章
	 * @param pageBean
	 * @return
	 */
	public List<Article> getArticle(PageBean pageBean);

	/**
	 * 获取分页的文章
	 * @param pageBean
	 * @return
	 */
	public List<Article> findArticle(PageBean pageBean);

	/**
	 * 根据Article_id获取文章
	 * @param article_id
	 * @return
	 */
	public Article getArticleById(int article_id);

	/**
	 * 根据类型，获取文章总数
	 * @param type
	 * @return
	 */
	public Integer getTotalArticlesByType(Integer type);

	/**
	 * 获取文章类型
	 * @return
	 */
	public List<ArticleType> getArticleType();

	/**
	 * 增加文章阅读量
	 * @return
	 */
	public Integer addReadNum(Integer articleId);

	/**
	 * 根据类型名称，获取推荐文章列表
	 * @param typename
	 * @return
	 */
	public List<Article> getArticleList(String typename);

	/**
	 * 获取前两篇文章
	 * @param item
	 * @return
	 */
	public List<Article> getArticles(Integer[] item);
}







