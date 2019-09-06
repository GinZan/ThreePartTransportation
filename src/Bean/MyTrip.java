package Bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class MyTrip {
	private int tripId;
	private Timestamp createdTime;
	private String originator;
	private String terminal;
	private Timestamp goOff;
	private boolean available;
	private Timestamp expTime;
	private int poll;
	private String remark;
	private int chargedUid;
	private Timestamp lastUpdateTime;
	public MyTrip() {
		// TODO Auto-generated constructor stub
	}

	public static List<MyTrip> turnToList(ResultSet rs) {
		List<MyTrip> myTripList=new ArrayList<MyTrip>();
		// TODO Auto-generated method stub
		try {
			while (rs.next()) {
				MyTrip one=new MyTrip();
				one.setTripId(rs.getInt("tripId"));
				one.setCreatedTime(rs.getTimestamp("createdTime"));
				one.setOriginator(rs.getString("originator"));
				one.setTerminal(rs.getString("terminal"));
				one.setGoOff(rs.getTimestamp("goOff"));
				one.setAvailable(rs.getBoolean("available"));
				one.setExpTime(rs.getTimestamp("expTime"));
				one.setPoll(rs.getInt("poll"));
				one.setRemark(rs.getString("remark"));
				one.setChargedUid(rs.getInt("chargedUid"));
				one.setLastUpdateTime(rs.getTimestamp("lastUpdateTime"));
				//myTripList.add(one);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myTripList;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
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

	public Timestamp getGoOff() {
		return goOff;
	}

	public void setGoOff(Timestamp goOff) {
		this.goOff = goOff;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Timestamp getExpTime() {
		return expTime;
	}

	public void setExpTime(Timestamp expTime) {
		this.expTime = expTime;
	}

	public int getPoll() {
		return poll;
	}

	public void setPoll(int poll) {
		this.poll = poll;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getChargedUid() {
		return chargedUid;
	}

	public void setChargedUid(int chargedUid) {
		this.chargedUid = chargedUid;
	}

	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
