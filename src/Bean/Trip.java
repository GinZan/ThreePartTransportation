package Bean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class Trip {
	private int tripId;
	private  Timestamp createdTime;
	private String originator;
	private String terminal;
	private Timestamp goOff;
	private Boolean available;
	private Timestamp expTime;
	private int poll;
	private String remark;
	private int chargUid;
	private Timestamp lastUpdateTime;
	/**
	 * 从ResultSet转换成Trip对象集合
	 * @param rs
	 * @return
	 */
	public static List<Trip> turnToTripList(ResultSet rs){
		List<Trip> triplist=null;
		try {
			triplist=new ArrayList<Trip>();
			while(rs.next()){
				Trip trip=new Trip();
				trip.setTripId(rs.getInt(1));
				trip.setCreatedTime(rs.getTimestamp(2));
				trip.setOriginator(rs.getString(3));
				trip.setTerminal(rs.getString(4));
				trip.setGoOff(rs.getTimestamp(5));
				trip.setAvailable(rs.getBoolean(6));
				trip.setExpTime(rs.getTimestamp(7));
				trip.setPoll(rs.getInt(8));
				trip.setRemark(rs.getString(9));
				trip.setChargUid(rs.getInt(10));
				trip.setLastUpdateTime(rs.getTimestamp(11));
				triplist.add(trip);
				System.out.println("Model在static装载rs为List结果后包含"+triplist.size()+"个元素");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getErrorCode();
			e.getSQLState();
			e.printStackTrace();
		}
		return triplist;
	}
	public String ToString(){
		String str= String.valueOf(this.tripId)+this.createdTime+this.originator+this.terminal+this.goOff+this.available+this.expTime+String.valueOf(this.poll);
		return str;
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
	
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
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
	public int getChargUid() {
		return chargUid;
	}
	public void setChargUid(int chargUid) {
		this.chargUid = chargUid;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	
}
