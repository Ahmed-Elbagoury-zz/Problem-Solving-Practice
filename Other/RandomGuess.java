import java.util.Random;

public class Solution {
   int target = 1;
   int count = 0;
   public int guess(int low, int high){
	   count++;
	   if(low == high)
		   return low;
	   int middle = 0;
	   if(high > 0 && low < 0)
		   middle = (high + low)/2;
	   else
	   		middle = low + (high - low)/2;
	   int flag = verify(middle);
	   if(flag == 0)
		   return middle;
	   if(flag == 1)
		   return guess(low, middle -1);
	   return guess(middle+1, high);
   }
   
   public int verify(int curGuess){
	   if(curGuess == target)
		   return 0;
	   return curGuess > target ? 1 : -1;
   }
    
    public static void main(String [] args){
    	Solution solution = new Solution();
    	Random random = new Random();
    	solution.target = random.nextInt();
    	solution.count = 0;
    	System.out.println("Target is = " + solution.target);
    	System.out.println(solution.guess(Integer.MIN_VALUE, Integer.MAX_VALUE) + ". Count = " + solution.count);
    	
    }
}
