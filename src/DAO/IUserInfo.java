package DAO;

import java.util.List;

import Bean.UserInfo;

public interface IUserInfo{
	
	int create(Object obj);
	int delete(int id);
	int update(int id,Object obj);
	int update2(Object obj);
	UserInfo read(int id);
	List<UserInfo> readAll();
	public String getUserTypeById(int userId);
}
