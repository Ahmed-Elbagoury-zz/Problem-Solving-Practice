public class Solution {
        public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0)
            return "";
        boolean flag = false;
        int n = s.length();
        int m = t.length();
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        Map<Character, Integer> hasToFind = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
        	int curCount = 1;
        	char curChar = t.charAt(i);
        	if(hasToFind.containsKey(curChar)){
        		curCount += hasToFind.get(curChar);
        	}
        	hasToFind.put(curChar, curCount);
        }
        int start = 0;
        int end = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        while(end < n){
            char curChar = s.charAt(end);
            if(!hasToFind.containsKey(curChar)){
            	end++;
            	continue;
            }
            int curCount = 1;
            if(found.containsKey(curChar)){
            	curCount += found.get(curChar);
            }
            found.put(curChar, curCount);
            if(curCount <= hasToFind.get(curChar)){
            	count++;
            }
            if(count < m){
            	end++;
            	continue;
            }
            if(count == m){
            	if(minLen > end - start+1){
            		flag = true;
            		minLen = end - start + 1;
            		minStart = start;
            		minEnd = end;
            	}
            	while(start < end){
            		if(found.get(s.charAt(start)) == null){
            			start++;
            			if(minLen > end-start+1){
            				flag = true;
            				minLen = end-start+1;
            				minStart = start;
            				minEnd = end;
            			}
            			continue;
            		}
            		
            		if(found.get(s.charAt(start)) >= hasToFind.get(s.charAt(start))){
            			if(minLen > end-start+1){
            				flag = true;
            				minLen = end-start+1;
            				minStart = start;
            				minEnd = end;
            			}
            			found.put(s.charAt(start), found.get(s.charAt(start)) - 1);
            			if(found.get(s.charAt(start)) < hasToFind.get(s.charAt(start))){
            				count--;
            				start++;
            				break;
            			}
            			else{
            				start++;
            			}
            		}
            		else{
            			start++;
            			count--;
            			break;
            		}
            	}
            }  
            end++;
        }
        System.out.println(minStart);
        System.out.println(minEnd);
        if(!flag)
        	return "";
        return s.substring(minStart, minEnd+1);
    }
}
