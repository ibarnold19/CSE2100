import java.util.Iterator; //import for interface

/* Bryan Arnold
 * Assignment 5
 * CSE 2100
 * 10/30/16
 */

/* Tree<E> Interface
 * Purpose: this interface allows for the creation
 * of nodes to be put at certain positions, whilst 
 * allowing for them to have an arbitrary number of
 * children. This interface will later be used, the methods, 
 * for more specific types of tree implementations.
 */

public interface Tree<E> extends Iterable<E> { //start interface, needs the Iterable<E> class for some methods

	Position<E> root(); //Root Method. Purpose: this simply returns the root node of the entire tree, the position. Returns: element/position of the root node. Parameters: none.
	Position<E> parent(Position<E> p) throws IllegalArgumentException; //parent() Method. This method makes a specified position a parent node in the tree.
	Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException; //children() Method. This method makes a specified position a child node of the tree.
	
	int numChildren(Position<E> p) throws IllegalArgumentException; //numChildren() Method. This method gets the total number of children currently in the tree, returns an exception if the position is not valid.
	boolean isInternal(Position<E> p) throws IllegalArgumentException; //isInternal() Method. This method checks whether or not the current position/node is internal or not (aka a parent or not).
	boolean isExternal(Position<E> p) throws IllegalArgumentException; //isExternal() Method. This method checks whether or not the current position/node is external or not (aka a child node or not).
	int size(); //size of the tree, total elements/positions
	boolean isEmpty(); //checks if nothing is in the tree
	Iterator<E> iterator(); //iterator for iteration later on
	Iterable<Position<E>> positions(); //Gets the position returns of certain
	
	
	
} //end interface
