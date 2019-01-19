import java.util.ArrayList; //imported for later use

/* Bryan Arnold
 * Assignment 5
 * CSE 2100
 * 10/30/16
 */

/* Permutations Class
 * Purpose: the purpose of this class is to create
 * methods to ultimately get all possible postfix 
 * combinations to help in finding all possible evaluations
 * that equal 24. It has methods to create a deck of card values,
 * then the same process for all operators. It also has methods that
 * put all possible card combinations, no number repeats, and all
 * possible operations combinations, repeats, into 2D arrays for later
 * use. Once all permutations are found, they are converted into 2D arrays of 
 * strings, as those are easier to use for postfix, using two other methods, 
 * one for cards and one for operators. Finally, having all possible combinations
 * for both parts, they are combined into one 2D string array in all possible
 * postfix forms combining all permutations of both. Uncomment all sysouts in each
 * method to see test methodology.
 */

public class Permutations { //start class

	public Permutations(){} //default
	
	/* operatorChange(char[] cards) Method
	 * Purpose: this method creates a new array operator values
	 * in the form of +++---... as it allows for easier permutation
	 * calculation later on. Instead of trying to convert in the 
	 * permutation algorithm, this method makes the code look neater
	 * and more organized. So, overall, this method just multiplies the
	 * amount of operators to 12 and creates 3 of each operator. 3 of each
	 * operator are created because no more than three operations can
	 * be used in one postfix notation.
	 * Parameters: char[] operators. The 4 operators in the 24 game
	 * are required to make 3 of each of them.
	 * Returns: a new array of operators, 3 of each value.
	 */
	
	public char[] operatorChange(char[] operators){
		
		char[] opsNew = new char[operators.length * 3]; //new size
		
		for(int i = 0; i < operators.length; i++){ //start for
			
			for(int j = 0; j < 3; j++){ //start for
				
				int k = i * 3 + j; //sets a value of first three positions to same operator
				opsNew[k] = operators[i];//^^
				
			} //end for j
			
		} //end for i
		
		return opsNew;
		
	} //end method
	
	/* opsPermutations(char[] operators) Method
	 * Purpose: this method is used to find all the possible
	 * 3 operators combinations, with repeats of operators
	 * in their combinations. These operator combinations will be used
	 * later on in unison with the cards combinations to find all
	 * postfix combinations. Note: the reason the 2D array storing the combinations
	 * is [64][3] is due to math and reasoning. The following equation was used
	 * to find 64 as the total number of combinations: n^r where
	 * n = 4, the number of possible operators, and r = 3, how many operators
	 * are used in each combination. The amount of operators in each combination, 3,
	 * is simply part of the rules of the 24 game given to us, there can't be more
	 * than 3 operators in each postfix. All commented out code in the method was used for testing.
	 * Parameters: char[] operators. This is all the operators, 3 of each, that makes
	 * for finding the possible operator combinations much simpler.
	 * Returns: char[][] permutations. All the permutations of 3 operators combinations are stored 
	 * in this 2D array.
	 */
	
	public char[][] opsPermutations(char[] operators){
		
		char[][] permutations = new char[64][3]; //total number of combinations of operators
		
		int counter = 0;
		int counter1 = 0;
//		int total = 0;
		
		for(int i = 0; i <= 9; i += 3){ //start for
			
			for(int i1 = 0; i1 <= 10; i1 += 3){ //start for
				
				for(int i2 = 0; i2 <= 11; i2 += 3){ //start for
					
						char c1 = operators[i];
						char c2 = operators[i1];
						char c3 = operators[i2];
						
						permutations[counter][counter1] = c1;
						counter1++;
						
//						System.out.print(c1);
						
						permutations[counter][counter1] = c2;
						counter1++;
						
//						System.out.print(c2);
						
						permutations[counter][counter1] = c3;
						counter++;
						counter1 = 0;
						
//						System.out.println(c3);

//						total++;
//						
//						System.out.println("Permations: " + total);	
					
				} //end for i2
				
			} //end for i1
			
		} //end for i
		
		return permutations;
		
	} //end method
	
