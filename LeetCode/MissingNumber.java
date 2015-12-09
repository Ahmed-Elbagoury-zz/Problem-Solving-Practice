//https://leetcode.com/problems/missing-number/
public class MissingNumber{
	public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        int min = 1;
        int max = nums.length;
        int sum = max * (min + max) / 2;
        for(int i = 0; i < nums.length; i++){
            sum -= nums[i];
        }
        return sum;
    }
}