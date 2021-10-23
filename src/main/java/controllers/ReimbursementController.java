package controllers;

import java.util.*;

import io.javalin.http.Context;
import models.*;
import servers.*;

public class ReimbursementController {
	
	static ReimbursementService dao = new ReimbursementServiceImp();
	
	
	public static void createTicket(Context context) {
		
		Employee currentUser = context.sessionAttribute("user");
		Reimbursement currentTicket = new Reimbursement();
		int author = currentUser.getUserId();
		int defaultStatus = 1;
		int temporary_reason = 2;
		
		temporary_reason = Integer.parseInt(context.formParam("reason"));
		
		
		
		currentTicket.setReimbAmount(Integer.parseInt(context.formParam("amount")));
		currentTicket.setReimbSubmitted();
		currentTicket.setReimbDescription(context.formParam("description"));
		currentTicket.setReimbAuthor(author);
		currentTicket.setReimbStatus(defaultStatus);
		currentTicket.setReimbType(temporary_reason);
		
		dao.createTicket(currentTicket, currentUser);

		if (context.sessionAttribute("user") != null) {

			System.out.println("The ticket has been created successfully!");
			context.result("You created a ticket!!").status(201);
			context.redirect("/test-employee.html");
			
		} else {
			
				/////////////////// MODIFY ENDPOINT
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
		}
		
		
	}
	
	public static void getAllReimbursements(Context context) {

		//////////// ADMIN
		Employee currentUser = context.sessionAttribute("user");
		

		if (currentUser != null) {

			context.json(dao.getAllTickets());
			
		} else {
			
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
			
		}

	}
	
	public static void getAllPendingReimbursements(Context context) {
		
		////////////ADMIN && EMPLOYEE
		Employee currentUser = context.sessionAttribute("user");
		

		if (currentUser != null) {

			context.json(dao.getPendingTickets());
			
		} else {
			
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
			
		}
	
	}
	
	public static void getAllApprovedReimbursements(Context context) {
		
		////////////ADMIN && EMPLOYEE
		Employee currentUser = context.sessionAttribute("user");
		
		int approved = 2;
		

		if (currentUser != null) {

			context.json(dao.getApprovedTickets(approved));
			
		} else {
			
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
			
		}
	
	}
	
	public static void getAllDeniedReimbursements(Context context) {
		
		////////////ADMIN && EMPLOYEE
		Employee currentUser = context.sessionAttribute("user");
		
		int denied = 3;

		if (currentUser != null) {

			context.json(dao.getApprovedTickets(denied));
			
		} else {
			
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
			
		}
	
	}
	
	
	
	
}
