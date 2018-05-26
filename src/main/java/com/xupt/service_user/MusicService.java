package com.xupt.service_user;


import com.xupt.vo.Music;
import com.xupt.vo.MusicType;
import com.xupt.vo.PageBean;

import java.util.List;

public interface MusicService {

	/**
	 * 获取首页音乐
	 * @param pageBean
	 * @return
	 */
	public List<Music> getMusic(PageBean pageBean);

	/**
	 * 根据音乐ID获取音乐
	 * @param music_id
	 * @return
	 */
	public Music getMusicById(int music_id);

	/**
	 * 根据音乐类型获取音乐
	 * @param pageBean
	 * @return
	 */
	public List<Music> getMusicByType(PageBean pageBean);

	/**
	 * 根据类型，获取音乐总数
	 * @param type
	 * @return
	 */
	public Integer getTotalMusicsByType(Integer type);

	/**
	 * 获取音乐类型列表
	 * @return
	 */
	public List<MusicType> getMusicType();

	/**
	 * 增加音乐播放量
	 * @param musicId
	 * @return
	 */
	public Integer addPlayNum(Integer musicId);

	/**
	 * 根据类型名称，获取推荐音乐
	 * @param typename
	 * @return
	 */
	public List<Music> getMusicList(String typename);

	/**
	 * 获取前四个音乐
	 * @param item
	 * @return
	 */
	public List<Music> getMusics(Integer[] item);
}

