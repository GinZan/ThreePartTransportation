package Action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import Bean.Trip;
import DAO.ITrip;
import DAO.TripImp;

public class AjaxAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4065985197706841122L;
	private List<Trip> triplist;
	private String from;
	private String to;
	private String godate;
	private String returndate;
	public String execute(){
		ITrip i=new TripImp();
		triplist=i.readSpecificTrip(from,to,Timestamp.valueOf(godate),Timestamp.valueOf(returndate));
		return SUCCESS;
	}
	public List<Trip> getTriplist() {
		return triplist;
	}
	
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getGodate() {
		return godate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setTriplist(List<Trip> triplist) {
		this.triplist = triplist;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void setGodate(String godate) {
		this.godate = godate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
}
