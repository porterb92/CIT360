/**
 * Basic class that controls the application
 * and handles the Handler classes
 * @author Benjamin Porter
 */

package porter.acp;

import java.util.HashMap;

public class ApplicationController {

	// HashMap Handler
	private HashMap<String, Handler> command;
	
	public ApplicationController() {
		
		// Place commands in handler
		command = new HashMap<String, Handler>();
		command.put("addGame", new addGameHandler());
		command.put("displayGames", new displayGamesHandler());
		command.put("removeGame", new removeGameHandler());
		command.put("displayMenu", new displayMenuHandler());
	}

	/**
	 * Get a HashMap containing one data command for Application Controller
	 * @param commandKey, commandData
	 * @return Handler method of specific command
	 */
	public Object doIt(String commandKey, HashMap<String, Object> commandData) throws Exception {
		Handler handle = command.getOrDefault(commandKey, null);
		if (handle == null) {
			throw new Exception("There is no command with the key word '" + commandKey + "'.");
		}
		
		return handle.handleIt(commandData);
	}
}
