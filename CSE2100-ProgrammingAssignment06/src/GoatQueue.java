/* Bryan Arnold
 * Assignment 6
 * CSE 2100
 * 11/13/16
 */

@SuppressWarnings("hiding")
public class GoatQueue<GoatPriority, Goat> extends HeapAdaptablePriorityQueue<GoatPriority, Goat> {
	
	/* GoatQueue Class
	 * This class is responsible for creating a queue
	 * with centering around goats. Uses the HeapAdaptablePriorityQueue
	 * class to perform functions centering around goats.
	 * CLASS NOT USED DUE TO NOT BEING FINISHED
	 */
	
	private int size; //size of queue
	
	public GoatQueue() { //default constructor
		
		this.size = super.size(); //size of queue
		
	} //end constructor
	
	/* This constructor will implement its own
	 * comparator to compare the goats correctly.
	 */
	public GoatQueue(GoatComparator comp){
		
		
	} //end constructor
	
	/* remove Method
	 * This class removes a goat from the queue
	 * that has run out of coins, or is going to
	 * the next bridge.
	 */
	public void remove(Goat g){
		
	} //end method
	
	public int getSize(){ //gets size of queue
		
		return size;
		
	} //end method
	
	public void setSize(int size){ //sets size of queue
		
		this.size = size;
		
	} //end method

} //end class