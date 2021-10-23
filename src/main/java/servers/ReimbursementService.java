package servers;

import java.util.ArrayList;

import models.Employee;
import models.Reimbursement;

public interface ReimbursementService {
	
	////////////////// INSERTS ////////////////
	public boolean createTicket(Reimbursement ticket, Employee emp);
	
	/////////////// Selects /////////////////
	public ArrayList<Reimbursement> getAllTickets();
	public ArrayList<Reimbursement> getPendingTickets();
	public ArrayList<Reimbursement> getApprovedTickets(int num);
	
	///////////////////// UPDATES //////////////////////////
	public boolean updateTicket(Reimbursement ticket);
	public Reimbursement setSingleTicket(Reimbursement ticket);

}
