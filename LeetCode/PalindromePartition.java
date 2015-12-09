//http://oj.leetcode.com/problems/palindrome-partitioning/
public class PalindromePartition {
    boolean [][] isPalind;
    
    public ArrayList<ArrayList<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<ArrayList<String>>();
        isPalind = new boolean[s.length()][s.length()];
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && (j-i <=1 || isPalind[i+1][j-1]) ){
                    isPalind[i][j] = true;
                }
            }
        }
        return helper(0, s);
    }
    
    public ArrayList<ArrayList<String>> helper(int st, String s){
        ArrayList<ArrayList<String>> sol = new ArrayList<ArrayList<String>>();
        if(st == s.length()){ //Base case return list contains an empty list to be filled by the calling function(s)
            sol.add(new ArrayList<String>());
            return sol;
        }
        for(int i = st; i < s.length(); i++){
            if(isPalind[st][i]){    //The substring s[st..i] is palindrome so we will try to partition from st+1 to the end of the string (s.length()-1)
                ArrayList<ArrayList<String>> ret = helper(i+1, s);
                for(ArrayList cur : ret){
                    cur.add(0, s.substring(st, i+1));
                    sol.add(cur);
                }
            }
        }
        return sol;
    }
}
