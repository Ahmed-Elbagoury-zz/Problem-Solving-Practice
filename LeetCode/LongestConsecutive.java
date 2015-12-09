//http://oj.leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutive{
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i: nums)
            set.add(i);
        int max = 1;    
        for(int i : nums){
            int left = i-1;
            int right = i+1;
            int count = 1;
            while(set.contains(left)){
                set.remove(left);
                left --;
                count++;
            }
            while(set.contains(right)){
                set.remove(right);
                right ++;
                count ++;
            }
            max = max > count ? max : count;
        }
        return max;
    }

}