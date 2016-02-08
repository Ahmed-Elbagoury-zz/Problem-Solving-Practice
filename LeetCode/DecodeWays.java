public class Solution {
    int [] memo;
    String s;
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        this.s = s;    
        int n = s.length();    
        memo = new int [n];    
        for(int i = 0; i < n; i++){
            memo[i] = -1;
        }
        return numDecodings(0);
    }
    
    public int numDecodings(int ind){
        if(ind == s.length())
            return 1;
        if(memo[ind] == -1){
            int count = 0;
            int firstDigit = (int)(s.charAt(ind) - '0');
            if(firstDigit != 0){
                count = numDecodings(ind+1);
                if(ind < s.length()-1){
                    int secondDigit = (int)(s.charAt(ind+1) - '0');    
                    int num = firstDigit*10 + secondDigit;
                    if(num <= 26)
                        count += numDecodings(ind + 2);
                }
            }
            memo[ind] = count;
        }
        return memo[ind];
    }
}
