/*Bryan Arnold
 * CSE 2100
 * Programming Assignment 3
 * 10/2/16
 */

public class Recursion2 { //start class

	/*Class Recursion2
	 * Purpose: this class is used to find and analyze
	 * the runtime of the second part of the assignment.
	 * It creates two methods, the original algorithm as
	 * well as my improved version. This class utilizes a main method
	 * to run the given test cases as well as display the runtime for
	 * each number and the total runtime.
	 */

	/*Method formulaG
	 * Purpose: this method is the original algorithm
	 * that was required to be implemented in java. It follows
	 * the rules of when a number is negative or positive
	 * and implements it using recursion. The algorithm takes
	 * in a number and eventually turns it to 1 through 
	 * different operations depending on if the number is odd or
	 * even throughout the operations. If odd, 1 is added to the
	 * return, then the number is multiplied by 3 and 1 is added to it,
	 * then the new number value is run again by the algorithm. If the number is
	 * 1 or even, the same process as the first algorithms occurs.
	 * Parameters: int n. A desired number to eventually
	 * evaluate to zero given the requirements of the given
	 * algorithm.
	 * Returns an int. This int is the total
	 * iterations, or runtime, of the method to
	 * get the given number to 1.
	 */

	public static int formulaG(int n){

		if(n == 1){ //base case

			return 1;

		}

		if(n % 2 == 0){ //if even

			return 1 + formulaG( n / 2);

		} else { //if odd

			return 1 + formulaG(3 * n + 1);

		} //end if else chain

	} //end method

	/*Method improvedFormulaG
	 * Purpose: this method is the improvement of the
	 * previous method in terms of runtime. It also takes in 
	 * a desired number and evaluates it to 1, using new
	 * operations that I chose to make it more efficient. 
	 * If even or the number is 1, the same process as the above
	 * method will occur, but if odd, 1 is still added to the 
	 * return, but the number is multiplied by 3 and 1 is added to it
	 * and then it is divided by two before being process back into
	 * the algorithm.
	 * Parameters: int n. A number to be evaluated to 1.
	 * Returns an n. This is the number of iterations or the 
	 * runtime of the method for the given method.
	 */

	public static int improvedFormulaG(int n){

		if(n == 1){ //base case

			return 1;

		}

		if (n % 2 == 0){ //if even

			return 1 + (improvedFormulaG(n / 2));

		}

		else { //if odd

			return 1 + (improvedFormulaG((3 * n + 1) / 2));

		} 

	} //end method

	/*Main Method
	 * Purpose: this method is responsible for running
	 * the given test cases of both the original and improved 
	 * algorithms. The test cases are the numbers 1-100000.
	 * The numbers printed out were altered to find the varying
	 * runtimes as well as the total runtime for 1-10000 for both
	 * algorithms. I commented or added to find both so all the
	 * printed values are not present.
	 */

	public static void main(String[] args) {

		int n = 1; //first test case
		int sumRun = 0; //sum of runtime for first algorithm
		int sumRunImproved = 0; //sum of runtime for second algorithm

		while(n <= 10000){ //start while

			System.out.println(improvedFormulaG(n)); //prints out runtime for each number

			sumRun += formulaG(n); 
			sumRunImproved += improvedFormulaG(n);

			n++; //iterates to next test case

		} //end while

		System.out.println(sumRun); //sum original algorithm
		System.out.println(sumRunImproved); //sum new algorithm


	} //end method

} //end class
