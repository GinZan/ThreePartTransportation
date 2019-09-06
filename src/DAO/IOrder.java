package DAO;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import Bean.*;

public interface IOrder{
	/**
	 * 下单
	 * @param tripId 班次
	 * @param operator 操作人
	 * @param passenger 乘客
	 * @return 如果成功返回1否则返回-1
	 */
	int create(int tripId,int operator,int passenger);

	/**
	 * 使订单失效，并在日志表添加纪录
	 * @param OrderId
	 * @return 如果成功返回1否则返回-1
	 */
	int delete(int id,int operator);

	/**
	 * 更新订单信息，只允许更改乘客和操作人
	 * @param orderId
	 * @param passenger 乘客
	 * @param operator 操作人
	 * @return 如果成功返回1否则返回-1
	 */
	int update(int orderId,int passenger,int operator);
	
	/**
	 * 查询订单详情
	 * @param OrderIdl
	 * @return
	 */
	Order read(int id);
	
	/**
	 * 得到我最近创建的一个订单，主要用于定时器
	 * @return 订单id
	 */
	int getMyRecentOrderId();
	/**
	 * 检查下单的前置条件，如一天中取消订单的次数、支付超时的订单数
	 * @return 符合条件则返回空String消息，否则返回异常消息字符串
	 */
	String checkQualifiedToMakeAnOrder();
	public List<MyOrder> getMyOrdersDetails(int uid);
	/**
	 * 查询所有订单
	 */
	List<Order> readAll(int operator);
	
	/**
	 * 查询订单相关的车次
	 */
	List<Trip> getTriplistOfOrder(int OrderId);
	/**
	 * 更新支付信息
	 * @param orderId 查询条件
	 * @param paytime支付时间
	 * @param payway支付方式
	 * @param payserialnum支付流水号
	 * @return
	 */
	public int updateOrderPayInfo(int orderId,Timestamp paytime,String payway,String payserialnum,String payStatus);
	/**
	 * 更改一张订单的支付状态
	 * @param orderId
	 * @param payStatus
	 * @return -1 SQL没执行 0 执行后没影响的行 否则返回影响的行数
	 */
	public int updateOrderPayInfo(int orderId,String payStatus,int operator);
	/**
	 * 查看一个管理员管理的所有订单
	 * @param uid
	 * @return 
	 */
	public List<MyManageOrder> getMyManageOrdersDetails(int managerUid);
}
