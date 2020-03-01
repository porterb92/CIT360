/**
 * Basic class that handles the
 * addGame command
 * @author Benjamin Porter
 */

package porter.acp;

import java.util.HashMap;
import java.util.Scanner;

public class addGameHandler implements Handler {

	@Override
	public Object handleIt(HashMap<String, Object> data) {
		Scanner input = (Scanner) data.get("scanner");
		Library lib = (Library) data.get("library");

		// User prompts for adding new Game object to Library
		System.out.print("\nEnter the game title: ");
		String title = input.nextLine();
		System.out.print("Enter the game type: ");
		String type = input.nextLine();
		System.out.print("Enter the number of players: ");
		String ages = input.nextLine();
		System.out.println("\nGenres:");
		int i = 1;
		
		// Genre selection
		Genre[] genres = Genre.values();
		int genreSelection = 0;
		while (genreSelection < 1 || genreSelection > genres.length) {
			for (Genre genre : genres) {
				System.out.println(i++ + " - " + genre.toString());
			}
			System.out.print("\nSelect a genre: ");
			genreSelection = GetNextInt(input);
			i = 1;
		}
		Genre selectedGenre = genres[genreSelection - 1];

		// Creates new Game object
		Game newGame = new Game(title, type, ages, selectedGenre);
		
		// Adds new object to Library
		lib.addGame(newGame);
		System.out.print("\nA new game, " + newGame.getTitle() + ", has been added to the Library.\n\n");
		return null;
	}

	/**
	 * Converts the Genre pointer input from String to Integer 
	 * @param scan
	 * @return Integer pointer to selected Genre
	 */
	private int GetNextInt(Scanner scan) {
		String input = scan.nextLine();
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Please choose a genre from the list.");
			return -1;
		}
	}
}
