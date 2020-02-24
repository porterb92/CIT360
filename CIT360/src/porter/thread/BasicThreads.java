/**
 * Basic Thread class that executes runnables and 
 * runs a couple of other threads.
 * @author Benjamin Porter
 */

package porter.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicThreads {

	// Main method
	public static void main(String[] args) {
		
		// Creates new thread pool
		ExecutorService es = Executors.newFixedThreadPool(4);
		
		// Create SewingCircle object instances
		SewingCircle sew1 = new SewingCircle(11, "Sally", "bags", 7, 7);
		SewingCircle sew2 = new SewingCircle(22, "Susan", "gloves", 4, 4);
		SewingCircle sew3 = new SewingCircle(33, "Jennifer", "shoes", 8, 5);
		SewingCircle sew4 = new SewingCircle(44, "Mary", "hats", 7, 5);
		SewingCircle sew5 = new SewingCircle(55, "Steve", "socks", 5, 3);
		SewingCircle sew6 = new SewingCircle(66, "Craig", "pants", 10, 2);
		SewingCircle sew7 = new SewingCircle(77, "Janet", "shirts", 9, 1);

		// Create new threads with different SewingCircle instances
		Thread secondOrder1 = new Thread(new SewingCircle(88, "Janet", "shirts", 9, 1));
		Thread secondOrder2 = new Thread(new SewingCircle(99, "Craig", "pants", 10, 2));
		
		// Execution's start time
		long startTime = System.currentTimeMillis();
		System.out.println("----- Business Day Begins ------\n");
		
		// Execution Services is executed
		es.execute(sew1);
		es.execute(sew2);
		es.execute(sew3);
		es.execute(sew4);
		es.execute(sew5);
		es.execute(sew6);
		es.execute(sew7);
		secondOrder1.run();
		secondOrder2.run();
		
		// Execution Services shuts down
		es.shutdown();
		
		// While loop that checks if all executions are done
		while (es.isTerminated() == false) {
			
		}
		
		// Execution's end time
		long endTime = System.currentTimeMillis();
		double totalTime = (double) (endTime - startTime) / 4000;
		
		// Final message with total runtime (1 hour = 4000 ms)
		System.out.println("------ Business Day Over. Total time: " 
				+ String.format("%,.1f", totalTime) +" hours ------");		
	}
}
