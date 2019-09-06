package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;


import com.opensymphony.xwork2.ActionContext;

import Bean.MyManageOrder;
import Bean.MyOrder;
import Bean.Order;
import Bean.Trip;
import exception.OrderException;
import schedule.OrderTimeoutTask;

public class OrderImp implements IOrder {

	public OrderImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(int tripId, int operator, int passenger) {
		// TODO Auto-generated method stub
		MySQLdb db=new MySQLdb();
		int result=0;
		try {
			int effect=db.stmt.executeUpdate("INSERT INTO Orders (tripId,createdTime,operator,passenger) VALUES ("+tripId+","+"now(),"+operator+","+passenger+")");
			if (effect==1) {
				//定时器 30分钟转入失效
				int rencetlyOrderId=this.getMyRecentOrderId();
				Timer timer=new Timer();
				OrderTimeoutTask task=new OrderTimeoutTask();
				timer.schedule(task, 60*1000*30);
				return 1;
			}else if (effect==0) {
				result=-1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=-100;
		}
		return result;
	}

	@Override
	public int delete(int id,int operator) {
		// TODO Auto-generated method stub
		//
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		try {
			//pdb.conn.setAutoCommit(false);
			PreparedStatement ps1=pdb.conn.prepareStatement("UPDATE Orders SET available=? WHERE orderId=?");
			ps1.setInt(1, 0);
			ps1.setInt(2, id);
			ps1.executeUpdate();
			/*
			 * 集成归档操作
			PreparedStatement ps2=pdb.conn.prepareStatement("SELECT available FROM Orders WHERE orderId=?");
			ps2.setInt(1, id);
			ps2.executeQuery();
			PreparedStatement ps3=pdb.conn.prepareStatement("INSERT INTO HistoryOrder (orderId,time,operator) VALUES(?,now(),?)");
			ps3.setInt(1, id);
			ps3.setInt(2, operator);
			ps3.executeUpdate();
			pdb.conn.commit();
			pdb.conn.setAutoCommit(true);*/
			return 1;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			
		}
		return 1;
	}

	@Override
	public int update(int orderId, int passenger, int operator) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order read(int id) {
		// TODO Auto-generated method stub
		MySQLdb db=new MySQLdb();
		Order order=null;
		try {
			ResultSet rs=db.stmt.executeQuery("SELECT * FROM Orders where orderId="+id+" AND available="+1);
			order=Order.turnToOrder(rs);
			rs.close();
			db.stmt.close();
			db.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Order> readAll(int operator) {
		// TODO Auto-generated method stub
		MySQLdb db=new MySQLdb();
		List<Order> orders=null;
		try {
			ResultSet rs=db.stmt.executeQuery("SELECT * FROM Orders WHERE operator ="+operator+" AND available="+1);
			orders=Order.turnToOrders(rs);
			rs.close();
			db.stmt.close();
			db.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<Trip> getTriplistOfOrder(int OrderId) {
		// TODO Auto-generated method stub
		MySQLPrepareDb db=new MySQLPrepareDb();
		
		//ps=db.conn.prepareStatement("SELECT * FROM Trip where tripId ");
		return null;
	}

	@Override
	public List<MyOrder> getMyOrdersDetails(int uid) {
		MySQLPrepareDb db=new MySQLPrepareDb();
		ResultSet rs=null;
		List<MyOrder> myOrderList=null;
		java.sql.CallableStatement cstmt = null;
		try {
			cstmt=db.conn.prepareCall("call getOrderdetails_procedure(?)");
			cstmt.setInt(1, uid);
			rs=cstmt.executeQuery();
			myOrderList=MyOrder.turnToList(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (cstmt!=null) {
					cstmt.close();
				}
				if (db.conn!=null) {
					db.conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return myOrderList;
	}
	@Override
	public List<MyManageOrder> getMyManageOrdersDetails(int managerUid){
		MySQLPrepareDb db=new MySQLPrepareDb();
		ResultSet rs=null;
		List<MyManageOrder> myManageOrder=null;
		java.sql.CallableStatement cstmt=null;
		try {
			cstmt=db.conn.prepareCall("call getMyManageOrdersDetails_procedure(?)");
			cstmt.setInt(1, managerUid);
			rs=cstmt.executeQuery();
			myManageOrder=MyManageOrder.turnToList(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getErrorCode();
			e.getMessage();
		}finally {
			try {
				if (cstmt!=null) {
					cstmt.close();
				}
				if (db.conn!=null) {
					db.conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return myManageOrder;
	}
	@Override
	public int updateOrderPayInfo(int orderId,Timestamp paytime,String payway,String payserialnum,String payStatus){
		// TODO Auto-generated method stub
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		PreparedStatement pstmt = null;
		int effected=-1;
		try {
			pstmt=pdb.conn.prepareStatement("UPDATE Orders SET payTime=?,payWay=?,paySerialNumber=?,payStatus=? WHERE orderId=?");
			pstmt.setTimestamp(1, paytime);
			pstmt.setString(2, payway);
			pstmt.setString(3, payserialnum);
			pstmt.setString(4, payStatus);
			pstmt.setInt(5, orderId);
			effected=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt!=null) {
					pstmt.close();
				}
				if (pdb.conn!=null) {
					pdb.conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			if (effected==-1) {
				throw new OrderException("effected未改变，未能运行SQL");
			}
			if (effected==0) {
				throw new OrderException("支付信息SQL更新失败，effected row为0");
			}
		} catch (OrderException e) {
			e.printStackTrace();
		}
		return effected;
	}

	@Override
	public int updateOrderPayInfo(int orderId, String payStatus,int operator) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		PreparedStatement pstmt=null;
		int effected=-1;
		try {
			pstmt=pdb.conn.prepareStatement("UPDATE Orders SET payStatus=? WHERE orderId=? operator=?");
			pstmt.setString(1, payStatus);
			pstmt.setInt(2,orderId);
			pstmt.setInt(3, operator);
			effected=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt!=null) {
					pstmt.close();
				}
				if (pdb.conn!=null) {
					pdb.conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if (effected==-1) {
				throw new OrderException("effected未改变，未能运行SQL");
			}
			if (effected==0) {
				throw new OrderException("支付信息SQL更新失败，effected row为0");
			}
		} catch (OrderException e) {
			e.printStackTrace();
		}
		return effected;
	}

	@Override
	public int getMyRecentOrderId() {
		// TODO Auto-generated method stub
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		PreparedStatement pstmt = null;
		int result=-1;
		try {
			pstmt=pdb.conn.prepareStatement("SELECT * FROM Orders WHERE available=? AND operator=? ORDER BY createdTime DESC LIMIT 1");
			pstmt.setBoolean(1, true);
			int me=(int)ActionContext.getContext().getSession().get("loginedUser");
			pstmt.setInt(2, me);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				result=rs.getInt(1);
			}else {
				result=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt!=null) {
					pstmt.close();
				}
				if (pdb.conn!=null) {
					pdb.conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public String checkQualifiedToMakeAnOrder() {
		// TODO Auto-generated method stub
		boolean onedaycancelNOtover3times = false;
		boolean ontdayInvalidOrderNumNOover3=false;
		boolean NOexistorderstillnotfinished=false;
		int me=(int)ActionContext.getContext().getSession().get("loginedUser");
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try {
			//第一步，一天内支付超时和取消次数加起来超过3次的
			String today1,today2;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			today1=df.format(new Date()).toString()+" 00:00:00";// new Date()为获取当前系统时间
			today2=df.format(new Date()).toString()+" 23:59:59";
			pstmt=pdb.conn.prepareStatement("SELECT * FROM Orders WHERE payStatus IN (?,?) AND createdTime>? AND  createdTime<? AND operator=?");
			pstmt.setString(1, "已取消");
			pstmt.setString(2, "支付超时");
			pstmt.setString(3, today1);
			pstmt.setString(4, today2);
			pstmt.setInt(5, me);
			ResultSet rs=pstmt.executeQuery();
			int i=0;
			while (rs.next()) {
				i++;
			}
			if (i<3) {
				onedaycancelNOtover3times=true;
			}
			//第二步 当天无效订单加起来超过3张的
			pstmt2=pdb.conn.prepareStatement("SELECT COUNT(1) FROM Orders WHERE available=? AND createdTime>? AND  createdTime<? AND operator=?");
			pstmt2.setBoolean(1, true);
			pstmt2.setString(2, today1);
			pstmt2.setString(3, today2);
			pstmt2.setInt(4, me);
			ResultSet rs2=pstmt2.executeQuery();
			if (rs2.next()) {
				int j=rs2.getInt(1);
				if (j<3) {
					ontdayInvalidOrderNumNOover3=true;
				}
			}
			//第三步 还存在一张没完成支付的订单的
			pstmt3=pdb.conn.prepareStatement("SELECT COUNT(1) FROM Orders WHERE payStatus=? AND createdTime>? AND  createdTime<? AND operator=?");
			pstmt3.setString(1, "未支付");
			pstmt3.setString(2, today1);
			pstmt3.setString(3, today2);
			pstmt3.setInt(4, me);
			ResultSet rs3=pstmt3.executeQuery();
			if (rs3.next()) {
				int k=rs3.getInt(1);
				if (k<3) {
					NOexistorderstillnotfinished=true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt!=null) {
					pstmt.close();
				}
				if (pstmt2!=null) {
					pstmt2.close();
				}
				if (pdb.conn!=null) {
					pdb.conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!onedaycancelNOtover3times||!ontdayInvalidOrderNumNOover3||!NOexistorderstillnotfinished) {
			if (!onedaycancelNOtover3times) {
				return "一天中支付超时、取消订单超过了3起！";
			}
			if(!ontdayInvalidOrderNumNOover3){
				return "一天中无效订单超过3起！";
			}
			else if (!NOexistorderstillnotfinished) {
				return "存在仍未完成支付的订单，请先支付或填写支付信息！";
			}
			else {
				return "未知异常Unknow Error";
			}
		}else{
			return "未知异常Unknow Error";
		}
	}
}
