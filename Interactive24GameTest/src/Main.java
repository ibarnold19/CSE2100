import java.util.Scanner; //user input

/* Main Class
 * Purpose: this class will be used to fully run all of the
 * other classes in motion and be the interactive portion of the
 * program. This would be the various choices for the user and corrections of their input.
 * INCOMPLETE
 */
public class Main { //start class

	public static void main(String[] args) {

		int checker = 0; //breaker
		Scanner s = new Scanner(System.in);

		System.out.println("Welcome to the interactive 24 game!!!");


		while(checker == 0){

			System.out.println("Card options: A (=1), 2, 3, 4, 5, 6, 7, 8, 9, 10, J (=11), Q (=12), K(=13)");
			System.out.println("To quit at any time, type Bye");
			System.out.println("Please input four cards you would like to see if they can possibly equal 24. Please enter the cards with a space inbetween them: ");

			String input = s.next();
			StringBuilder str = new StringBuilder();

			for(int i = 0; i < input.length(); i++){

				if(input.charAt(i) == ' '){}

				if(input.charAt(i) == 'A'){

					str.append(1);

				} else if(input.charAt(i) == 'J'){


					str.append(11);


				} else if(input.charAt(i) == 'Q'){

					str.append(12);

				} else if(input.charAt(i) == 'K'){

					str.append(13);


				} else if(Character.isDigit(input.charAt(i)) == true && Character.getNumericValue(input.charAt(i)) < 13 && Character.getNumericValue(input.charAt(i)) > 0){

					str.append(input.charAt(i));

				} else if(input.length() > 7 && input.length() < 7 && input.length() < 0){


					System.out.println("You have entered too many things as your input. Only pick four of the cards, and put a space inbetween each card.");
					break;

				} else if(input.compareTo("Bye") == 0 || input.compareTo("bye") == 0){

					System.out.println("Thanks for playing.");
					checker = 1;
					break;

				}  else if(str.toString().length() == 7){

					System.out.println(str.toString());
					checker = 1;
					break;

				}else{

					System.out.println("Invalid input choice.");
					break;

				} 

			}

		}

	} //end method

} //end class

