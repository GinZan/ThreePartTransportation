package Bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MyManageOrder {
	private int orderId;
	private Timestamp createdTime;
	private String operatorName;
	private String passengerName;
	private String tel;
	private String paymentStatus;
	private String payWay;
	private Timestamp payTime;
	private String paySerialNumber;
	private int tripId;
	private String originator;
	private String terminal;
	public MyManageOrder() {
		super();
	}
	
	public static List<MyManageOrder> turnToList(ResultSet rs){
		List<MyManageOrder> myManageOrder=new ArrayList<MyManageOrder>();
		try {
			while (rs.next()) {
				MyManageOrder one=new MyManageOrder();
				one.setOrderId(rs.getInt("orderId"));
				one.setCreatedTime(rs.getTimestamp("createdTime"));
				one.setOperatorName(rs.getString("operatorName"));
				one.setPassengerName(rs.getString("passengerName"));
				one.setTel(rs.getString("tel"));
				one.setPaymentStatus(rs.getString("payStatus"));
				one.setPayWay(rs.getString("payWay"));
				one.setPayTime(rs.getTimestamp("payTime"));
				one.setPaySerialNumber(rs.getString("paySerialNumber"));
				one.setTripId(rs.getInt("tripId"));
				one.setOriginator(rs.getString("originator"));
				one.setTerminal(rs.getString("terminal"));
				myManageOrder.add(one);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myManageOrder;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
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

	public void payTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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

	public String getPaySerialNumber() {
		return paySerialNumber;
	}

	public void setPaySerialNumber(String paySerialNumber) {
		this.paySerialNumber = paySerialNumber;
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
