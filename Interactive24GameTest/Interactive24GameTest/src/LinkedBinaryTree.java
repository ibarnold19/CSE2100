import java.util.Iterator;
import java.util.Stack; //imported for later implementation


/* Bryan Arnold
 * Assignment 5
 * CSE 2100
 * 10/30/16
 */

/* LinkedBinaryTree<E> Class
 * Purpose: this class fully embodies the implementation of a singly
 * linked list into a binary tree format. This class is responsible for having the methods of creating
 * nodes that will represent the parents and children of the tree, as well as operations to add,
 * remove, etc. nodes from the tree.
 */

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> { //start class
	
	/* Node<E> Class
	 * Purpose: this protected method that is embedded in the
	 * LinkedBinaryTree<E> class is used in the creation and instance
	 * variables for a node, which is a parent or child in the tree. The reason
	 * it's encapsulation is only protected, is to prevent any other method from
	 * altering the state of each node, but allows or the tree class to be able
	 * to gain the Node<E> class attributes.
	 */
	
	protected static class Node<E> implements Position<E>{ //start inner class
		
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;

		/* Node Constructor
		 * Purpose: this constructor creates Node<E> objects that can 
		 * be placed at any point of a tree. They contain an element of any 
		 * type, the corresponding children or parents of a node if applicable.
		 * Parameters: an element, two nodes for children, and the parent node 
		 * are needed to create a node.
		 */
		
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){ //start constructor
			
			element = e; //element in position
			parent = above; // parent
			left = leftChild; //left child
			right = rightChild; //right child
			
		} //end constructor
		
		public E getElement() { return element;} //simple getter for the element in the node.
		public Node<E> getParent() { return parent; } //simple getter for the parent of a node.
		public Node<E> getLeft() { return left; } //simple getter for the left child of a parent node.
		public Node<E> getRight() { return right; } //simple getter for the right child of a parent node.
		
		public void setElement(E e) { element = e; } //simple setter for the element contained in the node, to alter it.
		public void setParent(Node<E> parentNode) { parent = parentNode; } //simple setter for the parent node of a tree, alters the node entirely.
		public void setLeft(Node<E> leftChild) { left = leftChild; } //simple setter for the left child of a parent node, alters the node entirely.
		public void setRight(Node<E> rightChild) { right = rightChild; } //simple setter for the right child of a parent node, alters the node entirely.
		
	} //end class
	
	/* createNode() Method
	 * Purpose: this method is responsible for the creation of nodes of a tree,
	 * but used within the LinkedBinaryTree class, as it is protected in Node<E>.
	 * It simply calls to the Node<E> constructor in the embedded class to make
	 * a new node and place it in the tree.
	 * Returns: a newly created node for the tree.
	 * Parameters: the same parameters for this method are shared with the
	 * constructor in the Node<E> class for the same reasons.
	 */
	
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){ //start method
		
		return new Node<E>(e, parent, left, right);
		
	} //end method
	
	protected Node<E> root = null; //the root node, the highest parent of a tree, instance variable
	private int size = 0; //default tree size is 0
	
	public LinkedBinaryTree(){} //default constructor
	
	/* validate() Method
	 * Purpose:this method checks whether or not a node has been placed in a
	 * position that is valid. It cannot be placed in a place where there is
	 * already a node, or if the node in question isn't in the tree to
	 * begin with.
	 * Returns: the node that was being validated whether or not it's position was
	 * valid.
	 * Parameters: The position is the only aspect of the node in question for
	 * this method, so only a position is required to validate this node's position.
	 */
	
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException { //start method
		
		if(!(p instanceof Node)){ //check for good position
			
			throw new IllegalArgumentException("Not valid position type");
			
		} //end if
		
		Node<E> node = (Node<E>) p; //copy of the old node, casted from a positions
		
		if(node.getParent() == node){ //checks if the position is in the actual tree
			
			throw new IllegalArgumentException("p is no longer in the tree");
			
		} //end if
		
		return node;
		
	} //end method

	/* left() Method
	 * Purpose: this method just gets the node's position that is to the
	 * left of a position of another certain node. First, it validates the 
	 * given position to make clear that it is indeed in the tree, then simply gets the
	 * instance variable assigned at creation of the left node of the desired position.
	 * Returns: the position of the node that is the left child.
	 * Parameters: a position of a node must be given to find the left child of this node.
	 */
	
	public Position<E> left(Position<E> p) throws IllegalArgumentException { //start method
		
		Node<E> node = validate(p); //checks proper position
		
		return node.getLeft(); //gets left child position
		
	} //end method


	/* right() Method
	 * Purpose: this method gets the node's position that is to the right of
	 * a position of another certain node. First, it validates the given position
	 * to make clear that it is indeed in the tree, then simply gets the instance 
	 * variable assignment at creation of the right node of the desired position.
	 * Returns: the position of the node that is the right child.
	 * Parameters: a position of a node must be given to find the right child of this node.
	 */
	
	public Position<E> right(Position<E> p) throws IllegalArgumentException { //start method
	
		Node<E> node = validate(p); //Validates position
		
		return node.getRight(); //gets right child
		
	} //end method

	
	/* root() method
	 * Purpose: this method simply finds the root node position of the
	 * entire tree. The root node is the highest parent in the tree, where all
	 * the other nodes stem from.
	 * Returns: position of the root node
	 * Parameters: none
	 */
	
	public Position<E> root() { //start method
		
		return root;
		
	} //end method

	/* parent() Method
	 * Purpose: this method gets the parents, if it exists, of a given node
	 * in a certain position. This parent node position is simply found using a
	 * getter from the embedded class.
	 * Returns: position of a parent node of another node
	 * Parameters: the position of the node in question.
	 */
	
	public Position<E> parent(Position<E> p) throws IllegalArgumentException { //start method
		
		Node<E> node = validate(p); //validates node
		
		return node.getParent(); //gets the node's parent
		
	} //end method

	/* size() Method
	 * Purpose: this method simply gets the overall
	 * size of the tree. Each node increases the size
	 * by 1.
	 * Returns: an integer of the total number of nodes in the tree.
	 * Parameters: none.
	 */
	
	public int size() { //start method
	
		return size; 
		
	} //end method
	
	/* addRoot() Method
	 * Purpose: this method adds a root node to a new tree. This root
	 * node is the highest parent of the tree and it lays the foundation for 
	 * the rest of the tree to be built.
	 * Returns: the position of the new root node.
	 * Parameters: an element that is being put into the root node is needed to not just
	 * create the root node, but all nodes.
	 */
	
	public Position<E> addRoot(E e) throws IllegalStateException{ //start method
		
		if(!isEmpty()){ //checks if tree isn't empty, meaning there's already another root
			
			throw new IllegalStateException("Tree is not empty");
			
		} //end if
		
		root = createNode(e, null, null, null); //instance variable of root assigned/created
		size = 1; //size increased
		
		return root; //root position
		
	} //end method
	
	/* addLeft() Method
	 * Purpose: this method creates a left child of the given node position. This child
	 * is then created, giving it an element to hold, and a relative position assignment to
	 * other nearby nodes.
	 * Returns: the position/new node of a new left child in the tree of the desired node.
	 * Parameters: an element to be contained in the new node and the position of the desired
	 * parent node are needed to put it in the correct position.
	 */
	
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{ //start method
		
		Node<E> parent = validate(p); //validates the position
		
		if(parent.getLeft() != null){ //checks for left child already, can't have more than 1
			
			throw new IllegalArgumentException("p is already has a left child");
			
		} //end if
		
		Node<E> child = createNode(e, parent, null, null); //new node created
		parent.setLeft(child); //put into position of parent
		size++; //size increased
		
		return child; //child's new position  
		
	} //end method
	
	/* addRight() Method
	 * Purpose: this method creates a right child of the given node position. This child
	 * is then created, giving it an element to hold, and a relative position assignment to
	 * other nearby nodes.
	 * Returns: the position/new node of a new left child in the tree of the desired node.
	 * Parameters: an element to be contained in the new node and the position of the desired
	 * parent node are needed to put it in the correct position.
	 */
	
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException { //start method
		
		Node<E> parent = validate(p); //validates position
		
		if(parent.getRight() != null){ //if a right child already exists
			
			throw new IllegalArgumentException("p already has a right child");
			
		} //end if
		
		Node<E> child = createNode(e, parent, null, null); //new child created as the right child
		parent.setRight(child); //sets position
		size++; //increase size
		
		return child; //return new child
		
	} //end method
	
	/* set() Method
	 * Purpose: this method takes the element stored in a certain
	 * position/node and returns the old element that was stored there
	 * that is no longer stored there.
	 * Returns: old element of the node/position
	 * Parameters: a position and the element to replace the old element
	 * are needed.
	 */
	
	public E set(Position<E> p, E e) throws IllegalArgumentException { //start method
		
		Node<E> node = validate(p); //validates position
		E temp = node.getElement(); //store old to return later
		node.setElement(e); //old element replaced with new one
		
		return temp; //return old element
		
	} //end method
	
	/* attach() Method
	 * Purpose: this method takes two different binary tree objects, already with or without
	 * nodes stored in them, and attaches them together by one specified position/node.
	 * Returns: nothing, the trees just become one bigger one.
	 * Parameters: the two binary trees being attached are needed as well as the node/position
	 * to attach them at.
	 */
	
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException { //start method
		
		Node<E> node = validate(p); //validates position
		
		if(isInternal(p)){ //only attachable from leaves
			
			throw new IllegalArgumentException("p must be a leaf");
			
		} //end if
		
		size += t1.size + t2.size; //size of tree combined into one
		
		if(!t1.isEmpty()){ //checks if tree is empty
			
			t1.root.setParent(node); //root is now a parent
			node.setLeft(t1.root); //root moved left
			t1.root = null; //root no value
			t1.size = 0; 
			
		} //end if
		
		if(!t2.isEmpty()){ //checks if tree is empty
			
			t2.root.setParent(node); //root is now a parent
			node.setRight(t1.root); //root moved right
			t2.root = null; //root no value
			t2.size = 0;
			
		} //end if
		
	} //end method
	
	/* remove() Method
	 * Purpose: this method takes a node an entirely removes it
	 * from the tree. Then, it takes the remaining tree node
	 * values and rebalances the tree back into a binary tree.
	 * Returns: the element of the removed node.
	 * Parameters: the position of the node to remove.
	 */
	
	public E remove(Position<E> p) throws IllegalArgumentException { //start method
		
		Node<E> node = validate(p); //validates position
		
		if(numChildren(p) == 2){ //can't remove parents
			
			throw new IllegalArgumentException("p has two children");
			
		} //end if
		
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		
		if(child != null){ 
			
			child.setParent(node.getParent());
			
		} //end if
		
		if(node == root){
			
			root = child;
			
		} else {
			
			Node<E> parent = node.getParent();
			
			if(node == parent.getLeft()){
				
				parent.setLeft(child);
				
			} else {
				
				parent.setRight(child);
				
			} //end else if chain
			
		} //end else if chain
		
		size--; //decrease tree size
		E temp = node.getElement(); //take element of removed node
		node.setElement(null); 
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		
		return temp;
		
	} //end method


	//Not needed for the purposes of this project, but needed for proper implementation/extension
	public Iterator<E> iterator() {

		return null; 
		
	} //end method

	//Not needed for the purposes of this project, but needed for proper implmentation/extension
	public Iterable<Position<E>> positions() {

		return null;
		
	} //end method
	
} //end class
