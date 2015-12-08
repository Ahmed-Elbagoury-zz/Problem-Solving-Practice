//https://leetcode.com/problems/maximum-subarray/
public class MaxSubArray{
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int [] x = new int [nums.length];
        int [] y = new int [nums.length];
        int [] z = new int [nums.length];
        
        //sum(i -> j) = sum(0 -> j) - sum(0 -> i-1)
        x[0] = nums[0];
        y[0] = 0;
        z[0] = x[0];
        int max = z[0];
        for(int i = 1; i < nums.length; i++){
            x[i] = x[i-1] + nums[i];
            y[i] = x[i-1] < y[i-1] ? x[i-1] : y[i-1];
            z[i] = x[i] - y[i];
            max = max > z[i] ? max : z[i];
        }
        return max;
    }

}