	/* opsToString(char[][] operators) Method
	 * Purpose: this method is used to convert the 2D array containing all
	 * the possible operator combinations into strings. By being converted into
	 * strings, turning the combinations of operators and cards into the combinations
	 * of postfix becomes much simpler to evalute later on if both the cards
	 * and operators are of the same type.
	 * Parameters: char[][] operators. All the combinations of operators are required
	 * to transform them all into strings instead of chars.
	 * Returns: a 2D array of all operator combinations, but now as strings.
	 */
	
	public String[][] opsToString(char[][] operators){

		String[][] s = new String[operators.length][operators[0].length]; //amount of combinations and operators per combo

		for(int i = 0; i < operators.length; i++) { //start for

			s[i] = new String[operators[i].length]; //operators per combination

			for(int j = 0; j < operators[0].length; j++){ //start for

				s[i][j] = Character.toString(operators[i][j]); //string conversion

//				System.out.print(operators[i][j]);
				
			} //end for j
			
//			System.out.println("");

		} //end for i

		return s;

	} //end method
	
	/* permutation() Method
	 * Purpose: this method is used for getting all
	 * the possible combinations of the four numbers provided
	 * and putting them into a list format. This is a recursive
	 * method I had to do in high school, slightly altered though.
	 * Returns: array list of string card permutations
	 * Parameters: the original string to permutate.
	 */
	
	public static ArrayList<String> permutation(String s) { //start method
		
	    ArrayList<String> res = new ArrayList<String>(); //new list to be created
	    
	    if (s.length() == 1) { //base case
	    	
	        res.add(s);
	        
	    } else if (s.length() > 1) {
	    	
	        int lastIndex = s.length() - 1;  // Find out the last character
	        
	        String last = s.substring(lastIndex); // Rest of the string
	        
	        String rest = s.substring(0, lastIndex);
	        
	        res = merge(permutation(rest), last);
	        
	    } //end if else chain
	    
	    return res; //all permutations
	    
	} //end method

	
	 /* merge() Method
	  * Purpose: this method takes the last character of each string
	  * and merges them together into each possible permutation.
	  * Returns: array list of all possible card permutations
	  * Parameters: the string being permutated and the array list
	  * Previously being analyzed are required to fully permutate.
	  */
	
	public static ArrayList<String> merge(ArrayList<String> list, String c) {
		
	    ArrayList<String> res = new ArrayList<String>();
	    
	    for (String s : list) {
	    	
	        for (int i = 0; i <= s.length(); ++i) {
	        	
	            String ps = new StringBuffer(s).insert(i, c).toString();
	            res.add(ps);
	            
	        } //end for i
	        
	    } //end for each
	    
	    return res;
	    
	} //end method

	/* arrayListToString() Method
	 * Purpose: this method simply takes an array list, the card 
	 * permutations, and turns them into a 2D array of strings, each permutation,
	 * for easier postfix permutations later one (has to match type to operators).
	 * Returns: a 2D array of string representations of all the card permutations
	 * Parameters: an array list of card permutations to be changed into strings.
	 */
	
	public String[][] arrayListToString(ArrayList<String> cards){ //start method
		
		String[][] cardsString = new String[cards.size()][cards.get(0).length()]; //size of 2D
		
		for(int i = 0; i < cards.size(); i++){ 
				
				cardsString[i] = new String[cards.get(i).length()];
				
				for(int j = 0; j < 1; j++){
					
					cardsString[i][j] = cards.get(i);
					
//					System.out.println(cardsString[i][j]);
					
				} //end for j
			
		} //end for i
		
		return cardsString;
		
	} //end method
	
