//https://leetcode.com/problems/first-missing-positive/
//http://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/ 
public class FirstMissingPositive{
	public int firstMissingPositive(int[] nums) {
       if(nums == null || nums.length == 0)
           return 1;
       int [] arr = segregate(nums);
       if(arr.length == 0)
            return 1;
       for(int i = 0; i < arr.length; i++){
           int index = Math.abs(arr[i]);
           if(index -1 < arr.length && arr[index-1] > 0){
               arr[index-1] *= -1;
           }
       }
       for(int i = 0; i < arr.length; i++){
           if(arr[i] > 0)
                return i+1;
       }
       return arr.length+1;     
   }
    public int[] segregate (int [] nums){
        int positiveInd = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                int temp = nums[i];
                nums[i] = nums[positiveInd];
                nums[positiveInd++] = temp;
            }
        }    
        int [] arr = new int [nums.length - positiveInd];
        for(int i = positiveInd; i < nums.length; i++){
            arr [i - positiveInd] = nums[i];
        }
        
        return arr;
    }
    
    
    public int firstMissingPositive2(int[] nums) {
	       if(nums == null || nums.length == 0)
	           return 1;
	       int size = segregate2(nums);
	       if(size == 0)
	            return 1;
	       for(int i = 0; i < size; i++){
	           int index = Math.abs(nums[i]);
	           if(index -1 < size && nums[index-1] > 0){
	               nums[index-1] *= -1;
	           }
	       }
	       for(int i = 0; i < nums.length; i++){
	           if(nums[i] > 0)
	                return i+1;
	       }
	       return size+1;     
	    }
	    
	    public int segregate2(int [] nums){
	        int positiveInd = nums.length-1;
	        while(positiveInd >= 0 && nums[positiveInd] <= 0)
	            positiveInd --;
	        int i = 0;    
	        while(i < positiveInd){
	            if(nums[i] <= 0){
	                int temp = nums[i];
	                nums[i] = nums[positiveInd];
	                nums[positiveInd] = temp;
	                while(positiveInd >= 0 && nums[positiveInd] <= 0)
	    	        	positiveInd --;
	            }
	            i++;
	        }
	        return positiveInd+1;
	    }
	    

}
