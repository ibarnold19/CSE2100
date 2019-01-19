/* Bryan Arnold
 * Assignment 6
 * CSE 2100
 * 11/13/16
 */

public class Main {

	/* Main Class
	 * This class is solely just using a main method to
	 * run the simulation. Not complete/working.
	 */
	
	public static void main(String[] args) { //to run
		
		World world = new World(10000);
		
		int checker = 0;
		
		while(world.getTime() > 0){
			
			if(checker == 0){
				
				world.getGreyGoats().add(world.getBlackGoats().get(0));
				world.getBlackGoats().remove(0);
				world.getWhiteGoats().add(world.getGreyGoats().get(0));
				world.getGreyGoats().remove(0);
				world.getBlackGoats().add(world.getWhiteGoats().get(0));
				world.getWhiteGoats().remove(0);
				
				
				
				
				
			} else {
			
			world.adjuster(world.getBlackGoats(), world.getBridges()[0]);
			world.adjuster(world.getGreyGoats(), world.getBridges()[1]);
			world.adjuster(world.getWhiteGoats(), world.getBridges()[2]);
			
			Goat goat = world.getBlackGoats().remove(0);
			world.getGreyGoats().add(goat);
			Goat goat1 = world.getGreyGoats().remove(0);
			world.getWhiteGoats().add(goat1);
			Goat goat2 = world.getWhiteGoats().remove(0);
			world.getBlackGoats().add(goat2);
			
			} //end if else chain
			
			
		} //end while
		
	} //end method
	
} //end class
