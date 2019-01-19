/*`Bryan Arnold
 * CSE 2100
 * 9/7/2016
 * Assignment 1: Birthday Paradox
 */

import java.util.Random; //imported to make random days and months for later

/* Birthday Class
 * Purpose: The purpose of this class, and this assignment
 * as a whole, is to simulate the birthday paradox. This is
 * that when there are at least 23 people in the room, the 
 * chance people sharing a birthday is 50%. This class
 * is responsible for the creation and checking of the
 * birthdays to see if any match.
 */

public class Birthday { //beginning of class

	//member variables for birthdays
	private int day;
	private int month;

	public Birthday(){} //default constructor

	/*Birthday Constructor
	 * Creates a birthday of one person. 
	 * Parameters: int day, int month
	 * The number of the day and the month
	 * are required to get the date for a
	 * birthday.
	 */
	public Birthday(int day, int month){

		this.day = day;
		this.month = month;

	} //end constructor

	public int getMonth(){ //gets the month currently stored in the member variable

		return month;

	}

	public void setMonth(int month){ //sets the month value in the member variable to something else

		this.month = month;

	}

	public int getDay(){ //gets the day currently stored in the day member variable

		return day;

	}

	public void setDay(int day){ //sets the day value in the member variable to something else

		this.day = day;

	}

	/* createBirthdays Method
	 * Purpose: This method creates a collection of birthdays
	 * equivalent to the\ amount of people, and assigns
	 * a random day and month to each birthday 
	 * (months are from 1 to 12, while days are
	 * 1 to 31 depending on the month). 
	 * Parameters: int people
	 * The number of people determines how many birthdays need to be created.
	 * Returns: Birthday[]
	 * An array, a collection, of the created birthdays
	 * will be returned, this makes comparison of similar
	 * birthdays easier down the line.
	 */
	public Birthday[] createBirthdays(int people){

		Birthday[] birthdays = new Birthday[people]; //new array of birthdays the size of the number of people
		Random rand = new Random(); //for generating random day and month values

		for(int i = 0; i < people; i++){ //start i loop

			birthdays[i] = new Birthday(); //initializes each birthday to be the default constructor to avoid NullPointerException

			birthdays[i].setMonth(rand.nextInt(12) + 1); //sets the month

			if(birthdays[i].getMonth() == 2){

				birthdays[i].setDay(rand.nextInt(28) + 1); //sets day

			} else if(birthdays[i].getMonth() == 4 || birthdays[i].getMonth() == 6 || birthdays[i].getMonth() == 9 || birthdays[i].getMonth() == 11){

				birthdays[i].setDay(rand.nextInt(30) + 1); //sets day

			} else {

				birthdays[i].setDay(rand.nextInt(31) + 1); //sets day

			} //end if else if else chain

		} //end i loop

		return birthdays; //the collection of birthdays is returned

	} //end method

	/*birthdayChecker Method
	 * Purpose: this method compares the day and month
	 * of each randomly created birthday to see if they 
	 * are the same, thus a match of two people with the same
	 * birthday is found. The program breaks once a pair is found
	 * to save CPU time.
	 * Parameters: Birthday[] birthdays
	 * The collection of created birthdays from the createBirthdays
	 * method is used for comparison checking.
	 * Returns: int
	 * The number of pairings is returned, which will
	 * always be 1 since the method is closed once a match
	 * is found.
	 */
	public int birthdayChecker(Birthday[] birthdays){

		int matches = 0;

		for(int i = 0; i < birthdays.length; i++){ //begin i loop

			for(int j = 0; j < birthdays.length; j++){ //begin j loop

				if(j == i){ //does nothing to prevent a birthday being checked on itself

				}

				else if(birthdays[i].getDay() == birthdays[j].getDay() && birthdays[i].getMonth() == birthdays[j].getMonth()){ //checks if two birthdays match

					matches++; 

					return matches; //always returns 1

				} //end if else if chain

			} //end j loop

		}//end i loop

		return matches; //returns 1, the matches of the same birthday, will be 0 meaning none were found.

	} //end method

} //end class