	/* postFixPermutations(String[][] cards, String[][] operators) Method
	 * Purpose: this method combines the string representations of all the cards
	 * and operators combinations and puts them into all the possible postfix
	 * notation forms. It iterates one card combo by every operator combo, then the next card combo
	 * and so on. A ton of iteration and counter tracking is going on so it is hard
	 * to explain in detail. All possible postfix notations were found during class discussions.
	 * Parameters: String[][] cards, String[][] operators. All possible combinations of
	 * both the cards and operators are needed to find all the combinations of postfix notations.
	 * Returns: all possible postfix permutations in string form in a 2D array.
	 */
	
	public String[][] postFixPermutations(String[][] cards, String[][] operators){

		int a = 0; //track cards position
		int b = 0; //track cards position
		int c = 0; //track operator position
		int d = 0; //track opertator position
		int i = 0; //change permutation array position
		int j = 0; //change permutation array position
		int total = 0; //total permutations

		String[][] permutations = new String[cards.length * operators.length * 5][5]; //total combinations by how many forms per combination. Multiplied by 5 because 5 possible combinations of postfix for each operator card combo

				while(total != cards.length * operators.length * 5){ //start while
						
						permutations[i][j] = cards[a][b].charAt(0) + " " + cards[a][b].charAt(1) + " " + operators[c][d] + " " + cards[a][b].charAt(2) + " " + cards[a][b].charAt(3) + " " + operators[c][d + 1] + " " + operators[c][d + 2] + " ";
//						System.out.println(permutations[i][j]);
						i++;
						total++;
						
						permutations[i][j] = cards[a][b].charAt(0) + " " + cards[a][b].charAt(1) + " " + operators[c][d] + " " + cards[a][b].charAt(2) + " " + operators[c][d + 1] + " " + cards[a][b].charAt(3) + " " + operators[c][d + 2] + " ";
//						System.out.println(permutations[i][j]);
						i++;
						total++;
						
						permutations[i][j] = cards[a][b].charAt(0) + " " + cards[a][b].charAt(1) + " " + cards[a][b].charAt(2) + " " + cards[a][b].charAt(3) + " " + operators[c][d] + " " + operators[c][d + 1] + " " + operators[c][d + 2] + " ";
//						System.out.println(permutations[i][j]);
						i++;
						total++;
						
						permutations[i][j] = cards[a][b].charAt(0) + " " + cards[a][b].charAt(1) + " " + cards[a][b].charAt(2) + " " + operators[c][d] + " " + cards[a][b].charAt(3) + " " + operators[c][d + 1] + " " + operators[c][d + 2] + " ";
//						System.out.println(permutations[i][j]);
						i++;
						total++;
						
						permutations[i][j] = cards[a][b].charAt(0) + " " + cards[a][b].charAt(1) + " " + cards[a][b].charAt(2) + " " + operators[c][d] + " " + operators[c][d + 1] + " " + cards[a][b].charAt(3) + " " + operators[c][d + 2] + " ";
//						System.out.println(permutations[i][j]);
						i++;
						c++;
						total++;
						
						if(total % 64 == 0){ //to iterate to next card combination, 64 combos per card combo
							
							a++;
							c = 0;
							
						} //end if
						
				} //end while
				
//				System.out.println("Total permutations: " + total);
				
		return permutations;
		
	} //end method
	
	/*Main() Method
	 * This method is just for testing making sure all
	 * of my methods worked correctly and I ended up
	 * with the correct number of permutations.
	 */
	
	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] args) {
		
		Permutations a = new Permutations();
		
		char[] ops = {'+', '-', '*', '/'};
		
		char[] newOps = a.operatorChange(ops);
		
		char[][] opsPermutations = a.opsPermutations(newOps);
		
		String[][] finalOps = a.opsToString(opsPermutations);
		
		String cards = "1234";
		
		ArrayList<String> cardPermutations = a.permutation(cards);
		
		String[][] finalCardPermutations = a.arrayListToString(cardPermutations);
		
		String[][] finalPostFixPermutations = a.postFixPermutations(finalCardPermutations, finalOps);
		
		
	} //end method

} //end class
