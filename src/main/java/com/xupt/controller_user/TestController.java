package com.xupt.controller_user;

import com.xupt.service_user.*;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/apis/test")
public class TestController {

	@Autowired
	private TestAnswerService testAnswerService;

	@Autowired
	private TestPaperService testPaperService;

	@Autowired
	private TestTitleService testTitleService;

	@Autowired
	private UserTestRecordService userTestRecordService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private MusicService musicService;

	@Autowired
	private ForumService forumService;

	@RequestMapping("/getTestPage")
	@ResponseBody
	public TestPapersState getTestPage(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		TestPapersState testPaparsState=new TestPapersState();
		PageBean pageBean=new PageBean(1,Integer.parseInt(obj.getString("num")));
		List<TestPaper> testPapars=testPaperService.getTestPaper(pageBean);
		if(testPapars!=null){
			testPaparsState.setMsg("成功");
			testPaparsState.setState(1);
			testPaparsState.setTestPages(testPapars);
		}else{
			testPaparsState.setMsg("查询失败");
			testPaparsState.setState(0);
			testPaparsState.setTestPages(testPapars);
		}
		return testPaparsState;
	}

	@RequestMapping("/getTestPaperByType")
	@ResponseBody
	public PapersState getTestPaperByType(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		PapersState papersState=new PapersState();
		PageBean pageBean=new PageBean(Integer.parseInt(obj.getString("currentPage")),10);
		pageBean.setType(Integer.parseInt(obj.getString("type")));
		List<TestPaper> testPapars=testPaperService.getTestPaperByType(pageBean);
		if(testPapars!=null){
			papersState.setMsg("成功");
			papersState.setState(1);
			Integer total = testPaperService.getTotalPapersByType(Integer.parseInt(obj.getString("type")));
			papersState.setPapers(testPapars);
		}else{
			papersState.setMsg("查询失败");
			papersState.setState(0);
			papersState.setPapers(null);
		}
		return papersState;
	}

	@RequestMapping("/getTestPaperNameById")
	@ResponseBody
	@Transactional
	public TestPaperState getTestPaperNameById(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		TestPaperState testPaperState=new TestPaperState();
		TestPaper testPaper=testPaperService.getTestPaperNameById(Integer.parseInt(obj.getString("paperId")));
		if(testPaper!=null){
			testPaperService.addTestNum(Integer.parseInt(obj.getString("paperId")));
			testPaperState.setMsg("成功");
			testPaperState.setState(1);
			testPaperState.setPaper(testPaper);
		}else{
			testPaperState.setMsg("查询失败");
			testPaperState.setState(0);
			testPaperState.setPaper(null);
		}
		return testPaperState;
	}

	@RequestMapping("/getQuestionByPaperId")
	@ResponseBody
	public TestTitlesState getQuestionByPaperId(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		TestTitlesState testTitlesState = new TestTitlesState();
		List<TestTitle> testTitles = testTitleService.getQuestionByPaperId(Integer.parseInt(obj.getString("paperId")));
		List<TestTitle2> questions = new ArrayList<TestTitle2>();
		TestTitle2 test = null;
		for(int i = 0;i < testTitles.size();i++){
			test = new TestTitle2();
			test.setTest_id(testTitles.get(i).getTest_id());
			test.setTitle_id(testTitles.get(i).getTitle_id());
			test.setTitle_name(testTitles.get(i).getTitle_name());
			int j = 0;
			String[] arr = null;
			if(testTitles.get(i).getChoose_three().length()==0 && testTitles.get(i).getChoose_four().length()==0){
				arr = new String[2];
				arr[0] = testTitles.get(i).getChoose_one();
				arr[1] = testTitles.get(i).getChoose_two();
			}else if(testTitles.get(i).getChoose_three().length()>0 && testTitles.get(i).getChoose_four().length()==0){
				arr = new String[3];
				arr[0] = testTitles.get(i).getChoose_one();
				arr[1] = testTitles.get(i).getChoose_two();
				arr[2] = testTitles.get(i).getChoose_three();
			}else{
				arr = new String[4];
				arr[0] = testTitles.get(i).getChoose_one();
				arr[1] = testTitles.get(i).getChoose_two();
				arr[2] = testTitles.get(i).getChoose_three();
				arr[3] = testTitles.get(i).getChoose_four();
			}
			test.setChooses(arr);
			questions.add(test);
		}
		if(testTitles!=null){
			testTitlesState.setMsg("成功");
			testTitlesState.setState(1);
			testTitlesState.setQuestions(questions);
		}else{
			testTitlesState.setMsg("查询失败");
			testTitlesState.setState(0);
			testTitlesState.setQuestions(null);
		}
		return testTitlesState;
	}

