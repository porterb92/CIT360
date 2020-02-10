/**
 * Basic MVC exercise that demonstrates the separation
 * and rules of interaction between the three main concerns
 * within the application.
 * @author Benjamin Porter
 */

package porter.mvc;

public class BasicMVC {
	
	// Main method
	public static void main(String[] args) {
		
		// Initialize the three separate classes
		BasicModel model = new BasicModel();
		
		BasicView view = new BasicView();
			
		new BasicController(view, model);
		
		// Initiates Swing
		view.setVisible(true);
	}
}
