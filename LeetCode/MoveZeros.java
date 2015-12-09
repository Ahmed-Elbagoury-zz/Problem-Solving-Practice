//https://leetcode.com/problems/move-zeroes/
public class MoveZeros{
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2)
            return;
        int count = 0;    
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)
                nums[count++] = nums[i];
        }
        for(; count < nums.length; count ++){
            nums[count] = 0;
        }
    }

}