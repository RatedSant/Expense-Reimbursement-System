package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import mainproject01.Logging;
import models.*;

public class EmployeeDaoImp implements EmployeeDao {

	
	
	
	public ArrayList<Employee> selectAllEmployee() {
		
		ArrayList<Employee> currentVals = new ArrayList<Employee>();
		
		try (Connection conect = Logging.tryConnection()){
			
			String sql = "SELECT * FROM users";
			
			PreparedStatement prep = conect.prepareStatement(sql);
			
			ResultSet res = prep.executeQuery();
			
			while(res.next()) {
				currentVals.add(new Employee(res.getString("username"), res.getString("user_password"), res.getString("user_name"),
						res.getString("user_last"), res.getString("user_email"), res.getInt("user_id"), res.getInt("user_current_role_id")));
				
			}
			
		}catch(SQLException e) {
			Logging.loggingException(e);
		}
		
		for(Employee temp : currentVals) {
			temp.showAccount();
			System.out.println("-----------------------------------");
		}
		
		return currentVals;
	}
	
	
	@Override
	public boolean insertAccount(Employee emp) {
		
		try(Connection connect = Logging.tryConnection()){
			
			String sql = "INSERT INTO users(username, user_password, user_name, user_last , user_email, user_current_role_id) "
					   + "VALUES(?, ?, ?, ?, ?, ?)"; 
			
			PreparedStatement prep = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			prep.setString(1, emp.getLoginName());
			prep.setString(2, emp.getUserPass());
			prep.setString(3, emp.getUserName());
			prep.setString(4, emp.getUserLastName());
			prep.setString(5, emp.getUserEmail());
			prep.setInt(6, emp.getUserRole());
			
			prep.executeUpdate();
			
			int currentKey = 0;
			
			ResultSet rest = prep.getGeneratedKeys();
			
			if(rest.next()) {
				currentKey = rest.getInt("user_id");
				emp.setUserId(currentKey);
			}
			
		}catch(SQLException a) {
			Logging.loggingException(a);
			return false;
		}
		emp.showAccount();
		return true;
	}

	@Override
	public ArrayList<Reimbursement> selectUserTickets(Employee emp) {
		
		ArrayList<Reimbursement> currentVals = new ArrayList<Reimbursement>();
		
		try (Connection conect = Logging.tryConnection()){
			
			String sql = "SELECT * FROM fullReimbursement where reimb_author = ?";
			
			PreparedStatement prep = conect.prepareStatement(sql);
			
			prep.setInt(1, emp.getUserId());
			
			ResultSet res = prep.executeQuery();
			
			while(res.next()) {
				
				Reimbursement ticket = new Reimbursement();
				
				ticket.setReimbID(res.getInt("reimb_id"));
				ticket.setReimbAmount(res.getInt("reimb_amount"));
				ticket.setReimbSubmittedDB(res.getTimestamp("reimb_submitted"));
				ticket.setReimbResolvedDB(res.getTimestamp("reimb_resolved"));
				ticket.setReimbDescription(res.getString("reimb_description"));
				ticket.setReimbAuthor(res.getInt("reimb_author"));
				ticket.setReimbResolver(res.getInt("reimb_resolver"));
				ticket.setReimbStatus(res.getInt("reimb_current_status_id"));
				ticket.setReimbType(res.getInt("reimb_current_type_id"));
				ticket.setAuthor(res.getString("authorName"));
				ticket.setResolver(res.getString("resolverName"));
				ticket.setType(res.getString("reimb_type_name"));
				ticket.setStatus(res.getString("reimb_status_name"));
				
				currentVals.add(ticket);
				
			}
			
		}catch(SQLException e) {
			Logging.loggingException(e);
		}
		
		for(Reimbursement temp : currentVals) {
			temp.showReimbursements();
			System.out.println("-----------------------------------");
		}
		return currentVals;
		
	}

	@Override
	public ArrayList<Reimbursement> selectUserPendingTickets(Employee emp) {
		
		 	final int PENDING = 1;
		 
			ArrayList<Reimbursement> currentVals = new ArrayList<Reimbursement>();
			
			try (Connection conect = Logging.tryConnection()){
				
				String sql = "SELECT * FROM fullReimbursement where reimb_author = ? and reimb_current_status_id = ?";
				
				PreparedStatement prep = conect.prepareStatement(sql);
				
				prep.setInt(1, emp.getUserId());
				prep.setInt(2, PENDING);
				
				ResultSet res = prep.executeQuery();
				
				while(res.next()) {
					
					Reimbursement ticket = new Reimbursement();
					
					ticket.setReimbID(res.getInt("reimb_id"));
					ticket.setReimbAmount(res.getInt("reimb_amount"));
					ticket.setReimbSubmittedDB(res.getTimestamp("reimb_submitted"));
					ticket.setReimbResolvedDB(res.getTimestamp("reimb_resolved"));
					ticket.setReimbDescription(res.getString("reimb_description"));
					ticket.setReimbAuthor(res.getInt("reimb_author"));
					ticket.setReimbResolver(res.getInt("reimb_resolver"));
					ticket.setReimbStatus(res.getInt("reimb_current_status_id"));
					ticket.setReimbType(res.getInt("reimb_current_type_id"));
					ticket.setAuthor(res.getString("authorName"));
					ticket.setResolver(res.getString("resolverName"));
					ticket.setType(res.getString("reimb_type_name"));
					ticket.setStatus(res.getString("reimb_status_name"));
					
					currentVals.add(ticket);
					
				}
				
			}catch(SQLException e) {
				Logging.loggingException(e);
			}
			
			for(Reimbursement temp : currentVals) {
				temp.showReimbursements();
				System.out.println("-----------------------------------");
			}
			return currentVals;
	}

