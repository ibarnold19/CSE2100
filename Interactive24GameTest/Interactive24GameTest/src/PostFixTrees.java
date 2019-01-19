

/* Bryan Arnold
 * Assignment 5
 * CSE 2100
 * 10/30/16
 */

/* PostFixTrees Class
 * Purpose: this class holds the final steps and
 * calculations of the permutations of postfixes. It's responsible
 * for creating the trees in the proper binary tree format for
 * each type of postfix, and then evaluting the trees in postfix
 * order.
 */
public class PostFixTrees<E> extends LinkedBinaryTree<E>{ //start class

	/* treeConstructor() Method
	 * Purpose: this method is very complicated, and involves a lot
	 * of understanding of trees to develop. First, each type of postfix
	 * notation required a different type of binary tree to calculate later on properly. 
	 * So, this method does just that. This method created the 5 types of
	 * binary trees for each type of postfix, then creates the trees given the
	 * elements of digits and operations in the postfix.
	 * Returns: a binary linked list tree with the correct placements
	 * of each element at the right nodes/positions.
	 * Parameters: a string of postfix notation
	 */
	
	public LinkedBinaryTree<Character> treeConstructor(String postFix){ //start method
		
		LinkedBinaryTree<Character> postFixTree = new LinkedBinaryTree<Character>();
		
		int counter = 0;
		
		String postFixSwap = swapper(postFix);
		
		Position<Character> highestParent = null; //will always be one highest parent, and two lesser parents in this binary tree
		Position<Character> subParent1 = null;
		Position<Character> subParent2 = null;
		
		if(Character.isDigit(postFixSwap.charAt(1)) == false && Character.isDigit(postFixSwap.charAt(3)) == false && Character.isDigit(postFixSwap.charAt(9)) == false){
		
		for(int i = 0; i < postFixSwap.length(); i++){	
			
			if(counter == 3){
				
				counter = 0;
				break;
				
			}
				
			System.out.println("Current character: " + postFixSwap.charAt(i));
				
				if(postFixSwap.charAt(i) == '+' || postFixSwap.charAt(i) == '-' || postFixSwap.charAt(i) == '*' || postFixSwap.charAt(i) == '/'){
					
					if(counter == 0){
						
						highestParent = postFixTree.addRoot(postFixSwap.charAt(i));
						System.out.println("Root element: " + highestParent.getElement());
						counter++;
						
					} else if(counter == 1) {
						
						subParent1 = postFixTree.addRight(highestParent, postFixSwap.charAt(i));
						System.out.println("Right parent: " + subParent1.getElement());
						counter++;
						
					} else if(counter == 2){
						
						subParent2 = postFixTree.addLeft(highestParent, postFixSwap.charAt(i));
						System.out.println("Left parent: " + subParent2.getElement());
						counter++;
						
					}
					
				}
			
		}
		
		for(int j = 0; j < postFixSwap.length(); j++){
			
			if(counter == 4){
					
					counter = 0;
					break;
					
				}
			
			System.out.println("Current character: " + postFixSwap.charAt(j));
			
			if(Character.isDigit(postFixSwap.charAt(j))){
				
				if(counter == 0){
					
					postFixTree.addRight(subParent1, postFixSwap.charAt(j));
					System.out.println("SubParent1 right child: " + postFixSwap.charAt(j));
					counter++;
					
				} else if(counter == 1){
					
					postFixTree.addLeft(subParent1, postFixSwap.charAt(j));
					System.out.println("SubParent1 left child: " + postFixSwap.charAt(j));
					counter++;
					
				} else if(counter == 2){
					
					postFixTree.addRight(subParent2, postFixSwap.charAt(j));
					System.out.println("SubParent2 right child: " + postFixSwap.charAt(j));
					counter++;
					
				} else if(counter == 3){
					
					postFixTree.addLeft(subParent2, postFixSwap.charAt(j));
					System.out.println("SubParent2 left child: " + postFixSwap.charAt(j));
					counter++;
					
				}
				
			}
			
		}
		
		
	} else if(Character.isDigit(postFixSwap.charAt(1)) == false && Character.isDigit(postFixSwap.charAt(3)) == false && Character.isDigit(postFixSwap.charAt(5)) == false){
		
		for(int k = 0; k < postFixSwap.length(); k++){
		
			if(counter == 3){
				
				counter = 0;
				break;
				
			}
				
			System.out.println("Current character: " + postFixSwap.charAt(k));
			
				if(postFixSwap.charAt(k) == ' '){}
				
				
				if(postFixSwap.charAt(k) == '+' || postFixSwap.charAt(k) == '-' || postFixSwap.charAt(k) == '*' || postFixSwap.charAt(k) == '/'){
					
					if(counter == 0){
						
						highestParent = postFixTree.addRoot(postFixSwap.charAt(k));
						System.out.println("Root element: " + highestParent.getElement());
						counter++;
						
					} else if(counter == 1) {
						
						subParent1 = postFixTree.addRight(highestParent, postFixSwap.charAt(k));
						System.out.println("Right parent1: " + subParent1.getElement());
						counter++;
						
					} else if(counter == 2){
						
						subParent2 = postFixTree.addRight(subParent1, postFixSwap.charAt(k));
						System.out.println("Right parent2: " + subParent2.getElement());
						counter++;
						
					}
					
				}
			
			}
		
			for(int l = 0; l < postFixSwap.length(); l++){
			
			if(counter == 4){
					
					counter = 0;
					break;
					
				}
			
			System.out.println("Current character: " + postFixSwap.charAt(l));
			
			if(Character.isDigit(postFixSwap.charAt(l))){
				
				if(counter == 0){
					
					postFixTree.addRight(subParent2, postFixSwap.charAt(l));
					System.out.println("SubParent2 right child: " + postFixSwap.charAt(l));
					counter++;
					
				} else if(counter == 1){
					
					postFixTree.addLeft(subParent2, postFixSwap.charAt(l));
					System.out.println("SubParent2 left child: " + postFixSwap.charAt(l));
					counter++;
					
				} else if(counter == 2){
					
					postFixTree.addLeft(subParent1, postFixSwap.charAt(l));
					System.out.println("SubParent1 left child: " + postFixSwap.charAt(l));
					counter++;
					
				} else if(counter == 3){
					
					postFixTree.addLeft(highestParent, postFixSwap.charAt(l));
					System.out.println("Root left child: " + postFixSwap.charAt(l));
					counter++;
					
				}
				
			}
			
		}
		
	} else if(Character.isDigit(postFixSwap.charAt(1)) == false && Character.isDigit(postFixSwap.charAt(5)) == false && Character.isDigit(postFixSwap.charAt(7)) == false){
		
		for(int i = 0; i < postFixSwap.length(); i++){	
			
			if(counter == 3){
				
				counter = 0;
				break;
				
			}
				
			System.out.println("Current character: " + postFixSwap.charAt(i));
				
				if(postFixSwap.charAt(i) == '+' || postFixSwap.charAt(i) == '-' || postFixSwap.charAt(i) == '*' || postFixSwap.charAt(i) == '/'){
					
					if(counter == 0){
						
						highestParent = postFixTree.addRoot(postFixSwap.charAt(i));
						System.out.println("Root element: " + highestParent.getElement());
						counter++;
						
					} else if(counter == 1) {
						
						subParent1 = postFixTree.addLeft(highestParent, postFixSwap.charAt(i));
						System.out.println("Subparent1 parent: " + subParent1.getElement());
						counter++;
						
					} else if(counter == 2){
						
						subParent2 = postFixTree.addRight(subParent1, postFixSwap.charAt(i));
						System.out.println("SubParent2 parent: " + subParent2.getElement());
						counter++;
						
					}
					
				}
			
		}
		
			for(int j = 0; j < postFixSwap.length(); j++){
			
			if(counter == 4){
					
					counter = 0;
					break;
					
				}
			
			System.out.println("Current character: " + postFixSwap.charAt(j));
			
			if(Character.isDigit(postFixSwap.charAt(j))){
				
				if(counter == 0){
					
					postFixTree.addRight(highestParent, postFixSwap.charAt(j));
					System.out.println("Root right element: " + postFixSwap.charAt(j));
					counter++;
					
				} else if(counter == 1){
					
					postFixTree.addRight(subParent2, postFixSwap.charAt(j));
					System.out.println("SubParent2 right child: " + postFixSwap.charAt(j));
					counter++;
					
				} else if(counter == 2){
					
					postFixTree.addLeft(subParent2, postFixSwap.charAt(j));
					System.out.println("SubParent2 right child: " + postFixSwap.charAt(j));
					counter++;
					
				} else if(counter == 3){
					
					postFixTree.addLeft(subParent1, postFixSwap.charAt(j));
					System.out.println("SubParent2 left child: " + postFixSwap.charAt(j));
					counter++;
					
				}
				
			}
			
		}
		
		
	} else if(Character.isDigit(postFixSwap.charAt(1)) == false && Character.isDigit(postFixSwap.charAt(5)) == false && Character.isDigit(postFixSwap.charAt(9)) == false){
		
		
		for(int k = 0; k < postFixSwap.length(); k++){
			
			if(counter == 3){
				
				counter = 0;
				break;
				
			}
				
			System.out.println("Current character: " + postFixSwap.charAt(k));
			
				if(postFixSwap.charAt(k) == ' '){}
				
				
				if(postFixSwap.charAt(k) == '+' || postFixSwap.charAt(k) == '-' || postFixSwap.charAt(k) == '*' || postFixSwap.charAt(k) == '/'){
					
					if(counter == 0){
						
						highestParent = postFixTree.addRoot(postFixSwap.charAt(k));
						System.out.println("Root element: " + highestParent.getElement());
						counter++;
						
					} else if(counter == 1) {
						
						subParent1 = postFixTree.addLeft(highestParent, postFixSwap.charAt(k));
						System.out.println("Left parent1: " + subParent1.getElement());
						counter++;
						
					} else if(counter == 2){
						
						subParent2 = postFixTree.addLeft(subParent1, postFixSwap.charAt(k));
						System.out.println("Left parent2: " + subParent2.getElement());
						counter++;
						
					}
					
				}
			
			}
		
			for(int l = 0; l < postFixSwap.length(); l++){
			
			if(counter == 4){
					
					counter = 0;
					break;
					
				}
			
			System.out.println("Current character: " + postFixSwap.charAt(l));
			
			if(Character.isDigit(postFixSwap.charAt(l))){
				
				if(counter == 0){
					
					postFixTree.addRight(highestParent, postFixSwap.charAt(l));
					System.out.println("Root right child: " + postFixSwap.charAt(l));
					counter++;
					
				} else if(counter == 1){
					
					postFixTree.addRight(subParent1, postFixSwap.charAt(l));
					System.out.println("SubParent1 right child: " + postFixSwap.charAt(l));
					counter++;
					
				} else if(counter == 2){
					
					postFixTree.addRight(subParent2, postFixSwap.charAt(l));
					System.out.println("SubParent2 right child: " + postFixSwap.charAt(l));
					counter++;
					
				} else if(counter == 3){
					
					postFixTree.addLeft(subParent2, postFixSwap.charAt(l));
					System.out.println("SubParent2 left child: " + postFixSwap.charAt(l));
					counter++;
					
				}
				
			}
			
		}
		
	} else if(Character.isDigit(postFixSwap.charAt(1)) == false && Character.isDigit(postFixSwap.charAt(3)) == false && Character.isDigit(postFixSwap.charAt(7)) == false){
		
			for(int i = 0; i < postFixSwap.length(); i++){	
			
			if(counter == 3){
				
				counter = 0;
				break;
				
			}
				
			System.out.println("Current character: " + postFixSwap.charAt(i));
				
				if(postFixSwap.charAt(i) == '+' || postFixSwap.charAt(i) == '-' || postFixSwap.charAt(i) == '*' || postFixSwap.charAt(i) == '/'){
					
					if(counter == 0){
						
						highestParent = postFixTree.addRoot(postFixSwap.charAt(i));
						System.out.println("Root element: " + highestParent.getElement());
						counter++;
						
					} else if(counter == 1) {
						
						subParent1 = postFixTree.addRight(highestParent, postFixSwap.charAt(i));
						System.out.println("Right subparent1: " + subParent1.getElement());
						counter++;
						
					} else if(counter == 2){
						
						subParent2 = postFixTree.addLeft(subParent1, postFixSwap.charAt(i));
						System.out.println("Left of subparent1, subparent2: " + subParent2.getElement());
						counter++;
						
					}
					
				}
			
		}
		
			for(int j = 0; j < postFixSwap.length(); j++){
				
				if(counter == 4){
						
						counter = 0;
						break;
						
					}
				
				System.out.println("Current character: " + postFixSwap.charAt(j));
				
				if(Character.isDigit(postFixSwap.charAt(j))){
					
					if(counter == 0){
						
						postFixTree.addRight(subParent1, postFixSwap.charAt(j));
						System.out.println("SubParent1 right child: " + postFixSwap.charAt(j));
						counter++;
						
					} else if(counter == 1){
						
						postFixTree.addRight(subParent2, postFixSwap.charAt(j));
						System.out.println("SubParent2 right child: " + postFixSwap.charAt(j));
						counter++;
						
					} else if(counter == 2){
						
						postFixTree.addLeft(subParent2, postFixSwap.charAt(j));
						System.out.println("SubParent2 left child: " + postFixSwap.charAt(j));
						counter++;
						
					} else if(counter == 3){
						
						postFixTree.addLeft(highestParent, postFixSwap.charAt(j));
						System.out.println("Root left child: " + postFixSwap.charAt(j));
						counter++;
						
					}
					
				}
				
			}
		
	}
		
		return postFixTree;
		
	}
	
