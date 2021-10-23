package servers;

import java.util.ArrayList;

import daos.*;
import models.Employee;
import models.Reimbursement;

public class EmployeeServiceImp implements EmployeeService {
	
	EmployeeDao dao = new EmployeeDaoImp();

	@Override
	public boolean addAccount(Employee emp) {
		
		return dao.insertAccount(emp);
	}

	@Override
	public ArrayList<Reimbursement> getAllTickets(Employee emp) {

		return dao.selectUserTickets(emp);
	}

	@Override
	public ArrayList<Reimbursement> getPedingTickets(Employee emp) {
		
		return dao.selectUserPendingTickets(emp);
	}

	@Override
	public ArrayList<Reimbursement> getApprovedTickets(Employee emp, int num) {
		
		return dao.selectUserApprovedTickets(emp, num);
	}

	@Override
	public boolean confirmAccont(Employee emp) {
		
		return dao.verifyAccount(emp);
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {

		return dao.selectAllEmployee();
	}

	@Override
	public boolean updateUser(Employee emp) {
	
		return dao.updateAccount(emp);
	}

	@Override
	public boolean updateTicketStatus(Reimbursement ticket, Employee emp) {
		
		return dao.updateReimbursement(ticket, emp);
	}

	@Override
	public Employee setAccount(Employee emp) {
		
		return dao.loadAccount(emp);
	}

}
