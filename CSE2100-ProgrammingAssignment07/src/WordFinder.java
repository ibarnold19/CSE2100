/* Bryan Arnold
 * CSE 2100
 * Assignment 7
 * 11/27/16
 */

import java.io.BufferedReader; //import for later
import java.io.FileNotFoundException; //import for later
import java.io.FileReader; //import for later
import java.io.IOException; //import for later
import java.util.ArrayList; //import for later
import java.util.Collections; //import for later

/* WordFinder Class
 * Purpose: this class is responsible for reading the text file,
 * converting each line of the file into a string, then separating each
 * line into words, adding them into a hash and adding the frequency of
 * each number to the string key, then converting these words and frequencies
 * into a list and sorting them, then finally printing out the top 1000 most common
 * words. Basically, this class holds the main methods of doing this project.
 */

public class WordFinder { //start class

	private String fileName; //private member for the file name

	//simple getter to access the file name in case I need it
	public String getFileName() { //start method

		return fileName;

	} //end method

	//simple setter to change the file name in case I need it
	public void setFileName(String fileName) { //start method

		this.fileName = fileName;

	} //end method


	/* WordFinder Constructor
	 * Purpose: this creates a WordFinder object in order
	 * to carry out all the methods in the class as well as get
	 * a file name to read for the purpose of the project.
	 * Parameters: String fileName. The name of the file to be
	 * read is needed in order to find and read it.
	 * Returns: nothing.
	 */
	public WordFinder(String fileName){ //start constructor

		this.fileName = fileName;

	} //end constructor

	/*textToString Method
	 * Purpose: this method takes each line of text in the
	 * given file and puts them into an arraylist. It uses a
	 * buffer reader and file reader to take each line and add it to the
	 * list. These lines are one string, which will be separated later.
	 * Parameters: none.
	 * Returns: an array list of strings, each being a line in the
	 * text document.
	 */
	public ArrayList<String> textToString(){ //start method

		ArrayList<String> words = new ArrayList<String>(); //list of lines

		String str = null; //string to be a line

		try { //start try

			FileReader fileReader = new FileReader(this.getFileName());

			BufferedReader buffReader = new BufferedReader(fileReader);

			while((str = buffReader.readLine()) != null){ //while the next line in the text isn't null

				if(str.isEmpty()){ // excludes newlines with no text to be added

				} else {

					words.add(str); //adds new line to the list

				} //end if else chain

			} //end while

			buffReader.close(); //need to close buffer readers

		} catch (FileNotFoundException e) { //can't find the file, so send an error

			System.out.println("Cannot open given file name: " + this.getFileName());

		} catch (IOException e) { //cannot read a file, so send an error

			System.out.println("Cannot read given file: " + this.getFileName());

		} //end catch

		return words;

	} //end method

	/* parseStrings Method
	 * Purpose: this method takes the list of lines, then turns each 
	 * line into an array of words by splitting them up whenever there is a space
	 * character, then adding them to a ChainHashMap. If there is no cases of the
	 * string existing in the hash yet, it gets added with a value/frequency of 1. 
	 * If it has occurred, the value/frequency is changed by increasing it by 1. 
	 * Some special cases in the formatting of the given text file are also dealt 
	 * with here.
	 * Parameters: the list of words from the file.
	 * Returns: a ChainHashMap of each word and it's frequency.
	 */
	public ChainHashMap<String, Integer> parseStrings(ArrayList<String> lines){ //start method

		ChainHashMap<String, Integer> hash = new ChainHashMap<String, Integer>();

		for(int i = 0; i < lines.size(); i++){ //star for i

			String collection = lines.get(i);

			if(collection.contains("C sar")){ //Caesar was C sar in the text multiple times, this is used to fix those instances

				String newCollection = ""; //to correct C sar

				for(int m = 0; m < collection.length(); m++){ //start for m

					if(collection.charAt(m) == 'C' && collection.charAt(m + 1) == ' '){ //if C sar is the string

						if(m == 0){ //if C sar is the first word in the line

							newCollection += "Caesar "; //change to Caesar
							newCollection += collection.substring(m + 5, collection.length()); //add rest of string behind it

						} else { //C sar is in the middle of the line

							newCollection += collection.substring(0, m - 1); //add what's before C sar
							newCollection += " Caesar"; //change to Caesar
							newCollection += collection.substring(m + 5, collection.length()); //add what's after C sar

						} //end else if chain

					} //end if

				} //end m for

				collection = newCollection; // changes line to correct version

			} //end if

			//			System.out.println(collection);

			String[] str = collection.split(" "); //splits the lin into words whenever a space occurs

			for(int j = 0; j < str.length; j++){ //start for j

				String lowerCase = str[j].toLowerCase(); //changes the string to all lower case letters

				char[] letters = lowerCase.toCharArray(); //gets an array of all the characters in the word

				if(letters.length == 1 && Character.isAlphabetic(letters[0]) == false){ //eliminates sole punctuation from being added

				} else if(letters.length > 1 && Character.isAlphabetic(letters[1]) == false){ //eliminates cases of two punctuation attached to each other


				} else if(letters.length > 1 && Character.isAlphabetic(letters[0]) == false && Character.isAlphabetic(letters[letters.length - 1]) == false){

					lowerCase = str[j].substring(1, str[j].length() - 1);

				} else if(letters.length > 1 && Character.isUpperCase(letters[0]) == true){

					Character.toUpperCase(lowerCase.charAt(0));

				} else if(hash.get(lowerCase) == null){ //if the string key has never been added to the hash yet

					hash.put(lowerCase, 1);
					//						System.out.println(str[j] + " " + hash.get(str[j]));

				} else if(hash.get(lowerCase) != null){ //if the string key has been added to the hash before, aka a collision

					int total = (int) hash.get(lowerCase); //numerical value of the string key
					hash.remove(lowerCase); //removes old value
					hash.put(lowerCase, total + 1); //changes value by adding one

					//						System.out.println(str[j] + " " + hash.get(str[j]));

				} //end else if chain

			} //end for j

		} //end i for



		return hash;

	} //end method

