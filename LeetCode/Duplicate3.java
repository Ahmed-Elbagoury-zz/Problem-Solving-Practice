//https://leetcode.com/problems/contains-duplicate-iii/
public class Duplicate3{
	 public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k < 1 || t < 0)
            return false;
        
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if( (treeSet.floor(cur) != null && cur <= t + treeSet.floor(cur)) 
              ||(treeSet.ceiling(cur) != null && cur >= treeSet.ceiling(cur) - t) ){
                return true;
            }
            treeSet.add(cur);
            if(i >= k)
                treeSet.remove(nums[i-k]);
        }
        return false;
    }

}