package DAO;

import java.util.List;

import Bean.Contact;

public interface IContact {
	/**
	 * 创建联系人，可以在创建的时候加上belongUid代表属于谁的。
	 * @param contact 
	 * @return int 1表示成功 -1表示失败
	 */
	public int create(Contact contact);
	/**
	 * 删除联系人
	 * @param contactId 删除依据，联系人id
	 * @return int 1表示成功，-1表示失败，3表示SQL插入异常
	 */
	public int del(int contactId);
	/**
	 * 修改联系人
	 * @param contactId 查找依据 联系人id
	 * @param contact 联系人对象，作为更新的对象
	 * @return int 1表示成功， -1表示失败
	 */
	public int update(int contactId,Contact contact);
	/**
	 * 查询联系人 返回List联系人集合
	 * @return
	 */
	public List<Contact> query(int belongId);
}
