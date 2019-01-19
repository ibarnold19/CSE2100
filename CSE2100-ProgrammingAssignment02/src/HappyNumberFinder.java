import java.util.Scanner; //import for user desired number

/*HappyNumberFinder Class
 * Purpose: to find out whether or not the desired
 * number in question is happy or not. Using method that replicate the 
 * method of finding happy numbers.
 */
public class HappyNumberFinder{

	private int counter = 0; //to break out of checking
	private Long result; //result of each new calculation
	private Long initial; //initial number
	
	/*HappyNumberFinder Constructor
	 * Purpose: creates an object that will help in using the other 
	 * methods of the class in determining whether or not something is a happy
	 * number.
	 * Parameters: int counter, Long num, Long initial, all needed to
	 * track current calculated value, break out of loops, and initial number.
	 */
	public HappyNumberFinder(int counter, Long num, Long initial){
		
		this.counter = counter;
		this.result = num;
		this.initial = initial;
		
	} //end constructor
	
	//standard getter
	public int getCounter(){
		
		return this.counter;
		
	}
	
	//standard setter
	public void setCounter(int counter){
		
		this.counter = counter;
		
	}
	
	//standard getter
	public Long getInitial(){
		
		return this.initial;
		
	}
	
	//standard setter
	public void setInitial(Long initial){
		
		this.initial = initial;
		
	}
	
	//seperates the strong into single strongs to be converted to longs
	public String[] seperateString(String s){
		
		String[] a = new String[s.length()];
		
		for(int i = 0; i < a.length; i++){
			
			a[i] = Character.toString(s.charAt(i));
			
		}
		
		return a;
	} //end method
	
	//converts each single string character into a long for calculations
	public Integer[] stringToInteger(String[] s){
		
		Integer[] numbers = new Integer[s.length];
		
		for(int i = 0; i < s.length; i++){
			
			numbers[i] = Integer.valueOf(s[i]);
			
		}
		
		return numbers;
		
	}

	//squares each single digit converted and adds them
	public Long squareAndAdd(Integer[] nums){
		
		Long result = (long) 0;
		
		for(int i = 0; i < nums.length; i++){
			
			result += nums[i] * nums[i];
			
			if(i == nums.length - 1){
				
				System.out.print(nums[i] + "^2 = " + result);
				
			} else {
				
				System.out.print(nums[i] + "^2 + ");
				
			}
		
			
		}
		
		System.out.println("");
		
		return result;
		
	}
	
	//compares the node element values in the linked list as well as adds them
	//then determines if the number is happy or not
	public void addToListCompare(LinkedList<Long> list, Long result){
		
		if(list.getSize() == 0){
			
			list.addFirst(result);
			
		} else {
		
		list.addLast(result);
		
		}
		
		if(list.getSize() > 1){
		
			outerloop:
		for(int i = 0; i < list.getSize(); i++){
			
			for(int j = 0; j < list.getSize(); j++){
				
			if(result == 1){
				
				System.out.println("The number " + this.getInitial() + " is happy");
				
				this.setCounter(1);
				
				break outerloop;
				
			} else if(i == j){
				
			} else if(list.get(i) == list.get(j)){
				
				System.out.println("The number " + this.getInitial() + " is not happy");
				
				this.setCounter(1);
				
				break outerloop;
				
			}
			
		}
			
		}
		
		}

			this.setResult(result);
		
	}
	
	//an easier method to repeat the process of determinging happy number
	public void happyNumberProcess(LinkedList<Long> list){
		
		Long num = this.getResult();
		
		String s = num.toString();
		
		String[] str = this.seperateString(s);
		
		Integer[] nums = stringToInteger(str);
		
		this.setResult(this.squareAndAdd(nums));
		
		this.addToListCompare(list, this.getResult());
		
	}
	
	//main method
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		
		String str = s.nextLine();
		
		Long num = Long.valueOf(str);
		
		HappyNumberFinder a = new HappyNumberFinder(0, num, num);
		
		a.setResult(num);
		
		a.setInitial(num);
		
		LinkedList list = new LinkedList();
		
		while(a.getCounter() == 0){
		
		a.happyNumberProcess(list);
		
		}


	}

	//simple getter
	public Long getResult() {
		return result;
	}

	//simple setter
	public void setResult(Long num) {
		this.result = num;
	}

}
