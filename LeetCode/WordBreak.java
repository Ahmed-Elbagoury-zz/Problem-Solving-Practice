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
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict == null || wordDict.size() == 0){
            return false;
        }
        boolean [] memo = new boolean[s.length()];
        int n = s.length();
        for(int i = n-1; i >= 0 && !memo[i]; i--){
            for(int j = i; j < n; j++){
                if(wordDict.contains(s.substring(i, j+1)) && (j == n-1 || memo[j+1])){
                    memo[i] = true;
                    if(i == 0){
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

}