	/*postOrder() Method
	 * Purpose: this method had the prupose of attempting to
	 * turn the children and parent nodes back into postfix order from 
	 * postorder traversal for evaluation in a stack.
	 * Returns: string of postfix in tree
	 * Parameters: the tree and node of the root are needed
	 * INCOMPLETE
	 */
	
	public String postOrder(LinkedBinaryTree<Character> tree, Node<Character> root) {  
		
		String s = "";
		
		if(root == null) return s;
		
		 
		   for(int i = 0; i < 7; i++){
			   
			   s += root.getRight();
			   System.out.println(root.getRight().getElement());
			   s += root.getLeft();
			   System.out.println(root.getLeft().getElement());
			   
		   }
		   
		   return s;
		  
		 }  //end method

	
	/* swapper() Method
	 * Purpose: this method takes in a string and reverses
	 * it's order. Helpful when putting in parent and child nodes 
	 * for each type of tree.
	 * Returns: the reverse of the given string
	 * Parameters: the string to be reversed
	 */
	
	public static String swapper(String postFix){ //start method
		
		String s = new StringBuilder(postFix).reverse().toString();
		
		return s;
		
	} //end method
	
	
	public static void main(String[] args) {
	
		String input = "1 2 + 3 4 + + ";
		
		LinkedBinaryTree<Character> test = new LinkedBinaryTree<Character>();

		PostFixTrees a = new PostFixTrees();
		
		System.out.println(swapper(input));
		
		LinkedBinaryTree<Character> testDone = a.treeConstructor(input);

		
		
	}

}
