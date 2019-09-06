package util.demo;

import java.sql.SQLException;

import DAO.MySQLdb;

public class LoadUsers {

	public LoadUsers() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySQLdb db=new MySQLdb();
		for (int i = 10000; i < 15000; i++) {
			String randomEmail=RandomStuff.getRandomEmail();
			String pass="'123456'";
			try {
				String sql="INSERT INTO Users VALUES ("+"'"+i+"', "+"'"+randomEmail+"', "+"sha1("+pass+"));";
				System.out.println(sql);
				db.stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			db.stmt.close();
			db.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
