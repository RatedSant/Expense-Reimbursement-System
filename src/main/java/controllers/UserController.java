package controllers;

import io.javalin.http.Context;
import models.*;
import servers.*;

public class UserController {

	static EmployeeServiceImp dao = new EmployeeServiceImp();
	static ReimbursementService daoReimb = new ReimbursementServiceImp();
	

	public static void login(Context context) {
		
		Employee currentUser = new Employee();

		currentUser.setLoginName(context.formParam("username"));
		currentUser.setUserPass(context.formParam("password"));

		if (dao.confirmAccont(currentUser)) {

			currentUser = dao.setAccount(currentUser);

			System.out.println("Login Successfull.......");

			context.sessionAttribute("user", currentUser);

			if (currentUser.getUserRole() == 1) {
				context.redirect("/test-page.html");
			} else {
				context.redirect("/test-employee.html");
			}
		} else {

			context.redirect("/not-allowed.html");

		}
	}
	
	public static void logout(Context context) {
		
		context.sessionAttribute("user", null);	
		System.out.println("Logout Successfull.........");
		context.redirect("/index.html");
		
	}
	
	

	public static void getAllUsers(Context context) {

		//////////// ADMIN
		context.json(dao.getAllEmployee());

	}

	public static void getSingleUser(Context context) {
		
		//////////////// HTML USAGE
		
		Employee currentUser = context.sessionAttribute("user");

		if (currentUser != null) {

			context.json(currentUser);
			
		} else {
			
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
			
		}

	}
	
	public static void getUserReimbursements(Context context) {
		
		//////////// ADMIN && EMPLOYEE
		
		Employee currentUser = context.sessionAttribute("user");
		

		if (currentUser != null) {

			context.json(dao.getAllTickets(currentUser));
			
		} else {
			
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
			
		}
		
	}
	public static void getUserDeniedReimbursements(Context context) {
		
		////////////ADMIN && EMPLOYEE
		Employee currentUser = context.sessionAttribute("user");
		
		int denied = 3;
		

		if (currentUser != null) {

			context.json(dao.getApprovedTickets(currentUser, denied));
			
		} else {
			
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
			
		}
		
	}
	
	public static void getUserPendingReimbursements(Context context) {
		
		////////////ADMIN && EMPLOYEE
		
		Employee currentUser = context.sessionAttribute("user");
		

		if (currentUser != null) {

			context.json(dao.getPedingTickets(currentUser));
			
		} else {
			
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
			
		}
		
	}
	
	public static void getUserApprovedReimbursements(Context context) {
		
		////////////ADMIN && EMPLOYEE
		Employee currentUser = context.sessionAttribute("user");
		int approved = 2;

		if (currentUser != null) {

			context.json(dao.getApprovedTickets(currentUser, approved));
			
		} else {
			
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
			
		}
		
	}
	
	public static void updateUserReimbursement(Context context) {
		
		////////////ADMIN
		Employee currentUser = context.sessionAttribute("user");
		Reimbursement currentTicket = new Reimbursement();
		
		
		String ticketId = context.formParam("ticketId");
		
		currentTicket.setReimbID(Integer.parseInt(ticketId));
		currentTicket.setReimbResolved();
		currentTicket.setReimbStatus(Integer.parseInt(context.formParam("newStatus")));

		if (currentUser != null) {

			if(dao.updateTicketStatus(currentTicket, currentUser)) {	
				
				context.result("Oh yes, your ticket has been updated my friend!!!!!!!");
				
				context.redirect("/test-page.html");
				
			}
			
		} else {
			
			System.out.println("Broh, you need to login first!!!!!!!!!!");
			context.redirect("/test-login.html");
			
		}
		
	}
	
	
	
	

}
