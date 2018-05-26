package com.xupt.service_impl_user;
import com.xupt.dao_user.UserDao;
import com.xupt.service_user.UserService;
import com.xupt.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User login(String account, String password) {
		return userDao.login(account,password);
	}

	public User findUserByAccount(String account) {
		return userDao.findUserByAccount(account);
	}

	public int regist(User user) {
		return userDao.regist(user);
	}

	public int update(User user) {
		return userDao.update(user);
	}

	public User getUserInfo(Integer userId) {
		return userDao.getUserInfo(userId);
	}
}
