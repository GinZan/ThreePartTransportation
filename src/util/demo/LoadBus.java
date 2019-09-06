package util.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.MySQLdb;

public class LoadBus {

	public LoadBus() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] allDriverId=getDriverId();
		MySQLdb db=new MySQLdb();
		for (int i = 0; i < allDriverId.length; i++) {
			StringBuilder sb=new StringBuilder();
			sb.append("INSERT INTO Bus VALUES (");
			sb.append("'"+RandomStuff.getRandomPlate()+"',");
			sb.append(45);
			sb.append(","+allDriverId[i]);
			sb.append(");");
			//开始插入
			try {
				int state=db.stmt.executeUpdate(sb.toString());
				if (state==1) {
					System.out.println("司机id为"+allDriverId[i]+"的Bus记录插入成功！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//for循环结束后再关闭相关通道
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
		
	/**
	 * 查询所有司机的id
	 * @return String[] 注意不是按顺序的，因为是char主键
	 * @throws SQLException
	 */
	public static String[] getDriverId(){
		MySQLdb db=new MySQLdb();
		String[] temp=null;
		ResultSet rs=null;
		try {
			rs=db.stmt.executeQuery("SELECT * FROM Driver ORDER BY driverId");
			rs.last();
			int howmanyDrivers=rs.getRow();
			temp=new String[howmanyDrivers];
			//System.out.println("数组长度是"+temp.length+"得到司机数"+howmanyDrivers);
			rs.beforeFirst();
			for (int i = 0; i < temp.length; i++) {
				if (!rs.isAfterLast()) {
					rs.next();
					temp[i]=rs.getString(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
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
		return temp;
	}
}
