import java.util.ArrayList; //used for storage later on, since amount of results a pain allocate into an array that cannot change size

/* Bryan Arnold
 * CSE 2100
 * Programming Assignment 4
 * 10/16/16
 */

public class PostFix { //start class

	/* PostFix Class
	 * Purpose: this class is responsible for taking all the
	 * valid permutations of postfix notations, and evaluating them
	 * in the proper mathematical order, determining whether or not
	 * those postfixes equal 24, and finally displaying the ones that
	 * equal 24 in a step by step process. This class is the final
	 * engine of the entire program and displays the desired results
	 * as well as compute every postfix. Note: individual results
	 * for each postfix can be displayed, indicated in comments below.
	 * Do not uncomment out anything uncommented unless indication that
	 * it is ok. Those comments are solely for testing.
	 */
	
	public PostFix(){} //default constructor

	/* postFixSolutions(String[][] postFixes) Method
	 * Purpose: this method is the main computational method of
	 * this assignment. It takes in the 2D array of valid postfix
	 * notations and computes them out mathematically. This method is 
	 * extremely complicated so I will explain it as best as I can. First,
	 * It iterates through each string postfix notation, utilizes a stack
	 * to put numerical values into it, then pops them back out when an operator
	 * is iterated to in the postfix. The operation is done for the two numbers, and the
	 * result is put back into the stack. This process is repeated for each postfix, and when
	 * one is equal to 24, it is added to an arraylist to be returned later. This method converts 
	 * a lot on utilizes many outside class methods, StringBuilder, ArrayList, Double, etc.. 
	 * It also displays the step by step computation of each postfix notation. There are
	 * a ton of results, so it is not possible to see all of the computations with their
	 * step by step components of computations. Uncomment spots, indicated by a T after the two slashes, to display
	 * each permutation computation, not just the ones that equal 24. Delete the T once uncommented, and put back
	 * once re-commented.
	 * Parameters: String[][] postFixes. The 2D array of all valid postFixes are needed
	 * in order to compute their numerical values. 
	 * Returns: an array list the valid postfixes that equal 24 as strings. These valid ones
	 * will be utilized in a later method that will display a step by step process of each
	 * computation. An arraylist optimal because total amount that equal 24 is
	 * not known yet. Note: individual results
	 * for each postfix can be displayed, indicated in comments below.
	 * Do not uncomment out anything uncommented unless indication that
	 * it is ok. Those comments are solely for testing.
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" }) //gets rid of annoying warnings
	public ArrayList<String> postFixSolutions(String[][] postFixes){

		double[] result = new double[postFixes.length]; //results
		ArrayList<String> twentyFourPostFixes = new ArrayList<String>(); //storage for return later

		double pop2;
		double pop1;
		double goal = 24.0; //desired computational goal
//		int counter = 0;

		for(int i = 0; i < postFixes.length;){ //start for

			ArrayStack list = new ArrayStack(postFixes[0].length); //new stack each new postfix, don't want a giant stack

			for(int j = 0; j < postFixes[0].length; j++){ //start for

				String s = postFixes[i][j]; //current postfix being computed
//T				System.out.println("Postfix Notation: " + s);
//				System.out.println(s);
//				System.out.println(s.length());
//				System.out.println(s.charAt(s.length() - 2));
//				System.out.println(s.charAt(s.length() - 4));
//				System.out.println(s.charAt(s.length() - 10));

				for(int k = 0; k < s.length(); k++){ //start for
					
					if(k == 0){
						
//T						System.out.println("Step by step computation");
						
					}

					char c = s.charAt(k); //current character to be computed from postfix
//					System.out.println("Character being analyzed: " + c);

					
					if(c == ' '){} //ignore spaces
					
					else if(c >= '0' && c <= '9'){ //checks if the character in question is a number

						if(s.charAt(k + 1) != ' '){ //ensures two digit numbers are processed correctly, Ex) 12, not 1 then 2.
							
							StringBuilder doubleDigit = new StringBuilder(); //allows for combination of characters
							doubleDigit.append(s.charAt(k));
							doubleDigit.append(s.charAt(k + 1));
							String convert = doubleDigit.toString();
							k++; //compensate for skipped character
//							System.out.println(convert);
							list.push(convert);
							
						} else { //not double digit
						
						String convert1 = Character.toString(c);
						list.push(Double.parseDouble(convert1));
						//System.out.println("Stack size: " + list.size());
						
						}

					} else { //no further elements added to stack, so pop top 2 numbers

						pop1 = Double.parseDouble("" + list.pop()); //first
//						System.out.println("pop1: " + pop1);
						pop2 = Double.parseDouble("" + list.pop()); //second
//						System.out.println("pop2: " + pop2);
//						System.out.println("Stack size: " + list.size());

						if(c == '+'){ //if addition

							double add = pop2 + pop1; //computation
//T							System.out.println(pop2 + " + " + pop1 + " = " + add); //step by step display of computation above
							list.push(Double.toString(add));
							//System.out.println("Stack size: " + list.size());

						} else if(c == '-'){ //if subtraction, below large if statement ensures proper order of operations between numbers

							if((s.charAt(s.length() - 2) == '+' || s.charAt(s.length() - 2) == '-' || s.charAt(s.length() - 2) == '*' || s.charAt(s.length() - 2) == '/' )
									
							&& (s.charAt(s.length() - 4) == '+' || s.charAt(s.length() - 4) == '-' || s.charAt(s.length() - 4) == '*' || s.charAt(s.length() - 4) == '/')
							
							&& (s.charAt(s.length() - 10) == '+') || s.charAt(s.length() - 10) == '-' || s.charAt(s.length() - 10) == '*' || s.charAt(s.length() - 10) == '/'){
								
							double sub = (pop1 - pop2); //computation
//T							System.out.println(pop1 + " - " + pop2 + " = " + sub); //step by step display of computation
							list.push(Double.toString(sub));
							//System.out.println("Stack size: " + list.size());
							
									} else {
										
										double sub = (pop2 - pop1); //computation
//T										System.out.println(pop2 + " - " + pop1 + " = " + sub); //step by step display of computation
										list.push(Double.toString(sub));
										
									}

						} else if(c == '*'){ //multiplication

							double mult = pop2 * pop1; //computation
//T							System.out.println(pop2 + " * " + pop1 + " = " + mult); //step by step display of computation
							list.push(Double.toString(mult));
							//System.out.println("Stack size: " + list.size());

						} else if(c == '/'){ //division

							double v = (pop2 / pop1); //computation
//T							System.out.println(pop2 + " / " + pop1 + " = " + v); //step by step computation display
							list.push(Double.toString(v));
							//System.out.println("Stack size: " + list.size());

						} //end if else chain

					} //end if

					if(k == s.length() - 1){ //used to add result of computation to an array, uncomment 3 lines below to see all results
						
						result[i] = Double.parseDouble("" + list.pop());
//						Can uncomment below 3 lines, gets all computations
						
//						counter++;
//						System.out.println("PostFixes evaluated: " + counter);
//						System.out.println(result[i]);

						if(result[i] < goal || result[i] > goal || Double.isNaN(result[i])){ //checks if computed answer is 24, then stores in arraylist to be returned.

						} else {
							
							twentyFourPostFixes.add(s); //result equals 24, added to list of postfixes that equal 24
							
						} //end if else chain

						i++; //iterates to next postfix
//T						System.out.println("");

					} //end if

				} //end k loop

			} //end j loop

		} //end i loop

//		Can uncomment following below, it displays all postfixes that equal 24 as well as the total number of postfixes
		
//		System.out.println("All postfix notations that equal 24");
//
//		for(int i = 0; i < twentyFourPostFixes.size(); i++) {   
//
//			System.out.println(twentyFourPostFixes.get(i));
//
//		}  
//		
//		System.out.println("Total 24 combos: " + twentyFourPostFixes.size());

		return twentyFourPostFixes;	//postfixes that equal 24

	} //end class
	
	/* twentyFourExplained(ArrayList<String> twentyFourPostFixes) Method
	 * Purpose: this method is the step by step display component
	 * of the the main computational method of this assignment. It takes in the ArrayList
	 * of strings, aka the postfixes that equal 24, and displays a
	 * step by step process of all computations to get to 24. This method is 
	 * also complicated so I will explain it as best as I can, but simpler as
	 * the previous as its almost a carbon copy of the previous. First,
	 * it iterates through each string postfix notation, utilizes a stack
	 * to put numerical values into it, then pops them back out when an operator
	 * is iterated to in the postfix. The operation is done for the two numbers, and the
	 * result is put back into the stack. This process is repeated for each postfix, and 
	 * eachs tep by step computation is displayed Ex) 1 + 2 = 3. This method converts 
	 * a lot on utilizes many outside class methods, StringBuilder, ArrayList, Double, etc..
	 * This method also displays the total number of postfix notations that equal 24. Note: there
	 * are a ton of results so you may not be able to see each step by step as the console cannot
	 * contain them all, explained above as well.
	 * Parameters: ArrayList<String> twentyFourPostFixes. The arraylist of all postFixes that
	 * equal 24 are needed in order to show a step by step computation of how they equal 24.
	 * Returns: None, just need to print out step by step process
	 * no data or objects are needed to be returned. Note: 
	 * Do not uncomment out anything uncommented unless indication that
	 * it is ok. Those comments are solely for testing.
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" }) //negates annoying warnings
	public void twentyFourExplained(ArrayList<String> twentyFourPostFixes){
		
		double pop2;
		double pop1;
		int counter = 0; //total postfixes that equal 24
		
		for(int i = 0; i < twentyFourPostFixes.size(); i++){ //start for
			
			String s = twentyFourPostFixes.get(i); //postfix string to be analyzed
			System.out.println("PostFix Notation: " + s);
			ArrayStack list = new ArrayStack(s.length()); //new stack for each new postfix, no giant stacks plz
			
			for(int j = 0; j < s.length(); j++){ //start for
				
				if(j == 0){
					
					System.out.println("Steps to get solution");
					
				}
				
				char c = s.charAt(j); //number or operator to be analyzed/put in stack or not
//				System.out.println("Character being analyzed: " + c);
				
				if(c == ' '){} //ignore spaces
				
				else if(c >= '0' && c <= '9'){ //checks if the character in question is a number
					
					if(s.charAt(j + 1) != ' '){ //ensures two digit numbers are processed correctly, Ex) 12, not 1 then 2.
						
						StringBuilder doubleDigit = new StringBuilder(); //allows characters to be combined
						doubleDigit.append(s.charAt(j));
						doubleDigit.append(s.charAt(j + 1));
						String convert = doubleDigit.toString();
//						System.out.println(convert);
						j++; //compensate for skipped character
						list.push(convert);
						
					} else {
			
					String convert1 = Character.toString(c);
					list.push(convert1);
//					System.out.println("Stack size: " + list.size());
					
					}
					
				} else { //if an operator is being analyzed, no further addition to stack needed, so time to remove values and compute
					
					pop1 = Double.parseDouble("" + list.pop()); //first
//					System.out.println("n2: " + n2);
					pop2 = Double.parseDouble("" + list.pop()); //second
//					System.out.println("n1: " + n1);
//					System.out.println("Stack size: " + list.size());
					
					if(c == '+'){ //if addition
						
						double add = pop2 + pop1; //computation
						System.out.println(pop2 + " + " + pop1 + " = " + add); //step by step display of above computation
						list.push(Double.toString(add)); //added back to stack
						
					} else if(c == '-'){ //if subtraction, below giant if statement used for the same reason as listed above in the previous method, ensures order of operations

						if((s.charAt(s.length() - 2) == '+' || s.charAt(s.length() - 2) == '-' || s.charAt(s.length() - 2) == '*' || s.charAt(s.length() - 2) == '/' )
								
						&& (s.charAt(s.length() - 4) == '+' || s.charAt(s.length() - 4) == '-' || s.charAt(s.length() - 4) == '*' || s.charAt(s.length() - 4) == '/')
						
						&& (s.charAt(s.length() - 10) == '+') || s.charAt(s.length() - 10) == '-' || s.charAt(s.length() - 10) == '*' || s.charAt(s.length() - 10) == '/'){
							
						double sub = (pop1 - pop2); //computation
						System.out.println(pop1 + " - " + pop2 + " = " + sub); //step by step display of above computation
						list.push(Double.toString(sub));
						
						} else {
							
							double sub = (pop2 - pop1); //computation
							System.out.println(pop2 + " - " + pop1 + " = " + sub); //step by step display of above computation
							list.push(Double.toString(sub));
							
						}
						
						} else if(c == '*'){ //if multiplication
						
						double mult = pop2 * pop1; //computation
						System.out.println(pop2 + " * " + pop1 + " = " + mult); //step by step of computation above displayed
						list.push(Double.toString(mult));
						
					} else if(c == '/'){ //if division
						
						double div = pop2 / pop1; //computation
						System.out.println(pop2 + " / " + pop1 + " = " + div); //display of above computation, step by step
						list.push(Double.toString(div));
						
					} //end if else chain
					
				} //end if
				
				if(j == s.length() - 1){ //when the postfix is done being evaluated, add to the total number of postifxes that equal 24
					
					counter++;
					System.out.println("");
//					System.out.println(counter);
					
				} //end if
				
			} //end for j
			
		} //end for i
		
		System.out.println("Total possible permutations that equal 24: " + counter);
		
	} //end method

	/* Main Method
	 * Purpose: this is the ultimate runner of each method created.
	 * It creates all the valid permutations of the cards and operators,
	 * then utilizes the two above methods to display all computations of
	 * each permutation (in this case only the ones that equal 24 unless
	 * uncommented T comments). Also used to test functionality of each
	 * method with comments that shouldn't be uncommented.
	 */
	
	public static void main(String[] args) {
		
		PostFix b = new PostFix(); //creates default constructor to be able to use methods
		Permutations a = new Permutations(); //creates default constructor to be able to use method
		
		int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}; //cards
		
		char[] ops = {'+', '-', '*', '/'}; //operators
		
		/* Comment out excess sysouts in all following methods,
		 * anything that was commented out initially re-comment before 
		 * running or the console won't be able to display everything.
		 */
		
		char[] newOps = a.operatorChange(ops); 
		
		int[] newCards = a.cardChange(cards);
		
		int[][] validCards = a.cardPermutations(newCards);
		
		char[][] validOps = a.opsPermutations(newOps);
		
		String[][] validOpsFinal = a.opsToString(validOps);
		
		String[][] validCardsFinal = a.cardsToString(validCards);
		
		String[][] finalPermutations = a.postFixPermutations(validCardsFinal, validOpsFinal);
		
		ArrayList<String> twentyFourPostFixes = b.postFixSolutions(finalPermutations);
		
		b.twentyFourExplained(twentyFourPostFixes);
	
	} //end method
	
} //end class
