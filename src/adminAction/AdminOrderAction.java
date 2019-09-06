package adminAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Bean.MyManageOrder;
import DAO.IOrder;
import DAO.OrderImp;

public class AdminOrderAction extends ActionSupport {
	int loginedUser;
	//退票、更改订单支付信息用到的属性
	int orderId;
	//输出的List
	List<MyManageOrder> myManageOrderList;
	String resultMessage;
	int validateOrderPayIsCalled;
	
	public String getAdminOrdersDetails() throws SQLException{
		IOrder dao=new OrderImp();
		int managerUid=(int)ActionContext.getContext().getSession().get("loginedUser");
		myManageOrderList=dao.getMyManageOrdersDetails(managerUid);
		return SUCCESS;
	}
	public String validateOrderPay() throws SQLException{
		this.setValidateOrderPayIsCalled(1);
		int effectedRows=-1;
		IOrder dao=new OrderImp();
		int me=(int)ActionContext.getContext().getSession().get("loginedUser");
		effectedRows=dao.updateOrderPayInfo(orderId, "已支付",me);
		//这里应该添加日志
		if (effectedRows!=-1&&effectedRows!=0) {
			this.setResultMessage("已成功更新订单号为"+this.getOrderId()+"的支付状态为【已支付！】");
			getAdminOrdersDetails();
			return SUCCESS;
		} else {
			this.setResultMessage("更新支付状态失败！！！");
			return ERROR;
		}
	}
	/**
	 * 撤销指定订单的支付信息
	 * @return
	 * @throws SQLException 
	 */
	public String undoOrderPay() throws SQLException{
		this.validateOrderPayIsCalled=1;
		int effectedRows=-1;
		IOrder dao=new OrderImp();
		effectedRows=dao.updateOrderPayInfo(orderId, null, null, null, "未支付");
		//这里应该添加日志
		if (effectedRows!=-1&&effectedRows!=0) {
			this.setResultMessage("已成功更新订单号为"+this.getOrderId()+"的支付状态为【未支付！】");
			getAdminOrdersDetails();
			return SUCCESS;
		} else {
			this.setResultMessage("更新支付状态失败！！！");
			return ERROR;
		}
	}
	/**
	 * 手动强制删除订单
	 * 将物理删除无用订单，无法从历史纪录恢复
	 * @return
	 */
	public String ForceDelOrder(){
		this.validateOrderPayIsCalled=1;
		int effectedRows=-1;
		IOrder dao=new OrderImp();
		Map<String, Object> session=ActionContext.getContext().getSession();
		this.loginedUser=Integer.valueOf(session.get("loginedUser").toString());
		effectedRows=dao.delete(orderId, this.getLoginedUser());
		//这里应该添加日志
		if (effectedRows!=-1&&effectedRows!=0) {
			this.setResultMessage("已成功删除订单号为"+this.getOrderId()+"的所有相关信息");
			return SUCCESS;
		} else {
			this.setResultMessage("删除失败！！！");
			return ERROR;
		}
	}
	public List<MyManageOrder> getMyManageOrderList() {
		return myManageOrderList;
	}
	public void setMyManageOrderList(List<MyManageOrder> myManageOrderList) {
		this.myManageOrderList = myManageOrderList;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public int getValidateOrderPayIsCalled() {
		return validateOrderPayIsCalled;
	}
	public void setValidateOrderPayIsCalled(int validateOrderPayIsCalled) {
		this.validateOrderPayIsCalled = validateOrderPayIsCalled;
	}
	public int getLoginedUser() {
		return loginedUser;
	}
	public void setLoginedUser(int loginedUser) {
		this.loginedUser = loginedUser;
	}

}
