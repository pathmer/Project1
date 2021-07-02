package dev.athmer.project1.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dev.athmer.project1.beans.Request;
import dev.athmer.project1.beans.User;
//import dev.athmer.project1.logging.AppLogger;
import dev.athmer.project1.utilities.JDBCConnection;

public class RequestRepository implements RootRepository<Request> {
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Request add(Request r) {
		//AppLogger.logger.info("Account table add record request.");
		String sql = "insert into \"Project_1\".requests values"
				+ " (default, ?, ?, ?, ?, ?, ?, ?, default, default, default, default, default, default, default, default, default, ?) returning *;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getTitle());
			ps.setDate(2, r.getStartDate());
			ps.setDouble(3, r.getReimbursement());
			ps.setString(4, r.getStatus());
			ps.setInt(5, r.getInbox());
			ps.setDate(6, r.getDatetimestamp());
			ps.setString(7, r.getPriority());
			ps.setInt(8, r.getAccounts());
			
			boolean success = ps.execute();
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					r.setId(rs.getInt("id"));
					r.setTitle(rs.getString("title"));
					r.setStartDate(rs.getDate("startDate"));
					r.setReimbursement(rs.getDouble("reimbursement"));
					r.setStatus(rs.getString("status"));
					r.setInbox(rs.getInt("inbox"));
					r.setDatetimestamp(rs.getDate("datetimestamp"));
					r.setPriority(rs.getString("priority"));
					r.setAmountexceeded(rs.getString("amountexceeded"));
					r.setExceededreason(rs.getString("exceededreason"));
					r.setBencoescalated(rs.getString("bencoescalated"));
					r.setEmpapp(rs.getString("empapp"));
					r.setSupapp(rs.getString("supapp"));
					r.setManapp(rs.getString("manapp"));
					r.setDhdapp(rs.getString("dhdapp"));
					r.setBenapp(rs.getString("benapp"));
					r.setDenialreason(rs.getString("denialreason"));
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
		//AppLogger.logger.info("Account table view by ID request.");
		String sql = "select * from \"Project_1\".requests where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				Request r = new Request();
				r.setId(rs.getInt("id"));
				r.setTitle(rs.getString("title"));
				r.setStartDate(rs.getDate("startDate"));
				r.setReimbursement(rs.getDouble("reimbursement"));
				r.setStatus(rs.getString("status"));
				r.setInbox(rs.getInt("inbox"));
				r.setDatetimestamp(rs.getDate("datetimestamp"));
				r.setPriority(rs.getString("priority"));
				r.setAmountexceeded(rs.getString("amountexceeded"));
				r.setExceededreason(rs.getString("exceededreason"));
				r.setBencoescalated(rs.getString("bencoescalated"));
				r.setEmpapp(rs.getString("empapp"));
				r.setSupapp(rs.getString("supapp"));
				r.setManapp(rs.getString("manapp"));
				r.setDhdapp(rs.getString("dhdapp"));
				r.setBenapp(rs.getString("benapp"));
				r.setDenialreason(rs.getString("denialreason"));
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
		//AppLogger.logger.info("Account table view all request.");
		List<Request> requests = new ArrayList<Request>();
		
		String sql = "select * from \"Project_1\".requests;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Request r = new Request();
				r.setId(rs.getInt("id"));
				r.setTitle(rs.getString("title"));
				r.setStartDate(rs.getDate("startDate"));
				r.setReimbursement(rs.getDouble("reimbursement"));
				r.setStatus(rs.getString("status"));
				r.setInbox(rs.getInt("inbox"));
				r.setDatetimestamp(rs.getDate("datetimestamp"));
				r.setPriority(rs.getString("priority"));
				r.setAmountexceeded(rs.getString("amountexceeded"));
				r.setExceededreason(rs.getString("exceededreason"));
				r.setBencoescalated(rs.getString("bencoescalated"));
				r.setEmpapp(rs.getString("empapp"));
				r.setSupapp(rs.getString("supapp"));
				r.setManapp(rs.getString("manapp"));
				r.setDhdapp(rs.getString("dhdapp"));
				r.setBenapp(rs.getString("benapp"));
				r.setDenialreason(rs.getString("denialreason"));
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
		//AppLogger.logger.info("Account table update record request.");
		String sql = "update \"Project_1\".requests set id = ?, title = ? , startDate = ?, reimbursement = ?, status = ?, inbox = ?,"
					+ " datetimestamp = ?, priority = ?, amountexceeded = ?, exceededreason = ?, bencoescalated = ?,"
					+ " empapp = ?, supapp = ?, manapp = ?, dhdapp = ?, benapp = ?, denialreason = ?,"
					+ " accounts = ? where id = ? returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getId());
			ps.setString(2, r.getTitle());
			ps.setDate(3, r.getStartDate());
			ps.setDouble(4, r.getReimbursement());
			ps.setString(5, r.getStatus());
			ps.setInt(6, r.getInbox());
			ps.setDate(7, r.getDatetimestamp());
			ps.setString(8, r.getPriority());
			ps.setString(9, r.getAmountexceeded());
			ps.setString(10, r.getExceededreason());
			ps.setString(11, r.getBencoescalated());
			ps.setString(12, r.getEmpapp());
			ps.setString(13, r.getSupapp());
			ps.setString(14, r.getManapp());
			ps.setString(15, r.getDhdapp());
			ps.setString(16, r.getBenapp());
			ps.setString(17, r.getDenialreason());
			ps.setInt(18, r.getAccounts());
			ps.setInt(19, r.getId());
			
			boolean success = (ps.execute());
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					r.setId(rs.getInt("id"));
					r.setTitle(rs.getString("title"));
					r.setStartDate(rs.getDate("startDate"));
					r.setReimbursement(rs.getDouble("reimbursement"));
					r.setStatus(rs.getString("status"));
					r.setInbox(rs.getInt("inbox"));
					r.setDatetimestamp(rs.getDate("datetimestamp"));
					r.setPriority(rs.getString("priority"));
					r.setAmountexceeded(rs.getString("amountexceeded"));
					r.setExceededreason(rs.getString("exceededreason"));
					r.setBencoescalated(rs.getString("bencoescalated"));
					r.setEmpapp(rs.getString("empapp"));
					r.setSupapp(rs.getString("supapp"));
					r.setManapp(rs.getString("manapp"));
					r.setDhdapp(rs.getString("dhdapp"));
					r.setBenapp(rs.getString("benapp"));
					r.setDenialreason(rs.getString("denialreason"));
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
		//AppLogger.logger.info("Account table delete record request.");
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

	public List<Request> getUserRequestShortListByAccount(Integer acc) {
		//AppLogger.logger.info("Account table view by ID request.");
		String sql = "select * from \"Project_1\".requests where accounts = ?;";
		List<Request> requests = new ArrayList<Request>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acc);
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				Request r = new Request();
				r.setId(rs.getInt("id"));
				r.setTitle(rs.getString("title"));
				r.setStartDate(rs.getDate("startDate"));
				r.setReimbursement(rs.getDouble("reimbursement"));
				r.setStatus(rs.getString("status"));
				r.setInbox(rs.getInt("inbox"));
				r.setDatetimestamp(rs.getDate("datetimestamp"));
				r.setPriority(rs.getString("priority"));
				r.setAmountexceeded(rs.getString("amountexceeded"));
				r.setExceededreason(rs.getString("exceededreason"));
				r.setBencoescalated(rs.getString("bencoescalated"));
				r.setEmpapp(rs.getString("empapp"));
				r.setSupapp(rs.getString("supapp"));
				r.setManapp(rs.getString("manapp"));
				r.setDhdapp(rs.getString("dhdapp"));
				r.setBenapp(rs.getString("benapp"));
				r.setDenialreason(rs.getString("denialreason"));
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
	
	public List<Request> getOtherRequestShortListByYear(User u, Integer year) {
		//AppLogger.logger.info("Account table view by ID request.");
		String sql = null;
		
		if ("supervisor".equals(u.getUtype())) {
			sql = "select \"Project_1\".requests.* from \"Project_1\".users"
					+ " left join \"Project_1\".accounts on \"Project_1\".accounts.users = \"Project_1\".users.id"
					+ " left join \"Project_1\".requests on \"Project_1\".requests.accounts = \"Project_1\".accounts.id"
					+ " where (ayear = ? and supervisor = ?);";
		}
		else if ("manager".equals(u.getUtype())) {
			sql = "select \"Project_1\".requests.* from \"Project_1\".users"
					+ " left join \"Project_1\".accounts on \"Project_1\".accounts.users = \"Project_1\".users.id"
					+ " left join \"Project_1\".requests on \"Project_1\".requests.accounts = \"Project_1\".accounts.id"
					+ " where (ayear = ? and manager = ?);";
		}
		else if ("depthead".equals(u.getUtype())) {
			sql = "select \"Project_1\".requests.* from \"Project_1\".users"
					+ " left join \"Project_1\".accounts on \"Project_1\".accounts.users = \"Project_1\".users.id"
					+ " left join \"Project_1\".requests on \"Project_1\".requests.accounts = \"Project_1\".accounts.id"
					+ " where (ayear = ? and depthead = ?);";
		}
		
		List<Request> requests = new ArrayList<Request>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, year);
			ps.setInt(2, u.getId());
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				Request r = new Request();
				r.setId(rs.getInt("id"));
				r.setTitle(rs.getString("title"));
				r.setStartDate(rs.getDate("startDate"));
				r.setReimbursement(rs.getDouble("reimbursement"));
				r.setStatus(rs.getString("status"));
				r.setInbox(rs.getInt("inbox"));
				r.setDatetimestamp(rs.getDate("datetimestamp"));
				r.setPriority(rs.getString("priority"));
				r.setAmountexceeded(rs.getString("amountexceeded"));
				r.setExceededreason(rs.getString("exceededreason"));
				r.setBencoescalated(rs.getString("bencoescalated"));
				r.setEmpapp(rs.getString("empapp"));
				r.setSupapp(rs.getString("supapp"));
				r.setManapp(rs.getString("manapp"));
				r.setDhdapp(rs.getString("dhdapp"));
				r.setBenapp(rs.getString("benapp"));
				r.setDenialreason(rs.getString("denialreason"));
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
	
	public List<Request> getBencoRequestShortListByYear(Integer year) {
		//AppLogger.logger.info("Account table view by ID request.");
		String sql = null;
		sql = "select \"Project_1\".requests.* from \"Project_1\".users"
				+ " left join \"Project_1\".accounts on \"Project_1\".accounts.users = \"Project_1\".users.id"
				+ " left join \"Project_1\".requests on \"Project_1\".requests.accounts = \"Project_1\".accounts.id"
				+ " where (ayear = ?);";
		
		List<Request> requests = new ArrayList<Request>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, year);
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				Request r = new Request();
				r.setId(rs.getInt("id"));
				r.setTitle(rs.getString("title"));
				r.setStartDate(rs.getDate("startDate"));
				r.setReimbursement(rs.getDouble("reimbursement"));
				r.setStatus(rs.getString("status"));
				r.setInbox(rs.getInt("inbox"));
				r.setDatetimestamp(rs.getDate("datetimestamp"));
				r.setPriority(rs.getString("priority"));
				r.setAmountexceeded(rs.getString("amountexceeded"));
				r.setExceededreason(rs.getString("exceededreason"));
				r.setBencoescalated(rs.getString("bencoescalated"));
				r.setEmpapp(rs.getString("empapp"));
				r.setSupapp(rs.getString("supapp"));
				r.setManapp(rs.getString("manapp"));
				r.setDhdapp(rs.getString("dhdapp"));
				r.setBenapp(rs.getString("benapp"));
				r.setDenialreason(rs.getString("denialreason"));
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
}

