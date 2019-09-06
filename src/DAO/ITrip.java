package DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import Bean.MyTrip;
import Bean.Trip;

public interface ITrip{
	/**
	 * 新增班次
	 * @param originator 出发地
	 * @param terminal 终点站
	 * @param goOff 出发时间
	 * @param poll 座位数
	 * @param remark 备注
	 * @return 如果成功返回1否则返回-1
	 */
	int create(String originator,String terminal,Timestamp goOff,int poll,String remark,int chargedUid);

	/**
	 * 删除班次
	 * @param tripId
	 * @return 如果成功返回1否则返回-1
	 */
	int delete(int tripId);

	/**
	 * 修改班次备注，其他属性不支持修改
	 * @param tripId
	 * @param remark
	 * @return 如果成功返回1否则返回-1
	 */
	int update(int tripId,String remark);
	
	/**
	 * 查询车次对象
	 * @param tripId
	 * @return Trip对象
	 */
	Trip read(int tripId);
	public List<MyTrip> getMyManagedTrip(int uid);
	/**
	 * 查询某班次剩余票数
	 * @param tripid
	 * @return 剩余票数
	 */
	public int getRestPoll(int tripId);
	/**
	 * 获取班次剩余座位数，存储过程调用
	 * @param uid
	 * @return 订单详细的结果集
	 * 
	 */
	/**
	 * 查询所有车次对象
	 * @return List<Trip>
	 */
	List<Trip> readAll();
	
	/**
	 * 根据特定条件查询Trip集合
	 * @param from
	 * @param to
	 * @param goDate
	 * @param returnDate
	 * @return
	 */
	List<Trip> readSpecificTrip(String from, String to, Timestamp goDate, Timestamp returnDate);
	/**
	 * 检查班次是否还存在有有效订单,删除班次的时候用
	 * @return 存在返回真否则返回false
	 * @throws SQLException 
	 */
	boolean checkExistValidOrderByTripId(int tripId) throws SQLException;
}
