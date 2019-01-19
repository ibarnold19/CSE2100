/* Bryan Arnold
 * CSE 2100
 * Extra Credit Assignment
 * 12/9/16
 */

/* LinkedList Class
 * Purpose: the purpose of this
 * class is to create a LinkedList
 * object that holds Nodes of certain
 * element values. This LinkedList for
 * this particular assignment holds unique letters
 *  in the sequence being evaluated to solve the puzzle. This class
 * will also create method of adding to the list of values,
 * get the values of certain nodes, etc.
 */

public class LinkedList { //begin class

	/* Node Class
	 * Purpose: this class is embedded in the LinkedList
	 * class as private because of how closely linked this is
	 * to the LinkedList class. This class is responsible for the creation of each Node that
	 * will be put into the LinkedList. The Node class is responsible for the creation
	 * of how the Node will function, as well as accessing and setting the values
	 * in the node.
	 */

	private class Node { //begin class

		private String element; //String this node stores
		private Node next; //next node 

		/* Node Constructor
		 * Purpose: to create a node to store a value and
		 * point to another node, thus creating the innards of 
		 * a linked list. 
		 * Parameters: String element
		 * A node needs an element to be contained within itself as well
		 * as a pointer to another node to be considered a node. The node 
		 * doesn't initially have to point to anything, this can be done later.
		 */

		public Node(String element) { //start constructor

			this.element = element;

		} //end constructor

		/*getElement Method
		 * Purpose: to access the element that is contained
		 * in the current Node in question.
		 * Returns: String element
		 * Returns a String element, aka the value in the node.
		 */

		public String getElement() { //start method

			return element;

		} //end method

		/*getNext Method
		 * Purpose: to access the node that is next in
		 * the linked list. This just allows for easy access to the next node
		 * after the one in question.
		 * Returns: Node next
		 * Returns the next node in the linked list chain after the one
		 * that is currently being looked at.
		 */

		public Node getNext() { //start method

			return next;	

		} //end method

		/*setElement Method
		 * Purpose: sets the value of a node to a
		 * desired element.
		 * Parameters: String element
		 * Requires an element to be changed or put
		 * into the Node.
		 */

		@SuppressWarnings("unused") //annoying warnings
		public void setElement(String element) { //start method

			this.element = element;

		} //end method

		/*setNext Method
		 * Purpose: sets the value of null that is next in
		 * the linked list chain to a new Node. This allows for
		 * the continuation of the linked list chain and additions onto
		 * the linked list chain later on.
		 * Parameters: Node<String> newest
		 * Requires the newest Node in the chain to be able to set it's 
		 * pointer to what will be the next node, or null.
		 */

		public void setNext(Node next) { //start method

			this.next = next;

		} //end method

	} //end class

	private Node head; //beginning node to start the list
	private Node tail;	//end node to end the list
	private int size; //total size of the list

	/* LinkedList() Constructor
	 * Purpose: creates a linked list object that sets
	 * the beginning and end of the list to null to start out,
	 * as well as making the size 0.	
	 */
	public LinkedList(){ //start constructor

		this.head = null;
		this.tail = null;
		this.size = 0;

	} //end constructor

	/*addFirst Method
	 * Purpose: adds a node onto the head end of
	 * the linked list. Used to add nodes that are created with 
	 * different letters.
	 * Parameters: String s, the element to go in the node
	 * Returns: nothing
	 */
	public void addFirst(String s){ //start method

		Node next = new Node(s);

		if(this.getSize() == 0){ //start if

			this.tail = next;

		} //end if

		next.setNext(this.head);
		this.head = next;

		this.size++;

	} //end method

	/*addLast Method
	 * Purpose: to add a node onto the tail part of the 
	 * linked list. Used to add nodes to linked list for
	 * comparison later on.
	 * Parameters: String s, element to go into node into place
	 * Returns: nothing
	 */
	public void addLast(String s){

		Node next = new Node(s);

		if(this.getSize() == 0){ //start if

			addFirst(s);

		} else {

			next.setNext(null);
			this.tail.setNext(next);
			this.tail = next;

			this.size++;

		} //end if else chain

	} //end method

	/* removeFirst() Method
	 * Purpose: this method removes the node
	 * at the head of the linked list, so the first
	 * node. Doesn't return the node.
	 * Parameters: none
	 * Returns: none
	 */
	public void removeFirst(){ //start method

		if (this.getHead() == null){ //start if

			System.out.println("LinkedList is Empty");

		} else if(this.getHead() != null){

			Node head = this.head;
			this.head = this.head.getNext();
			head.setNext(null);

			size--;

		} //end if else chain

	} //end method

	/* getHead Method
	 * Purpose: gets the element that 
	 * is in the head node, or the first node,
	 * of the linked list.
	 * Parameters: none
	 * Returns: String element, the element in the node
	 */
	public String getHead(){ //start method

		return head.getElement();

	} //end method

	/* getTail Method
	 * Purpose: gets the element that 
	 * is in the tail node, or the last node,
	 * of the linked list.
	 * Parameters: none
	 * Returns: String element, the element in the node
	 */
	public String getTail(){ //start method

		return tail.getElement();

	} //end method

	/* getSize Method
	 * Purpose: gets the total amount
	 * of nodes that are in the linked list, 
	 * or the size of the linked list.
	 * Parameters: none
	 * Returns: int size, the size of the linked list
	 */
	public int getSize(){ //start method

		return size;

	} //end method

	/* isEmpty Method
	 * Purpose: determines whether or not
	 * the linked list has no nodes in it,
	 * or the linked list is empty.
	 * Parameters: none
	 * Returns: String element, the element in the node
	 */
	public boolean isEmpty(){ //start method

		return head == null;

	} //end method

	/* elementsToString() Method
	 * Purpose: this method takes a linked list
	 * and turns the elements of each node into one 
	 * String, so basically it combines the elements of 
	 * each node into one string for printing.
	 * Parameters: none
	 * Returns: String str, the new string of all
	 * the elements.
	 */
	public String elementsToString(){ //start method

		Node current = head;
		String str = "";

		while(current != null){ //start while

			str = str + String.valueOf(current.getElement());
			current = current.getNext();

		} //end while

		return str;

	} //end method

	/* displayElements() Method
	 * Purpose: this method prints out the elements
	 * of each node in the linked list.
	 * Parameters: none
	 * Returns: none
	 */
	public void displayElements(){ //start method

		Node current = head;

		while(current != null){ //start while

			System.out.println(current.getElement().toString());
			current = current.getNext();

		} //end while

	} //end method

} //end class