	@Override
	public ArrayList<Reimbursement> selectUserApprovedTickets(Employee emp, int num) {
		
	 	final int APPROVED = 2, DENIED = 3;
	 	int result;
	 	if(num == APPROVED) {
	 		result = num;
	 	}else {
	 		result = num;
	 	}
		 
		ArrayList<Reimbursement> currentVals = new ArrayList<Reimbursement>();
		
		try (Connection conect = Logging.tryConnection()){
			
			String sql = "SELECT * FROM fullReimbursement where reimb_author = ? and reimb_current_status_id = ?";
			
			PreparedStatement prep = conect.prepareStatement(sql);
			
			prep.setInt(1, emp.getUserId());
			prep.setInt(2, result);
			
			ResultSet res = prep.executeQuery();
			
			while(res.next()) {
				
				Reimbursement ticket = new Reimbursement();
				
				ticket.setReimbID(res.getInt("reimb_id"));
				ticket.setReimbAmount(res.getInt("reimb_amount"));
				ticket.setReimbSubmittedDB(res.getTimestamp("reimb_submitted"));
				ticket.setReimbResolvedDB(res.getTimestamp("reimb_resolved"));
				ticket.setReimbDescription(res.getString("reimb_description"));
				ticket.setReimbAuthor(res.getInt("reimb_author"));
				ticket.setReimbResolver(res.getInt("reimb_resolver"));
				ticket.setReimbStatus(res.getInt("reimb_current_status_id"));
				ticket.setReimbType(res.getInt("reimb_current_type_id"));
				ticket.setAuthor(res.getString("authorName"));
				ticket.setResolver(res.getString("resolverName"));
				ticket.setType(res.getString("reimb_type_name"));
				ticket.setStatus(res.getString("reimb_status_name"));
				
				currentVals.add(ticket);
				
			}
			
		}catch(SQLException e) {
			Logging.loggingException(e);
		}
		
		for(Reimbursement temp : currentVals) {
			temp.showReimbursements();
			System.out.println("-----------------------------------");
		}
		return currentVals;
	}

	@Override
	public boolean verifyAccount(Employee emp) {
		
		String userDB, userPassDB;
		
		try (Connection conect = Logging.tryConnection()){
			
			String sql = "SELECT username, user_password FROM users";
			
			PreparedStatement prep = conect.prepareStatement(sql);
			
			ResultSet res = prep.executeQuery();
			
			while(res.next()) {
				userDB = res.getString("username");
				userPassDB = res.getString("user_password");
				if(emp.getLoginName().contentEquals(userDB) && emp.getUserPass().contentEquals(userPassDB)) {
					return true;
				}
			}
			
		}catch(SQLException e) {
			Logging.loggingException(e);
			return false;
		}
		return false;
	}

	@Override
	public boolean updateAccount(Employee emp) {
		
		return false;
		
	}

	@Override
	public boolean updateReimbursement(Reimbursement ticket, Employee emp) {
		
		try(Connection connect = Logging.tryConnection()){
			
			String sql = "UPDATE reimbursement "
					+ "SET reimb_resolved = ?, reimb_resolver = ?, reimb_current_status_id = ? "
					+ "WHERE reimb_id = ?"; 
			
			PreparedStatement prep = connect.prepareStatement(sql);
			
			prep.setObject(1, ticket.getReimbResolved());
			prep.setInt(2, emp.getUserId());
			prep.setInt(3, ticket.getReimbStatus());
			prep.setInt(4, ticket.getReimbID());
			
			prep.executeUpdate();
			
		}catch(SQLException a) {
			Logging.loggingException(a);
			return false;
		}
		return true;
	}

	@Override
	public Employee loadAccount(Employee emp) {
		
		try (Connection conect = Logging.tryConnection()){
			
			String sql = "select * from users where username = ?";
			
			PreparedStatement prep = conect.prepareStatement(sql);
			
			prep.setString(1, emp.getLoginName());
			
			ResultSet res = prep.executeQuery();
			
			if(res.next()) {
				emp.setLoginName(res.getString("username"));
				emp.setUserPass(res.getString("user_password"));
				emp.setUserName(res.getString("user_name"));
				emp.setUserLastName(res.getString("user_last"));
				emp.setUserEmail(res.getString("user_email"));
				emp.setUserId(res.getInt("user_id"));
				emp.setUserRole(res.getInt("user_current_role_id"));
			}
			
		}catch(SQLException e) {
			Logging.loggingException(e);
		}
		return emp;
	}
	
	

}
