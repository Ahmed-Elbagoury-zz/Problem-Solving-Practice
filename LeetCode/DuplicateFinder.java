//https://leetcode.com/problems/find-the-duplicate-number/
public class DuplicateFinder{
	public int findDuplicate(int[] nums) {
        if(nums == null || nums.length < 2)
            return -1;
        for(int i = 0 ; i < nums.length; i++){
            int absVal = nums[i] > 0 ? nums[i] : -1 * nums[i];
            if(nums[absVal] < 0)
                return absVal;
            nums[absVal] = -1*nums[absVal];    
        }
        return -1;
    }

}