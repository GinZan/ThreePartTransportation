package DAO;

import java.util.List;

import Bean.Bus;
import Bean.*;
public interface IBus{

	/**
	 * 新增巴士
	 * @param plateNumber
	 * @param driverId
	 * @param seating
	 * @return 如果成功返回1否则返回-1
	 */
	int create(String plateNumber,int driverId,String seating);
	
	/**
	 * 删除巴士
	 * @param plateNumber
	 * @return 如果成功返回1否则返回-1
	 */
	int delete(String plateNumber);

	/**
	 * 修改大巴信息，请注意！车牌号禁止修改
	 * @param id 查找依据
	 * @param bus 将此作为更新实体
	 * @return 如果成功返回1否则返回-1
	 */
	public int update(String plateNumber,int driverId,String seating);
	
	/**
	 * 查询大巴
	 * @param plateNumber
	 * @return 
	 */
	Bus read(String plateNumber);

	List<Bus> readAll();

}
