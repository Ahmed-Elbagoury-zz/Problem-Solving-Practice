//http://yucoding.blogspot.ca/2015/03/leetcode-question-largest-number.html
public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        int n = nums.length;    
        String [] arr = new String[n];    
        for(int i = 0; i < n; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2){
                String leftToRight = s1 + s2;
                String rightToLeft = s2 + s1;
                int comp = leftToRight.compareTo(rightToLeft);
                //If leftToRight is greater than rightToLeft then left, s1, should be first (return -1) otherwise s2 should be first (return 1)
                return -1*comp;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String st : arr)
            sb.append(st);
        while(sb.charAt(0) == '0' && sb.length() != 1)
            sb.deleteCharAt(0);
        return sb.toString();    
    }
}
