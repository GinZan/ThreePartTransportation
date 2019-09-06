package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.*;
public class MySQLdb{
	public  Connection conn=null;
	public Statement stmt = null;
	/**
	 * test
	  public static void main(String args[]){
		doCreate("");
	}
	 * @param args
	 */
	public MySQLdb(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://139.129.27.128/buscompany?"+"user=root&password=PE57-mysql&characterEncoding=utf-8");
			stmt=conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
