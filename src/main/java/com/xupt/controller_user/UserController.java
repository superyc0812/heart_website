package com.xupt.controller_user;

import com.xupt.service_user.UserService;
import com.xupt.util.State;
import com.xupt.util.UserState;
import com.xupt.util.Utils;
import com.xupt.vo.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/apis/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/checkUserAccount",method = RequestMethod.POST)
	@ResponseBody
	public State checkUserAccount(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		State state = new State();
		if(jsonString != null) {
			JSONObject obj = JSONObject.fromObject(jsonString);
			User user = userService.findUserByAccount(obj.getString("account"));
			if (user != null) {
				state.setState(0);
				state.setMsg("已存在用户");
			} else {
				state.setState(1);
				state.setMsg("成功");
			}
		}else{
			state.setState(0);
			state.setMsg("用户没有输入账号");
		}
		return state;
	}

	@RequestMapping(value = "/regist",method = RequestMethod.POST)
	@ResponseBody
	public State regist(@RequestBody User user){
		State state=new State();
		String nickName=user.getAccount();
		user.setNickname(nickName);
		int num=userService.regist(user);
		if(num==1){
			state.setState(1);
			state.setMsg("成功");
		}else{
			state.setState(0);
			state.setMsg("注册失败");
		}
		return state;
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public State login(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		State state = new State();
		if(jsonString != null) {
			JSONObject obj = JSONObject.fromObject(jsonString);
			User user = userService.login(obj.getString("account"), obj.getString("password"));
			if (user != null) {
				state.setState(1);
				state.setMsg("成功");
				HttpSession session = request.getSession();
				session.removeAttribute("admin");
				session.setAttribute("userInfo", user);
			} else {
				state.setState(0);
				state.setMsg("账号或密码不正确");
			}
		}else{
			state.setState(0);
			state.setMsg("用户没有输入账号");
		}
		return state;
	}

	@RequestMapping(value = "/checkOldPassword",method = RequestMethod.POST)
	@ResponseBody
	public State checkOldPassword(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		State state=new State();
		if(jsonString != null) {
			JSONObject obj = JSONObject.fromObject(jsonString);
			HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute("userInfo");
			if (obj.getString("password").equals(userInfo.getPassword())) {
				state.setState(1);
				state.setMsg("成功");
			} else {
				state.setState(0);
				state.setMsg("密码错误");
			}
		}else{
			state.setState(0);
			state.setMsg("密码为空");
		}
		return state;
	}

	@RequestMapping(value = "/checkPassword",method = RequestMethod.POST)
	@ResponseBody
	public State checkPassword(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		State state=new State();
		if(jsonString != null){
			JSONObject obj = JSONObject.fromObject(jsonString);
			HttpSession session=request.getSession();
			User userInfo=(User) session.getAttribute("userInfo");
			User user=new User();
			user.setUser_id(userInfo.getUser_id());
			user.setPassword(obj.getString("newPassword"));
			int num=userService.update(user);
			if(num==1){
				state.setState(1);
				state.setMsg("密码修改成功");
			}else{
				state.setState(0);
				state.setMsg("密码修改失败");
			}
		}else{
			state.setState(0);
			state.setMsg("新密码不能为空");
		}
		return state;
	}

	@RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
	@ResponseBody
	public UserState getUserInfo(HttpServletRequest request){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("userInfo");
		UserState userState = new UserState();
		if(user != null){
			userState.setState(1);
			userState.setMsg("成功");
			userState.setUser(user);
		}else{
			userState.setState(0);
			userState.setMsg("失败");
			userState.setUser(null);
		}
		return userState;
	}

	@RequestMapping(value = "/changeUserInfo",method = RequestMethod.POST)
	@ResponseBody
	public State changeUserInfo(@RequestBody User user,HttpServletRequest request){
		HttpSession session = request.getSession();
		User userInfo = (User)session.getAttribute("userInfo");
		user.setUser_id(userInfo.getUser_id());
		State state=new State();
		int num=userService.update(user);
		session.setAttribute("userInfo",user);
		if(num==1){
			state.setState(1);
			state.setMsg("成功");
		}else{
			state.setState(0);
			state.setMsg("修改失败");
		}
		return state;
	}
}