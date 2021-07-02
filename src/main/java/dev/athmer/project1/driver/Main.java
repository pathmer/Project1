package dev.athmer.project1.driver;

//import dev.athmer.project1.logging.AppLogger;
import dev.athmer.project1.services.AutoApproveServices;

public class Main {
	
	public static boolean quit = false;


	public static void main(String[] args) {
		AutoApproveServices aas = new AutoApproveServices();

		//AppLogger.logger.info("Program started.");
		aas.mainaas();
	}
}
