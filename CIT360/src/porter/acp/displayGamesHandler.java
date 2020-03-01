/**
 * Basic class that handles the
 * display library command
 * @author Benjamin Porter
 */

package porter.acp;

import java.util.HashMap;

public class displayGamesHandler implements Handler {

	@Override
	public Object handleIt(HashMap<String, Object> data) {
		Library lib = (Library) data.get("library");

		// Displays content in Library
		String s = lib.toString();
		System.out.println(s);
		return null;
	}
}
