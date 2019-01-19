/* Bryan Arnold
 * Assignment 6
 * CSE 2100
 * 11/13/16
 */

public class Troll {
	
	/* Troll Class
	 * This class is used to create the queues, trolls, that
	 * are at each bridge. Rules are in place to remove or add
	 * goats, not used, and creation of troll policies are made.
	 */
	
	private String bridgeColor;
	private int totalCoins;
	@SuppressWarnings("unused")
	private final int toll = 20;
	private GoatQueue<GoatPriority, Goat> queue;
	private Troll nexTroll;
	
	/* Troll Constructor
	 * Each troll has a color, the amount of coins it collected,
	 * and a queue, or policy, that it holds at each bridge.
	 */
	public Troll(String bridgeColor, GoatQueue<GoatPriority, Goat> queue){
		
		this.bridgeColor = bridgeColor;
		this.totalCoins = 0;
		this.queue = queue;
		
	} //end constructor
	
	public void addNextTroll(Troll nextTroll){ //sets the next bridge of a troll
		
		this.nexTroll = nextTroll;
		
	} //end method
	
	/* addGoat Method
	 * This method adds a goat from a previous bridge to the 
	 * new bridge.
	 */
	public void addGoat(Goat goat){
		
		GoatPriority priority = new GoatPriority(goat);
		
		this.getGoatQueue().insert(priority, goat);
		
	} //end method
	
	/* removeGoat Method
	 * This method removes a goat from the queue
	 * if it runs out of coins or it needs to move
	 * to the next bridge after crossing the previous
	 * one.
	 */
	public void removeGoat(Goat goat){
		
		if(goat.coinChecker(goat) == false){
			
		} //end if
		
	} //end method


	public int getTotalCoins() { //gets the total coins of the troll
		
		return totalCoins;
		
	} //end method

	public void setTotalCoins(int totalCoins) { //sets the total coins of the troll
		
		this.totalCoins = totalCoins;
		
	} //end method

	public String getBridgeColor() { //gets the troll's bridge color
		
		return bridgeColor;
		
	} //end method

	public void setBridgeColor(String bridgeColor) { //sets the troll's bridge color
		
		this.bridgeColor = bridgeColor;
		
	} //end method


	public Troll getNexTroll() { //gets the next bridge
		
		return nexTroll;
		
	} //end method


	public void setNexTroll(Troll nexTroll) { //sets the next bridge troll
		
		this.nexTroll = nexTroll;
		
	} //end method
	
	public GoatQueue<GoatPriority, Goat> getGoatQueue(){ //gets the queue of a troll
		
		return this.queue;
		
	} //end method
	
	
	public static void main(String[] args) { //for testing
		
		Goat goat = new Goat("Black");
		
		GoatQueue<GoatPriority, Goat> queue = new GoatQueue<GoatPriority, Goat>();
		
		Troll troll = new Troll("Black", queue);
		
		troll.addGoat(goat);
		
	} //end method

} //end class
