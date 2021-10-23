package frontcontrollers;

import static io.javalin.apibuilder.ApiBuilder.*;

import controllers.*;
import io.javalin.Javalin;

public class Dispatcher {
	
	public Dispatcher(Javalin app) {

		setupAllPaths(app);
	}

	public static void setupAllPaths(Javalin app) {
		
		setupUserAccountControllerPaths(app);
	}

	public static void setupUserAccountControllerPaths(Javalin app) {
		
		System.out.println("Entering the Dispatcher");
		
		app.routes(()->{
			path("/get-users", ()->{
				get(UserController::getAllUsers);
			});
			path("/user-login", ()->{
				post(UserController::login);
			});
			path("/user-logout", ()->{
				get(UserController::logout);
			});
			path("/get-user", ()->{
				get(UserController::getSingleUser);
			});
			path("/create-reimb", ()->{
				post(ReimbursementController::createTicket);
			});
			path("/update-reimb", ()->{
				post(UserController::updateUserReimbursement);
			});
			path("/get-reimbs", ()->{
				get(ReimbursementController::getAllReimbursements);
			});
			path("/get-user-reimbs", ()->{
				get(UserController::getUserReimbursements);
			});
			path("/get-user-approved-reimbs", ()->{
				get(UserController::getUserApprovedReimbursements);
			});
			path("/get-user-pending-reimbs", ()->{
				get(UserController::getUserPendingReimbursements);
			});
			path("/get-user-denied-reimbs", ()->{
				get(UserController::getUserDeniedReimbursements);
			});
			path("/get-all-pending-reimbs", ()->{
				get(ReimbursementController::getAllPendingReimbursements);
			});
			path("/get-all-approved-reimbs", ()->{
				get(ReimbursementController::getAllApprovedReimbursements);
			});
			path("/get-all-denied-reimbs", ()->{
				get(ReimbursementController::getAllDeniedReimbursements);
			});

		});
	}

}
