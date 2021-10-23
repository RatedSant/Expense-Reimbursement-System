package servers;

import java.util.ArrayList;

import daos.*;
import models.Employee;
import models.Reimbursement;

public class ReimbursementServiceImp implements ReimbursementService {
	
	ReimbursementDao dao = new ReimbursementDaoImp();

	@Override
	public boolean createTicket(Reimbursement ticket, Employee emp) {
		
		return dao.insertTicket(ticket, emp);
		
	}

	@Override
	public ArrayList<Reimbursement> getAllTickets() {
		
		return dao.selectAllTickets();
		
	}

	@Override
	public ArrayList<Reimbursement> getPendingTickets() {
		
		return dao.selectPendingTickets();
		
	}

	@Override
	public ArrayList<Reimbursement> getApprovedTickets(int num) {
		
		return dao.selectApprovedTickets(num);
		
	}

	@Override
	public boolean updateTicket(Reimbursement ticket) {
		
		return dao.updateReimbursement(ticket);
		
	}

	@Override
	public Reimbursement setSingleTicket(Reimbursement ticket) {
		
		return dao.loadSingleTicket(ticket);
	}

}
