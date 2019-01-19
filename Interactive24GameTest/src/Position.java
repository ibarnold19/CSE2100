/* Bryan Arnold
 * Assignment 5
 * CSE 2100
 * 10/30/16
 */

/* Position<E> Interface
 * Purpose: This interface is to be used by an type of tree,
 * in my case a linked binary tree, to keep track of the elements in certain
 * positions in the tree. This interface can also be utilized by any type of
 * iterator class.
 */

public interface Position<E> { //begin interface

	/*getElement() Method
	 * Purpose: gets the element stored in the specific
	 * position in the iterator or tree. This will simply return
	 * some sort of element that the tree or iterator contains.
	 * Returns: an element E, so some sort of return type that
	 * is contained in a position. Will return a legal state
	 * exception if the element in the position is not valid.
	 * Parameters: none
	 */
	
	E getElement() throws IllegalStateException;
	
}//end interface
