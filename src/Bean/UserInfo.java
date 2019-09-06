package Bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.MySQLdb;

public class UserInfo {
	private int userInfoId;
	private String nickName;
	private String realName;
	private String sex;
	private String tel;
	private int userId;
	private String type;
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public  static UserInfo turnToUserInfo(ResultSet rs){
		MySQLdb db=new MySQLdb();
		UserInfo userInfo = null;
		try {
			if (rs.next()) {
				userInfo=new UserInfo();
				userInfo.setUserInfoId(rs.getInt(1));
				userInfo.setNickName(rs.getString(2));
				userInfo.setRealName(rs.getString(3));
				userInfo.setSex(rs.getString(4));
				userInfo.setTel(rs.getString(5));
				userInfo.setUserId(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}
	public int getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
