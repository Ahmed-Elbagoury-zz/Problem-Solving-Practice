//https://leetcode.com/problems/majority-element-ii/
public class MajorityElement2{
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> sol = new LinkedList<Integer>();
        if(nums == null || nums.length == 0)
            return sol;
        Integer n1 = null;
        Integer n2 = null;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++){
            int curNum = nums[i];
            if(n1 != null && curNum == n1.intValue())
                count1 ++;
            else if(n2 != null && curNum == n2.intValue())
                count2 ++;
            else{
                if(count1 == 0){
                    n1 = curNum;
                    count1 = 1;
                }
                else if(count2 == 0){
                    n2 = curNum;
                    count2 = 1;
                }
                else{
                    count1 --;
                    count2 --;
                }
            }    
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == n1.intValue())
                count1 ++;
            else if(nums[i] == n2.intValue())
                count2 ++;
        }
        
        if(count1 > nums.length/3) sol.add(n1);
        if(count2 > nums.length/3) sol.add(n2);
        return sol;
    }
}