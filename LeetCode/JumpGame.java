//https://leetcode.com/problems/jump-game/
public class JumpGame{
	public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        if(nums.length == 1)
            return true;
        int max = 0;    
        for(int i = 0; i < nums.length; i++){
            if(max <= i && nums[i] == 0) // if(max < i)
                return false;
            if(nums[i] + i >= nums.length - 1)
                return true;
            max = max > nums[i] + i ? max : nums[i] + i;    
        }
        return false;
    }

}