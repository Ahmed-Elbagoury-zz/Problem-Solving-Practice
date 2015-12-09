//https://leetcode.com/problems/rotate-array/
public class RotateArray{
	//O(n) space
	public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(nums == null || nums.length == 0 || k == 0)
            return;    
        int count = 0;
        int n = nums.length;
        int [] sol = new int [n];
        for(int i = 0; i < n; i++){
            sol[i] = nums[(n-k+i) % n];
        }
        for(int i = 0; i< n; i++){
            nums[i] = sol[i];
        }
    }
    //O(1) space
    public void rotate(int[] nums, int k) {
       if(nums == null || nums.length == 0 || k%nums.length == 0)
            return;
        int n = nums.length;
        k = k % n;
        nums = reverse(nums, 0, n-1);
        nums = reverse(nums, 0, k-1);
        nums = reverse(nums, k, n-1);
    }
    public int [] reverse(int [] nums, int st, int end){
        while(st < end){
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st ++;
            end --;
        }
        return nums;
    }

}