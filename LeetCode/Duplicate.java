//https://leetcode.com/problems/contains-duplicate/
public class Duplicate{
	public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Arrays.sort(nums);
        int last = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == last){
                return true;
            }
            last = nums[i];
        }
        return false;
    }

}