/**
 * Basic class that tests the connection to database
 * and verifies proper configurations in xml file
 * @author Benjamin Porter
 */

package porter.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		// JBDC connection settings
		String jdbcUrl = "jdbc:mysql://localhost/eclipse?useSS=false";
		String user = "root";
		String password = "jatmbk8633";
		
		// Tries to connect to database
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection connect = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection successful!!!!");
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}

}
