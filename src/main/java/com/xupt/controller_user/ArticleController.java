package com.xupt.controller_user;

import com.xupt.service_user.AmlCommentService;
import com.xupt.service_user.ArticleCommentService;
import com.xupt.service_user.ArticleService;
import com.xupt.util.*;
import com.xupt.vo.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/apis/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleCommentService articleCommentService;

	@Autowired
	private AmlCommentService amlCommentService;

	@RequestMapping("/getArticle")
	@ResponseBody
	public ArticlesState getArticle(HttpServletRequest request) throws Exception{
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		ArticlesState articlesState=new ArticlesState();
		PageBean pageBean=new PageBean(1,Integer.parseInt(obj.getString("num")));
		List<Article> articles=articleService.getArticle(pageBean);
		if(articles!=null){
			articlesState.setState(1);
			articlesState.setMsg("查询成功");
			articlesState.setArticles(articles);
		}else{
			articlesState.setState(0);
			articlesState.setMsg("查询失败");
			articlesState.setArticles(null);
		}
		return articlesState;
	}

	@RequestMapping("/getArticleByType")
	@ResponseBody
	public ArticlesState getArticleByType(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		ArticlesState articlesState=new ArticlesState();
		PageBean pageBean=new PageBean(Integer.parseInt(obj.getString("currentPage")),Integer.parseInt(obj.getString("currentPageSize")));
		pageBean.setType(Integer.parseInt(obj.getString("type")));
		List<Article> articles=articleService.findArticle(pageBean);
		if(articles!=null){
			articlesState.setMsg("成功");
			articlesState.setState(1);
			Integer total = articleService.getTotalArticlesByType(Integer.parseInt(obj.getString("type")));
			articlesState.setTotal(total);
			articlesState.setCurrentPage(pageBean.getPage());
			articlesState.setArticles(articles);
		}else{
			articlesState.setMsg("查询失败");
			articlesState.setState(0);
			articlesState.setArticles(null);
		}
		return articlesState;
	}

	@RequestMapping("/getArticleById")
	@ResponseBody
	@Transactional
	public ArticleState getArticleById(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		ArticleState articleState=new ArticleState();
		Article article=articleService.getArticleById(Integer.parseInt(obj.getString("articleId")));
		if(article!=null){
			articleService.addReadNum(Integer.parseInt(obj.getString("articleId")));
			articleState.setMsg("成功");
			articleState.setState(1);
			articleState.setArticle(article);
		}else{
			articleState.setMsg("查询失败");
			articleState.setState(0);
			articleState.setArticle(null);
		}
		return articleState;
	}

	@RequestMapping(value = "/getCommentByArticleId",method = RequestMethod.POST)
	@ResponseBody
	public CommentsState getCommentByArticleId(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		CommentsState commentsState=new CommentsState();
		List<ArticleComment> comments=articleCommentService.getCommentByArticleId(Integer.parseInt(obj.getString("articleId")));
		for(int i=0;i < comments.size(); i++){
			List<AmlComment> comment = comments.get(i).getChildComments();
			if(comment.size() == 1 && comment.get(0).getId() == null){
				comments.get(i).getChildComments().remove(0);
			}
		}
		if(comments!=null){
			commentsState.setMsg("成功");
			commentsState.setState(1);
			commentsState.setComments(comments);
		}else{
			commentsState.setMsg("查询失败");
			commentsState.setState(0);
			commentsState.setComments(null);
		}
		return commentsState;
	}

	@RequestMapping("/commitArticleComment")
	@ResponseBody
	public State commitArctiltComment(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		State state=new State();
		String src = this.getClass().getClassLoader().getResource("keyword.properties").getFile();
		//获取评论内容，进行过滤
		String message = obj.getString("message");
		if(Utils.map.size() == 0){
			Utils.readFilterProperties(src);
		}
		String content = Utils.replaceCheck(Utils.map,message);
		if(content != null){
			HttpSession session=request.getSession();
			User userInfo=(User) session.getAttribute("userInfo");
			ArticleComment articleComment=new ArticleComment();
			articleComment.setArticle_id(Integer.parseInt(obj.getString("articleId")));

			articleComment.setContent(content);
			articleComment.setUser_id(userInfo.getUser_id());
			articleComment.setComment_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			int num=articleCommentService.commitComment(articleComment);
			if(num==1){
				state.setState(1);
				state.setMsg("成功");
			}else{
				state.setState(0);
				state.setMsg("提交评论失败");
			}
		}else{
			state.setState(0);
			state.setMsg("铭感字眼太多");
		}
		return state;
	}

	@RequestMapping("/commitUserComment")
	@ResponseBody
	public State commitUserComment(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		State state=new State();
		String src = this.getClass().getClassLoader().getResource("keyword.properties").getFile();
		//获取评论内容，进行过滤
		String message = obj.getString("message");
		if(Utils.map.size() == 0){
			Utils.readFilterProperties(src);
		}
		String content = Utils.replaceCheck(Utils.map,message);
		if(content != null){
			HttpSession session=request.getSession();
			User userInfo=(User) session.getAttribute("userInfo");
			AmlComment amlComment=new AmlComment();
			amlComment.setComment_id(Integer.parseInt(obj.getString("commentId")));
			amlComment.setAml_content(content);
			amlComment.setUser_two(Integer.parseInt(obj.getString("userId2")));
			amlComment.setUser_one(userInfo.getUser_id());
			amlComment.setAml_comment_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			int num=amlCommentService.commitComment(amlComment);
			if(num==1){
				state.setState(1);
				state.setMsg("成功");
			}else{
				state.setState(0);
				state.setMsg("提交评论失败");
			}
		}else{
			state.setState(0);
			state.setMsg("铭感字眼太多");
		}
		return state;
	}

	@RequestMapping(value = "/getArticleType",method = RequestMethod.POST)
	@ResponseBody
	public ArticleTypesState getArticleType(HttpServletRequest request){
		List<ArticleType> articleTypes = articleService.getArticleType();
		ArticleTypesState articleTypesState = new ArticleTypesState();
		if(articleTypes != null){
			articleTypesState.setState(1);
			articleTypesState.setMsg("成功");
			articleTypesState.setLabels(articleTypes);
		}else{
			articleTypesState.setState(0);
			articleTypesState.setMsg("失败");
			articleTypesState.setLabels(null);
		}
		return articleTypesState;
	}
}

