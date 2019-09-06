package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Bean.MyOrder;
import Bean.MyTrip;
import Bean.Trip;
import exception.OrderException;
import exception.TripException;
public class TripImp implements ITrip{
	public TripImp() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int create(String originator, String terminal, Timestamp goOff, int poll, String remark,int chargedUid) {
		// TODO Auto-generated method stub
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		PreparedStatement pstmt=null;
		int effected=0;
		try {
			pstmt=pdb.conn.prepareStatement("INSERT INTO Trip VALUES(originator=?,terminal=?,goOff=?,poll=?,remark=?,chargedUid=?)");
			pstmt.setString(1, originator);
			pstmt.setString(2, terminal);
			pstmt.setTimestamp(3, goOff);
			pstmt.setInt(4, poll);
			pstmt.setString(5, remark);
			pstmt.setInt(6, chargedUid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (effected==-1) {
				throw new TripException("effected未改变，未能运行SQL");
			}
			if (effected==0) {
				throw new TripException("新增Trip SQL更新失败，effected row为0");
			}
		} catch (TripException e) {
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
		return effected;

	}
	@Override
	public int delete(int tripId) {
		// TODO Auto-generated method stub
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		PreparedStatement pstmt = null;
		int effected=-1;
		try {
			pstmt=pdb.conn.prepareStatement("Update Trip SET avalible='0' WHERE tripId=?");
			pstmt.setInt(1, tripId);
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
				throw new TripException("effected未改变，未能运行SQL");
			}
			if (effected==0) {
				throw new TripException("删除Trip SQL更新失败，effected row为0");
			}
		} catch (TripException e) {
			e.printStackTrace();
		}
		return effected;
	}
	@Override
	public int update(int tripId, String remark) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Trip read(int tripId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> readSpecificTrip(String from,String to,Timestamp goDate, Timestamp returnDate){
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		PreparedStatement pstmt=null;
		List<Trip> triplist = null;
		try {
			pstmt=pdb.conn.prepareStatement("SELECT * FROM Trip where originator=? and terminal=? AND available=? and goOff between ? and ?");
			pstmt.setString(1, from);
			pstmt.setString(2, to);
			pstmt.setBoolean(3, true);
			pstmt.setTimestamp(4, goDate);
			pstmt.setTimestamp(5, returnDate);
			ResultSet rs=pstmt.executeQuery();
			if (rs.last()) {
				System.out.println("Dao.TripImp查询到的rs有"+rs.getRow()+"个结果");
				rs.beforeFirst();
				triplist=Bean.Trip.turnToTripList(rs);
			}else {
				
			}
			rs.close();
			return triplist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();e.getErrorCode();e.getSQLState();e.getMessage();
			return null;
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
	}
	@Override
	public List<Trip> readAll() {
		// TODO Auto-generated method stub
		MySQLdb  db=new MySQLdb();
		List<Trip> triplist=new ArrayList<>();
		ResultSet rs=null;
		try {
			rs=db.stmt.executeQuery("SELECT * FROM Trip WHERE available=1");
			while (rs.next()) {
				Trip tripBean=new Trip();
				tripBean.setTripId(rs.getInt(1));
				tripBean.setCreatedTime(rs.getTimestamp(2));
				tripBean.setOriginator(rs.getString(3));
				tripBean.setTerminal(rs.getString(4));
				tripBean.setGoOff(rs.getTimestamp(5));
				tripBean.setAvailable(rs.getBoolean(6));
				tripBean.setExpTime(rs.getTimestamp(7));
				tripBean.setPoll(rs.getInt(8));
				triplist.add(tripBean);
				//System.out.println(tripBean.ToString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getErrorCode();e.getSQLState();e.getStackTrace();
		}finally {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}
				if (db.stmt!=null) {
					db.stmt.close();
				}
				if (db.conn!=null) {
					db.conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return triplist;
	}
	@Override
	public int getRestPoll(int tripId) {
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		int rest_poll=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=pdb.conn.prepareStatement("SELECT (SELECT COUNT(*) FROM Orders WHERE available=1 AND tripId=?  )- (SELECT COUNT(*) FROM Trip WHERE available=0 AND tripId=? ) AS 'REST'");
		    pstmt.setInt(1, tripId);
		    pstmt.setInt(2, tripId);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				rest_poll=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getErrorCode());
			System.err.println(e.getMessage());
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
		return rest_poll;
	}
	@Override
	public boolean checkExistValidOrderByTripId(int tripId) throws SQLException {
		// TODO Auto-generated method stub
		MySQLPrepareDb pdb=new MySQLPrepareDb();
		PreparedStatement pstmt;
		ResultSet rs;
			pstmt=pdb.conn.prepareStatement(" SELECT * FROM Orders WHERE tripId =? AND available=1");
			pstmt.setInt(1, tripId);
			rs=pstmt.executeQuery();
		if (rs.next()) {
			return true;
		}else{
			return false;
		}
	}
	@Override
	public List<MyTrip> getMyManagedTrip(int uid) {
		// TODO Auto-generated method stub
		MySQLPrepareDb db=new MySQLPrepareDb();
		ResultSet rs=null;
		List<MyTrip> myTripList=null;
		java.sql.CallableStatement cstmt = null;
		try {
			cstmt=db.conn.prepareCall("call getMyManageOrdersDetails_procedure(?)");
			cstmt.setInt(1, uid);
			rs=cstmt.executeQuery();
			myTripList=MyTrip.turnToList(rs);
			
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
		return myTripList;
	}
}
