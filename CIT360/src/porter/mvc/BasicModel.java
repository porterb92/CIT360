/**
 * Basic model class that stores data and 
 * only interacts with the controller class.  
 * @author Benjamin Porter
 */

package porter.mvc;

public class BasicModel {
	
	 private double convertedValue;
	 
	 // Method that converts USD currency to CAD
	 // @param currency
	 public void convert2CD(double currency){
		 convertedValue = currency * 1.331;
	 }
	 
	 // Method that converts USD currency to AUD
	 // @param currency
	 public void convert2AD(double currency){
		 convertedValue = currency * 1.497;
	 }
	 
	 // Method that converts USD currency to EUR
	 // @param currency
	 public void convert2Euro(double currency){
		 convertedValue = currency * 0.9131;
	 }
	 
	 // Method that converts USD currency to GBP
	 // @param currency
	 public void convert2Pound(double currency){
		 convertedValue = currency * 0.7732;
	 }
	 
	 // Method that converts USD currency to JPY
	 // @param currency
	 public void convert2Yen(double currency){
		 convertedValue = currency * 109.762;
	 }
	 
	 // Method that converts USD currency to INR
	 // @param currency
	 public void convert2Rupee(double currency){
		 convertedValue = currency * 71.447;
	 }
	 
	 // Method that returns the stored converted value
	 public double getConvertedValue(){
		 return convertedValue;
	 }
}
