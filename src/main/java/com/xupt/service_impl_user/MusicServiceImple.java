package com.xupt.service_impl_user;

import java.util.List;

import com.xupt.dao_user.MusicDao;
import com.xupt.service_user.MusicService;
import com.xupt.vo.Music;
import com.xupt.vo.MusicType;
import com.xupt.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImple implements MusicService {

	@Autowired
	private MusicDao musicDao;
	
	public List<Music> getMusic(PageBean pageBean) {
		return musicDao.getMusic(pageBean);
	}

	public Music getMusicById(int music_id) {
		return musicDao.getMusicById(music_id);
	}

	public List<Music> getMusicByType( PageBean pageBean) {
		return musicDao.getMusicByType(pageBean);
	}

	public Integer getTotalMusicsByType(Integer type) {
		return musicDao.getTotalMusicsByType(type);
	}

	public List<MusicType> getMusicType() {
		return musicDao.getMusicType();
	}

	public Integer addPlayNum(Integer musicId) {
		return musicDao.addPlayNum(musicId);
	}

	public List<Music> getMusicList(String typename) {
		return musicDao.getMusicList(typename);
	}

	public List<Music> getMusics(Integer[] item) {
		return musicDao.getMusics(item);
	}
}
