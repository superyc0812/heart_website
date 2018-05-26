package com.xupt.controller_user;

import com.xupt.service_user.FmlCommentService;
import com.xupt.service_user.ForumCommentService;
import com.xupt.service_user.ForumService;
import com.xupt.util.*;
import com.xupt.vo.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/apis/forum")
public class ForumController {

	@Autowired
	private ForumService forumService;

	@Autowired
	private ForumCommentService forumCommentService;

	@Autowired
	private FmlCommentService fmlCommentService;

	@RequestMapping("/getForums")
	@ResponseBody
	public ForumsState getForums(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		Integer currentPage = Integer.parseInt(obj.getString("currentPage"));
		ForumsState forumsState=new ForumsState();
		State state=new State();
		PageBean pageBean=new PageBean(currentPage,10);
		List<Forum> forums=forumService.getForums(pageBean);
		if(forums!=null){
			forumsState.setMsg("成功");
			forumsState.setState(1);
			Integer total = forumService.getTotalForums();		//获取论坛帖子总数
			forumsState.setTotal(total);
			forumsState.setCurrentPage(currentPage);
			forumsState.setForums(forums);
		}else{
			forumsState.setMsg("查询失败");
			forumsState.setState(0);
			forumsState.setTotal(null);
			forumsState.setCurrentPage(currentPage);
			forumsState.setForums(forums);
		}
		return forumsState;
	}

	@RequestMapping("/getForumByForumId")
	@ResponseBody
	public ForumState getForumByForumId(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);

		ForumState forumState=new ForumState();
		Forum forum=forumService.getForumByForumId(Integer.parseInt(obj.getString("forumId")));
		if(forum!=null){
			forumState.setMsg("成功");
			forumState.setState(1);
			forumState.setForum(forum);
		}else{
			forumState.setMsg("查询失败");
			forumState.setState(0);
			forumState.setForum(null);
		}
		return forumState;
	}

	@RequestMapping("/getCommentByForumId")
	@ResponseBody
	public CommentsState getCommentByForumId(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);

		CommentsState commentsState=new CommentsState();
		List<ForumComment> comments=forumCommentService.getCommentByForumId(Integer.parseInt(obj.getString("forumId")));
		for(int i=0;i < comments.size(); i++){
			List<FmlComment> comment = comments.get(i).getChildComments();
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

	@RequestMapping("/commitForumComment")
	@ResponseBody
	public State commitForumComment(HttpServletRequest request){
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
			ForumComment forumComment=new ForumComment();
			forumComment.setForum_id(Integer.parseInt(obj.getString("forumId")));
			forumComment.setContent(content);
			forumComment.setUser_id(userInfo.getUser_id());
			forumComment.setComment_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			int num=forumCommentService.commitComment(forumComment);
			if(num==1){
				state.setState(1);
				state.setMsg("成功");
			}else{
				state.setState(0);
				state.setMsg("提交评论失败");
			}
		}else{
			state.setState(0);
			state.setMsg("敏感字眼太多");
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
		if(content != null) {
			HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute("userInfo");
			FmlComment fmlComment = new FmlComment();
			fmlComment.setComment_id(Integer.parseInt(obj.getString("commentId")));
			fmlComment.setFml_content(content);
			fmlComment.setUser_two(Integer.parseInt(obj.getString("userId2")));
			fmlComment.setUser_one(userInfo.getUser_id());
			fmlComment.setFml_comment_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			int num = fmlCommentService.commitComment(fmlComment);
			if (num == 1) {
				state.setState(1);
				state.setMsg("成功");
			} else {
				state.setState(0);
				state.setMsg("提交评论失败");
			}
		}else{
			state.setState(0);
			state.setMsg("敏感字眼太多");
		}
		return state;
	}

	@RequestMapping("/getLabels")
	@ResponseBody
	public ForumTypesState getLabels(){
		ForumTypesState forumTypesState = new ForumTypesState();
		List<ForumType2> types = forumService.getLabels();
		if(types != null){
			forumTypesState.setState(1);
			forumTypesState.setMsg("成功");
			forumTypesState.setList(types);
		}else{
			forumTypesState.setState(0);
			forumTypesState.setMsg("失败");
			forumTypesState.setList(null);
		}
		return forumTypesState;
	}

	@RequestMapping("/addForum")
	@ResponseBody
	public State addForum(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject object = JSONObject.fromObject(jsonString);
		JSONObject obj = object.getJSONObject("forum");
		State state = new State();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userInfo");
		Forum forum = new Forum();
		forum.setUser_id(user.getUser_id());
		forum.setDescription(obj.getString("description"));
		forum.setTitle(obj.getString("title"));
		forum.setContent(obj.getString("content"));
		forum.setPublish_date(obj.getString("publish_date"));
		forum.setType(Integer.parseInt(obj.getString("forum_label_id")));
		Integer num = forumService.addForum(forum);
		if (num != null) {
			state.setState(1);
			state.setMsg("成功");
		} else {
			state.setState(0);
			state.setMsg("提交评论失败");
		}
		return state;
	}

	@RequestMapping("/getMyForums")
	@ResponseBody
	public ForumsState getMyforums(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userInfo");
		ForumsState forumsState = new ForumsState();
		List<Forum2> forums = forumService.getMyforums(user.getUser_id());
		if(forums != null){
			forumsState.setState(1);
			forumsState.setMsg("成功");
			forumsState.setForums(forums);
			forumsState.setTotal(forums.size());
			forumsState.setCurrentPage(1);
		}else{
			forumsState.setState(0);
			forumsState.setMsg("失败");
			forumsState.setForums(null);
			forumsState.setTotal(0);
			forumsState.setCurrentPage(0);
		}
		return forumsState;
	}

	@RequestMapping("/deleteOneForum")
	@ResponseBody
	public State deleteOneForum(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		State state = new State();
		Integer num = forumService.deleteOneForum(Integer.parseInt(obj.getString("forumId")));
		if (num != null) {
			state.setState(1);
			state.setMsg("成功");
		} else {
			state.setState(0);
			state.setMsg("提交评论失败");
		}
		return state;
	}
}
