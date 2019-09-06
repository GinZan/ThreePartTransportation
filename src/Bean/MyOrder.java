package Bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MyOrder {
	private int orderId;
	private Timestamp createdTime;
	private String paymentStatus;
	private String realName;
	private String tel;
	private int tripId;
	private String originator;
	private String terminal;
	public MyOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static List<MyOrder> turnToList(ResultSet rs){
		List<MyOrder> myOrderList=new ArrayList<MyOrder>();
		try {
			while (rs.next()) {
				MyOrder one=new MyOrder();
				one.setOrderId(rs.getInt(1));
				one.setCreatedTime(rs.getTimestamp(2));
				one.setPaymentStatus(rs.getString(3));
				one.setRealName(rs.getString(4));
				one.setTel(rs.getString(5));
				one.setTripId(rs.getInt(6));
				one.setOriginator(rs.getString(7));
				one.setTerminal(rs.getString(8));
				myOrderList.add(one);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myOrderList;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getOriginator() {
		return originator;
	}
	public void setOriginator(String originator) {
		this.originator = originator;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	
}
