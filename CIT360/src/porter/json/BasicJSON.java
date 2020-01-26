/**
 * Basic JSON exercise that converts a Java object
 * into a JSON object, stores it on a separate JSON file titled 
 * "JSON_Test.json", and the file contents are converted into
 * a new Java object.
 * @author Benjamin Porter
 */

package porter.json;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;


public class BasicJSON {
	
	// Main Method
	public static void main(String[] args) {
	
	// Create new Scanner object
	Scanner input = new Scanner(System.in);	
	
	// System prompts user to create an Avatar object
	System.out.print("What is your name?: ");
	String name = emptyString(input.nextLine(), input);
	System.out.print("How old are you?: ");
	int age = numInput(emptyString(input.nextLine(), input), input);
	System.out.print("What is the color of your hair?: ");
	String hair = emptyString(input.nextLine(), input);
	System.out.print("What is your height? (i.e. 5'6\"): ");
	String height = emptyString(input.nextLine(), input);
	System.out.print("What is your body type? (slim, muscular, big, etc.): ");
	String body = emptyString(input.nextLine(), input);
	
	// Scanner object closes
	input.close();
	
	// New Avatar is created
	ArrayList<Avatar> objJava = new ArrayList<Avatar>();
	objJava.add(new Avatar(name, age, hair, height, body));
	
	// Display Java object
	System.out.print("\n---- Java Object ----\n");
	for(Avatar part : objJava) {
		System.out.println(part);
	}
	
	// Java object is converted and stored in JSON format
	Java2JSON(objJava);
	
	// JSON object is converted into a new Java object
	ArrayList<Avatar> newJavaObject = JSON2Java("JSON_Test.json");
	
	// Displays new Java object after conversion
	System.out.print("\n---- JSON --> Java ----\n");
	for(Avatar part : newJavaObject) {
		System.out.println(part);
	}

	}
	
	
	/* Method that takes the Java object and converts it into JSON
 	*  @param object
 	*/
	public static void Java2JSON(ArrayList<Avatar> object ) {
		
		// Creates new JSON object
		JSONObject objJSON = new JSONObject();
		
		objJSON.put("name", object.get(0).getName());
		objJSON.put("age", object.get(0).getAge());
		objJSON.put("hair color", object.get(0).getHairColor());
		objJSON.put("height", object.get(0).getHeight());
		objJSON.put("body type", object.get(0).getBodyType());
		
		// Creates new JSON file to store JSON object
		try(FileWriter file = new FileWriter("JSON_Test.json")){
			file.write(objJSON.toString());
			file.flush();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		// Displays JSON object
		System.out.print("\n---- Java --> JSON ----\n");
		System.out.println(objJSON);
	}
	
	
	/* Method that takes the JSON file with stored object and 
	 * converts it into a new Java object
 	 * @param fileName
 	*/
	public static ArrayList<Avatar> JSON2Java(String fileName){
		
		// Creates new JSON parser and Java object
		JSONParser parser = new JSONParser();
		ArrayList<Avatar> newObject = new ArrayList<Avatar>();
		
		// Extracts JSON object's content to create new Java object
		try {
			Object fileObject = parser.parse(new FileReader(fileName));
			JSONObject jsonObject = (JSONObject) fileObject;
			String name = (String) jsonObject.get("name");
			int age = (int) (long) jsonObject.get("age");
			String hair = (String) jsonObject.get("hair color");
			String height = (String) jsonObject.get("height");
			String body = (String) jsonObject.get("body type");
			
			newObject.add(new Avatar(name, age, hair, height, body));
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// Returns new Java object
		return newObject;
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
		
		// return valid input
		return input;
	}
	
	
	/* Method that makes sure input is an integer
 	*  @param input, tryAgain
 	*/
	public static int numInput(String input, Scanner tryAgain) {
		
		// Initial integer variable
		int convert2Num = 0;
		
		// While loop that makes certain user input can be parsed into an integer
		while (!input.isEmpty()) {
			try {
				convert2Num = Integer.parseInt(input);
				break;
			}
		
			catch (NumberFormatException ex) {
				System.err.print("Invalid entry.  Please enter a number: ");
				input = emptyString(tryAgain.nextLine(), tryAgain);
			}
		}
		
		// Returns valid integer
		return convert2Num;
	}
}
