package com.xupt.controller_user;

import com.xupt.service_user.MusicService;
import com.xupt.util.MusicState;
import com.xupt.util.MusicTypesState;
import com.xupt.util.MusicsState;
import com.xupt.util.Utils;
import com.xupt.vo.Music;
import com.xupt.vo.MusicType;
import com.xupt.vo.PageBean;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/apis/music")
public class MusicController {

	@Autowired
	private MusicService musicService;

	@RequestMapping("/getMusic")
	@ResponseBody
	public MusicsState getMusic(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);

		MusicsState musicsState=new MusicsState();
		PageBean pageBean=new PageBean(1,Integer.parseInt(obj.getString("num")));
		List<Music> musics=musicService.getMusic(pageBean);
		if(musics!=null){
			musicsState.setMsg("成功");
			musicsState.setState(1);
			musicsState.setMusics(musics);
		}else{
			musicsState.setMsg("查询失败");
			musicsState.setState(0);
			musicsState.setMusics(musics);
		}
		return musicsState;
	}

	@RequestMapping("/getMusicByType")
	@ResponseBody
	public MusicsState getMusicByType(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);

		MusicsState musicsState=new MusicsState();
		PageBean pageBean=new PageBean(Integer.parseInt(obj.getString("currentPage")),10);
		pageBean.setType(Integer.parseInt(obj.getString("type")));
		List<Music> musics=musicService.getMusicByType(pageBean);
		if(musics!=null){
			musicsState.setMsg("成功");
			musicsState.setState(1);
			Integer total = musicService.getTotalMusicsByType(Integer.parseInt(obj.getString("type")));
			musicsState.setTotal(total);
			musicsState.setCurrentPage(pageBean.getPage());
			musicsState.setMusics(musics);
		}else{
			musicsState.setMsg("查询失败");
			musicsState.setState(0);
			musicsState.setMusics(null);
		}
		return musicsState;
	}

	@RequestMapping("/getMusicById")
	@ResponseBody
	@Transactional
	public MusicState getMusicById(HttpServletRequest request){
		String jsonString = Utils.getRequestBody(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		MusicState musicState=new MusicState();
		Music music=musicService.getMusicById(Integer.parseInt(obj.getString("musicId")));
		if(music!=null){
			musicService.addPlayNum(Integer.parseInt(obj.getString("musicId")));
			musicState.setMsg("成功");
			musicState.setState(1);
			musicState.setMusic(music);
		}else{
			musicState.setMsg("查询失败");
			musicState.setState(0);
			musicState.setMusic(null);
		}
		return musicState;
	}

	@RequestMapping(value = "/getMusicType",method = RequestMethod.POST)
	@ResponseBody
	public MusicTypesState getArticleType(){
		List<MusicType> musicTypes = musicService.getMusicType();
		MusicTypesState musicTypesState = new MusicTypesState();
		if(musicTypes != null){
			musicTypesState.setState(1);
			musicTypesState.setMsg("成功");
			musicTypesState.setLabels(musicTypes);
		}else{
			musicTypesState.setState(0);
			musicTypesState.setMsg("失败");
			musicTypesState.setLabels(null);
		}
		return musicTypesState;
	}
}
