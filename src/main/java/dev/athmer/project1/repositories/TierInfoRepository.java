package dev.athmer.project1.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.athmer.project1.beans.TierInfo;
import dev.athmer.project1.logging.AppLogger;
import dev.athmer.project1.utilities.JDBCConnection;

public class TierInfoRepository implements RootRepository<TierInfo> {
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public TierInfo add(TierInfo t) {
		AppLogger.logger.info("Account table add record request.");
		String sql = "insert into \"Project_1\".tierinfo values (default, ?, default, default, default, default, default, default, default, default, ?, ?) returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getLevels());
			ps.setInt(2, t.getUserid());
			ps.setInt(3, t.getRequests());
			
			boolean success = ps.execute();
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					t.setId(rs.getInt("id"));
					t.setLevels(rs.getString("levels"));
					t.setApproval(rs.getString("approval"));
					t.setDenialreason(rs.getString("denialreason"));
					t.setToemp(rs.getString("toemp"));
					t.setFromemp(rs.getString("fromemp"));
					t.setTosup(rs.getString("tosup"));
					t.setFromsup(rs.getString("fromsup"));
					t.setTodh(rs.getString("todh"));
					t.setFromdh(rs.getString("fromdh"));
					t.setUserid(rs.getInt("userid"));
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
		AppLogger.logger.info("Account table view by ID request.");
		String sql = "select * from \"Project_1\".tierinfo where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				TierInfo t = new TierInfo();
				t.setId(rs.getInt("id"));
				t.setLevels(rs.getString("levels"));
				t.setApproval(rs.getString("approval"));
				t.setDenialreason(rs.getString("denialreason"));
				t.setToemp(rs.getString("toemp"));
				t.setFromemp(rs.getString("fromemp"));
				t.setTosup(rs.getString("tosup"));
				t.setFromsup(rs.getString("fromsup"));
				t.setTodh(rs.getString("todh"));
				t.setFromdh(rs.getString("fromdh"));
				t.setUserid(rs.getInt("userid"));
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
		AppLogger.logger.info("Account table view all request.");
		List<TierInfo> tierinfo = new ArrayList<TierInfo>();
		
		String sql = "select * from \"Project_1\".tierinfo;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				TierInfo t = new TierInfo();
				t.setId(rs.getInt("id"));
				t.setLevels(rs.getString("levels"));
				t.setApproval(rs.getString("approval"));
				t.setDenialreason(rs.getString("denialreason"));
				t.setToemp(rs.getString("toemp"));
				t.setFromemp(rs.getString("fromemp"));
				t.setTosup(rs.getString("tosup"));
				t.setFromsup(rs.getString("fromsup"));
				t.setTodh(rs.getString("todh"));
				t.setFromdh(rs.getString("fromdh"));
				t.setUserid(rs.getInt("userid"));
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
		AppLogger.logger.info("Account table update record request.");
		String sql = "update \"Project_1\".tierinfo set id = ?, levels = ?, approval = ?,"
				+ " denialreason = ?, toemp = ?, fromemp = ?, tosup = ?, fromsup = ?,"
				+ " todh = ?, fromdh = ?, userid = ?, requests = ? where id = ? returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getLevels());
			ps.setString(3, t.getApproval());
			ps.setString(4, t.getDenialreason());
			ps.setString(5, t.getToemp());
			ps.setString(6, t.getFromemp());
			ps.setString(7, t.getTosup());
			ps.setString(8, t.getFromsup());
			ps.setString(9, t.getTodh());
			ps.setString(10, t.getFromdh());
			ps.setInt(11, t.getUserid());
			ps.setInt(12, t.getRequests());
			ps.setInt(13, t.getId());
			
			boolean success = (ps.execute());
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					t.setId(rs.getInt("id"));
					t.setLevels(rs.getString("levels"));
					t.setApproval(rs.getString("approval"));
					t.setDenialreason(rs.getString("denialreason"));
					t.setToemp(rs.getString("toemp"));
					t.setFromemp(rs.getString("fromemp"));
					t.setTosup(rs.getString("tosup"));
					t.setFromsup(rs.getString("fromsup"));
					t.setTodh(rs.getString("todh"));
					t.setFromdh(rs.getString("fromdh"));
					t.setUserid(rs.getInt("userid"));
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
		AppLogger.logger.info("Account table delete record request.");
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