	/* convertHashAndSort Method
	 * Purpose: this method takes the ChainHashMap that was created of all the words and
	 * frequencies, and creates an array list of entries to sort the entries of each word
	 * by their frequency. It then sorts them using the Collections in java.
	 * Parameters: the ChainHashMap of all the words in the text file
	 * Returns: an arraylist of all the entries in the ChainHashMap, sorted from
	 * greatest to least.
	 */
	public ArrayList<Entry<String, Integer>> convertHashAndSort(ChainHashMap<String, Integer> hash){ //start method

		Iterable<Entry<String, Integer>> wordsToSort = hash.entrySet(); //gets iterable of the entries in the ChainHashMap

		ArrayList<Entry<String, Integer>> sortedWords = new ArrayList<Entry<String, Integer>>(); //to be sorted

		ValueComparator comparator = new ValueComparator(sortedWords); //uses custom comparator in order to use Collections sort method

		for(Entry<String, Integer> i : wordsToSort){ //start for each 

			Entry<String, Integer> entry = i; //creates new entry from the ChainHashMap to be added to the list

			sortedWords.add(entry); //adds to the list

		} //end for each

		Collections.sort(sortedWords, comparator); //uses the custom comparator class and sorts the list of words by value

		return sortedWords; //sorted list

	} //end method

	/* printTopThousand Method
	 * Purpose: the purpose of this method is to print
	 * the top 1000 most frequent words in the sorted list
	 * from the text file. The end goal of the project.
	 * Parameters: the list of sorted words by frequency
	 * Returns: nothing
	 */
	public void printTopThousand(ArrayList<Entry<String, Integer>> sortedWords){ //start method

		System.out.println("Top 1000 most frequent words");

		for(int i = 0; i < 1000; i++){ //1005, there are 5 ties for 74, start for i

			Entry<String, Integer> newEntry = sortedWords.get(i); //new entry created to display each entry

			if(newEntry.getKey().length() == 1){ //start if

				System.out.println("Word: " + newEntry.getKey().toUpperCase()); //for words like I and A, proper grammar when they are sole words

			} else {

				System.out.println("Word: " + newEntry.getKey()); //prints the word

			} //end else if chain

			System.out.print("Number of times used: " + newEntry.getValue()); //prints the frequency of the total times the word appears in the text file
			System.out.println(); //new line for neatness

		} //end for i

	} //end method

	/* printAll Method
	 * Purpose: the purpose of this method is to print
	 * all the words with more than 1 frequency, aka at least one collision,
	 * from the text file. The end goal of the project.
	 * Parameters: the list of sorted words by frequency
	 * Returns: nothing
	 */
	public void printAll(ArrayList<Entry<String, Integer>> sortedWords){

		for(int i = 0; i < sortedWords.size(); i++){ //start for i

			Entry<String, Integer> newEntry = sortedWords.get(i); //new entry created to display each entry

			if(newEntry.getValue() < 2){ //words with no collisions are not displayed

			} else if(newEntry.getKey().length() == 1){ //start else if

				System.out.println("Word: " + newEntry.getKey().toUpperCase()); //for words like I and A, proper grammar when they are sole words

				System.out.print("Number of times used: " + newEntry.getValue()); //prints the frequency of the total times the word appears in the text file
				System.out.println(); //new line for neatness

			} else if(newEntry.getKey().length() > 1){ //start else if

				System.out.println("Word: " + newEntry.getKey()); //prints the word

				System.out.print("Number of times used: " + newEntry.getValue()); //prints the frequency of the total times the word appears in the text file
				System.out.println(); //new line for neatness

			} //end else if chain

		} //end for i

	} //end method

} //end class