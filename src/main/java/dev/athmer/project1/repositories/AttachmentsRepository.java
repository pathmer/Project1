package dev.athmer.project1.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.athmer.project1.beans.Attachments;
import dev.athmer.project1.logging.AppLogger;
import dev.athmer.project1.utilities.JDBCConnection;

public class AttachmentsRepository implements RootRepository<Attachments> {
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Attachments add(Attachments a) {
		AppLogger.logger.info("Account table add record request.");
		String sql = "insert into \"Project_1\".attachments values (default, default, default, default, default, ?) returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getRequests());
			
			boolean success = ps.execute();
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					a.setId(rs.getInt("id"));
					a.setOptattachments(rs.getString("optattachments"));
					a.setMsgsupapproval(rs.getString("msgsupapproval"));
					a.setMsgdephdapproval(rs.getString("msgdephdapproval"));
					a.setGradepresentation(rs.getString("gradepresentation"));
					a.setRequests(rs.getInt("requests"));
					
					return a;
				}
			}
			
		}
		catch (SQLException e) {
//			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Attachments getById(Integer id) {
		AppLogger.logger.info("Account table view by ID request.");
		String sql = "select * from \"Project_1\".attachments where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				Attachments a = new Attachments();
				a.setId(rs.getInt("id"));
				a.setOptattachments(rs.getString("optattachments"));
				a.setMsgsupapproval(rs.getString("msgsupapproval"));
				a.setMsgdephdapproval(rs.getString("msgdephdapproval"));
				a.setGradepresentation(rs.getString("gradepresentation"));
				a.setRequests(rs.getInt("requests"));
				return a;
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Attachments> getAll() {
		AppLogger.logger.info("Account table view all request.");
		List<Attachments> attachments = new ArrayList<Attachments>();
		
		String sql = "select * from \"Project_1\".attachments;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Attachments a = new Attachments();
				a.setId(rs.getInt("id"));
				a.setOptattachments(rs.getString("optattachments"));
				a.setMsgsupapproval(rs.getString("msgsupapproval"));
				a.setMsgdephdapproval(rs.getString("msgdephdapproval"));
				a.setGradepresentation(rs.getString("gradepresentation"));
				a.setRequests(rs.getInt("requests"));
				
				attachments.add(a);
			}
			return attachments;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Attachments update(Attachments a) {
		AppLogger.logger.info("Account table update record request.");
		String sql = "update \"Project_1\".attachments set id = ?, optattachments = ?, msgsupapproval = ?,"
				+ " msgdephdapproval = ?, gradepresentation = ?, requests = ? where id = ? returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getId());
			ps.setString(2, a.getOptattachments());
			ps.setString(3, a.getMsgsupapproval());
			ps.setString(4, a.getMsgdephdapproval());
			ps.setString(5, a.getGradepresentation());
			ps.setInt(6, a.getRequests());
			ps.setInt(7, a.getId());
			
			boolean success = (ps.execute());
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					a.setId(rs.getInt("id"));
					a.setOptattachments(rs.getString("optattachments"));
					a.setMsgsupapproval(rs.getString("msgsupapproval"));
					a.setMsgdephdapproval(rs.getString("msgdephdapproval"));
					a.setGradepresentation(rs.getString("gradepresentation"));
					a.setRequests(rs.getInt("requests"));
					return a;
				}
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public boolean delete(Integer id) {
		AppLogger.logger.info("Account table delete record request.");
		String sql = "delete from \"Project_1\".attachments where id = ? returning *;";
		
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
