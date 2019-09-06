package DAO;
import java.sql.SQLException;
import java.util.List;

import Bean.*;
import exception.LoginException;
public interface IUser{
	/**
	 * 注册用户
	 * @param account
	 * @param password
	 * @return 如果成功返回1否则返回-1
	 */
	int create(String email,String password);
	
	/**
	 * 注销
	 * @param uid
	 * @return 如果成功返回1否则返回-1
	 */
	int delete(int uid);
	
	/**
	 * 更新账户密码
	 * @param uid
	 * @param password
	 * @return 如果成功返回1否则返回-1
	 */
	int update(int uid,String password);
	
	/**
	 * 查询一个用户
	 * @param uid
	 */
	User read(int uid);
	/**
	 * 登陆验证
	 * @param user实体
	 * @return 查询有此用户返回uid，否则返回默认值0
	 * @throws SQLException 
	 * @throws LoginException 
	 */
	public int validateLogin(User user) throws SQLException, LoginException;
	/**
	 * 查询所有用户
	 */
	List<User> readAll();
}
