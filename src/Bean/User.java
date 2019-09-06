package Bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.MySQLdb;

public class User {
	private int uid;
	private String email;
	private String pass;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public void turnToUser(ResultSet rs){
		MySQLdb db=new MySQLdb();
		try {
			if (rs.next()) {
			 this.setUid(rs.getInt(1));
			 this.setEmail(rs.getString(2));
			 this.setPass(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
