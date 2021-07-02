package dev.athmer.project1.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.athmer.project1.beans.TierInfo;
//import dev.athmer.project1.logging.AppLogger;
import dev.athmer.project1.utilities.JDBCConnection;

public class TierInfoRepository implements RootRepository<TierInfo> {
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public TierInfo add(TierInfo t) {
		//AppLogger.logger.info("Account table add record request.");
		String sql = "insert into \"Project_1\".tierinfo values (default, default, default, default, default ?) returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getRequests());
			
			boolean success = ps.execute();
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					t.setId(rs.getInt("id"));
					t.setToid(rs.getString("toid"));
					t.setTomsg(rs.getString("tomsg"));
					t.setFromid(rs.getString("fromid"));
					t.setTomsg(rs.getString("frommsg"));
					t.setRequests(rs.getInt("requests"));
					
					return t;
				}
			}
			
		}
		catch (SQLException e) {
//			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TierInfo getById(Integer id) {
		//AppLogger.logger.info("Account table view by ID request.");
		String sql = "select * from \"Project_1\".tierinfo where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				TierInfo t = new TierInfo();
				t.setId(rs.getInt("id"));
				t.setToid(rs.getString("toid"));
				t.setTomsg(rs.getString("tomsg"));
				t.setFromid(rs.getString("fromid"));
				t.setTomsg(rs.getString("frommsg"));
				t.setRequests(rs.getInt("requests"));
				
				return t;
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<TierInfo> getAll() {
		//AppLogger.logger.info("Account table view all request.");
		List<TierInfo> tierinfo = new ArrayList<TierInfo>();
		
		String sql = "select * from \"Project_1\".tierinfo;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				TierInfo t = new TierInfo();
				t.setId(rs.getInt("id"));
				t.setToid(rs.getString("toid"));
				t.setTomsg(rs.getString("tomsg"));
				t.setFromid(rs.getString("fromid"));
				t.setTomsg(rs.getString("frommsg"));
				t.setRequests(rs.getInt("requests"));
				
				tierinfo.add(t);
			}
			return tierinfo;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TierInfo update(TierInfo t) {
		//AppLogger.logger.info("Account table update record request.");
		String sql = "update \"Project_1\".tierinfo set id = ?, toid = ?, tomsg = ?, frommsg = ?,"
				+ " frommsg = ?, requests = ? where id = ? returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getId());

			ps.setString(5, t.getToid());
			ps.setString(6, t.getTomsg());
			ps.setString(7, t.getFromid());
			ps.setString(8, t.getFrommsg());
			ps.setInt(12, t.getRequests());

			
			boolean success = (ps.execute());
			
			if (success) {
				ResultSet rs = ps.getResultSet();

				if (rs.next()) {
					t.setId(rs.getInt("id"));
					t.setToid(rs.getString("toid"));
					t.setTomsg(rs.getString("tomsg"));
					t.setFromid(rs.getString("fromid"));
					t.setTomsg(rs.getString("frommsg"));
					t.setRequests(rs.getInt("requests"));
					return t;
				}
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public boolean delete(Integer id) {
		//AppLogger.logger.info("Account table delete record request.");
		String sql = "delete from \"Project_1\".tierinfo where id = ? returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			boolean success = ps.execute();
			
			if (success) {
				return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
