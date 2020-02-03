/**
 * Basic HTTP exercise that connects to specific URL addresses,
 * uses a GET and POST request method to connected URLs, and 
 * displays the HTTP response from the web server.
 * @author Benjamin Porter
 */

package porter.http;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class BasicHTTP {
	
	// Main method
	public static void main(String[] args) throws Exception {
		 
		 // Create new Scanner object
		 Scanner input = new Scanner(System.in);
		 
		 // Type in domain name to use GET method
		 System.out.print("Enter the domain name to send a GET request\n(oracle.com, byui.edu, churchofjesuschrist.org): ");
		 String domainGet = emptyString(input.nextLine(), input);
		 
		 // Type in domain name to use POST method
		 System.out.print("Enter the domain name to send a POST request\n(oracle.com, byui.edu, churchofjesuschrist.org): ");
		 String domainPost = emptyString(input.nextLine(), input);
		 
		 // Using GET and POST request methods towards the input domain names
		 sendGet(domainGet);
		 sendPost(domainPost);
	}
	
	
	/* Method that sends a GET request to a designated domain 
	*  @param domain
	*/
	public static void sendGet(String domain) {
		
		 try {
			 // New URL and HttpURLConnection objects
			 URL page = new URL("https://www." + domain +"/");
			 HttpURLConnection connect = (HttpURLConnection) page.openConnection(); 
			 
			 // Add request header
			 connect.setRequestMethod("GET");
			 connect.setRequestProperty("User-Agent", "Mozilla/5.0");

			 // Get ResponseCode
		     int code = connect.getResponseCode();
		     
		     // GET message
		     System.out.println("\n\nSending 'GET' request to URL : " + page.getHost());
		     System.out.println("Response Code : " + code);
		     
		     // Record response if connected
		     if(isServerUp(page)) {
		    	 Response(connect);
		     }		     
		 }
		 catch (IOException e) {
			System.err.println("Failed to connect.");	
		 }
	}
	
	
	/* Method that sends a POST request to a designated domain 
	*  @param domain
	*/
	public static void sendPost(String domain) {
		
		 try {
			 // New URL and HttpURLConnection objects
			 URL page = new URL("https://www." + domain + "/");
			 HttpURLConnection connect = (HttpURLConnection) page.openConnection();
			 
			 // Add request header
			 connect.setRequestMethod("POST");
			 connect.setRequestProperty("User-Agent", "Mozilla/5.0");
			 connect.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			 String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
			 
			 // Send POST request
			 connect.setDoOutput(true);
			 try (DataOutputStream wr = new DataOutputStream(connect.getOutputStream())) {
				 wr.writeBytes(urlParameters);
				 wr.flush();
			 }
			 
			 // Get ResponseCode
			 int code = connect.getResponseCode();
			 
			 // POST message
			 System.out.println("\n\nSending 'POST' request to URL : " + page.getHost());
			 System.out.println("Post parameters : " + urlParameters);
			 System.out.println("Response Code : " + code);
			 
			 // Record response if connected
			 if(isServerUp(page)) {
		    	 Response(connect);
		     }	
			 
		 }
		 catch (IOException e) {
			 System.err.println("Failed to connect.");
		 } 
	}
	
	
	/* Method that returns the HTTP response from the request methods 
	*  @param connection
	*/
	public static void Response(HttpURLConnection connection) {
		
		 try {
			 // New BufferedReader object and String
			 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			 String inputLine;
		 
			 // Print the response
			 while ((inputLine = in.readLine()) != null) {
				 if(inputLine.isEmpty() == false) {
					 System.out.println(inputLine);
				 }
				 else {
					 System.out.println("");
				 }
			 }
			 // Close BufferedReader
			 in.close();
		 }
		 catch (IOException e) {
			 if(e.getCause() == null) {
				 System.err.println("Failed to connect.");
			 }
			 else {
				 System.err.println("Request method has been rejected.");
			 }
		 } 
	}
	
	
	/* Method that makes sure there are no empty inputs
	*  @param input, tryAgain
	*/
	public static String emptyString(String input, Scanner tryAgain) {
		
		// While loop that makes certain user input is not empty or null
		while(input.isEmpty()) {
			System.err.print("Invalid entry. Please enter a response: ");
			input = tryAgain.nextLine();
		}
		// Returns valid input
		return input;						
	}
	
	
	/* Method that checks whether the server is up and running
	*  @param webPage
	*/
	public static boolean isServerUp(URL webPage) {
		
		// Host name in String format
		String webCheck = webPage.getHost();
		 
        try {
        	// Checks whether server accesses designated host or not
            InetAddress.getByName(webCheck).isReachable(2000);
            return true;
        } 
        catch (Exception e) {
        	// Server error message
        	System.err.println("\nServer is currently down. "
        			+ "Please try again later.");
            return false;
        }
	}
}
