package dev.athmer.project1.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.athmer.project1.beans.AutoApprove;
//import dev.athmer.project1.logging.AppLogger;
import dev.athmer.project1.utilities.JDBCConnection;

public class AutoApproveRepository {

	private Connection conn = JDBCConnection.getConnection();

	public List<AutoApprove> getRequests() {
		//AppLogger.logger.info("Account table view all request.");
		List<AutoApprove> autoapprove = new ArrayList<AutoApprove>();
		
		String sql = "select * from \"Project_1\".autoapproval;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				AutoApprove aa = new AutoApprove();
				aa.setUserid(rs.getInt("userid"));
				aa.setUtype(rs.getString("utype"));
				aa.setSupervisor(rs.getInt("supervisor"));
				aa.setManager(rs.getInt("manager"));
				aa.setDepthead(rs.getInt("depthead"));
				
				aa.setId(rs.getInt("requestid"));
				aa.setTitle(rs.getString("title"));
				aa.setStartDate(rs.getDate("startDate"));
				aa.setReimbursement(rs.getDouble("reimbursement"));
				aa.setStatus(rs.getString("status"));
				aa.setInbox(rs.getInt("inbox"));
				aa.setDatetimestamp(rs.getDate("datetimestamp"));
				aa.setPriority(rs.getString("priority"));
				aa.setAmountexceeded(rs.getString("amountexceeded"));
				aa.setExceededreason(rs.getString("exceededreason"));
				aa.setBencoescalated(rs.getString("bencoescalated"));
				aa.setEmpapp(rs.getString("empapp"));
				aa.setSupapp(rs.getString("supapp"));
				aa.setManapp(rs.getString("manapp"));
				aa.setDhdapp(rs.getString("dhdapp"));
				aa.setBenapp(rs.getString("benapp"));
				aa.setDenialreason(rs.getString("denialreason"));
				aa.setAccounts(rs.getInt("accounts"));
				
				autoapprove.add(aa);
			}
			return autoapprove;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
