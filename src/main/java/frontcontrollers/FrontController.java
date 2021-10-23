package frontcontrollers;

import controllers.UserController;
import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Employee;

public class FrontController {
	
	Javalin app;
	Dispatcher dispatcher;
	
	
	public FrontController(Javalin app) {
		
		this.app = app;
		
		app.before("/*", FrontController::checkAllRequests);
		
		this.dispatcher = new Dispatcher(app);
	}
	
	public static void checkAllRequests(Context context) {
		
		
		
		System.out.println("In front controller");
		
		
		if(context.path().equals("/index.html")) {
			System.out.println("Back from the index ");
			return;
		}else if(context.path().equals("/test-login.html")) {
			System.out.println("Back from the login ");
			return;
		}

	}

}
