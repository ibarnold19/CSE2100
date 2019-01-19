/* Bryan Arnold
 * CSE 2100
 * Programming Assignment 4
 * 10/16/16
 */

public class Permutations { //start class
	
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
	 * method and total variables to see each permutation and total permutations.
	 */
	
	public Permutations(){} //default constructor
	
	/* cardChange(int[] cards) Method
	 * Purpose: this method creates a new array of card values
	 * in the form of 111122223333... as it allows for easier permutation
	 * calculation later on. Instead of trying to convert in the 
	 * permutation algorithm, this method makes the code look neater
	 * and more organized. So, overall, this method just multiplies the
	 * amount of cards to 52 and creates 4 of each card, like a standard deck. 
	 * 4 of each are made because only 4 cards are using in 1 postfix notation.
	 * Parameters: int[] cards. The thirteen cards in the 24 game, 1-13,
	 * are required to create a deck of them.
	 * Returns: a new array of card value, 4 of each value, so a
	 * deck of the card value essentially.
	 */
	public int[] cardChange(int[] cards){
		
		int[] cardsNew = new int[cards.length * 4]; //new size
		
		for(int i = 0; i < cards.length; i++){ //start for
			
			for(int j = 0; j < 4; j++){ //start for
				
				int k = i * 4 + j; //sets a value of first four positions to same number
				cardsNew[k] = i + 1; //^^
				
			} //end for j
			
		} //end for i
		
		return cardsNew; 
		
	} //end method
	
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

	/* cardPermutations(int[] cards)
	 * Purpose: this method is used to find all the possible
	 * 4 card value combinations, without any repeat values in
	 * the combinations. These card combinations will be used
	 * later on in unison with the operator combinations to find all
	 * postfix combinations. By making sure repeats cannot occur in the
	 * combinations of this method, it negates the need for another method 
	 * checking repeats. Note: the reason the 2D array storing the combinations
	 * is [715][4] is due to math and reasoning. The following equation was used
	 * to find 715 as the total number of combinations: n!/(r!(n-r)!) where
	 * n = 13, the number of possible card values, and r = 4, how many numbers
	 * are used in each combination. The amount of cards in each combination, 4,
	 * is simply part of the rules of the 24 game given to us, there can't be more
	 * than 4 numbers in each postfix. All commented out code in the method was used for testing.
	 * Parameters: int[] cards. This is the deck of cards, 4 of each value, that makes
	 * for finding the possible card combinations much simpler.
	 * Returns: int[][] permutations. All the permutations of 4 card combinations are stored 
	 * in this 2D array.
	 */
	
