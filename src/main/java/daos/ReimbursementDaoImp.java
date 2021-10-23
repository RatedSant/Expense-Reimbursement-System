package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.*;

import mainproject01.Logging;
import models.*;

public class ReimbursementDaoImp implements ReimbursementDao {

	@Override
	public boolean insertTicket(Reimbursement ticket, Employee emp) {
		
					
			try(Connection connect = Logging.tryConnection()){
				
				String sql = "INSERT INTO reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_current_type_id, reimb_current_status_id) "
						   + "VALUES(?, ?, ?, ?, ?, ?)"; 
				
				PreparedStatement prep = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				
				//Get amount from the user 'Int' 
				prep.setInt(1, ticket.getReimbAmount());
				prep.setObject(2, ticket.getReimbSubmitted());
				prep.setString(3, ticket.getReimbDescription());
				prep.setInt(4, ticket.getReimbAuthor());
				prep.setInt(5, ticket.getReimbType());
				prep.setInt(6, ticket.getReimbStatus());
				
				prep.executeUpdate();
				
				int currentKey = 0;
				
				ResultSet rest = prep.getGeneratedKeys();
				
				if(rest.next()) {
					currentKey = rest.getInt("reimb_id");
					ticket.setReimbID(currentKey);
				}
				
			}catch(SQLException a) {
				Logging.loggingException(a);
				return false;
			}
			
			ticket.showReimbursements();
			return true;
	}

	@Override
	public ArrayList<Reimbursement> selectAllTickets() {
		
		ArrayList<Reimbursement> currentVals = new ArrayList<Reimbursement>();
		
		try (Connection conect = Logging.tryConnection()){
			
			String sql = "SELECT * FROM fullReimbursement";
			
			PreparedStatement prep = conect.prepareStatement(sql);
			
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
	public ArrayList<Reimbursement> selectPendingTickets() {
		
	 	final int PENDING = 1;
		 
		ArrayList<Reimbursement> currentVals = new ArrayList<Reimbursement>();
		
		try (Connection conect = Logging.tryConnection()){
			
			String sql = "SELECT * FROM fullReimbursement where reimb_current_status_id = ?";
			
			PreparedStatement prep = conect.prepareStatement(sql);
			
			prep.setInt(1, PENDING);
			
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
	public ArrayList<Reimbursement> selectApprovedTickets(int num) {
		
	 	final int APPROVED = 2, DENIED = 3;
	 	int result;
	 	if(num == APPROVED) {
	 		result = num;
	 	}else {
	 		result = num;
	 	}
		 
		ArrayList<Reimbursement> currentVals = new ArrayList<Reimbursement>();
		
		try (Connection conect = Logging.tryConnection()){
			
			String sql = "SELECT * FROM fullReimbursement where reimb_current_status_id = ?";
			
			PreparedStatement prep = conect.prepareStatement(sql);
			
			prep.setInt(1, result);
			
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
	public boolean updateReimbursement(Reimbursement ticket) {
		
		return false;
		
	}

	@Override
	public Reimbursement loadSingleTicket(Reimbursement ticket) {
		
		try (Connection conect = Logging.tryConnection()){
			
			String sql = "select * from fullReimbursement where reimb_id = ?";
			
			PreparedStatement prep = conect.prepareStatement(sql);
			
			prep.setInt(1, ticket.getReimbID());
			
			ResultSet res = prep.executeQuery();
			
			if(res.next()) {
				
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
			}
		
		}catch(SQLException e) {
			Logging.loggingException(e);
		}
		
		ticket.showReimbursements();
		return ticket;
	}

}
