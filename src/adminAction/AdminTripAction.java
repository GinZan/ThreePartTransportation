package adminAction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Bean.MyOrder;
import Bean.MyTrip;
import DAO.ITrip;
import DAO.TripImp;

public class AdminTripAction extends ActionSupport {
	private String  originator;
	private String terminal;
	private Timestamp goOff;
	private int poll;
	private String remark;
	private  int chargedUid;
	private int tripId;
	String resultMessage;
	int delTripIsCalled;
	//获取我的订单的存储进程_参数
	int admin_uid_getMyManageOrdersDetails_procedure;
	List<MyTrip> myTripList;
	
	 public String addTrip(){
		ITrip dao=new TripImp();
		int result=dao.create(this.originator,this.terminal,this.goOff,this.poll,this.remark,this.chargedUid);
		if (result==1) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	 public String getMyManageTrip(){
		 ITrip trip =new TripImp();
		 admin_uid_getMyManageOrdersDetails_procedure=(int)ActionContext.getContext().getSession().get("loginedUser");
		 myTripList=trip.getMyManagedTrip(admin_uid_getMyManageOrdersDetails_procedure);
		 return SUCCESS;
	 }
	public String delTrip(int tripId){
		ITrip dao=new TripImp();
		int result=dao.delete(tripId);
		//线程中已经调用过此方法
		delTripIsCalled=1;
		String returnString=" ";
		//检查是否正准备删除的Trip存在有效订单
		try {
			boolean safe=dao.checkExistValidOrderByTripId(tripId);
			if(!safe){
				resultMessage="删除失败！该班次还存在有效订单！";
				returnString=ERROR;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dao.delete(tripId)==1) {
			resultMessage="删除班次成功!";
			returnString=SUCCESS;
		}else{
			resultMessage="删除失败！imp操作失败";
			//这里应该增加日志
			returnString=ERROR;
		}
		return returnString;
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
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public int getDelTripIsCalled() {
		return delTripIsCalled;
	}
	public void setDelTripIsCalled(int delTripIsCalled) {
		this.delTripIsCalled = delTripIsCalled;
	}
}
