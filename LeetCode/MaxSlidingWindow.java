//https://leetcode.com/problems/sliding-window-maximum/
public class MaxSlidingWindow{
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return new int [] {};
        int st = 0;
        int end = k-1;
        int [] maxArray = new int [nums.length - k + 1];
        int maxIndex = 0;
        while(end < nums.length){
            int max = Integer.MIN_VALUE;
            for(int i = st; i<= end; i++)
                max = max > nums[i] ? max : nums[i];
            maxArray[maxIndex++] = max;
            st ++;
            end ++;
        }
        return  maxArray;
    }

}