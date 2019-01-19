/* Bryan Arnold
 * CSE 2100
 * Extra Credit Assignment
 * 12/9/16
 */

/* PuzzleSolver Class
 * Purpose: this class contains the methods responsible
 * for finding the summation puzzle solution only for the puzzle:
 * FORTY + TEN + TEN = SIXTY. It uses a multiple recursive method called SolvePuzzle
 * to go through all the possibilities of number assignments to the unique characters
 * in the puzzle, then checks if the number assignments solve the puzzle with the
 * Solution method. Utilizes my LinkedList class. THIS IS NOT A GENERIC METHOD
 * TO SOLVE ANY PUZZLE, IT ONLY SOLVES THIS ONE PUZZLE.
 */
public class PuzzleSolver{ //start class

	private String uniqueLetters = "FORTYENSIX"; //the unique letters of this one puzzle

	/* SolvePuzzle(int k, LinkedList sequence, LinkedList universe) Method
	 * Purpose: this method recursively goes through all the possible sequences
	 * of the unique letters in the puzzle. It then uses another method to check
	 * whether or not that order of letters and number assignments solves the puzzle.
	 * Parameters: int k, LinkedList sequence, LinkedList universe. The int k is the
	 * number of unique letters to assign to integers, goes from 0-10. the linked list
	 * sequence is an empty sequence to be filled with new elements from the other linked list,
	 * universe, which has all the unique letters of the puzzle.
	 * Returns: nothing, only need to print out results.
	 */
	public void SolvePuzzle(int k, LinkedList sequence, LinkedList universe){ //start method

		LinkedList newSequence = sequence;
		LinkedList newUniverse = universe;

		if(k == 10){ //if unique sequence of letters is reached

			Solution(newSequence); //see if it works

		} //end if

		for(int i = 0; i < newUniverse.getSize(); i++){ //start for i

			newSequence.addFirst(newUniverse.getHead());
			newUniverse.removeFirst();

			SolvePuzzle(k + 1, newSequence, newUniverse); //new call

			newUniverse.addLast(newSequence.getHead());
			newSequence.removeFirst();

		} //end for i

	} //end method

	/* Solution(LinkedList currentSequence) Method
	 * Purpose: this method assigns integer values to each letter
	 * in the new unique sequence, then checks whether or not that new
	 * sequence is a solution that solves the puzzle. Lastly, it displays
	 * the sequence of letters, the number assignment sequence, then the direct
	 * assignment of letters to numbers that solve the puzzle.
	 * Parameters: LinkedList currentSequence. This sequence is a new unique sequence
	 * to be assigned values.
	 * Returns: none, just need to display solutions if they exist
	 */
	public void Solution(LinkedList currentSequence){

		String solution = currentSequence.elementsToString(); //string of all elements
		String result = "FORTY + TEN + TEN = SIXTY"; //puzzle to be solved

		for(int i = 0; i < 10; i++){ //start for i

			String al = uniqueLetters.substring(i,i+1);	//pick one letter from puzzle
			String so = solution.substring(i,i+1); //pick one number from currentSequence
			result = result.replaceAll(al,so);	//replace all of that letter with number solution

		} //end for i	

		result = result.replaceAll("\\s", ""); //replace unnecessary characters

		String[] str = result.split("[\\+=]"); //removes +- from puzzle for easier calculations/assignments
		int[] answer = new int[str.length]; //answer to be found

		for(int i = 0; i < answer.length; i++){ //start for i

			answer[i] = Integer.parseInt(str[i]);

		} //end for i

		int total = answer[answer.length-1];
		int sums = 0;

		for(int i = 0; i < answer.length - 1;i++){ //start for i

			sums = sums + answer[i];
		} //end for i

		if(sums == total){ //will only print out solutions that are correct, not just print out sequences

			System.out.println("Solution(s) Found:");
			System.out.print("Unique letter sequence: ");

			for(int i = 0; i < solution.length(); i++) { //start for i

				System.out.print(uniqueLetters.substring(i, i + 1));

			} //end for i

			System.out.println("");
			System.out.print("Corresponding letter number values: ");

			for(int i = 0; i < solution.length(); i++){ //start for i

				System.out.print(solution.substring(i, i + 1));

			} //end for i

			System.out.println("");
			System.out.print("Direct letter to number assignment: ");

			for(int i = 0; i < solution.length(); i++){ //start for i

				System.out.print(uniqueLetters.substring(i,i+1) + " = " + solution.substring(i,i+1) + ", ");

			} //end for i

		} //end if

	} //end method

	//Runs the program to find solutions to the puzzle
	public static void main(String[] args){ //start main

		PuzzleSolver a = new PuzzleSolver();
		LinkedList S = new LinkedList();
		LinkedList U = new LinkedList();

		U.addFirst("0");
		U.addFirst("1");
		U.addFirst("2");
		U.addFirst("3");
		U.addFirst("4");
		U.addFirst("5");
		U.addFirst("6");
		U.addFirst("7");
		U.addFirst("8");
		U.addFirst("9");

		System.out.println("Puzzle to solve: FORTY + TEN + TEN = SIXTY");

		a.SolvePuzzle(0,S,U);

	} //end main

} //end class