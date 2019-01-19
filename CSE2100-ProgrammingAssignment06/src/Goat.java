/* Bryan Arnold
 * Assignment 6
 * CSE 2100
 * 11/13/16
 */

public class Goat {
	
	/* Goat Class
	 * This class creates a goat object to be put in bridges' queues. A goat
	 * have a wait time in the queue, 100 coins of
	 * each color, a color of its own, and a decision
	 * on whether or not to pay a toll.
	 */
	
	private String color;
	private int blackCoins;
	private int greyCoins;
	private int whiteCoins;
	private int waitTime;
	private Troll currentTroll;
	private boolean willPay;
	
	/* Goat Constructor
	 * Sets the default coin count of
	 * each color, the goat's color, the default
	 * wait time, and the default decision to pay being 
	 * no.
	 */
	public Goat(String color){
		
		this.color = color;
		this.blackCoins = 100;
		this.whiteCoins = 100;
		this.greyCoins = 100;
		this.waitTime = 1;
		this.willPay = false;

	} //end constructor
	
	public boolean forcePay(){ //forces a goat to pay without making it pay, not sure why put in the skeleton structure
		
		return true;
		
	} //end method
	
	public void addTrollBridge(Troll troll){ //gives the goat a bridge that it is currently at
		
		this.currentTroll = troll;
		
	} //end method
	
	/* strategy Method
	 * This method determines whether or not a goat will pay at a
	 * given time. The full details of how a goat will pay are
	 * in the report.
	 */
	public void strategy(Troll currentTroll){
		
		if((this.getColor().compareTo("Black") == 0 && this.getBlackCoins() > 20) || (this.getColor().compareTo("White") == 0 && this.getWhiteCoins() > 20)){
			
			if(this.getColor().compareTo(currentTroll.getBridgeColor()) == 0){
				
				if(currentTroll.getGoatQueue().getSize() == 0){
					
					this.setWillPay(false);
	
				} //end if
				
			} else {
				
				this.setWillPay(true);
				
			} //end if else chain
			
		} else if(this.getColor().compareTo("Grey") == 0){
			
			if(currentTroll.getBridgeColor().compareTo("Black") == 0 || currentTroll.getBridgeColor().compareTo("White") == 0){
				
				this.setWillPay(true);
			
				
			} else if(currentTroll.getBridgeColor().compareTo("Grey") == 0){
				
				this.setWillPay(false);
				
			} //end if else chain
			
		} //end if else chain
		
	} //end method
	
	//Thought I would use this method from skeleton structure, not needed
//	public boolean willPay() {
//		
//		if(this.getColor().compareTo("Black") == 0 || this.getColor().compareTo("White") == 0){
//			
//			if(this.getColor().compareTo(this.getTroll().getBridgeColor()) == 0){
//				
//				if(this.getTroll().getGoatQueue().isEmpty() == false){
//					
//					this.setWillPay(true);
//
//					
//				}
//				
//			}
//			
//		} else if(this.getColor().compareTo("Grey") == 0){
//			
//			if(this.getTroll().getBridgeColor().compareTo("Black") == 0 || this.getTroll().getBridgeColor().compareTo("White") == 0){
//				
//				this.setWillPay(true);
//				
//				return true;
//				
//			}
//			
//		} 
//		
//		return false;
//		
//	}
	
	public void resetWait(){ //resets the goat's wait time to default, not sure why needed from the skeleton structure
		
		this.waitTime = 1;
		
	} //end method
	
	/* payToll Method
	 * This method makes a goat pay when it
	 * enters the queue of a troll's bridge
	 * and increases the total coins that the troll
	 * has.
	 */
	public void payToll(Troll troll){
		
		String color = troll.getBridgeColor();
		
		if(color.compareTo("Black") == 0){
			
			this.setBlackCoins(this.getBlackCoins() - 20);
			
			troll.setTotalCoins(troll.getTotalCoins() + 20);
			
//			System.out.println("Troll coins: " + troll.getTotalCoins());

			
		} else if(color.compareTo("White") == 0){
			
			this.setWhiteCoins(this.getWhiteCoins() - 20);
			
			troll.setTotalCoins(troll.getTotalCoins() + 20);
			
//			System.out.println("Troll coins: " + troll.getTotalCoins());

			
		} else if(color.compareTo("Grey") == 0){
			
			this.setGreyCoins(this.getGreyCoins() - 20);
			
			troll.setTotalCoins(troll.getTotalCoins() + 20);
			
//			System.out.println("Troll coins: " + troll.getTotalCoins());
			
		} //end if else chain
		
	} //end method
	
	/* getCoins Method
	 * This method just gets an
	 * array representation of the goat's
	 * coins to easily check whether or not
	 * a got has 0 coins.
	 */
	public int[] getCoins(Goat goat){
		
		int[] coins = new int[3];
		
		coins[0] = goat.getBlackCoins();
//		System.out.println(goat.getBlackCoins());
		coins[1] = goat.getGreyCoins();
//		System.out.println(goat.getGreyCoins());
		coins[2] = goat.getWhiteCoins();
//		System.out.println(goat.getWhiteCoins());
		
		return coins;
		
	} //end method
	
