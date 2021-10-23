package mainproject01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Logging {
	
	public static Logger logging = Logger.getLogger(Logging.class);
	
	public static String url = "jdbc:postgresql://" + System.getenv("Reimbursement_IP") + "/Reimbursement";
	public static String username = System.getenv("Reimbursement_username");
	public static String password = System.getenv("Reimbursement_password");

	
	public static void loggingException(Exception a) {
		logging.warn("Warning make sure you're not touching this stuff again");
		logging.error("Oh ohhhh, I told you not to touch it!!!!!!!!!!!!", a);
		logging.fatal("Now you are in big trouble for touching what I told you not to do \t", a);
		logging.info("---------------------------------------------------------------------------");
	}
	
	public static Connection tryConnection() throws SQLException{
		logging.setLevel(Level.ALL);
				
		if(logging.isInfoEnabled()) {
			logging.info("The Data Base was accessed");
		}
		return DriverManager.getConnection(url, username, password);
	}

}
