package com.xupt.dao_user;

import com.xupt.vo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(@Param("account")String account, @Param("password")String password);

	/**
	 * 根据account查询用户
	 * @param account
	 * @return
	 */
	public User findUserByAccount(String account);

	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public int regist(User user);

	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	public int update(User user);

	/**
	 * 根据用户编号，获取用户信息
	 * @param userId
	 * @return
	 */
	public User getUserInfo(Integer userId);
}
