package Bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Contact {

	public Contact() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private int belongUid;
	private String userName;
	private String sex;
	private String phone;
	private String shortNum;
	
	public static List<Contact> turnToContactList(ResultSet rs){
		List<Contact> list=null;
		try {
			list=new ArrayList<Contact>();
			while(rs.next()){
				Contact c=new Contact();
				c.setId(rs.getInt(1));
				c.setBelongUid(rs.getInt(2));
				c.setUserName(rs.getString(3));
				c.setSex(rs.getString(4));
				c.setPhone(rs.getString(5));
				c.setShortNum(rs.getString(6));
				list.add(c);
			}
		} catch (SQLException e) {
			e.getErrorCode();e.getSQLState();e.getStackTrace();
		}
		return list;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getBelongUid() {
		return belongUid;
	}
	public void setBelongUid(int belongUid) {
		this.belongUid = belongUid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShortNum() {
		return shortNum;
	}
	public void setShortNum(String shortNum) {
		this.shortNum = shortNum;
	}
	
	
}
