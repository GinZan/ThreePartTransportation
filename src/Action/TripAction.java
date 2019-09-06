package Action;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Bean.Trip;
import DAO.ITrip;
import DAO.TripImp;


public class TripAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		List<Trip> triplist;
		//某班次剩余票数
		private int rest_poll;
		//分页查询条件
		private int limit_rows;
		private int offset;
		
		@Override
		public String execute() throws Exception {
			return null;
			// TODO Auto-generated method stub
			
		}
		
		public String ajaxQueryAlltrip(){
			ITrip i=new TripImp();
			this.triplist=i.readAll();
			int tripId=1;
			offset=i.getRestPoll(tripId);
			return SUCCESS;
		}
		public List<Trip> getTriplist() {
			return triplist;
		}

		public void setTriplist(List<Trip> triplist) {
			this.triplist = triplist;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public int getLimit_rows() {
			return limit_rows;
		}
		public void setLimit_rows(int limit_rows) {
			this.limit_rows = limit_rows;
		}
		public int getOffset() {
			return offset;
		}
		public void setOffset(int offset) {
			this.offset = offset;
		}


		public int getRest_poll() {
			return rest_poll;
		}


		public void setRest_poll(int rest_poll) {
			this.rest_poll = rest_poll;
		}
	
}
