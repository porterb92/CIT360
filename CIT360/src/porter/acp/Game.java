/**
 * Basic class that creates, sets,
 * and displays Game objects 
 * @author Benjamin Porter
 */

package porter.acp;

public class Game {

	private String title;
	private String type;
	private String players;
	private Genre genre;
	
	// Game constructor
	public Game(String title, String type, String players, Genre genre) {
		this.title = title;
		this.type = type;
		this.players = players;
		this.genre = genre;
	}

	// Getter and setter methods
	public String getTitle() {
		return title;
	}

	public void setAuthor(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "[title=" + title + ",     type=" + type + ",     # of players=" + players + ",     genre=" + genre.toString() + "]";
	}
}
