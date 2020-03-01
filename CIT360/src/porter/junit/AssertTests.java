/**
 * Basic JUnit class that stores and 
 * tests all of the assert methods.
 * @author Benjamin Porter
 */

package porter.junit;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertTests {
	
	// Testing variables
	String[] array1 = {"uno", "dos", "tres"};
	String[] array2 = {"one", "two", "three"};
	String none = null;
	String str1 = "pass";
	String str2 = "pass";
	int val1 = 8;
	int val2 = 8;
	
	// Method that tests for matching arrays
	@Test
	public void testAssertArrayEquals() {
		assertArrayEquals("assertArrayEquals test failed. Arrays don't match.\n",array1, array1);
	}
	
	// Method that tests for equal values between two objects
	@Test
	public void testAssertEquals() {
		assertEquals("assertEquals test failed. Objects are not equal to each other.\n", str1, str2);
	}
	
	// Method that tests for false conditions. Fails if condition is true.
	@Test
	public void testAssertFalse() {
		assertFalse("assertFalse test failed. Condition is true, not false.\n", val1 < val2);
	}
	
	// Method that tests if object in question is not null	
	@Test
	public void testAssertNotNull() {
		assertNotNull("assertNotNull test failed. Object is null.\n", str1);
	}
	
	// Method that tests if both objects are not the same
	@Test
	public void testAssertNotSame() {
		assertNotSame("assertNotSame test failed. Objects are the same.\n",str2, none);
	}	
	
	// Method that tests if object in question is null
	@Test
	public void testAssertNull() {
		assertNull("assertNull test failed. Object is not null.\n", str1);
	}	
	
	// Method that tests if both objects are the same
	@Test
	public void testAssertSame() {
		assertSame("assertSame test failed. Objects are not the same.\n", val1, val2);
	}
	
	// Method that tests objects using hamcrest matchers	
	@Test
	public void testAssertThat() {
		assertThat("assertThat test failed. Specified conditions are false.\n", val1, is(any(Integer.class)));
	}	
	
	// Method that tests for true conditions. Fails if condition is false.
	@Test
	public void testAssertTrue() {
		assertTrue("assertTrue test failed. Condition is false, not true.\n", val1 > val2);
	}		
}
