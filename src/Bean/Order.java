package Bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	private int orderId;
	private  int tripId;
	private Timestamp createTime;
	private int operator;
	private int passenger;
	private String payStatus;
	private String payWay;
	private Timestamp payTime;
	private String payserialNumber;
	private Boolean available;
	private Timestamp lastUpdateTime;
	
	public static List<Order> turnToOrders(ResultSet rs){
		List<Order> orderList=null;
		try {
			orderList=new ArrayList<Order>();
			while (rs.next()) {
				Order order=new Order();
				order.setOrderId(rs.getInt(1));
				order.setTripId(rs.getInt(2));
				order.setCreateTime(rs.getTimestamp(3));
				order.setOperator(rs.getInt(4));
				order.setPassenger(rs.getInt(5));
				order.setPayStatus(rs.getString(6));
				order.setPayWay(rs.getString(7));
				order.setPayTime(rs.getTimestamp(8));
				order.setPayserialNumber(rs.getString(9));
				order.setAvailable(rs.getBoolean(10));
				order.setLastUpdateTime(rs.getTimestamp(11));
				orderList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getErrorCode();
			e.getSQLState();
			e.getMessage();
		}
		return orderList;
	}
	public static Order turnToOrder(ResultSet rs){
		Order order=null;
		try {
			if (rs.next()) {
				order=new Order();
				order.setOrderId(rs.getInt(1));
				order.setTripId(rs.getInt(2));
				order.setCreateTime(rs.getTimestamp(3));
				order.setOperator(rs.getInt(4));
				order.setPassenger(rs.getInt(5));
				order.setPayStatus(rs.getString(6));
				order.setPayWay(rs.getString(7));
				order.setPayTime(rs.getTimestamp(8));
				order.setPayserialNumber(rs.getString(9));
				order.setAvailable(rs.getBoolean(10));
				order.setLastUpdateTime(rs.getTimestamp(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripid) {
		this.tripId = tripid;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getPassenger() {
		return passenger;
	}
	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public Timestamp getPayTime() {
		return payTime;
	}
	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}
	public String getPayserialNumber() {
		return payserialNumber;
	}
	public void setPayserialNumber(String payserialNumber) {
		this.payserialNumber = payserialNumber;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
}
