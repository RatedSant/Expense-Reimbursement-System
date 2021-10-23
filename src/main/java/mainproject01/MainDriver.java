package mainproject01;

import daos.*;
import frontcontrollers.FrontController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import models.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class MainDriver {

	public static void main(String[] args) {

		Javalin app = Javalin.create(config -> {
			config.addStaticFiles(staticFiles -> {
				staticFiles.directory = "/html-pages";
				staticFiles.hostedPath = "/";
				staticFiles.location = Location.CLASSPATH;
			});
			
		}).start(9002);
		
		
		FrontController frontCont = new FrontController(app);
	}

}
