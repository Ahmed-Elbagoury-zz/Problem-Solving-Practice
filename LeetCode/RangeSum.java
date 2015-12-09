//https://leetcode.com/problems/range-sum-query-immutable/
publi class RangeSum{
	int [] nums;
    int [] sum;
    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int [nums.length];
        if(nums == null || nums.length == 0)
            return;
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(sum == null || sum.length == 0)
            return 0;
        //sum(i, j) = sum(0, j) - sum(0, i) + nums[i];
        return sum[j] - sum[i] + nums[i];
    }
}