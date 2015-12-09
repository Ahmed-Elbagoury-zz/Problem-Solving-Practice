//http://oj.leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartition2 {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        boolean [][] isPalind = new boolean [s.length()][s.length()];
        int [] memo = new int [s.length()+1];
        for(int i = 0; i < memo.length; i++)
            memo[i] = s.length()- i-1;
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && (j-i <= 1 || isPalind[i+1][j-1]) ){
                    //The substring s[i..j] is a palindrome
                    isPalind[i][j] = true;
                    memo[i] = Math.min(memo[i], 1+memo[j+1]);
                    //The cost at index i is the minimum between the current cost and the cost of partitioning after index j
                }
            }
        }
        return memo[0];
    }
}
