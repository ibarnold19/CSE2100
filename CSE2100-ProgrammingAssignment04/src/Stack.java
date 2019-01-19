/* Bryan Arnold
 * CSE 2100
 * Programming Assignment 4
 * 10/16/16
 */

public interface Stack<E> { //start interface
	
	/* Interface Stack<E>
	 * Purpose: this interface is used to allow any type
	 * of stack implementation to be used later on. It includes 
	 * the essential and helpful methods that every stack implemented 
	 * class will need/want. The type E is used to allow for
	 * an data type to be used in the stack implementation, not just
	 * array or linked list based. The top() method was not put in
	 * due to the fact it is not worth implementing due to not being
	 * necessary, and not too helpful in postfix notation.
	 */

	int size(); //size of stack
	
	boolean isEmpty(); //empty or not stack
	
	void push(E e); //add something to the stack
	
	E pop(); //take something off the stack
	
} //end interface
