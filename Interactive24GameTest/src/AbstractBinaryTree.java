import java.util.ArrayList; //import for later implementation
import java.util.List; //import for later implementation

/* Bryan Arnold
 * Assignment 5
 * CSE 2100
 * 10/30/16
 */

/* AbstractBinaryTree<E> Class
 * Purpose: this class takes the declared methods in the BinaryTree<E> interface
 * and makes them fully functional. It also takes the methods extended from the 
 * previously made AbstractTree<E> class for further implementation and operational
 * methods to be implemented for binary trees.
 */

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> { //start class, needs BinaryTree<E> and AbstractTree<E> to implement

	/* sibling() Method
	 * Purpose: this method takes in a position
	 * of a specified value/node in a tree and checks
	 * whether or not another child shares the same parents,
	 * meaning the two nodes are siblings.
	 * Returns: the position/element of the other
	 * sibling child in the parent.
	 * Parameters: a position of a node is needed
	 * to know if it has a sibling.
	 */
	
	public Position<E> sibling(Position<E> p) { //start method

		Position<E> parent = parent(p); //new parent

		if(parent == null){ //null meaning there is no node in place

			return null;

		} //end if

		if(p == left(parent)){ //left child, return right child (sibling)

			return right(parent);

		} else { //right child, return left child (sibling)

			return left(parent);

		} //end if else chain

	} //end method
	
	
	/* numChildren() Method
	 * Purpose: this method takes in a node/position 
	 * in the tree and counts the number of total children that
	 * a parent node has (should have two since its a binary tree).
	 * Returns: an integer, the number of children of a node
	 * Parameters: the position in the tree to check the number of
	 * children that it has.
	 */
	
	public int numChildren(Position<E> p){ //start method

		int count = 0; //initial children

		if(left(p) != null){ //something exists to the left

			count++;

		} //end if

		if(right(p) != null){ //something exists to the right

			count++;

		} //end if

		return count; //total children

	} //end method
	
	/* children() Method
	 * Purpose: this method returns the positions/elements of
	 * the children of a parent node. There should be no more than two,
	 * since this is a proper binary tree.
	 * Returns: this method returns the positions of the children nodes 
	 * in an Iterable type.
	 * Parameters: a position of a node is needed in order to find the
	 * children of this node.
	 */
	
	public Iterable<Position<E>> children(Position<E> p){ //start method
		
		List<Position<E>> snapshot = new ArrayList<>(2); //make number of children
		
		if(left(p) != null){ //something exists on the left of the parent
			
			snapshot.add(left(p)); //adds to children
			
		} //end if
		
		if(right(p) != null){ //something exists on the right of the parent
			
			snapshot.add(right(p)); //adds to children
			
		} //end if
		
		return snapshot; //children
		
	} //end method

} //end class
