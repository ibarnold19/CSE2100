/* Bryan Arnold
 * Assignment 6
 * CSE 2100
 * 11/13/16
 */

import java.util.Comparator; //import for use

public class GoatComparator implements Comparator<GoatPriority>{
	
	/* GoatComparator Class
	 * This class utilizes the comparator class in
	 * java and uses it to compare two goatpriorities.
	 * Comparator cannot compare two objects, so this is
	 * used instead. 
	 * CLASS NOT USED DUE TO NOT BEING FINISHED
	 */

	/* compare Method
	 * This method compares the wait time
	 * of two goats' priorities and returns
	 * 1, -1, or 0, corresponding to if the first
	 * priority is bigger, smaller, or the priorities
	 * are the same.
	 */
	@SuppressWarnings("unchecked")
	public int compare(GoatPriority a, GoatPriority b) throws ClassCastException {
		
	return ((Comparable<GoatPriority>) a).compareTo(b);
		
	} //end method
	
	/* priority Method
	 * This is just a integer representation
	 * of a priority, aka its wait time.
	 */
	public int priority(GoatPriority goatPriority){
		
		return goatPriority.getWaitTime();
		
	} //end method
	
} //end class
