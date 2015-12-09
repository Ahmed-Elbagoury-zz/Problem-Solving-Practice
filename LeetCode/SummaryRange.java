//https://leetcode.com/problems/summary-ranges/
public class SummaryRange{
	public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<String>();
        if(nums == null || nums.length == 0)
            return list;
        int st = 0;    
        for(int i =1; i < nums.length; i++){
            if(nums[i] - 1 != nums[i-1]){
                if(st == i-1)
                    list.add(String.valueOf(nums[st]));
                else{    
                    String cur = nums[st] + "->" + nums[i-1];
                    list.add(cur);
                }
                st = i;
            }
        }
        if(st < nums.length - 1){
            list.add(String.valueOf(nums[st]) + "->" + nums[nums.length-1]);
        }
        else if (st == nums.length - 1){
            list.add(String.valueOf(nums[st]));
        }
        return list;    
    }

}