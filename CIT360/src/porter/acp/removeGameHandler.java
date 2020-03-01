/**
 * Basic class that handles the
 * removal of Game objects
 * @author Benjamin Porter
 */

package porter.acp;

import java.util.HashMap;
import java.util.Scanner;

public class removeGameHandler implements Handler {

	@Override
	public Object handleIt(HashMap<String, Object> data) {
		Scanner input = (Scanner) data.get("scanner");
		Library lib = (Library) data.get("library");
		
		// Prompts user for title of Game object to remove
		System.out.print("\nEnter the title you want to remove: ");
		String title = input.nextLine();
		
		// Verifies if Game object exists in Library before removal
		if(lib.removeGame(title.toLowerCase())) {
			System.out.println("\n" + title + " has successfully been removed.\n");
		}
		else {
			System.out.println("\n" + title + " was not found.\n");
		}
		return null;
	}
}
