/* Bryan Arnold
 * Assignment 6
 * CSE 2100
 * 11/13/16
 */

public class GoatPriority {
	
	/* GoatPriority Class
	 * This class is responsible for updating each goat's
	 * coin values, keeping track of the wait time of each
	 * goat, and updating the wait time as well. Each goat should have 
	 * a wait time (not completed/implemented).
	 * CLASS NOT USED DUE TO NOT BEING FINISHED
	 */
	
	private int waitTime;
	private boolean willPay;
	private Goat goat;
	private Troll troll;
	
	public Troll getTroll() { //gets the troll
		
		return troll;
		
	} //end method

	public void setTroll(Troll troll) { //sets the troll
		
		this.troll = troll;
		
	} //end method

	/* GoatPriority Constructor
	 * A priority will have a goat as well as
	 * a wait time and whether or not the specified goat will
	 * pay or not.
	 */
	public GoatPriority(Goat goat){
		
		this.goat = goat;
		this.waitTime = goat.getWaitTime();
		this.willPay = goat.getWillPay();
		
	} //end constructor
	
	/* update Method
	 * This method updates the coins and wait time of a goat, depending where they are and whether they want 
	 * to pay. Not sure whether to put this in Goat class or here, so I included different
	 * versions in both.
	 */
	public void update(){
		
		if (this.goat.getWillPay() == true && troll.getBridgeColor().compareTo("Black") == 0 && goat.getColor().compareTo("Black") != 0){
			
			goat.payToll(troll);
			waitTime = waitTime - 1;
			goat.setBlackCoins(goat.getBlackCoins() - 1);
			goat.setGreyCoins(goat.getGreyCoins() - 1);
			goat.setWhiteCoins(goat.getWhiteCoins() - 1);
			
		} //end if
		
		if (this.goat.getWillPay() == true && troll.getBridgeColor().compareTo("White") == 0 && goat.getColor().compareTo("White") != 0){
			
			goat.payToll(troll);
			waitTime = waitTime - 1;
			goat.setBlackCoins(goat.getBlackCoins() - 1);
			goat.setGreyCoins(goat.getGreyCoins() - 1);
			goat.setWhiteCoins(goat.getWhiteCoins() - 1);
			
		} //end if
		
		if (this.goat.getWillPay() == true && troll.getBridgeColor().compareTo("Grey") == 0 && goat.getColor().compareTo("Grey") != 0){
			
			goat.payToll(troll);
			waitTime = waitTime - 1;
			goat.setBlackCoins(goat.getBlackCoins() - 1);
			goat.setGreyCoins(goat.getGreyCoins() - 1);
			goat.setWhiteCoins(goat.getWhiteCoins() - 1);
			
		} //end if
		
		if(this.goat.getWillPay() == false){
			
			waitTime = waitTime - 1;
			goat.setBlackCoins(goat.getBlackCoins() - 1);
			goat.setGreyCoins(goat.getGreyCoins() - 1);
			goat.setWhiteCoins(goat.getWhiteCoins() - 1);
			
		} //end if
		
	} //end method

	public boolean isWillPay() { //gets whether or not a goat will pay
		
		return willPay;
		
	} //end method

	public void setWillPay(boolean willPay) { //sets the goat's will pay
		
		this.willPay = willPay;
		
	} //end method
	
	public int getWaitTime(){ //gets the wait time of the goat
		
		return waitTime;
		
	} //end method
	
	public void setWaitTime(int waitTime){ //sets the wait time of the goat
		
		this.waitTime = waitTime;
		
	} //end method
	
	public static void main(String[] args) { //for testing
		
		Goat goat = new Goat("Grey");
		GoatQueue<GoatPriority, Goat> queue = new GoatQueue<GoatPriority, Goat>();
		Troll troll = new Troll("White", queue);
		goat.strategy(troll);
		GoatPriority priority = new GoatPriority(goat);
		priority.setTroll(troll);
		
		priority.update();
		System.out.println(goat.coinChecker(goat));
		System.out.println(troll.getTotalCoins());
		
	} //end method
	
} //end class
