/**
 * Basic class that demonstrates the use of a 
 * program in an Application Controller Pattern
 * @author Benjamin Porter
 */

package porter.acp;

import java.util.HashMap;
import java.util.Scanner;

public class BasicACP {

	// Main method
	public static void main(String[] args) {
		
		// Creates new ApplicationController, Scanner, and Library objects
		ApplicationController appController = new ApplicationController();
		Scanner input = new Scanner(System.in);
		Library data = new Library();
		
		try {
			int act = -1;
			
			// Menu while loop
			while (act != 0) {
				
				act = (int)appController.doIt("displayMenu", getIt("scanner", input));
				
				// Action switch
				switch (act) {
				
					case 1:
						// Displays Library content
						appController.doIt("displayGames", getIt("library", data));
						break;
						
					case 2:
						// Adds new Game object to Library
						HashMap<String, Object> commandData = getIt("scanner", input);
						commandData.put("library", data);
						appController.doIt("addGame", commandData);
						break;
						
					case 3:
						// Removes Game object from Library
						HashMap<String, Object> commandDelete = getIt("scanner", input);
						commandDelete.put("library", data);
						appController.doIt("removeGame", commandDelete);
						break;
						
					case 0:
						// Closes program
						System.out.println("\nGoodbye :)");
						break;
						
					default:
						// Invalid action input
						System.out.println("Selection not recognized. Please try again.");
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			input.close();
		}
	}
	
	/**
	 * Get a HashMap containing one data command for Application Controller
	 * @param key, value
	 * @return HashMap data with one command
	 */
	public static HashMap<String, Object> getIt(String key, Object value) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put(key, value);
		return data;
	}
}
