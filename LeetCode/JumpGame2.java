//https://leetcode.com/problems/jump-game-ii/
public JumpGame2{
	public int jump(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int n = nums.length;    
        int coverage = 0;   //The range of values that can be covered, the steps to reach this coverage is not counted yet
        int countedCoverage = 0;    //The range that we can reach with the counted number of steps
        int step = 0;   //Steps to reach the countedCoverage
        for(int i = 0; i < n && i<= coverage; i ++){
            if(i > countedCoverage){    //We can reach this number but we did not count the steps yet
                step ++;
                countedCoverage = coverage; //We counted the jump so we can reach any cell in the coverage as the jump is already counted
            }
            //Update the coverage given the current cell
            coverage = coverage > nums[i] + i ? coverage : nums[i] + i;
        }
        if(coverage < n-1)
            return -1;
        return step;    
    }

    public int jump2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;    
        int maxReach = 0;
        int countedReach = 0;
        int step = 0;
        int n = nums.length;
        if(n == 1)
            return 0;
        for(int i = 0; i < n; i++){
            if(i > maxReach)
                return -1;
            if(i > countedReach){
                step++;
                countedReach = maxReach;
            }
            maxReach = Math.max(maxReach, nums[i] + i);
            if(maxReach >= n-1)
                return step+1;
        }
        return step;
    }

}