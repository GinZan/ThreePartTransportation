package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Bean.User;
import exception.LoginException;

public class UserImp implements IUser {

	public UserImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(String email,String password) {
		// TODO Auto-generated method stub
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		try {
			PreparedStatement ps=pdb.conn.prepareStatement("INSERT INTO Users VALUES(email=?,pass=?)");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int uid, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User read(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int validateLogin(User user) throws SQLException, LoginException {
		// TODO Auto-generated method stub
		boolean result=false;
		int returnedUID=0;
		MySQLPrepareDb pdb=new MySQLPrepareDb();
			PreparedStatement ps;
			if (user.getEmail()==null||user.getEmail()=="") {//email为空
				if (user.getUid()!=0) {//但uid不为空
					ps=pdb.conn.prepareStatement("SELECT * FROM Users WHERE uid=? AND pass=?");
					ps.setInt(1, user.getUid());
				}else{//同时uid也空
					throw new LoginException("登陆账号一项中email和uid二者必须有一者不为空Exception");
				}
			}else{//email不为空
				ps=pdb.conn.prepareStatement("SELECT * FROM Users WHERE uid=? AND pass=?");
				ps.setString(1, user.getEmail());
			}
			//无论如何最后都设置第二个prepared参数
			ps.setString(2, user.getPass());
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				returnedUID=rs.getInt(1);
				result=true;
			}else {
				result=false;
			}
		return returnedUID;	
	}
	
}
