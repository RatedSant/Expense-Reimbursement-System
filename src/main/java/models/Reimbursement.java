package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Reimbursement {
	
	LocalDateTime currentTime = LocalDateTime.now();
	
	private int reimbAmount, reimbAuthor, reimbResolver, reimbStatus,
				reimbType, reimbID;
	private String reimbDescription, author, resolver, status, type;
	private Timestamp reimbSubmitted, reimbResolved;
	
	public Reimbursement() {
		
	}
	
	public Reimbursement(int reimbAmount, int reimbAuthor, int reimbResolver,
			int reimbStatus, int reimbType, int reimbID, String reimbDescription, String author, String resolver,
			String status, String type, Timestamp reimbSubmitted, Timestamp reimbResolved) {

		
		this.reimbAmount = reimbAmount;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
		this.reimbID = reimbID;
		this.reimbDescription = reimbDescription;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
	}


	public String getAuthor() {
		return author;
	}

	public String getResolver() {
		return resolver;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Reimbursement(int reimbAmount, int reimbAuthor, int reimbStatus, int reimbType,
			String reimbDescription) {
		
		this.reimbAmount = reimbAmount;
		this.reimbAuthor = reimbAuthor;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
		this.reimbDescription = reimbDescription;
		this.setReimbSubmitted();
		
	}
	
	public Reimbursement(int reimbAmount, int reimbAuthor, int reimbResolver, int reimbStatus, int reimbType,
			int reimbID, String reimbDescription, Timestamp reimbSubmitted, Timestamp reimbResolved) {
		
		this.reimbAmount = reimbAmount;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
		this.reimbID = reimbID;
		this.reimbDescription = reimbDescription;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
	}

	public void setReimbAmount(int reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public void setReimbStatus(int reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public void setReimbType(int reimbType) {
		this.reimbType = reimbType;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public void setReimbSubmitted() {
		this.reimbSubmitted = reimbSubmitted.valueOf(currentTime);
	}
	public void setReimbSubmittedDB(Timestamp reimbSubmitted) {
		
		this.reimbSubmitted = reimbSubmitted;
	}
	public void setReimbResolved() {
		this.reimbResolved = reimbResolved.valueOf(currentTime);
	}
	public void setReimbResolvedDB(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public int getReimbAmount() {
		return reimbAmount;
	}
	public int getReimbID() {
		return reimbID;
	}
	public int getReimbAuthor() {
		return reimbAuthor;
	}
	public int getReimbResolver() {
		return reimbResolver;
	}
	public int getReimbStatus() {
		return reimbStatus;
	}
	public int getReimbType() {
		return reimbType;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void showReimbursements() {
		System.out.println("-------------------------------");
		System.out.println("Reimb ID: " + this.reimbID);
		System.out.println("Reimb Amount: " + this.reimbAmount);
		System.out.println("Reimb Reimb Submitted: " + this.reimbSubmitted);
		System.out.println("Reimb Reimb Resolved: " + this.reimbResolved);
		System.out.println("Reimb Descript: " + this.reimbDescription);
		System.out.println("Reimb Author: " + this.author);
		System.out.println("Reimb Resolver: " + this.resolver);
		System.out.println("Reimb Status: " + this.status);
		System.out.println("-------------------------------");	
	}

}
