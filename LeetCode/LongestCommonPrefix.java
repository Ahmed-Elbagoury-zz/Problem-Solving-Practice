//http://oj.leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int size = strs[0].length();
        for(int i = 0; i < strs.length; i++){
            boolean diffChar = false;
            String curStr = strs[i];
            int len = Math.min(curStr.length(), size);
            int j = 0;
            while(!diffChar && j < len){    
                if(curStr.charAt(j) != strs[0].charAt(j)){
                    diffChar = true;
                    break;
                }
                j++;
            }
            size = j;
        }
        return strs[0].substring(0, size);
    }
}
