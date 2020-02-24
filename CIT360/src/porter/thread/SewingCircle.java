/**
 * Basic object class that implements Runnable class
 * for multi-thread demonstration.
 * @author Benjamin Porter
 */

package porter.thread;

public class SewingCircle implements Runnable {

	private int order;
	private String name;
	private String clothing;
	private int num;
	private int halt;
	private int random;
	
	// Object constructor method
	public SewingCircle(int order, String name, String clothing, int num, int halt) {
		
		this.order = order;
		this.name = name;
		this.clothing = clothing;
		this.num = num;
		this.halt = halt;
		
		random = (int) (Math.random() * 100 + 4) / 2;
	}
	
	// Runnable's run method
	public void run() {
		
		// Initial Run Message
		System.out.println("Executing Order " + order + ": " + name + " needs to sew " 
				+ random + " " + clothing + ".\n(sews/needle = " + num +", Time "
				+ "to replace needle = " + halt + " minutes)\n\n");
		
		// For loop based on random number
		for(int i = 1; i <= random; i++) {
			if(i % num == 0) {
				
				// Object thread sleeps
				System.out.println(name + "'s needle broke.");
				try {
					Thread.sleep(halt * 1000);
				}
				catch(InterruptedException e){
					System.err.println(e.toString());
				}
			}
		}
		// Message when run is complete
		System.out.println("\n" + name + " has finished!\n");
	}
}
