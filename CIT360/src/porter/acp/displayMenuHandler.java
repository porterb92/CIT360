/**
 * Basic class that handles the
 * menu and its display
 * @author Benjamin Porter
 */

package porter.acp;

import java.util.HashMap;
import java.util.Scanner;

public class displayMenuHandler implements Handler {

	@Override
	public Object handleIt(HashMap<String, Object> data) {
		
		// Display Main Menu
		System.out.println("---- Main Menu ----------------\n");
		System.out.println("1 - Display Game Library");
		System.out.println("2 - Add Game");
		System.out.println("3 - Remove Game");
		System.out.println("0 - Exit");
		System.out.print("\nEnter [1], [2], [3], or [0]: ");
		
		// User's input
		Scanner input = (Scanner)data.get("scanner");
		int selection = GetNextInt(input);
		return selection;
	}

	/**
	 * Checks on user input verification 
	 * @param scanner
	 * @return Integer input result
	 */
	private int GetNextInt (Scanner scanner) {
		String input = scanner.nextLine();
		try {
			int result = Integer.parseInt(input);
			return result;
		} catch (Exception e) {
			System.out.println("You must enter a number from the menu.");
			return -1;
		}
	}
}
