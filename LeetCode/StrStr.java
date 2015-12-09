//http://oj.leetcode.com/problems/implement-strstr/
public class StrStr {
    public String strStr(String haystack, String needle) {
        if(haystack == null) return null;
        if(needle == null) return haystack;
        int ind = -1;
        for(int i = 0; i < haystack.length()-needle.length()+1 && ind == -1; i++){
            ind = i;
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    ind = -1;
                    break;
                }
            }
        }
        if(ind == -1) return null;
        return haystack.substring(ind);
    }
}
