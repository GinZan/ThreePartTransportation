package util.demo;

import java.sql.SQLException;

import DAO.MySQLdb;

public class LoadDriver {

	public LoadDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		MySQLdb db=new MySQLdb();
		try {
			for (int i = 1; i < 50; i++) {
				StringBuilder sb=new StringBuilder();
				sb.append("INSERT INTO Driver VALUES (");
				sb.append(i+",");
				sb.append("'"+"123456"+"'"+",");
				sb.append("'"+RandomStuff.getRandomName()+"'"+",");
				sb.append("'"+RandomStuff.getRandomTel()+"'"+",");
				sb.append("'"+RandomStuff.getRandomSex()+"'");
				sb.append(");");
				System.out.println(sb.toString());
			db.stmt.executeUpdate(sb.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getErrorCode();
			e.getSQLState();
			e.getMessage();
			e.printStackTrace();
		}finally {
			try {
				db.stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				db.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
