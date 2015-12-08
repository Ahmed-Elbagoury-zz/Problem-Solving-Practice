//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedSortedArray2{
	//To handle a case like: nums = [1,3,1,1,1], target = 3
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        return helper(nums, 0, nums.length-1, target);    
    }
    
    boolean helper(int [] nums, int st, int end, int target){
        if(st == end)
            return nums[st] == target;
        if(st > end)    
            return false;
        int mid = st + (end-st)/2;
        if(st == mid || nums[st] < nums[mid]){//First hald is sorted
            if(nums[st] <= target && target <= nums[mid])
                return BS(nums, st, mid, target);
            else
                return helper(nums, mid+1, end, target);
        }
        else if(mid+1 == end || nums[mid+1] < nums[end]){ //Second half is sorted
        //mid+1 == end to handle [5, 1, 3] 
            if(nums[mid+1] <= target && nums[end] >= target)
                return BS(nums, mid+1, end, target);
            else
                return helper(nums, st, mid, target);
        }
        else{//Duplicates
            if(nums[st] == nums[mid])
                return helper(nums, st+1, end, target);
            else
                return helper(nums, st, end-1, target);
        }
    }
    
    boolean BS(int []nums, int st, int end, int target){
        if(st > end)
            return false;
        if(st == end)    
            return nums[st] == target;
        int mid = st + (end-st)/2;    
        if(nums[mid] == target)
            return true;
        if(nums[mid] > target)    
            return BS(nums, st, mid-1, target);
        else
            return BS(nums, mid+1, end, target);
    }
}