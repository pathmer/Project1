package dev.athmer.project1.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.athmer.project1.beans.FormData;
//import dev.athmer.project1.logging.AppLogger;
import dev.athmer.project1.utilities.JDBCConnection;

public class FormDataRepository implements RootRepository<FormData> {
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public FormData add(FormData f) {
		//AppLogger.logger.info("Account table add record request.");
		String sql = "insert into \"Project_1\".formdata values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, f.getTimes());
			ps.setString(2, f.getLocations());
			ps.setString(3, f.getDescription());
			ps.setDouble(4, f.getCosts());
			ps.setString(5, f.getGradeFormat());
			ps.setString(6, f.getEventType());
			ps.setString(7, f.getJustification());
			ps.setInt(8, f.getMissedWorkhrsperwk());
			ps.setInt(9, f.getRequests());
			
			boolean success = ps.execute();
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					f.setId(rs.getInt("id"));
					f.setTimes(rs.getInt("times"));
					f.setLocations(rs.getString("locations"));
					f.setDescription(rs.getString("description"));
					f.setCosts(rs.getDouble("costs"));
					f.setGradeFormat(rs.getString("gradeFormat"));
					f.setEventType(rs.getString("eventType"));
					f.setJustification(rs.getString("justification"));
					f.setMissedWorkhrsperwk(rs.getInt("missedWorkhrsperwk"));
					f.setRequests(rs.getInt("requests"));
					
					return f;
				}
			}
			
		}
		catch (SQLException e) {
//			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FormData getById(Integer id) {
		//AppLogger.logger.info("Account table view by ID request.");
		String sql = "select * from \"Project_1\".formdata where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				FormData f = new FormData();
				f.setId(rs.getInt("id"));
				f.setTimes(rs.getInt("times"));
				f.setLocations(rs.getString("locations"));
				f.setDescription(rs.getString("description"));
				f.setCosts(rs.getDouble("costs"));
				f.setGradeFormat(rs.getString("gradeFormat"));
				f.setEventType(rs.getString("eventType"));
				f.setJustification(rs.getString("justification"));
				f.setMissedWorkhrsperwk(rs.getInt("missedWorkhrsperwk"));
				f.setRequests(rs.getInt("requests"));
				return f;
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FormData> getAll() {
		//AppLogger.logger.info("Account table view all request.");
		List<FormData> formdata = new ArrayList<FormData>();
		
		String sql = "select * from \"Project_1\".formdata;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				FormData f = new FormData();
				f.setId(rs.getInt("id"));
				f.setTimes(rs.getInt("times"));
				f.setLocations(rs.getString("locations"));
				f.setDescription(rs.getString("description"));
				f.setCosts(rs.getDouble("costs"));
				f.setGradeFormat(rs.getString("gradeFormat"));
				f.setEventType(rs.getString("eventType"));
				f.setJustification(rs.getString("justification"));
				f.setMissedWorkhrsperwk(rs.getInt("missedWorkhrsperwk"));
				f.setRequests(rs.getInt("requests"));
				
				formdata.add(f);
			}
			return formdata;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FormData update(FormData f) {
		//AppLogger.logger.info("Account table update record request.");
		String sql = "update \"Project_1\".formdata set id = ?, times = ?, locations = ?, description = ?,"
				+ " costs = ?, gradeFormat = ?, eventType = ?, justification = ?, missedWorkhrsperwk = ?, requests = ?"
				+ " where id = ? returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, f.getId());
			ps.setInt(2, f.getTimes());
			ps.setString(3, f.getLocations());
			ps.setString(4, f.getDescription());
			ps.setDouble(5, f.getCosts());
			ps.setString(6, f.getGradeFormat());
			ps.setString(7, f.getEventType());
			ps.setString(8, f.getJustification());
			ps.setInt(9, f.getMissedWorkhrsperwk());
			ps.setInt(10, f.getRequests());
			ps.setInt(11, f.getId());
			
			boolean success = (ps.execute());
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					f.setId(rs.getInt("id"));
					f.setTimes(rs.getInt("times"));
					f.setLocations(rs.getString("locations"));
					f.setDescription(rs.getString("description"));
					f.setCosts(rs.getDouble("costs"));
					f.setGradeFormat(rs.getString("gradeFormat"));
					f.setEventType(rs.getString("eventType"));
					f.setJustification(rs.getString("justification"));
					f.setMissedWorkhrsperwk(rs.getInt("missedWorkhrsperwk"));
					f.setRequests(rs.getInt("requests"));
					return f;
				}
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean delete(Integer id) {
		//AppLogger.logger.info("Account table delete record request.");
		String sql = "delete from \"Project_1\".formdata where id = ? returning *;";
		
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

	public List<FormData> getByAccount(Integer id) {
		//AppLogger.logger.info("Account table view by ID request.");
		String sql = "select * from from \"Project_1\".requests left join \"Project_1\".formdata"
				+ " on \"Project_1\".requests.id = \"Project_1\".formdata.requests where accounts = ?;";
		
		List<FormData> formdata = new ArrayList<FormData>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				FormData f = new FormData();
				f.setId(rs.getInt("id"));
				f.setTimes(rs.getInt("times"));
				f.setLocations(rs.getString("locations"));
				f.setDescription(rs.getString("description"));
				f.setCosts(rs.getDouble("costs"));
				f.setGradeFormat(rs.getString("gradeFormat"));
				f.setEventType(rs.getString("eventType"));
				f.setJustification(rs.getString("justification"));
				f.setMissedWorkhrsperwk(rs.getInt("missedWorkhrsperwk"));
				f.setRequests(rs.getInt("requests"));
				formdata.add(f);
			}
			return formdata;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public FormData getByRequestId(Integer id) {
		//AppLogger.logger.info("Account table view by ID request.");
		String sql = "select * from \"Project_1\".formdata where requests = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				FormData f = new FormData();
				f.setId(rs.getInt("id"));
				f.setTimes(rs.getInt("times"));
				f.setLocations(rs.getString("locations"));
				f.setDescription(rs.getString("description"));
				f.setCosts(rs.getDouble("costs"));
				f.setGradeFormat(rs.getString("gradeFormat"));
				f.setEventType(rs.getString("eventType"));
				f.setJustification(rs.getString("justification"));
				f.setMissedWorkhrsperwk(rs.getInt("missedWorkhrsperwk"));
				f.setRequests(rs.getInt("requests"));
				return f;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
