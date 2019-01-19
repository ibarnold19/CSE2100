/* Bryan Arnold
 * CSE 2100
 * Programming Assignment 4
 * 10/16/16
 */

public class ArrayStack<E> implements Stack<E>{ //start class

	/* Class ArrayStack<E>
	 * Purpose: this class is an array based 
	 * implementation of the Stack<E> interface. This
	 * class is responsible for creating the bodies
	 * of the methods from the Stack<E> interface in terms of the
	 * elements E being in arrays. E allows for any data type to be used
	 * in the array. This class has the same overall goals in its methods
	 * as previously stated in the interface, but in terms of arrays.
	 * Parts of this class were taken from the text, with permission,
	 * and slightly altered. The top() method was removed as it isn't
	 * worth implementing.
	 */

	private E[] data; //place to store data from stack
	private int t = -1; //top of the stack

	public ArrayStack(){} //default constructor

	/* ArrayStack(int size) Constructor
	 * Purpose: this constructor creates an ArrayStack object
	 * of the desired capacity of elements to be put inside of it.
	 * It sets the ArrayStack size to a definite value and it cannot be
	 * changed afterwards.
	 * Parameters: int size. A size of desired capacity is needed to
	 * create an array of elements that size.
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int size){

		data = (E[]) new Object[size];

	} //end constructor

	/* size() Method
	 * Purpose: this method returns the current size of the array.
	 * Since the top of the array is considered -1, 1 must always be added
	 * to indicate a size of 0. Not an essential method, but helpful in tracking
	 * stack size during postfix evaluations.
	 * Parameters: none.
	 * Returns: an int. This integer value is the current size of the stack,
	 * or how many elements are in it.
	 */
	@Override
	public int size() {

		return (t + 1);

	} //end method

	/* isEmpty() Method
	 * Purpose: this method checks whether or not the stack is empty/there are no
	 * elements currently in the stack. Since the default stack value is set at -1, 
	 * indicating there is no size/no elements in the stack, -1 will indicate an empty
	 * stack.
	 * Parameters: none.
	 * Returns: a boolean. The actual return value is -1, but this is equivalent to false,
	 * so the return is false, indicating an empty stack.
	 */

	@Override
	public boolean isEmpty() {

		return (t == -1);

	} //end method

	/* push(E e) Method
	 * Purpose: this method is responsible for adding new elements to the stack,
	 * as well as moving the position of previous elements in the stack up
	 * one position in the stack. It will also check if the stack is full, in which
	 * no further elements can be added. A new element added on top of an old in a stack
	 * will be popped back out first.
	 * Parameters: E e. This allows for any type of element to be added to the stack or pushed
	 * to the next spot of the stack.
	 * Returns: nothing, just alters stack.
	 */

	@Override
	public void push(E e) {

		if(size() == data.length){ //checks stack capacity

//			System.out.println("Stack is full");

		} else {

			data[++t] = e; //pushes and adds

		} //end if else chain

	} //end method

	/* pop() Method
	 * Purpose: this method removes the element most recently added
	 * to the stack as well as moves the rest of the elements in the 
	 * stack closer to the top of the stack. This allows for operations
	 * to be done on specific numbers in specific orders, postfix, later
	 * on.
	 * Parameters: none.
	 * Returns: answer E. This answer E is simply the element that is
	 * currently located at the top of the stack.
	 */

	@Override
	public E pop() {

		if(isEmpty()){ //check if stack empty

			return null;

		} else { //now proceed to pop

			E answer = data[t];
			data[t] = null;
			t--;

			return answer;

		} //end if else chain

	} //end method

} //end class
