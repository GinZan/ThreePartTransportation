package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.mysql.fabric.Response;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DAO.IOrder;
import DAO.ITrip;
import DAO.OrderImp;
import DAO.TripImp;
import Bean.MyOrder;
public class OrderAction extends ActionSupport {
	//下单条件
	int tripId;
	int loginedUser;
	String[] passenger;
	//反馈的成功数量
	int succNum;
	//获取我的订单的存储进程_参数
	int uid_getOrderdetails_procedure;
	List<MyOrder> myOrderList;
	//退票、更改订单支付信息用到的属性
	int orderId;
	//更改订单支付信息用到的属性
	String paySerialNumber;
	Timestamp tradeTime;
	String payWay;
	
	//前台提示信息
	String resultMessage;
	boolean makeOrderIscalled;
	
	@Override
	public String execute() throws Exception {
		makeOrderIscalled=true;
		// TODO Auto-generated method stub
		IOrder dao=new OrderImp();
		Map<String, Object> session=ActionContext.getContext().getSession();
		this.loginedUser=Integer.valueOf(session.get("loginedUser").toString());
		//下订单
			//先检查下订单的前置条件
		String messageAfterCheck=dao.checkQualifiedToMakeAnOrder();
		if (messageAfterCheck!=null) {
			//说明不符合资格
				//输出前端提示信息
			resultMessage=messageAfterCheck;
			return ERROR;
		}
		//下面检查余票要用到的dao
		ITrip tripdao=new TripImp();
		for (int i = 0; i < passenger.length; i++) {
			//检查还有没有票
			int howmany=tripdao.getRestPoll(tripId);
			if (howmany>0) {
				//才开始真正的操作订票，增加Order记录
				int result=dao.create(tripId, loginedUser, Integer.valueOf(passenger[i]));
				if (result==1) {
					succNum++;
				}
			}//否则的话就不用管了
		}
		if (succNum!=0) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	public String getMyOrdersDetails() throws SQLException{
		IOrder dao=new OrderImp();
		uid_getOrderdetails_procedure=(int)ActionContext.getContext().getSession().get("loginedUser");
		//uid_getOrderdetails_procedure=1;
		myOrderList=dao.getMyOrdersDetails(uid_getOrderdetails_procedure);
		return SUCCESS;
	}
	/**
	 *订单状态由未支付改为待审核 
	 * @return
	 */
	public String payValidateInfo(){
		IOrder dao=new OrderImp();
		int result=dao.updateOrderPayInfo(orderId, tradeTime, payWay, paySerialNumber,"待审核");
		String returnString=null;
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        PrintWriter out=null;
		try {
			out = response.getWriter();
			if (result>=1) {
				out.write("<script>alert('验证成功！')</script>");
				returnString=SUCCESS;
			}else {
				out.write("<script>alert('验证失败！')</script>");
				returnString= ERROR;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return returnString;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String delOrder(){
		IOrder dao=new OrderImp();
		loginedUser=(int)ActionContext.getContext().getSession().get("loginedUser");
		//loginedUser=1;
		int result=dao.delete(orderId, loginedUser);
		return SUCCESS;
	}
	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public int getLoginedUser() {
		return loginedUser;
	}

	public void setLoginedUser(int loginedUser) {
		this.loginedUser = loginedUser;
	}

	public int getSuccNum() {
		return succNum;
	}

	public int getUid_getOrderdetails_procedure() {
		return uid_getOrderdetails_procedure;
	}
	public void setUid_getOrderdetails_procedure(int uid_getOrderdetails_procedure) {
		this.uid_getOrderdetails_procedure = uid_getOrderdetails_procedure;
	}
	public List<MyOrder> getMyOrderList() {
		return myOrderList;
	}
	public void setMyOrderList(List<MyOrder> myOrderList) {
		this.myOrderList = myOrderList;
	}
	public void setSuccNum(int succNum) {
		this.succNum = succNum;
	}

	public String[] getPassenger() {
		return passenger;
	}

	public void setPassenger(String[] passenger) {
		this.passenger = passenger;
	}
	
	public String getPaySerialNumber() {
		return paySerialNumber;
	}
	public void setPaySerialNumber(String paySerialNumber) {
		this.paySerialNumber = paySerialNumber;
	}
	public Timestamp getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Timestamp tradeTime) {
		this.tradeTime = tradeTime;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public boolean isMakeOrderIscalled() {
		return makeOrderIscalled;
	}
	public void setMakeOrderIscalled(boolean makeOrderIscalled) {
		this.makeOrderIscalled = makeOrderIscalled;
	}
}
