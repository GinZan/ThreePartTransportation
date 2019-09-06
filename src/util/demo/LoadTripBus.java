package util.demo;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Random;

import DAO.MySQLdb;

public class LoadTripBus {
	String busPlate;
	
	public LoadTripBus() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySQLdb db=new MySQLdb();
		StringBuilder sb=new StringBuilder();
		Timestamp ts=RandomStuff.getCurrentTime();
		for(int i=1;i<64;i++){
			sb.append("INSERT INTO TripBus VALUES ");
			sb.append("(");
			sb.append(i+" ");
			sb.append(i+" ");
			sb.append(ts);
			sb.append(");");
		}
		System.out.println(sb);
	}
}