	public int[][] cardPermutations(int[] cards){
		
		int[][] permutations = new int[715][4]; //total amount of combinations by how many numbers in each combination
		
		int counter = 0;
		int counter1 = 0;
//		int total = 0;

		for(int i1 = 0; i1 <= 48; i1 += 4){ //start for

			for(int i2 = i1 + 1; i2 <= 49; i2 += 4){ //start for

				for(int i3 = i2 + 1; i3 <= 50; i3 += 4){ //start for

					for(int i4 = i3 + 1; i4 <= 51; i4 += 4) { //start for
						
						int c1 = cards[i1];
						int c2 = cards[i2];
						int c3 = cards[i3];
						int c4 = cards[i4];
						
						if(c1 != c2 && c1 != c3 && c1 != c4 && c2 != c3 && c2 != c4 && c3 != c4){ //check for repeats first
						
						permutations[counter][counter1] = c1;
						counter1++;
						
//						System.out.print(c1 + " ");
						
						permutations[counter][counter1] = c2;
						counter1++;
						
//						System.out.print(c2 + " ");
						
						permutations[counter][counter1] = c3;
						counter1++;
						
//						System.out.print(c3 + " ");
						
						permutations[counter][counter1] = c4;
						
						counter++;
						counter1 = 0;
						
//						System.out.println(c4);
						
//						total++;
//						
//						System.out.println("Valid permutations: " + total);
						
						} //end if
						
					} //end for i4
					
				} //end for i3
				
			} //end for i2
			
		} //end for i1
		
		return permutations;
		
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

//				System.out.print(converted[i][j]);
				
			} //end for j
			
//			System.out.println("");

		} //end for i

		return s;

	} //end method

	/* cardsToString(int[][] cards) Method
	 * Purpose: this method is used to convert the 2D array containing all
	 * the possible card combinations into strings. By being converted into
	 * strings, turning the combinations of operators and cards into the combinations
	 * of postfix becomes much simpler to evalute later on if both the cards
	 * and operators are of the same type.
	 * Parameters: int[][] operators. All the combinations of cards are required
	 * to transform them all into strings instead of ints.
	 * Returns: a 2D array of all card combinations, but now as strings.
	 */
	public String[][] cardsToString(int[][] cards){
		
		String[][] s = new String[cards.length][cards[0].length]; //amount of combinations and operators per combo

		for(int i = 0; i < cards.length; i++) {

			s[i] = new String[cards[i].length]; //cards per combo

			for(int j = 0; j < cards[0].length; j++){ //start for

				s[i][j] = Integer.toString(cards[i][j]); //string conversion

//				System.out.print(s[i][j] + " ");
				
			} //end for j
			
//			System.out.println("");

		} //end for i

		return s;
		
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
						
						permutations[i][j] = cards[a][b] + " " + cards[a][b + 1] + " " + operators[c][d] + " " + cards[a][b + 2] + " " + cards[a][b + 3] + " " + operators[c][d + 1] + " " + operators[c][d + 2] + " ";
//						System.out.println(permutations[i][j]);
						i++;
						j++;
						total++;
						
						permutations[i][j] = cards[a][b] + " " + cards[a][b + 1] + " " + operators[c][d] + " " + cards[a][b + 2] + " " + operators[c][d + 1] + " " + cards[a][b + 3] + " " + operators[c][d + 2] + " ";
//						System.out.println(permutations[i][j]);
						i++;
						j++;
						total++;
						
						permutations[i][j] = cards[a][b] + " " + cards[a][b + 1] + " " + cards[a][b + 2] + " " + cards[a][b + 3] + " " + operators[c][d] + " " + operators[c][d + 1] + " " + operators[c][d + 2] + " ";
//						System.out.println(permutations[i][j]);
						i++;
						j++;
						total++;
						
						permutations[i][j] = cards[a][b] + " " + cards[a][b + 1] + " " + cards[a][b + 2] + " " + operators[c][d] + " " + cards[a][b + 3] + " " + operators[c][d + 1] + " " + operators[c][d + 2] + " ";
//						System.out.println(permutations[i][j]);
						i++;
						j++;
						total++;
						
						permutations[i][j] = cards[a][b] + " " + cards[a][b + 1] + " " + cards[a][b + 2] + " " + operators[c][d] + " " + operators[c][d + 1] + " " + cards[a][b + 3] + " " + operators[c][d + 2] + " ";
//						System.out.println(permutations[i][j]);
						i++;
						c++;
						j = 0;
						total++;
						
						if(total % 64 == 0){ //to iterate to next card combination, 64 combos per card combo
							
							a++;
							c = 0;
							
						} //end if
						
				} //end while
				
//				System.out.println("Total permutations: " + total);
				
		return permutations;
		
	} //end method

	/* Main Method
	 * Purpose: the main method of this class was only used
	 * to test the functionality of each method, as well as if the number of permutation
	 * was correct for what each method was trying to find. To see the test cases, only 1-13 and 4 operators
	 * are the test cases of this assignment as they are the only thing we have to check for, uncomment
	 * all the commented sections of each method and run. All total valid combos of each component will be printed.
	 * Note: won't theoretically be able to see all since 228800 total postfix combos clutter console. Nothing prints
	 * unless sysouts uncommented in each method.
	 */
	
	public static void main(String[] args) {
		
		Permutations a = new Permutations();
		
		int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		
		char[] ops = {'+', '-', '*', '/'};
		
		char[] newOps = a.operatorChange(ops);
		
		int[] newCards = a.cardChange(cards);
		
		int[][] validCards = a.cardPermutations(newCards);
		
		char[][] validOps = a.opsPermutations(newOps);
		
		String[][] validOpsFinal = a.opsToString(validOps);
		
		String[][] validCardsFinal = a.cardsToString(validCards);
		
		a.postFixPermutations(validCardsFinal, validOpsFinal);
		
	} //end method

} //end class
