/* Bryan Arnold
 * CSE 2100
 * Assignment 7
 * 11/27/16
 */

import java.util.ArrayList; //import for later

/* Main Class
 * Purpose: This class is used for testing of my program to
 * make sure it's functional, as well as run the end result of the
 * program and all the methods created in other classes. So, this
 * is the main runner of the program.
 */

public class Main { //start class

	public static void main(String[] args) { //main method

		WordFinder text = new WordFinder("shakespear.txt"); //gets file from source folder

		ArrayList<String> lines = new ArrayList<String>(); //for sorting and string insertion

		lines = text.textToString(); //gets lines from file and put into strings

		ChainHashMap<String, Integer> words = text.parseStrings(lines); //puts each word into hash buckets and separates words in each string

		ArrayList<Entry<String, Integer>> sortedWords = text.convertHashAndSort(words); //sorts the hash into an arraylist

		text.printTopThousand(sortedWords); //prints the top 1000 most frequent words

		//	text.printAll(sortedWords); //prints all the entries with more than one collision, commented out to display top 1000 which is more important

	} //end method

} //end class