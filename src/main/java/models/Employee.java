package models;

public class Employee {

	private String loginName, userPass, userName, userLastName, userEmail;
	private int userId, userRole;
	
	
	public Employee() {
		
	}
	
	public Employee(String loginName, String userPass) {
		
		this.loginName = loginName;
		this.userPass = userPass;
	}
	public Employee(String loginName, String userPass, String userName, String userLastName, String userEmail,
			int userId, int userRole) {
		super();
		this.loginName = loginName;
		this.userPass = userPass;
		this.userName = userName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userId = userId;
		this.userRole = userRole;
	}
	public Employee(String loginName, String userPass, String userName, String userLastName, String userEmail,
			 int userRole) {
		super();
		this.loginName = loginName;
		this.userPass = userPass;
		this.userName = userName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	
	public void showAccount() {
		System.out.println("-------------------------------");
		System.out.println("User ID: " + this.userId);
		System.out.println("Username: " + this.loginName);
		System.out.println("Password: " + this.userPass);
		System.out.println("First Name: " + this.userName);
		System.out.println("Last Name: " + this.userLastName);
		System.out.println("Email: " + this.userEmail);
		System.out.println("Employee Role: " + this.userRole);
		System.out.println("-------------------------------");	
	}
}
