/**
 * Basic class that demonstrates the connection 
 * and use of a separate database using hibernate
 * @author Benjamin Porter
 */

package porter.hibernate;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BasicHibernate {

	// Main method
	public static void main(String[] args) {
		
		// Create Scanner object and linked list of new entries
		Scanner scan = new Scanner(System.in);
		List<Kennel> newEntries = new LinkedList<Kennel>();
		
		// Create session to designated database table
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Kennel.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// Trigger variable for while loop
			int act = -1;
			
			// While loop that creates new objects
			while(act != 0) {
				// Create new object entries
				System.out.println("\n\nAdding new entry....\n");
				newEntries.add(entry(scan));
				
				System.out.println("\nNew animal has been entered.");
				
				int choice = -1;
				
				// While loop that ensures accurate input answering whether 
				// user wants to add another entry to the list
				while (choice != 0) {
					
					System.out.print("\nWould you like to add another entry? (Y/N): ");
					String cont = scan.nextLine().toUpperCase();
					if(cont.contentEquals("Y") || cont.contentEquals("YES")) {
						
						choice = 0;
					}
					else if(cont.contentEquals("N") || cont.contentEquals("NO")) {
						
						act = 0;
						choice = 0;
					}
					else {
						
						System.err.println("\nInvalid response. Please try again.");
					}		
				}
			}
			
			// Start Transaction
			session.beginTransaction();
			
			// Save the new entries to database table
			System.out.println("Saving new object(s)....");
			for (Kennel animal : newEntries) {
				
				session.save(animal);
			}
			
			// Commit the transaction
			session.getTransaction().commit();
		}
		
		// Close session and program
		finally{
			
			factory.close();
			scan.close();
			System.out.println("Finished!");
		}

	}
	
	/**
	 * Method that creates new entry object
	 * @param scan
	 * @return Kennel object
	 */
	public static Kennel entry(Scanner scan) {
		
		// Object's name
		System.out.print("Enter the animal's name: ");
		String name = scan.nextLine();
		
		// Object's type of breed
		System.out.print("\nEnter the type of animal breed: ");
		String breed = scan.nextLine();
		
		// Object's isLicensed boolean
		Boolean isLicensed = false;
		int choice = -1;
		
		// While loop that ensures valid boolean response
		while (choice != 0) {
			
			System.out.print("\nIs the animal licensed? (True/False): ");
			String licensed = scan.nextLine().toUpperCase();
			if(licensed.contentEquals("T") || licensed.contentEquals("TRUE")) {
				
				isLicensed = true;
				choice = 0;
			}
			else if(licensed.contentEquals("F") || licensed.contentEquals("FALSE")) {
				
				choice = 0;
			}
			else {
				
				System.err.println("\nInvalid response. Please try again.");
			}		
		}
		
		// Return newly created object
		return new Kennel(name, breed, isLicensed);
	}

}
