package daos;

import java.util.*;
import models.*;

public interface ReimbursementDao {

	
	////////////////// INSERTS ////////////////
	public boolean insertTicket(Reimbursement ticket, Employee emp);
	
	/////////////// Selects /////////////////
	public ArrayList<Reimbursement> selectAllTickets();
	public ArrayList<Reimbursement> selectPendingTickets();
	public ArrayList<Reimbursement> selectApprovedTickets(int num);
	
	///////////////////// UPDATES //////////////////////////
	public boolean updateReimbursement(Reimbursement ticket);
	public Reimbursement loadSingleTicket(Reimbursement ticket);
	
	
}
