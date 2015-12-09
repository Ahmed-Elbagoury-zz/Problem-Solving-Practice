//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestInreasingSequence{
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;    
        int [] lis = new int [n];
        int sol = 0;
        for(int i = n-1; i>= 0; i--){
            int max = 1;
            for(int j = i+1; j < n; j++){
                if(nums[j] > nums[i]){
                    max = max > 1 + lis[j] ? max : 1+lis[j];
                }
            }
            lis[i] = max;
            sol  = sol > max? sol:max;
        }
        return sol;
    }
}