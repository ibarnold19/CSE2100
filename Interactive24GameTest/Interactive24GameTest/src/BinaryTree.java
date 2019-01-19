/* Bryan Arnold
 * Assignment 5
 * CSE 2100
 * 10/30/16
 */

/* BinaryTree<E> Interface
 * Purpose: this interface will limit a tree to be a binary
 * tree, meaning that each parent node cannot have more than two
 * children. It will also put certain implementations of finding certain position in 
 * relation to the parent/children in place for later use.
 */

public interface BinaryTree<E> extends Tree<E> { //start interface, extends/utilizes the Tree<E> interface

	Position<E> left(Position<E> p) throws IllegalArgumentException; //left() Method. This method will find the node that is left in relation to a specified node's position on the tree. Will return exception if not a valid position.
	
	Position<E> right(Position<E> p) throws IllegalArgumentException; //right() Method. This method will find the node that is right in relation to a specified node's position on the tree. Will return exception if not a valid position.
	
	Position<E> sibling(Position<E> p) throws IllegalArgumentException; //sibling() Method. This method checks whether or not a specified node has a sibling, or there is an opposite  child sharing a parent in the tree. Returns exception if the position is not valid.
	
	
} //end interface
