//https://leetcode.com/problems/contains-duplicate-ii/
public class Duplicate2{
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return false;
        if(k == 0)
            return false;    
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int pre = map.get(nums[i]);
                if(i - pre <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}