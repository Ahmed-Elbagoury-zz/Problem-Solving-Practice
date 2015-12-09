//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
public class MinInRotatedArray2{
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        //0 1 2 3 4 5 6 7 8  -> 7 8 0 1 2 3 4 5 6    
        return helper(nums, 0, nums.length -1);
    }
    
    int helper(int [] nums, int st, int end){
        if(st == end)
            return nums[st];
        int mid = st + (end-st)/2;
        int min1 = Integer.MAX_VALUE;
        if(nums[mid+1] < nums[end])    
            min1 = nums[mid+1];
        else
            min1 =  helper(nums, mid+1, end);
        int min2 = Integer.MAX_VALUE;
        if(nums[st] < nums[mid])
            min2 = nums[st];
        else
            min2 = helper(nums, st, mid);
        return min1 < min2 ? min1 : min2;    
    }


}