//https://leetcode.com/problems/interleaving-string/
public class Solution {
    int [][] memo1;
    int [][] memo2;
    public boolean isInterleave(String s1, String s2, String s3) {
        memo1 = new int [s1.length()][s3.length()];
        for(int i = 0; i < memo1.length; i++){
            for(int j = 0; j < memo1[i].length; j++){
                memo1[i][j] = -1;
            }
        }
        memo2 = new int [s2.length()][s3.length()];
        for(int i = 0; i < memo2.length; i++){
            for(int j = 0; j < memo2[i].length; j++){
                memo2[i][j] = -1;
            }
        }
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }
    
    public boolean isInterleave(String s1, String s2, String s3, int ind1, int ind2, int ind3){
        if(ind3 == s3.length() && ind1 == s1.length() && ind2 == s2.length()){
            return true;
        }
        if(ind3 >= s3.length())
            return false;
        boolean flag = false;
        if(ind1 < s1.length() && s1.charAt(ind1) == s3.charAt(ind3)){
            int result = 0;
            if(memo1[ind1][ind3] == -1){
                flag = isInterleave(s1, s2, s3, ind1+1, ind2, ind3+1);
                result = flag ? 1 : 0;
            }
            memo1[ind1][ind3] = result;
        }
        if(flag)
            return true;
        if(ind2  < s2.length() && s2.charAt(ind2) == s3.charAt(ind3)){    
            int result = 0;
            if(memo2[ind2][ind3] == -1){
                flag = isInterleave(s1, s2, s3, ind1, ind2+1, ind3+1);
                result = flag ? 1 : 0;
            }
            memo2[ind2][ind3] = result;
        }
        return flag;    
    }
}
