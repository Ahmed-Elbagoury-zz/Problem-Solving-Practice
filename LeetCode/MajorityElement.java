//https://leetcode.com/problems/majority-element/
public class MajorityElement{
	//O(n) time and O(n) space
	public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums){
            int count = 1;
            if(map.containsKey(i))
                count += map.get(i);
            map.put(i, count);
            if(count > nums.length/2)
                return i;
        }
        return -1;
    }

    //Using Moore’s Voting Algorithm, we can achieve Time: O(n). Space: O(1)
    //Basic idea of the algorithm is if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority element.
    //http://www.geeksforgeeks.org/majority-element/
    public int majorityElement2(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int majIndex = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[majIndex])
                count ++;
            else{
                count --;
                if(count == 0){
                    count = 1;
                    majIndex = i;
                }
            }    
        }
        return nums[majIndex];
    }

    //Time: O(nlogn), Space: O(1)
	public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}