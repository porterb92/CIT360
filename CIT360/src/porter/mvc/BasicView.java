/**
 * Basic view class that displays the Swing and
 * interacts with the user and controller class, 
 * but not the model class.
 * @author Benjamin Porter
 */

package porter.mvc;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BasicView extends JFrame{
	
	// Label, text field, and button objects
	private JLabel dollarLabel = new JLabel("$");
	private JTextField UScurrency  = new JTextField(10);
	private JButton convertButton = new JButton("Convert");
	private JLabel equalLabel = new JLabel("=");
	
	// Foreign currency labels and text fields
	private JLabel canadianLabel = new JLabel("Canadian Dollar (CA$)");
	private JTextField canadianSolution = new JTextField(10);
	private JLabel austrailianLabel = new JLabel("Australian Dollar (AU$)");
	private JTextField austrailianSolution = new JTextField(10);
	private JLabel euroLabel = new JLabel("Euro (€)");
	private JTextField euroSolution = new JTextField(10);
	private JLabel poundLabel = new JLabel("Pound (£)");
	private JTextField poundSolution = new JTextField(10);
	private JLabel yenLabel = new JLabel("Yen (¥)");
	private JTextField yenSolution = new JTextField(10);
	private JLabel rupeeLabel = new JLabel("Indian Rupee (Rs)");
	private JTextField rupeeSolution = new JTextField(10);
	
	// Initializes view object and creates Swing 
	BasicView(){
		JPanel calcPanel = new JPanel(new GridBagLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Currency Exchange Rate - 2/7/2020");
		this.setSize(575, 200);
		this.setResizable(false);
		GridBagConstraints c = new GridBagConstraints();

		// 1st Row
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,0,10);
		calcPanel.add(dollarLabel, c);
		c.gridx = 1;
		calcPanel.add(UScurrency, c);
		c.gridx = 2;
		calcPanel.add(new JLabel(" "), c);
		c.gridx = 3;
		calcPanel.add(convertButton, c);
		c.gridx = 4;
		calcPanel.add(equalLabel, c);
		c.gridx = 5;
		calcPanel.add(canadianLabel, c);
		c.gridx = 6;
		calcPanel.add(canadianSolution, c);
		
		// Rows 2-6
		for (int i = 1; i <= 5; i++) {
			c.gridy = i;
			for (int j = 0; j <= 4; j++) {
				c.gridx = j;
				calcPanel.add(new JLabel(" "), c);
			}
			if(i == 1) {
				c.gridx = 5;
				calcPanel.add(austrailianLabel, c);
				c.gridx = 6;
				calcPanel.add(austrailianSolution, c);
			}
			else if(i == 2) {
				c.gridx = 5;
				calcPanel.add(euroLabel, c);
				c.gridx = 6;
				calcPanel.add(euroSolution, c);
			}
			else if(i == 3) {
				c.gridx = 5;
				calcPanel.add(poundLabel, c);
				c.gridx = 6;
				calcPanel.add(poundSolution, c);
			}
			else if(i == 4) {
				c.gridx = 5;
				calcPanel.add(yenLabel, c);
				c.gridx = 6;
				calcPanel.add(yenSolution, c);
			}
			else {
				c.gridx = 5;
				calcPanel.add(rupeeLabel, c);
				c.gridx = 6;
				calcPanel.add(rupeeSolution, c);
			}	
		}
		
		// Display panel
		this.add(calcPanel);
	}
	
	// Method that converts string input into double data type
	public double getCurrency(){
		return Double.parseDouble(UScurrency.getText());
	}
	
	// Method that sets CAD value
	// @param solution
	public void setCADSolution(double solution){
		canadianSolution.setText(String.format("%,.2f", solution));
	}
	
	// Method that sets AUD value
	// @param solution
	public void setAUDSolution(double solution){
		austrailianSolution.setText(String.format("%,.2f", solution));
	}
	
	// Method that sets EUR value
	// @param solution
	public void setEuroSolution(double solution){
		euroSolution.setText(String.format("%,.2f", solution));
	}
	
	// Method that sets GBP value
	// @param solution
	public void setPoundSolution(double solution){
		poundSolution.setText(String.format("%,.2f", solution));
	}
	
	// Method that sets JPY value
	// @param solution
	public void setYenSolution(double solution){
		yenSolution.setText(String.format("%,.2f", solution));
	}
	
	// Method that sets INR value
	// @param solution
	public void setRupeeSolution(double solution){
		rupeeSolution.setText(String.format("%,.2f", solution));
	}
	
	// Method that manages button actions
	// @param listenForButton
	void addBasicListener(ActionListener listenForButton){
		convertButton.addActionListener(listenForButton);
	}
	
	// Method that displays separate window with input error message
	// @param errorMessage
	void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
