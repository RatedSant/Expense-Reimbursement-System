package daos;

import java.util.*;
import models.*;


public interface EmployeeDao {
	
	///////Inserts ////////
	public boolean insertAccount(Employee emp);
	
	///////// Selects //////////
	public ArrayList<Reimbursement> selectUserTickets(Employee emp);
	public ArrayList<Reimbursement> selectUserPendingTickets(Employee emp);
	public ArrayList<Reimbursement> selectUserApprovedTickets(Employee emp, int num);
	public boolean verifyAccount(Employee emp);
	
	public ArrayList<Employee> selectAllEmployee();
	
	
	///////Updates //////////// 
	public boolean updateAccount(Employee emp);
	public boolean updateReimbursement(Reimbursement ticket, Employee emp);
	public Employee loadAccount(Employee emp);
	
	
	//////////Deletes ////////////
	
}
