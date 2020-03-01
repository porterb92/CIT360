/**
 * Basic enum that stores and
 * calls genre values
 * @author Benjamin Porter
 */

package porter.acp;

public enum Genre {

	ADVENTURE("Adventure"),
	CLASSIC("Classic"),
	DICE("Dice"),
	GAMBLING("Gambling"),
	PARTY("Party"),
	PUZZLE("Puzzle"),
	ROLE_PLAYING("Role-Playing"),
	SHOOTER("Shooter"),
	SPORTS("Sports"),
	STRATEGY("Strategy"),
	TRIVIA("Trivia");
	
	private String name;
	
	private Genre(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
