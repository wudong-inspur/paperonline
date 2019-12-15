package com.sp.questionnaire.service;

import com.sp.questionnaire.entity.User;

import java.util.List;

/**
 * description: Author:Xiaowanwan Date:2018/9/13-10:52
 */
public interface UserService {
	/**
	 * 查询所有User，返回List<User>
	 * 
	 * @return
	 */
	List<User> queryUser();

	/**
	 * 根据id查询User，返回User
	 * 
	 * @param id
	 * @return
	 */
	User queryUserByID(String id);

	/**
	 * 插入一个User对象到数据库中
	 * 
	 * @param user
	 * @return
	 */
	boolean insertUser(User user);

	/**
	 * 更新user，根据id更新
	 * 
	 * @param user
	 * @return
	 */
	boolean updateUser(User user);

	/**
	 * 根据id删除User对象
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteUser(String id);

	/**
	 * 根据email查询User对象
	 * 
	 * @param email
	 * @return
	 */
	User queryUserByEmail(String email);

	/**
	 * Query user by user name.
	 * 
	 * @param userName
	 *            the user name
	 * @return the user
	 */
	User queryUserByUserName(String userName);

	User queryUserByRandomCode(String code);
}