	@RequestMapping("/getResultByPaperId")
	@ResponseBody
	@Transactional
	public AnswerState getResultByPaperId(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);

		HttpSession session=request.getSession();
		User userInfo=(User) session.getAttribute("userInfo");
		AnswerState answerState=new AnswerState();
		String result="";
		Integer paperId = Integer.parseInt(obj.getString("paperId"));
		Integer score = Integer.parseInt(obj.getString("score"));
		TestPaper testPaper = testPaperService.getTestPaperById(paperId);

		List<Article> articleList = null;
		List<Music> musicList = null;
		List<Forum> forumList = null;
		if(testPaper != null){
			Integer index = testPaper.getTypeName().indexOf("测");
			String typename = testPaper.getTypeName().substring(0,index);
			articleList = articleService.getArticleList(typename);
			musicList = musicService.getMusicList(typename);
			forumList = forumService.getForumList(typename);
			if(articleList.size() > 2){
				articleList = Utils.getRandomArticles(articleList);
			}else if(articleList.size() == 0){
				articleList = articleService.getArticles(new Integer[]{20,21});
			}
			if(musicList.size() > 2){
				musicList = Utils.getRandomMusics(musicList);
			}else if(musicList.size() == 0){
				musicList = musicService.getMusics(new Integer[]{15,16});
			}
			if(forumList.size() > 2){
				forumList = Utils.getRandomForums(forumList);
			}
		}

		TestAnswer testAnswer=testAnswerService.getResultByPaperId(paperId);
		if(score<60){
			result=testAnswer.getRegion_one();
		}else if(score>=60&&score<80){
			result=testAnswer.getRegion_two();
		}else{
			result=testAnswer.getRegion_three();
		}
		UserTestRecord userTestRecord=new UserTestRecord();
		userTestRecord.setUser_id(userInfo.getUser_id());
		userTestRecord.setTest_id(paperId);
		userTestRecord.setTest_result(result);
		userTestRecord.setStatus(1);
		userTestRecord.setTest_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		int num=userTestRecordService.save(userTestRecord);
		if(num==1 && testAnswer != null){
			Answer answer=new Answer();
			answer.setAnswer_id(testAnswer.getAnswer_id());
			answer.setResult(result);
			answer.setTest_id(paperId);
			answerState.setArticles(articleList);
			answerState.setMusics(musicList);
			answerState.setForums(forumList);
			answerState.setState(1);
			answerState.setMsg("成功");
			answerState.setAnswer(answer);
		}else{
			answerState.setState(0);
			answerState.setMsg("获取测试失败");
			answerState.setAnswer(null);
			answerState.setArticles(null);
			answerState.setMusics(null);
			answerState.setForums(null);
		}
		return answerState;
	}

	@RequestMapping(value = "/getTestType",method = RequestMethod.POST)
	@ResponseBody
	public TestTypesState getTestType(){
		TestTypesState testTypesState = new TestTypesState();
		List<TestPaperType> testPaperTypes = testPaperService.getTestType();
		if(testPaperTypes != null){
			testTypesState.setState(1);
			testTypesState.setMsg("成功");
			testTypesState.setLabels(testPaperTypes);
		}else{
			testTypesState.setState(0);
			testTypesState.setMsg("失败");
			testTypesState.setLabels(null);
		}
		return testTypesState;
	}
}
