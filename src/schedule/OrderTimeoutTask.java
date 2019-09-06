package schedule;

import java.util.TimerTask;

import com.opensymphony.xwork2.ActionContext;

import Bean.Order;
import DAO.IOrder;
import DAO.OrderImp;

public class OrderTimeoutTask extends TimerTask {
	int orderId;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		IOrder dao=new OrderImp();
		if (orderId!=0) {
			Order order=dao.read(orderId);
			String payStatus=order.getPayStatus();
			if (payStatus=="未支付") {
				int me=(int)ActionContext.getContext().getSession().get("loginedUser");
				//使当前超时订单
				dao.updateOrderPayInfo(orderId, "支付超时",me);
				System.err.println("订单"+orderId+"已经设置成\"支付超时\"状态");
			}
		}else{
			return;
		}
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
