/**
 * Basic interface that handles all 
 * commands in the application
 * @author Benjamin Porter
 */

package porter.acp;

import java.util.HashMap;

public interface Handler {

	public Object handleIt(HashMap<String, Object> data);
}
