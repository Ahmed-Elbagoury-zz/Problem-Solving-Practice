//https://leetcode.com/problems/maximum-product-subarray/
//http://www.programcreek.com/2014/03/leetcode-maximum-product-subarray-java/ 
public class MaxProduct{
	public int maxProduct(int[] nums) {
         if(nums == null || nums.length == 0)
             return 0;
         int localMax = nums[0];
         int localMin = nums[0];
         int maxProd = localMax;
         for(int i = 1; i < nums.length; i++){
             if(nums[i] > 0){
                 localMax = Math.max(localMax * nums[i], nums[i]);
                 localMin = Math.min(localMin * nums[i], nums[i]);
             }
             else{
                 int temp = Math.max(localMin * nums[i], nums[i]);//As localMax will be used in next line
                 localMin = Math.min(localMax * nums[i], nums[i]);
                 localMax = temp;
             }
             maxProd = maxProd > localMax ? maxProd : localMax;
         }
         return maxProd;
     }

     public int maxProduct2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;    
        int [] max = new int[n];
        int [] min = new int[n];
        max[0] = nums[0];
        min[0] = nums[0];
        int sol = nums[0];
        for(int i = 1; i < n; i++){
            int val1 = Math.max(nums[i], Math.max(nums[i] * max[i-1], nums[i] * min[i-1]));
            int val2 = Math.min(nums[i], Math.min(nums[i] * max[i-1], nums[i] * min[i-1]));
            max[i] = val1 > val2 ? val1 : val2;
            min[i] = val1 < val2 ? val1 : val2;
            sol = max[i] > sol ? max[i] : sol;
        }
        return sol;
    }
}
