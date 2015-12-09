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

}