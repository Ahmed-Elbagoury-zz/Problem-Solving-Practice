//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray{
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        return helper(nums, 0, nums.length-1, target);    
    }
    
    int helper(int [] nums, int st, int end, int target){
//Base case
        if(st == end)
            return nums[st] == target ? st : -1;
//Base case
        if(st > end)    
            return -1;
        int mid = st + (end-st)/2;
        if(st == mid || nums[st] < nums[mid]){//First half is sorted
            if(nums[st] <= target && target <= nums[mid])
                return BS(nums, st, mid, target);
            else
                return helper(nums, mid+1, end, target);
        }
        else{ //Second half is sorted
            if(nums[mid+1] <= target && nums[end] >= target)
                return BS(nums, mid+1, end, target);
            else
                return helper(nums, st, mid, target);
        }
    }
    
    int BS(int []nums, int st, int end, int target){
        if(st > end)
            return -1;
        if(st == end)    
            return nums[st] == target ? st : -1;
        int mid = st + (end-st)/2;    
        if(nums[mid] == target)
            return mid;
        if(nums[mid] > target)    
            return BS(nums, st, mid-1, target);
        else
            return BS(nums, mid+1, end, target);
    }

}