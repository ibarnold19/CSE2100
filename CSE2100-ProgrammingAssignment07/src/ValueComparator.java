/* Bryan Arnold
 * CSE 2100
 * Assignment 7
 * 11/27/16
 */

import java.util.ArrayList; //import for later
import java.util.Comparator; //import for later

/* ValueComparator Class
 * Purpose: the purpose of this class is implement a method
 * for comparing entries of key and values in the hash to sort them
 * efficiently using Collections. This overrides comparator in java
 * and uses an arraylist of the entries in the hash and sorts them
 * by the number of collisions/frequency of the word.
 */

public class ValueComparator implements Comparator<Entry<String, Integer>>{ //start class

	private ArrayList<Entry<String, Integer>> words; //private member of words in hash

	/* Value Comparator Constructor
	 * Purpose: this constructor creates a ValueComparator object
	 * that takes in an array list of entries. These entries are the
	 * entries of words and their frequencies in the hash. 
	 * Parameters: ArrayList<Entry<String, Integer>> words. The list of
	 * words with their key and values are needed from the hash to compare them.
	 * Returns: nothing.
	 */
	public ValueComparator(ArrayList<Entry<String, Integer>> words){

		this.words = words; //sets private member to given list

	} //end constructor

	/*compare Method
	 * Purpose: this method is the override to the compare method
	 * in comparator. It compares the values of two entry values, and puts
	 * one in front of the other in order based on which one is bigger or smaller.
	 * So, it's a method in which to compare two entry frequency values to each other.
	 * Parameters: two entries in the word list. There has to be two entries
	 * to compare their frequencies and sort them.
	 * Returns: -1 or 1 indicating true or false. This allows Collections
	 * to know where to sort the two entries. 1 being greater, -1 be less than.
	 */
	@Override
	public int compare(Entry<String, Integer> a , Entry<String, Integer> b) { //start method 

		if(a.getValue() >= b.getValue()){ //if 

			return -1;

		} //end if

		return 1;

	} //end method

	//simple getter access to the private member variable, in case I needed it
	public ArrayList<Entry<String, Integer>> getWords() { //start method

		return words;

	} //end method

	//simple setter to change the member variable, in case I needed it
	public void setWords(ArrayList<Entry<String, Integer>> words) { //start method

		this.words = words;

	} //end method

} //end method