//https://leetcode.com/problems/move-zeroes/
public class MoveZeroes{
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int zeroPos = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 && zeroPos != -1){
                nums[zeroPos] = nums[i];
                nums[i] = 0;
                if(zeroPos < nums.length-1 && nums[zeroPos+1] == 0)
                    zeroPos ++;
                else
                    zeroPos = -1;
            }
            else if(nums[i] == 0 && zeroPos == -1){
                zeroPos = i;
            }
        }
    }

}