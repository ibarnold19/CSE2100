/* Bryan Arnold
 * Assignment 5
 * CSE 2100
 * 10/30/16
 */

/* AbstractTree<E> Class
 * Purpose: this class sets up all the necessary methods of a class 
 * that implements and uses trees. Since this class is abstract, other classes
 * can easily implement and use the methods in the way they are needed. 
 */
public abstract class AbstractTree<E> implements Tree<E> { //start class

	public boolean isInternal(Position<E> p) { return numChildren(p) > 0; } //isInternal() Method. This method determines whether or not the position/node is a parent node. Returns true or false, depending on if children is greater than 0.
	public boolean isExternal(Position<E> p) { return numChildren(p) == 0; } //isExternal() Method. This method determines whether or not the position/node is a child node. Returns true or false, depending on if the number of children is equal to 0 of the position.
	public boolean isRoot(Position<E> p) { return p == root(); } //isRoot() Method. This method simply finds the root node/parent of a tree given a position. Returns the root node position/element of the tree.
	public boolean isEmpty() { return size() == 0; } //isEmpty() Method. This method simply checks whether or not a tree is empty. Returns true or false, depending on what size method returns.
	
} //end class
