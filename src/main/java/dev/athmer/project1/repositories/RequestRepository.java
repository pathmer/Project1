package dev.athmer.project1.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dev.athmer.project1.beans.Request;
import dev.athmer.project1.logging.AppLogger;
import dev.athmer.project1.utilities.JDBCConnection;

public class RequestRepository implements RootRepository<Request> {
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Request add(Request r) {
		AppLogger.logger.info("Account table add record request.");
		String sql = "insert into \"Project_1\".requests values (default, ?, ?, ?, ?, ?, ?, ?, default, default, default, ?) returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getTitle());
			ps.setDouble(2, r.getReimbursement());
			ps.setString(3, r.getStatus());
			ps.setString(4, r.getInbox());
			ps.setString(5, r.getDestination());
			ps.setInt(6, r.getDatetimestamp());
			ps.setString(7, r.getPriority());
			ps.setInt(8, r.getAccounts());
			
			boolean success = ps.execute();
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					r.setId(rs.getInt("id"));
					r.setTitle(rs.getString("title"));
					r.setReimbursement(rs.getDouble("reimbursement"));
					r.setStatus(rs.getString("status"));
					r.setInbox(rs.getString("inbox"));
					r.setDestination(rs.getString("destination"));
					r.setDatetimestamp(rs.getInt("datetimestamp"));
					r.setPriority(rs.getString("priority"));
					r.setAmmountexceeded(rs.getString("ammountexceeded"));
					r.setExceededreason(rs.getString("exceededreason"));
					r.setBencoescalated(rs.getString("bencoescalated"));
					r.setAccounts(rs.getInt("accounts"));
					
					return r;
				}
			}
			
		}
		catch (SQLException e) {
//			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Request getById(Integer id) {
		AppLogger.logger.info("Account table view by ID request.");
		String sql = "select * from \"Project_1\".requests where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				Request r = new Request();
				r.setId(rs.getInt("id"));
				r.setTitle(rs.getString("title"));
				r.setReimbursement(rs.getDouble("reimbursement"));
				r.setStatus(rs.getString("status"));
				r.setInbox(rs.getString("inbox"));
				r.setDestination(rs.getString("destination"));
				r.setDatetimestamp(rs.getInt("datetimestamp"));
				r.setPriority(rs.getString("priority"));
				r.setAmmountexceeded(rs.getString("ammountexceeded"));
				r.setExceededreason(rs.getString("exceededreason"));
				r.setBencoescalated(rs.getString("bencoescalated"));
				r.setAccounts(rs.getInt("accounts"));
				return r;
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getAll() {
		AppLogger.logger.info("Account table view all request.");
		List<Request> requests = new ArrayList<Request>();
		
		String sql = "select * from \"Project_1\".requests;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Request r = new Request();
				r.setId(rs.getInt("id"));
				r.setTitle(rs.getString("title"));
				r.setReimbursement(rs.getDouble("reimbursement"));
				r.setStatus(rs.getString("status"));
				r.setInbox(rs.getString("inbox"));
				r.setDestination(rs.getString("destination"));
				r.setDatetimestamp(rs.getInt("datetimestamp"));
				r.setPriority(rs.getString("priority"));
				r.setAmmountexceeded(rs.getString("ammountexceeded"));
				r.setExceededreason(rs.getString("exceededreason"));
				r.setBencoescalated(rs.getString("bencoescalated"));
				r.setAccounts(rs.getInt("accounts"));
				
				requests.add(r);
			}
			return requests;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Request update(Request r) {
		AppLogger.logger.info("Account table update record request.");
		String sql = "update \"Project_1\".requests set id = ?, title = ? , reimbursement = ?, status = ?, inbox = ?,"
					+ " destination = ?, datetimestamp = ?, priority = ?, ammountexceeded = ?, exceededreason = ?,"
					+ " bencoescalated = ?, accounts = ? where id = ? returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getId());
			ps.setString(2, r.getTitle());
			ps.setDouble(3, r.getReimbursement());
			ps.setString(4, r.getStatus());
			ps.setString(5, r.getInbox());
			ps.setString(6, r.getDestination());
			ps.setInt(7, r.getDatetimestamp());
			ps.setString(8, r.getPriority());
			ps.setString(9, r.getAmmountexceeded());
			ps.setString(10, r.getExceededreason());
			ps.setString(11, r.getBencoescalated());
			ps.setInt(12, r.getAccounts());
			ps.setInt(13, r.getId());
			
			boolean success = (ps.execute());
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					r.setId(rs.getInt("id"));
					r.setTitle(rs.getString("title"));
					r.setReimbursement(rs.getDouble("reimbursement"));
					r.setStatus(rs.getString("status"));
					r.setInbox(rs.getString("inbox"));
					r.setDestination(rs.getString("destination"));
					r.setDatetimestamp(rs.getInt("datetimestamp"));
					r.setPriority(rs.getString("priority"));
					r.setAmmountexceeded(rs.getString("ammountexceeded"));
					r.setExceededreason(rs.getString("exceededreason"));
					r.setBencoescalated(rs.getString("bencoescalated"));
					r.setAccounts(rs.getInt("accounts"));
					return r;
				}
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public boolean delete(Integer id) {
		AppLogger.logger.info("Account table delete record request.");
		String sql = "delete from \"Project_1\".requests where id = ? returning *;";
		
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
