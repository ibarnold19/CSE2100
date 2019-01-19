/* Bryan Arnold
 * Assignment 6
 * CSE 2100
 * 11/13/16
 */

import java.util.ArrayList; //imports for use of goats

public class World {
	
	/* World Class
	 * This class puts the pieces of the program
	 * together. This class basically sets up the initial
	 * parts of the simulation then has methods that keep
	 * the simulation rolling throughout the 10000 time units.
	 */
	
	private int time;
	private Troll[] bridges = new Troll[3];
	private ArrayList<Goat> blackGoats = new ArrayList<Goat>();
	private ArrayList<Goat> greyGoats = new ArrayList<Goat>();
	private ArrayList<Goat> whiteGoats = new ArrayList<Goat>();
	
	
	public void setTime(int time) { //sets the time of the simulation
		
		this.time = time;
		
	} //end method
	
	/* World Constructor
	 * This method sets the initial condition of the simulation. It creates
	 * 3 goats and troll, puts the goats at the same colored bridge and sets
	 * trolls and goats the respective classes.
	 */
	public World(int time){
		
		this.time = time;
		GoatComparator comparator = new GoatComparator();
		
		Goat firstBlack = new Goat("Black");
		Goat firstGrey = new Goat("Grey");
		Goat firstWhite = new Goat("White");
		
		GoatQueue<GoatPriority, Goat> blackQueue = new GoatQueue<GoatPriority, Goat>(comparator);
		GoatQueue<GoatPriority, Goat> greyQueue = new GoatQueue<GoatPriority, Goat>(comparator);
		GoatQueue<GoatPriority, Goat> whiteQueue = new GoatQueue<GoatPriority, Goat>(comparator);
		
		Troll blackTroll = new Troll("Black", blackQueue);
		Troll greyTroll = new Troll("Grey", greyQueue);
		Troll whiteTroll = new Troll("White", whiteQueue);
		
		this.blackGoats.add(firstBlack);
		this.greyGoats.add(firstGrey);
		this.whiteGoats.add(firstWhite);
		
		blackTroll.addGoat(firstBlack);
		greyTroll.addGoat(firstGrey);
		whiteTroll.addGoat(firstWhite);
		
		blackTroll.setNexTroll(greyTroll);
		greyTroll.setNexTroll(whiteTroll);
		whiteTroll.setNexTroll(blackTroll);
		
		this.bridges[0] = blackTroll;
		this.bridges[1] = greyTroll;
		this.bridges[2] = whiteTroll;
		
	} //end method
	
	public Troll[] getBridges() { //gets the troll bridges
		
		return bridges;
		
	} //end method



	public void setBridges(Troll[] bridges) { //sets the troll bridges
		
		this.bridges = bridges;
		
	} //end method


	public ArrayList<Goat> getBlackGoats() { //gets the goats at the black bridge
		
		return blackGoats;
		
	} //end method


	public void setBlackGoats(ArrayList<Goat> blackGoats) { //sets the goats at the black bridge
		
		this.blackGoats = blackGoats;
		
	} //end method


	public ArrayList<Goat> getGreyGoats() { //gets the goats at the grey bridge
		
		return greyGoats;
		
	} //end method


	public void setGreyGoats(ArrayList<Goat> greyGoats) { //sets the goats at the grey bridge
		
		this.greyGoats = greyGoats;
		
	} //end method


	public ArrayList<Goat> getWhiteGoats() { //gets the goats at the white bridge
		
		return whiteGoats;
		
	} //end method


	public void setWhiteGoats(ArrayList<Goat> whiteGoats) { //sets the goats at the white bridge
		
		this.whiteGoats = whiteGoats;
		
	} //end method


	public int getTime(){ //gets the time of the simulation
		
		return this.time;
		
	} //end method

	/*adjuster Method
	 * This method adjusts the order of the goats in
	 * a bridge based on whether they will pay and
	 * their color.
	 */
	public void adjuster(ArrayList<Goat> goats, Troll troll){

		ArrayList<Goat> temp = goats;

		if(troll.getBridgeColor() == "Black"){

			for(int j = 0; j < goats.size(); j++){

				if(goats.get(j).getColor() != "Black" && goats.get(j).getWillPay() == true){

					temp.remove(j);

					if(goats.get(j).getColor() != "Black"){

						temp.add(goats.get(j));

					} //end if

				}//end if

			} //end j for

		} else if(troll.getBridgeColor() == "White"){

			for(int i = 0; i < goats.size(); i++){

				if(goats.get(i).getColor() != "White" && goats.get(i).getWillPay() == true){

					temp.remove(i);

					if(goats.get(i).getColor() != "White"){

						temp.add(goats.get(i));

					} //end if

				} //end if

			} //end i for

		} //end else if chain

		goats = temp;

	} //end method

} //end class

