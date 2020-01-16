/**
 * Basic Collections exercise showcasing
 * the uniqueness of the collection types
 * using orders from a diner as an example.
 * @author Benjamin Porter
 */

package porter.collections;

import java.util.*;

public class BasicCollections {

	public static void main(String[] args) {
		
		/* 
		 * List type stores all added data 
		 *		in sequential order.
		*/
		System.out.println("--- List ---");
		List orderInList = new ArrayList();
		orderInList.add("Burger");
		orderInList.add("Steak");
		orderInList.add("Pancakes");
		orderInList.add("Salad");
		orderInList.add("Cola");
		orderInList.add("Burger");
		orderInList.add("Soup");
		orderInList.add("Cola");
		
		for(Object str : orderInList) {
			System.out.println((String) str);
		}
		
		/* 
		 * Set type stores all unique data, no duplicates.
		 * TreeSet is a sorted set.
		*/
		System.out.println("\n--- Set ---");
		Set orderInSet = new TreeSet();
		orderInSet.add("Burger");
		orderInSet.add("Steak");
		orderInSet.add("Pancakes");
		orderInSet.add("Salad");
		orderInSet.add("Cola");
		orderInSet.add("Burger");
		orderInSet.add("Soup");
		orderInSet.add("Cola");
				
		for(Object str : orderInSet) {
			System.out.println((String) str);
		}
		
		/* 
		 * Queue type stores and holds all data
		 *		until they are needed.
		 * PriorityQueue is the same as queue, 
		 *  	but also sorts the data alphabetically.
		*/
		System.out.println("\n--- Queue ---");
		Queue orderInQueue = new PriorityQueue();
		orderInQueue.add("Burger");
		orderInQueue.add("Steak");
		orderInQueue.add("Pancakes");
		orderInQueue.add("Salad");
		orderInQueue.add("Cola");
		orderInQueue.add("Burger");
		orderInQueue.add("Soup");
		orderInQueue.add("Cola");
		
		Iterator iterator = orderInQueue.iterator();
		while (iterator.hasNext()) {
			System.out.println(orderInQueue.poll());
		}
		
		/* 
		 * Deque type is a Queue that supports the 
		 * 		insertion and extraction of elements
		 * 		on both ends.
		*/
		System.out.println("\n--- Deque Last/First ---");
		Deque orderInDeque = new ArrayDeque();
		orderInDeque.add("Burger");
		orderInDeque.add("Steak");
		orderInDeque.add("Pancakes");
		orderInDeque.add("Salad");
		orderInDeque.add("Cola");
		orderInDeque.add("Burger");
		orderInDeque.add("Soup");
		orderInDeque.add("Cola");
		
		// Both ends are being extracted, starting with the last element.
		while (!orderInDeque.isEmpty()) {
			System.out.println(orderInDeque.pollLast());
			System.out.println(orderInDeque.pollFirst());
		}
		
		/*
		 * Map type stores unique value pairs.
		 * Any similar value pairs will be overwritten.
		 */
		System.out.println("\n--- Map ---");
		Map orderInMap = new HashMap();
		orderInMap.put(1,"Burger");
		orderInMap.put(2,"Steak");
		orderInMap.put(3,"Pancakes");
		orderInMap.put(4,"Salad");
		orderInMap.put(5,"Cola");
		orderInMap.put(6,"Burger");
		orderInMap.put(2,"Soup");
		orderInMap.put(3,"Cola");
		
		for (int i = 1; i < 7; i++) {
			String results = (String)orderInMap.get(i);
			System.out.println(results);
		}
		
		// Linked List using Generics
		System.out.println("\n--- Today's Orders ---");
		List<Orders> todays_orders = new LinkedList<Orders>();
		todays_orders.add(new Orders(1, "Steak, Eggs, Coffee"));
		todays_orders.add(new Orders(6, "Pancakes, Sausage, Cola"));
		todays_orders.add(new Orders(10, "Bacon, Eggs, Sausage, Water"));
		todays_orders.add(new Orders(5, "Steak, Potatoes, Cola"));
		todays_orders.add(new Orders(5, "Pancakes, Bacon, Shake"));
		todays_orders.add(new Orders(3, "Toast, Eggs, Water"));
		
		for(Orders orders : todays_orders) {
			System.out.println(orders);
		}
	}

}
