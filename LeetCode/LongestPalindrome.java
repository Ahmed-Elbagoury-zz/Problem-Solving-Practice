//http://oj.leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() == 0) return "";
        int maxSt = 0;
        int maxEnd = 0;
        int maxLen = 1;
        int st;
        int end;
        for(int i = 0; i < s.length(); i++){
            st = i-1;
            end = i+1;
            while(st >= 0 && end <= s.length()-1 && s.charAt(st) == s.charAt(end)){
                st --;
                end ++;
            }
            if(maxLen < end-st-1){
                maxLen = end-st-1;
                maxSt = st+1;
                maxEnd = end-1;
            }
            //Check for palinedromes of even length
            st = i;
            end = i+1;
            while(st >= 0 && end <= s.length()-1 && s.charAt(st) == s.charAt(end)){
                st --;
                end ++;
            }
            if(maxLen < end-st-1){
                maxLen = end-st-1;
                maxSt = st+1;
                maxEnd = end-1;
            }
            
        }
        return s.substring(maxSt, maxEnd+1);
    }

    //DP Solution
     public String longestPalindromeDP(String s) {
        boolean[][] memo = new boolean[s.length()][s.length()];
        int maxSt = 0;
        int maxEnd = 0;
        int maxLen = 0;
        for(int i = memo.length-1; i >= 0; i --){
            for (int j = i; j < memo.length; j++) {
                memo[i][j] =  s.charAt(i) == s.charAt(j) && (j-i <= 1 || memo[i+1][j-1]);
                if (memo[i][j] && maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    maxSt = i;
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxSt, maxEnd + 1);
    }
}