/**
 * Basic class that stores and 
 * displays the Game objects
 * @author Benjamin Porter
 */

package porter.acp;

import java.util.ArrayList;

public class Library {

	// Create Game object array
	private ArrayList<Game> games;

	public Library() {
		games = new ArrayList<>();
		String board = "Board";
		String card = "Card";
		String video = "Video";
		String sports = "Sports";
		
		// Adds default list of objects into Library
		games.add(new Game("Chess", board, "2", Genre.STRATEGY));
		games.add(new Game("Go Fish", card, "2-10", Genre.CLASSIC));
		games.add(new Game("Monopoly", board, "2-8", Genre.DICE));
		games.add(new Game("Basketball", sports, "2-10", Genre.SPORTS));
		games.add(new Game("Pong", video, "2", Genre.SPORTS));
		games.add(new Game("Pinochle", card, "4", Genre.STRATEGY));
		games.add(new Game("Clue", board, "2-6", Genre.DICE));
		games.add(new Game("Super Mario Bros.", video, "2", Genre.ADVENTURE));
		games.add(new Game("Raquetball", sports, "2-4", Genre.SPORTS));
		games.add(new Game("Cranium", board, "4+", Genre.TRIVIA));
	}
	
	/**
	 * Method that adds new Game object to Library 
	 * @param newGame
	 */
	public void addGame(Game newGame) {
		this.games.add(newGame);
	}
	
	/**
	 * Method that removes Game object from Library 
	 * @param title
	 * @return boolean based on success of object removal
	 */
	public boolean removeGame(String title) {
		for(Game game : games) {
			String checker = game.getTitle().toLowerCase();
			if(checker.equals(title)) {
				this.games.remove(game);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int i = 1;
		builder.append("\n---- Library ------------------------\n\n");
		ArrayList<String> gamesList = new ArrayList<>();
		for(Game game : games) {
			gamesList.add("Game " + i++ + " " + game.toString());
		}
		String gameStrings = String.join(",\n", gamesList);
		builder.append(gameStrings);
		builder.append("\n\n------------------------------------\n\n");
		return builder.toString();
	}
}
