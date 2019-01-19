import java.text.DecimalFormat; //used to make the percentage chance look neater
import java.util.Scanner; //used for user input, to make the main method less dense, as well as more interactive and specific

/* Main Class
 * This class tests out and performs
 * the methods from the Birthday class, and
 * performs the desired experiment 100,000 times
 * for each number of desired people. 
 * Differing design choices: instead of repeating the same
 * process below for differing number of people, I chose to
 * take system input from the user to get my output and save code.
 * This also makes it more interactive, less cluttered in the
 * output box, and overall less code.
 */
public class Main {

	public static void main(String args[]){ //main method, same purpose as main class

		Scanner s = new Scanner(System.in); //to get input
		System.out.print("Enter the number of people for the experiment: ");
		int people = s.nextInt();

		//values to track number of runs versus number of matches and the percentage
		int run = 1;
		int matches = 0;
		double percent = 0.0;

		Birthday birthday = new Birthday(); //defauly constructor to begin the experiments

		while(run <= 100000){ //begin while loop, runs 100,000 times to meet the desired 100,000 experiments

			Birthday[] birthdays = birthday.createBirthdays(people); //creates a new collection and assigns its members using the createBirthdays method

			int match = birthday.birthdayChecker(birthdays); //runs the birthdayChecker method to find matching birthdays

			matches = matches + match; //total experiments where birthdays matched

			run++; //incrementing number of experiments run

			if(run == 100000){

				percent = ((double)matches / (double)run) * 100; //calculates percentage chance for two people to share birthday
				DecimalFormat numberFormat = new DecimalFormat("#.000"); //makes decimal neater and specific

				System.out.println("For every 100,000 experiments with " + people + " people there were " + matches + " experiments where two people shared the same birthday."); //display
				System.out.println("This can be seen as " + matches + "/" + run + ", or around a " + numberFormat.format(percent) + "% chance for a group of " + people + " people to have at least one shared \nbirthday between two people."); //display

			} //end if

		} //end while loop

		s.close(); //closes scanner

	} //end main method

} //end class
