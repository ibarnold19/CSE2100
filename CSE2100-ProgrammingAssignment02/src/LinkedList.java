/*Bryan Arnold
 * CSE 2100
 * Programming Assignment 2
 * 9/23/16
 * LinkedList Class
 */

/* LinkedList<Long> Class
 * Purpose: the purpose of this
 * class is to create a LinkedList
 * object that holds Nodes of certain
 * element values. This LinkedList for
 * this particular assignment is used to store
 * the squares of all the digits of the number in question
 * in a Node, then compares all the nodes to check if the number
 * is happy or not. Basically, this class holds the calculated
 * values of each step of the number process of finding if the
 * number is happy or not. This class
 * will also create method of adding to the list of values,
 * get the values of certain nodes, etc. The LinkedList is denoted to type
 * Long to hold bigger numbers in the future. Parts of this class
 * were taken from the textbook, with permission, but altered slightly
 * to my preferences.
 */
@SuppressWarnings("hiding")
public class LinkedList<Long>{ //begin class
	
	/*Node<Long> Class
	 * Purpose: this class is embedded in the LinkedList
	 * class as private because of how closely linked this is
	 * to the LinkedList class. This class is responsible for the creation of each Node that
	 * will be put into the LinkedList. The Node class is responsible for the creation
	 * of how the Node will function, as well as accessing and setting the values
	 * in the node. Set to Long type for bigger numbers. Parts of this class
	 * were taken from the textbook, with permission, but altered slightly to my
	 * preferences.
	 */
	private static class Node<Long>{ //begin node class

		private Long element; //the element in the specific node
		private Node<Long> next; //a pointer to the next node

		/* Node Constructor
		 * Purpose: to create a node to store a value and
		 * point to another node, thus creating the innards of 
		 * a linked list. 
		 * Parameters: Long e, Node<Long> n
		 * A node needs an element to be contained within itself as well
		 * as a pointer to another node to be considered a snode. The following
		 * are initialized in this Node constructor.
		 */
		public Node(Long e, Node<Long> n){

			element = e;
			next = n;

		} //end constructor

		/*getElement Method
		 * Purpose: to access the element that is contained
		 * in the current Node in question. Will be used later on
		 * to compare the elements of each node in the linked list to
		 * determine whether or not the number in question is happy or not.
		 * Returns: Long element
		 * Returns a Long element, aka the value in the node.
		 */
		public Long getElement(){

			return element;

		} //end method

		/*getNext Method
		 * Purpose: to access the node that is next in
		 * the linked list. This just allows for easy access to the next node
		 * after the one in question.
		 * Returns: Node<Long> next
		 * Returns the next node in the linked list chain after the one
		 * that is currenctly being looked at.
		 */
		@SuppressWarnings("unused")
		public Node<Long> getNext() {

			return next;

		} //end method

		/*setNext Method
		 * Purpose: sets the value of null that is next in
		 * the linked list chain to a new Node. This allows for
		 * the continuation of the linked list chain and additions onto
		 * the linked list chain later on.
		 * Parameters: Node<Long> newest
		 * Requires the newest Node in the chain to be able to set it's 
		 * pointer to what will be the next node, or null.
		 */
		public void setNext(Node<Long> newest){

			next = newest;

		} //end method

	} //end Node class

	private Node<Long> head = null; //a beginning Node to start to linked list
	private Node<Long> tail = null; //an end node to end the linked list
	private int size = 0; //linked list has no initial size

	public LinkedList(){} //default constructor, nothing needed to create linked list
	
	/*goToNode Method
	 * Purpose: this method takes a desired number and locates that specific node
	 * in the linked list chain. This is used to make finding the element value
	 * of the node easier later on. 
	 * Parameters: int index
	 * An index of the desired node must be stated in order to find said node
	 * Returns: node at desired index
	 */
	public Node<Long> goToNode(int index) {
		
		Node<Long> current = head;
		
		for (int i = 0; i < index; i++) {
			
			current = current.next;
			
		}
		
		return current;
		
	} //end method
	
	/*get Method
	 * Purpose: to get the element in the specified node
	 * index for use in determining whether or not the number is happy.
	 * Parameters: int index, index needed to find node element
	 * Returns: Long, the value of the element in the node.
	 */
	public Long get(int index) {
		
		Node<Long> current = goToNode(index);
		
		return current.getElement();
		
	} //end method
	
	/*getSize()
	 * Purpose: gets the size of the linked list. 
	 * Returns: int value of the size of the linekd list.
	 */
	public int getSize(){

		return this.size;

	} //end method

	/*isEmpty Method
	 * Purpose: to tell whether or not the linked list in
	 * question has no nodes in it or not.
	 * Returns: 0, if the linked list is empty.
	 */
	public boolean isEmpty(){

		return size == 0;

	} //end method


	/*addFirst Method
	 * Purpose: adds a node onto the head end of
	 * the linked list. Used to add nodes that are created with 
	 * calculated values later on.
	 * Parameters: Long result, the element to go in the node
	 * Returns: nothing
	 */
	public void addFirst(Long result){

		head = new Node<>(result, head);

		if(size == 0){

			tail = head;
			
			size++;

		}

	} //end method

	/*addLast Method
	 * Purpose: to add a ndoe onto the tail part of the 
	 * linked list. Used to add nodes to linked list for
	 * comparison later on.
	 * Parameters: Long e, element to go into node into place
	 * Returns: nothing
	 */
	public void addLast(Long e){

		Node<Long> newest = new Node<>(e, null);

		if(isEmpty() == true){

			head = newest;

		} else {

			tail.setNext(newest);


		}

		tail = newest;
		size++;	

	} //end method

} //end class




