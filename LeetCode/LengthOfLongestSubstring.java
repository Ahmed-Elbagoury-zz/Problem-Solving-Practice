//http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
//"abba"
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int curLen = 0;
        for(int i =0; i < s.length(); i ++){
            HashSet<Character> set = new HashSet<Character>();
            for(int j=i; j < s.length(); j++){
                if(set.contains(s.charAt(j)))break;
                curLen ++;
                set.add(s.charAt(j));
            }
            if(curLen > maxLength) maxLength = curLen;
            curLen = 0;
            set.clear();
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
         if(s == null || s.length() == 0)
             return 0;
         HashSet<Character> map = new HashSet<Character>();
         int st = 0;
         int end = 0;
         int max = 0;
         int count = 0;
         while(st < s.length() && end < s.length()){
             if(map.contains(s.charAt(end))){
                 map.remove(s.charAt(st));
                 st++;
                 max = max > count ? max : count;
                 count -=1;
             }
             else{
                 map.add(s.charAt(end));
                 count ++;
                 end ++;
             }
         }
         return max > count ? max : count;
     }
     
     public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();    
        int maxLen = 0;
        int st = 0;
        int end = 0;
        HashSet<Character> set = new HashSet<Character>();
        while(st < n && end < n){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(st));
                st++;
            }
            else{
                maxLen = Math.max(maxLen, end-st+1);
                set.add(s.charAt(end++));
            }
        }
        return maxLen;
    }

}

