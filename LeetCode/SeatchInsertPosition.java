//https://leetcode.com/problems/search-insert-position/
public SeatchInsertPosition{
	public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        int st = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(st <= end){
            mid = st + (end-st)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target) 
                end = mid - 1;
            else
                st = mid + 1;
        }
        if(st == end){
            if(nums[st] > target)
                return st - 1 >= 0 ? st -1 : 0;
            else
                return st + 1;
        }
        else{
            return end + 1;   
        }    
    }

    public int searchInsert2(int[] nums, int target) {
        return BS(nums, 0, nums.length-1, target);
    }
    
    public int BS(int [] nums, int st, int end, int target){
        int mid = st + (end-st)/2;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] > target){
            if(st == mid){
                if(nums[st] == target)
                    return st;
                else
                    return nums[st] > target ? st : st+1;
            }
            else{
                return BS(nums, st, mid-1, target);
            }
        }
        else{    //nums[mid] < target
            if(mid == end){
               if(nums[end] == target) 
                    return end;
                else{
                    return nums[end] > target ? end : end+1;
                }    
            }
            else{
                return BS(nums, mid+1, end, target);
            }
        }
    }
}