package util.demo;

import java.sql.SQLException;

import DAO.MySQLdb;

public class Truncate {

	public Truncate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySQLdb db=new MySQLdb();
		String tableToTuncated="Bus";
		try {
			db.stmt.execute("SET foreign_key_checks=0");
			db.stmt.execute("TRUNCATE TABLE "+tableToTuncated);
			db.stmt.execute("SET foreign_key_checks=1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
