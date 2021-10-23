package servers;

import java.util.ArrayList;

import models.Employee;
import models.Reimbursement;

public interface EmployeeService {
	
	///////Inserts ////////
	public boolean addAccount(Employee emp);
	
	///////// Selects //////////
	public ArrayList<Reimbursement> getAllTickets(Employee emp);
	public ArrayList<Reimbursement> getPedingTickets(Employee emp);
	public ArrayList<Reimbursement> getApprovedTickets(Employee emp, int num);
	public boolean confirmAccont(Employee emp);

	public ArrayList<Employee> getAllEmployee();
	
	///////Updates //////////// 
	public boolean updateUser(Employee emp);
	public boolean updateTicketStatus(Reimbursement ticket, Employee emp);
	public Employee setAccount(Employee emp);
	

}