	/* coinChecker Method
	 * This method checks the coins of
	 * a goat and returns false if the
	 * goat has any type of coin less than
	 * or equal to 0, in which it would be removed.
	 */
	public boolean coinChecker(Goat goat){
		
		int[] coins = goat.getCoins(goat);
		
		int checker = 0;
		
		for(int i = 0; i < coins.length; i++){
			
			if(coins[i] >= 0){
				
				checker++;
				
			} else if(checker == 3){
				
				return true;
				
			} //end if else chain
			
		} //end i for
		
		return false;
		
	} //end method
	
	/* addCoins Method
	 * This method adds 100 of each colored coin
	 * if a goat has gotten back to it's original bridge, 
	 * aka has crossed three bridges.
	 */
	public void addCoins(Goat goat){
		
		goat.setBlackCoins(goat.getBlackCoins() + 100);
		goat.setGreyCoins(goat.getGreyCoins() + 100);
		goat.setWhiteCoins(goat.getWhiteCoins() + 100);
		
	} //end method

	public String getColor() { //gets the color of the goat
		
		return color;
		
	} //end method

	public void setColor(String color) { //sets the color of the goat
		
		this.color = color;
		
	} //end method

	public int getBlackCoins() { //gets the goat's black coins
		
		return blackCoins;
		
	} //end method

	public void setBlackCoins(int blackCoins) { //sets the goat's black coins
		
		this.blackCoins = blackCoins;
		
	} //end method

	public int getGreyCoins() { //gets the goat's grey coins
		
		return greyCoins;
		
	} //end method

	public void setGreyCoins(int greyCoins) { //sets the goat's grey coins
		
		this.greyCoins = greyCoins;
		
	} //end method

	public int getWhiteCoins() { //gets the goat's white coins
		
		return whiteCoins;
		
	} //end method

	public void setWhiteCoins(int whiteCoins) { //sets the goat's white coins
		
		this.whiteCoins = whiteCoins;
		
	} //end method

	public int getWaitTime() { //gets the goat's wait time
		
		return this.waitTime;
		
	} //end method
	
	public void setWaitTime(int waitTime){ //sets the goat's wait time
		
		this.waitTime = waitTime;
		
	} //end method
	
	public boolean getWillPay(){ //gets the goat's decision to pay or not
		
		return this.willPay;
		
	} //end method
	
	public void setWillPay(boolean willPay){ //sets the goat's decision to pay or not
		
		this.willPay = willPay;
		
	} //end method
	
	public Troll getTroll(){ //gets the troll bridge the goat currently is at
		
		return this.currentTroll;
		
	} //end method
	
	/* update Method
	 * This method updates the coins and wait time of a goat, depending where they are and whether they want 
	 * to pay. Not sure whether to put this in GoatPriority class or here, so I included different
	 * versions in both.
	 */
	public void update(){
		
		if (this.getWillPay() == true && this.currentTroll.getBridgeColor().compareTo("Black") == 0 && this.getColor().compareTo("Black") != 0){
			
			this.payToll(currentTroll);
			waitTime = waitTime - 1;
			this.setBlackCoins(this.getBlackCoins() - 1);
			this.setGreyCoins(this.getGreyCoins() - 1);
			this.setWhiteCoins(this.getWhiteCoins() - 1);
			
		} //end if
		
		if (this.getWillPay() == true && currentTroll.getBridgeColor().compareTo("White") == 0 && this.getColor().compareTo("White") != 0){
			
			this.payToll(currentTroll);
			waitTime = waitTime - 1;
			this.setBlackCoins(this.getBlackCoins() - 1);
			this.setGreyCoins(this.getGreyCoins() - 1);
			this.setWhiteCoins(this.getWhiteCoins() - 1);
			
		} //end if
		
		if (this.getWillPay() == true && currentTroll.getBridgeColor().compareTo("Grey") == 0 && this.getColor().compareTo("Grey") != 0){
			
			this.payToll(currentTroll);
			waitTime = waitTime - 1;
			this.setBlackCoins(this.getBlackCoins() - 1);
			this.setGreyCoins(this.getGreyCoins() - 1);
			this.setWhiteCoins(this.getWhiteCoins() - 1);
			
		} //end if
		
		if(this.getWillPay() == false){
			
			waitTime = waitTime - 1;
			this.setBlackCoins(this.getBlackCoins() - 1);
			this.setGreyCoins(this.getGreyCoins() - 1);
			this.setWhiteCoins(this.getWhiteCoins() - 1);
			
		} //end if
		
	} //end method
	
	public static void main(String[] args) { //for testing
		
		Goat goat = new Goat("Black");
		
		GoatQueue<GoatPriority, Goat> queue= new GoatQueue<GoatPriority, Goat>();
		
		queue.setSize(0);
		
		Troll troll = new Troll("Black", queue);
		
		System.out.println(goat.coinChecker(goat));
		
		goat.addCoins(goat);
		
		System.out.println(goat.coinChecker(goat));
		
		goat.payToll(troll);
		
		System.out.println(goat.coinChecker(goat));
		
		goat.strategy(troll);
		
		System.out.println(goat.getWillPay());
		
	} //end method

} //end class
