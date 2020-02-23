/**
 * Basic JUnit exercise that incorporates and 
 * tests all of the assert methods.
 * @author Benjamin Porter
 */

package porter.junit;

import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class BasicJUnit {
	
	// Main method
	public static void main(String[] args) {
		
		// Fail counter
		int failCount = 0;
		
		// Run test methods in the test class
		Result results = JUnitCore.runClasses(AssertTests.class);
		
		// Records any tests that fail
		for(Failure failure : results.getFailures()) {
			failCount++;
			System.out.println(failure.toString()+ "\n");
		}

		// Display success message
		if(results.wasSuccessful()) {
			System.out.println("All tests passed successfully!!");
		}
		
		// Display fail message
		else if(failCount == 1) {
			System.out.println("\n" + failCount + " test has failed.");
		}
		else {
			System.out.println("\n" + failCount + " tests have failed.");
		}
	}
}
