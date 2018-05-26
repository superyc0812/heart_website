package com.xupt.controller_user;

import com.xupt.service_user.UserTestRecordService;
import com.xupt.util.ListState;
import com.xupt.util.State;
import com.xupt.util.UserTestRecordsState;
import com.xupt.util.Utils;
import com.xupt.vo.User;
import com.xupt.vo.UserTestRecord;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("apis/record")
public class UserTestRecordController {

	@Autowired
	private UserTestRecordService userTestRecoreService;

	@RequestMapping("/getTestRecord")
	@ResponseBody
	public UserTestRecordsState getTestRecord(HttpServletRequest request){
		HttpSession session=request.getSession();
		User userInfo=(User) session.getAttribute("userInfo");
		UserTestRecordsState userTestRecordsState=new UserTestRecordsState();
		List<UserTestRecord> userTestRecords=userTestRecoreService.getTestRecord(userInfo.getUser_id());
		if(userTestRecords!=null){
			userTestRecordsState.setMsg("成功");
			userTestRecordsState.setState(1);
			userTestRecordsState.setRecords(userTestRecords);
		}else{
			userTestRecordsState.setMsg("查询失败");
			userTestRecordsState.setState(0);
			userTestRecordsState.setRecords(userTestRecords);
		}
		return userTestRecordsState;
	}

	@RequestMapping("/deleteRecord")
	@ResponseBody
	public State deleteRecord(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		State state=new State();
		int num=userTestRecoreService.delete(Integer.parseInt(obj.getString("id")));
		if(num==1){
			state.setState(1);
			state.setMsg("成功");
		}else{
			state.setState(0);
			state.setMsg("删除失败");
		}
		return state;
	}
}
