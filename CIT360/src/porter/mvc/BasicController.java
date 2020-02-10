/**
 * Basic controller class that acts as the
 * middle man in the application and interacts 
 * with the model and view classes.  
 * @author Benjamin Porter
 */

package porter.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicController {

	private BasicView view;
	private BasicModel model;
	
	// Method that initializes controller object
	// @param view, model
	public BasicController(BasicView view, BasicModel model) {
		this.view = view;
		this.model = model;
		
		this.view.addBasicListener(new CalculateListener());
	}
	
	// Class that manages button action in the view class
	class CalculateListener implements ActionListener{
		
		// Method that performs every time the button is pressed
		public void actionPerformed(ActionEvent e) {
			double currency = 0.0;
			
			try{
				// Round the input amount to two decimal places
				currency = Math.round(view.getCurrency() * 100.0) / 100.0;
				
				// Conversion and setter methods
				model.convert2CD(currency);
				view.setCADSolution(model.getConvertedValue());
				model.convert2AD(currency);
				view.setAUDSolution(model.getConvertedValue());
				model.convert2Euro(currency);
				view.setEuroSolution(model.getConvertedValue());
				model.convert2Pound(currency);
				view.setPoundSolution(model.getConvertedValue());
				model.convert2Yen(currency);
				view.setYenSolution(model.getConvertedValue());
				model.convert2Rupee(currency);
				view.setRupeeSolution(model.getConvertedValue());
			}
			
			// Exception for empty and non-numerical inputs
			catch(NumberFormatException ex){
				 System.out.println(ex);
				 view.displayErrorMessage("Enter the currency value in USD($)");
			}	
		}
	}
}
