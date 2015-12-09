//https://leetcode.com/problems/word-break/
public class WordBreak{
	public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0)
            return true;
        int n = s.length();    
        boolean [] memo = new boolean[n+1];
        memo[0] = true;
        for(int i = 0; i < n; i++){
        	if(!memo[i])
        		continue;
        	for(String str: wordDict){
        		int end = i + str.length();
        		if(end > s.length())
        		    continue;
        		if(str.compareTo(s.substring(i, end)) == 0){
        			memo[end] = true;
        			if(end == n)
        				return true;
        		}
        	}
        }
        return false;
    }

}