//https://leetcode.com/problems/search-for-a-range/
public class RangeSearch{
	public int[] searchRange(int[] nums, int target) {
        int [] sol = new int [] {-1, -1};
        if(nums == null || nums.length == 0)
            return sol;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                if(sol[0] == -1)
                    sol[0] = i;
                sol[1] = i;
            }
        }
        return sol;
    }

    public int[] searchRange2(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int [] {-1, -1};
        int[] sol = new int [] {-1, -1};
        if(nums.length == 1){
            if(nums[0] == target)
                return new int [] {0, 0};
            return sol;    
        }
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                sol[0] = mid;
                sol[1] = mid;
                int ind = mid+1;
                while(ind < nums.length && nums[ind] == target){
                    sol[1] = ind++;
                }
                ind = mid-1;
                while(ind >= 0 && nums[ind] == target)
                    sol[0] = ind--;
                return sol;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid+1;
            }
        }
        return sol;
    }

}