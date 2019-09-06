package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Bean.UserInfo;
import exception.OrderException;

public class UserInfoImp implements IUserInfo {

	public UserInfoImp() {
		// TODO Auto-generated constructor stub
	}

	public int create(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(int id, Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update2(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserInfo read(int id) {
		// TODO Auto-generated method stub
		UserInfo userInfo=null;
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		try {
			PreparedStatement pstmt=pdb.conn.prepareStatement("SELECT * FROM UserInfo WHERE userId=?)");
			pstmt.setInt(1, id);
			UserInfo.turnToUserInfo(pstmt.executeQuery());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}

	public List<UserInfo> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	//其实这个方法有点多余，但是是一开始就写的，为了省事还是保留。
	@Override
	public String getUserTypeById(int userId) {
		// TODO Auto-generated method stub
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		PreparedStatement pstmt;
		int effected=-1;
		String type=null;
		try {
			pstmt=pdb.conn.prepareStatement("SELECT FROM UserInfo WHERE userId=?");
			pstmt.setInt(1, userId);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				type=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return type;
	}


}
