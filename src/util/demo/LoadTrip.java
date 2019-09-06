package util.demo;

import java.sql.SQLException;
import java.sql.Statement;

import DAO.MySQLdb;

public class LoadTrip {
	static String[] start={"广州","深圳","梅州","湛江","清远","佛山","中山","韶关"};
	static String[] des={"福州","宁德","莆田","泉州","漳州","龙岩 ","三明","南平"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		MySQLdb db=new MySQLdb();
		for (int i = 0; i < start.length; i++) {
			for (int j = 0; j < des.length; j++) {
				String string="INSERT INTO `buscompany`.`Trip` (`createdTime`, `originator`, `terminal`, `goOff`, `poll`) VALUES ('2015-12-07 16:42:00','"+start[i].toString()+"','"+des[j].toString()+"',"+"'2015-12-07 16:42:00',"+"45)";
				try {
					db.stmt.execute(string);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("SQL字符串是："+string);
				count++;
			}
		}
		System.out.println("以上共计："+count+"个结果");
		try {
			db.stmt.close();
			db.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
