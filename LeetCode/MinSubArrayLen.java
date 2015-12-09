//https://leetcode.com/problems/minimum-size-subarray-sum/
//http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
public class MinSubArrayLen{
	public int minSubArrayLen(int s, int[] nums) {
         if(nums == null || nums.length == 0 || s < 0)
             return 0;
         int st = 0;
         int end = 1;
         int sum = nums[0];
         int minLen = Integer.MAX_VALUE;
         while(end < nums.length){
             while(sum < s && end < nums.length)
                 sum += nums[end++];
             while(st < end && sum >= s){
                 minLen = minLen < end-st ? minLen : end-st;
                 sum -= nums[st++];
             }
         }
         return minLen == Integer.MAX_VALUE ? 0 : minLen;
     }

}