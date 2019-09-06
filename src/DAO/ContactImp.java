package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Bean.Contact;

public class ContactImp implements IContact  {

	public ContactImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Contact contact) {
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		PreparedStatement stmt = null;
		try {
			stmt=pdb.conn.prepareStatement("INSERT INTO Contact VALUES(id=?,belongUid=?,userName=?,sex=?,phone=?,shortNum=?)");
			stmt.setInt(1, contact.getId());
			stmt.setInt(2, contact.getBelongUid());
			stmt.setString(3, contact.getUserName());
			stmt.setString(4, contact.getSex());
			stmt.setString(5, contact.getPhone());
			stmt.setString(6, contact.getShortNum());
			int result=stmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 3;
		}finally{
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pdb.conn!=null) {
				try {
					pdb.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public int del(int contactId) {
		// TODO Auto-generated method stub
		MySQLdb db=new MySQLdb();
		try {
			return db.stmt.executeUpdate("DELETE FROM Contact WHERE id="+contactId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 3;
		}
	}

	@Override
	public int update(int contactId, Contact contact) {
		// TODO Auto-generated method stub
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		try {
			PreparedStatement stmt=pdb.conn.prepareStatement("UPDATE  Contact SET belongUid=?,userName=?,sex=?,phone=?,shortNum=? WHERE id=?");
			stmt.setInt(1,	contact.getBelongUid());
			stmt.setString(2, contact.getUserName());
			stmt.setString(3, contact.getSex());
			stmt.setString(4, contact.getPhone());
			stmt.setString(5, contact.getShortNum());
			stmt.setInt(6,contactId);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 3;
		}
	}

	@Override
	public List<Contact> query(int belongId) {
			// TODO Auto-generated method stub
		List<Contact> contactList=null;
		 MySQLdb db=new MySQLdb();
		 try {
			ResultSet rs=db.stmt.executeQuery("SELECT * FROM Contact WHERE belongUid="+belongId);
			if (rs.last()) {
				rs.beforeFirst();
				contactList=Contact.turnToContactList(rs);
			}
			return contactList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
